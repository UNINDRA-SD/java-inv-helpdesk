/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import dao.DOAssetDAO;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import config.MysqlDB;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.AssetModel;
import model.DOAssetModel;
import table.DOAssetTable;
import view.Frame_AddDOAsset;
import view.form.Form_DeliveryOrders;
import view.Frame_DetailDeliveryOrder;

/**
 *
 * @author ACER
 */
public class DOAssetController {
    Form_DeliveryOrders formDeliveryOrders;
    Frame_DetailDeliveryOrder detailDeliveryOrder;
    Frame_AddDOAsset addDOAssetView;
    DOAssetDAO doAssetDAO;
    List<DOAssetModel> doAssets;
    
    public DOAssetController(Frame_DetailDeliveryOrder detailDeliveryOrder) {
        this.detailDeliveryOrder = detailDeliveryOrder;
        doAssetDAO = new DOAssetDAO();
    }
    
    public void showDOAssets(int doId) {
        doAssets = doAssetDAO.getDOAssets(doId);
        DOAssetTable doAssetTable = new DOAssetTable(doAssets);
        detailDeliveryOrder.getDataTable().setModel(doAssetTable);

        // Panggil metode hideIdColumn untuk menyembunyikan kolom ID
        detailDeliveryOrder.hideIdColumn();
    }

    
    public void saveDOAsset(Frame_AddDOAsset addDOAssetView) {
        Connection connection = null;
        try {
            connection = MysqlDB.connection();
            connection.setAutoCommit(false); // Mulai transaksi

            // Pastikan input tidak kosong
            if (addDOAssetView.getjComboAsset().getSelectedItem() != null
                && !addDOAssetView.getjTextQty().getText().trim().isEmpty()
                && !addDOAssetView.getjLabelId().getText().trim().isEmpty()) {

                DOAssetModel doAsset = new DOAssetModel();
                doAsset.setDeliveryOrderId(Integer.parseInt(addDOAssetView.getjLabelId().getText()));

                // Ambil data aset yang dipilih
                String selectedAsset = (String) addDOAssetView.getjComboAsset().getSelectedItem();
                String[] assetDetails = selectedAsset.split("\\|");
                int assetId = Integer.parseInt(assetDetails[0].trim());
                doAsset.setAssetId(assetId);

                // Periksa stok aset saat ini
                int currentQty = AssetModel.getQtyByAssetId(connection, assetId);
                int inputQty = Integer.parseInt(addDOAssetView.getjTextQty().getText());

                if (currentQty >= inputQty) {
                    doAsset.setQty(inputQty);

                    // Simpan data DO Asset
                    if (doAssetDAO.saveDOAsset(doAsset)) {
                        // Kurangi stok aset
                        AssetModel.setMinQtyByAssetId(connection, assetId, inputQty);
                        JOptionPane.showMessageDialog(addDOAssetView, "Data saved successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                        // Komit transaksi jika semua operasi berhasil
                        connection.commit();

                        addDOAssetView.setVisible(false);
                    } else {
                        throw new SQLException("Failed to save data!");
                    }
                } else {
                    JOptionPane.showMessageDialog(addDOAssetView, "Qty is out of stock!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(addDOAssetView, "Input cannot be empty!", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            // Rollback transaksi jika terjadi kesalahan
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    System.out.println("Failed to rollback transaction: " + rollbackEx);
                }
            }
            System.out.println("Error during transaction: " + e);
            JOptionPane.showMessageDialog(addDOAssetView, "Failed to save data!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Pastikan connection ditutup
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Kembalikan ke mode auto-commit
                } catch (SQLException closeEx) {
                    System.out.println("Failed to close connection: " + closeEx);
                }
            }
        }
    }

    public void deleteDOAsset(String id, int assetId, int qty, Frame_DetailDeliveryOrder deliveryOrderView) {
        Connection connection = null;
        try {
            connection = MysqlDB.connection();
            connection.setAutoCommit(false); // Mulai transaksi

            // Tambahkan kembali kuantitas ke aset
            AssetModel.setAddQtyByAssetId(connection, assetId, qty);

            // Hapus DO Asset
            doAssetDAO.deleteDOAsset(connection, id);

            // Commit transaksi
            connection.commit();

            // Beri tahu pengguna bahwa kuantitas telah dikembalikan
            int totalQty = AssetModel.getQtyByAssetId(connection, assetId);
            JOptionPane.showMessageDialog(deliveryOrderView,
                "Qty stock: | " + qty + " | has been returned to Asset ID: | " + assetId + " | Total Qty stock: | " + totalQty + " |",
                "INFO",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            // Rollback transaksi jika terjadi kesalahan
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    System.out.println("Failed to rollback transaction: " + rollbackEx);
                }
            }
            System.out.println("Error during transaction: " + e);
            JOptionPane.showMessageDialog(deliveryOrderView, "Failed to delete DO Asset!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Pastikan untuk menutup koneksi
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Kembalikan ke mode auto-commit
                } catch (SQLException closeEx) {
                    System.out.println("Failed to close connection: " + closeEx);
                }
            }
        }
    }
    
    public int getDOSettlementByDOAssetId(int id){
        return doAssetDAO.getDOSettlementIDByDOAssetId(id);
    }
    
    static Cell getHeaderTextCell(String textValue) {
        return new Cell().add(new Paragraph(textValue)).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }
    
    static Cell getHeaderTextCellValue(String textValue) {
        return new Cell().add(new Paragraph(textValue)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }
    
    static Cell getBillingShippingCell(String textValue) {
        return new Cell().add(new Paragraph(textValue)).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }
    
    static Cell getCell10Left(String textValue, Boolean isBold) {
        Cell myCell = new Cell().add(new Paragraph(textValue)).setFontSize(10f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ? myCell.setBold() : myCell;
    }
    
    public void printDO(Frame_DetailDeliveryOrder detailDeliveryOrder, String dir){
        try {
            PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(new File(dir + ".pdf")));
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            try (Document document = new Document(pdfDocument)) {
                float twoCol = 285f;
                float twoCol150 = twoCol + 150f;
                float twoColumnWidth[] = {twoCol150, twoCol};
                float threeCol = 190f;
                float threeColumnWidth[] = {threeCol, threeCol, threeCol};
                float fiveColumnWidth[] = {94f, 129f, 129f, 129f, 89f};
                float fullwidth[] = {threeCol*3};
                Paragraph oneSp = new Paragraph("\n");
                
                Table tableLetterHead = new Table(twoColumnWidth);
                tableLetterHead.addCell(new Cell().add(new Paragraph("Delivery Order").setFontSize(20f).setBold()).setBorder(Border.NO_BORDER));
                
                Table tableLetterHeadInside = new Table(new float[]{twoCol / 2, twoCol / 2});
                tableLetterHeadInside.addCell(getHeaderTextCell("DO / Ticket :"));
                tableLetterHeadInside.addCell(getHeaderTextCellValue(detailDeliveryOrder.getjLabelId().getText() + " / " + detailDeliveryOrder.getjTextTicketId().getText()));
                tableLetterHeadInside.addCell(getHeaderTextCell("Date :"));
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                String formattedDate = currentDate.format(formatter);
                tableLetterHeadInside.addCell(getHeaderTextCellValue(formattedDate));
                tableLetterHead.addCell(new Cell().add(tableLetterHeadInside).setBorder(Border.NO_BORDER));
                
                Border borderSolid = new SolidBorder(new DeviceRgb(128, 128, 128), 2f);
                Table divider = new Table(fullwidth);
                divider.setBorder(borderSolid);
                
                document.add(tableLetterHead);
                document.add(oneSp);
                document.add(divider);
                document.add(oneSp);
                
                Table tableTitleInfo = new Table(twoColumnWidth);
                tableTitleInfo.addCell(getBillingShippingCell("Ticket Information"));
                tableTitleInfo.addCell(getBillingShippingCell("PIC Information"));
                document.add(tableTitleInfo.setMarginBottom(12f));
                
                Table tableTicketInfo = new Table(twoColumnWidth);
                tableTicketInfo.addCell(getCell10Left("Ticket Status", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Name", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailDeliveryOrder.getjTextTicketStatus().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailDeliveryOrder.getjTextCustomerName().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("Problem", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Phone", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailDeliveryOrder.getjTextProblem().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailDeliveryOrder.getjLabelPhone().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Customer Info", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("", Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailDeliveryOrder.getjTextCustomerDescription().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("Ticket Description", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Address", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailDeliveryOrder.getjTextTicketDescription().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailDeliveryOrder.getjLabelAddress().getText(), Boolean.FALSE));
                document.add(tableTicketInfo);
                
                
                Table tableDivider = new Table(fullwidth);
                Border dashedBorder = new DashedBorder(new DeviceRgb(128, 128, 128), 0.5f);
                document.add(tableDivider.setBorder(dashedBorder));
                Paragraph product = new Paragraph("# Items");
                document.add(product.setBold());
                
                Table tableItemHead = new Table(fiveColumnWidth);
                tableItemHead.setBackgroundColor(new DeviceRgb(0, 0, 0), 0.7f);
                tableItemHead.addCell(new Cell().add(new Paragraph("Asset ID")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Name")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Model")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Serial Number")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Qty")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableItemHead);
                
                Table tableItems = new Table(fiveColumnWidth);
                int rowCount = detailDeliveryOrder.getjTableDOAssets().getRowCount();

                // Loop through each row
                for (int row = 0; row < rowCount; row++) {
                    tableItems.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTableDOAssets().getValueAt(row, 1).toString())).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTableDOAssets().getValueAt(row, 4).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTableDOAssets().getValueAt(row, 5).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTableDOAssets().getValueAt(row, 7).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTableDOAssets().getValueAt(row, 9).toString())).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
                }

                // Add the table to the document with margin bottom
                document.add(tableItems.setMarginBottom(20f));
                
                document.add(oneSp);
                document.add(tableDivider.setBorder(dashedBorder));
                
                Paragraph notes = new Paragraph("# Notes");
                document.add(notes.setBold());
                document.add(oneSp);
                document.add(oneSp);
                document.add(oneSp);
                document.add(tableDivider.setBorder(dashedBorder));
                
                Paragraph approval = new Paragraph("# Approval");
                document.add(approval.setBold());
                Table tableTTD = new Table(threeColumnWidth);
                tableTTD.addCell(new Cell().add(new Paragraph("Warehouse Team")).setBorder(Border.NO_BORDER));
                tableTTD.addCell(new Cell().add(new Paragraph("Engineer Team")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableTTD.addCell(new Cell().add(new Paragraph("PIC Customer")).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableTTD);
                document.add(oneSp);
                document.add(oneSp);
                document.add(oneSp);
                document.add(oneSp);
                Table tableTTDName = new Table(threeColumnWidth);
                tableTTDName.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTextTeamWarehouse().getText())).setBorder(Border.NO_BORDER));
                tableTTDName.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTextTeamEngineer().getText())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableTTDName.addCell(new Cell().add(new Paragraph(detailDeliveryOrder.getjTextCustomerName().getText())).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableTTDName);
                document.add(divider);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(detailDeliveryOrder, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
