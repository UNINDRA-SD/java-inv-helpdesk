/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import static controller.SummaryReportController.getHeaderTextCell;
import static controller.SummaryReportController.getHeaderTextCellValue;
import dao.AssetReportDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import model.AssetReportModel;
import table.AssetReportTable;
import view.form.Form_AssetReports;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class AssetReportController {
    Home home;
    Form_AssetReports formAssetReports;
    AssetReportDAO assetReportDAO;
    List<AssetReportModel> availableStockSummary;
    List<AssetReportModel> needToRestockSummary;

    public AssetReportController(Form_AssetReports formAssetReports, Home home) {
        this.home = home;
        this.formAssetReports = formAssetReports;
        assetReportDAO = new AssetReportDAO();
    }

    public void showAvailableStockSummary() {
        availableStockSummary = assetReportDAO.getAvailableStockSummary();
        AssetReportTable availableStockTable = new AssetReportTable(availableStockSummary, true);
        formAssetReports.getjTableStockSummary().setModel(availableStockTable);
    }

    public void showNeedToRestockSummary() {
        needToRestockSummary = assetReportDAO.getNeedToRestockSummary();
        AssetReportTable needToRestockTable = new AssetReportTable(needToRestockSummary, false);
        formAssetReports.getjTableRestockSummary().setModel(needToRestockTable);
    }
    
    public void printAssetReport(Form_AssetReports formAssetReports, String dir) {
        try {
            PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(new File(dir + ".pdf")));
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
            try (Document document = new Document(pdfDocument)) {
                float twoCol = 1140f;
                float twoCol150 = twoCol + 150f;
                float threeCol = 570f;
                float threeColumnWidth[] = {threeCol, threeCol, threeCol};
                float fourColumnWidth[] = {63f, 500f, 500f, 100f};
                float sixColumnWidth[] = {63, 500, 500, 500, 500, 500};
                float fullwidth[] = {threeCol*3};
                Paragraph oneSp = new Paragraph("\n");
                
                Table tableLetterHead = new Table(threeColumnWidth);
                tableLetterHead.addCell(new Cell().add(new Paragraph("Summary Report").setFontSize(20f).setBold()).setBorder(Border.NO_BORDER));
                tableLetterHead.addCell(new Cell().add(new Paragraph("").setFontSize(20f).setBold()).setBorder(Border.NO_BORDER));
                
                Table tableLetterHeadInside = new Table(new float[]{twoCol / 2, twoCol / 2});
                tableLetterHeadInside.addCell(getHeaderTextCell("Reporter :"));
                tableLetterHeadInside.addCell(getHeaderTextCellValue(formAssetReports.getjLabelNameLogin().getText()));
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
                
                Table tableDivider = new Table(fullwidth);
                Border dashedBorder = new DashedBorder(new DeviceRgb(128, 128, 128), 0.5f);
                document.add(oneSp);
                
                Paragraph stock = new Paragraph("# Available Stock Summary");
                document.add(stock.setBold());
                
                Table tableItemHead = new Table(fourColumnWidth);
                tableItemHead.setBackgroundColor(new DeviceRgb(0, 0, 0), 0.7f);
                tableItemHead.addCell(new Cell().add(new Paragraph("#")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Brand")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Category")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Total")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableItemHead);
                
                Table tableItems = new Table(fourColumnWidth);
                int rowCount = formAssetReports.getjTableStockSummary().getRowCount();

                for (int row = 0; row < rowCount; row++) {
                    tableItems.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableStockSummary().getValueAt(row, 0).toString())).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableStockSummary().getValueAt(row, 1).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableStockSummary().getValueAt(row, 2).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableStockSummary().getValueAt(row, 3).toString())).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
                }
                document.add(tableItems.setMarginBottom(20f));
                
                document.add(oneSp);
                document.add(tableDivider.setBorder(dashedBorder));
                document.add(oneSp);
                
                Paragraph restock = new Paragraph("# Need To Restock");
                document.add(restock.setBold());
                
                Table tableItemHeadRestock = new Table(sixColumnWidth);
                tableItemHeadRestock.setBackgroundColor(new DeviceRgb(0, 0, 0), 0.7f);
                tableItemHeadRestock.addCell(new Cell().add(new Paragraph("Asset Id")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setBorder(Border.NO_BORDER));
                tableItemHeadRestock.addCell(new Cell().add(new Paragraph("Brand")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHeadRestock.addCell(new Cell().add(new Paragraph("Category")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHeadRestock.addCell(new Cell().add(new Paragraph("Asset Name")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHeadRestock.addCell(new Cell().add(new Paragraph("Asset Model")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHeadRestock.addCell(new Cell().add(new Paragraph("Qty")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableItemHeadRestock);
                
                Table tableItemsRestock = new Table(sixColumnWidth);
                int rowCountRestock = formAssetReports.getjTableRestockSummary().getRowCount();

                // Loop through each row
                for (int row = 0; row < rowCountRestock; row++) {
                    tableItemsRestock.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableRestockSummary().getValueAt(row, 0).toString())).setBorder(Border.NO_BORDER));
                    tableItemsRestock.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableRestockSummary().getValueAt(row, 1).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItemsRestock.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableRestockSummary().getValueAt(row, 2).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItemsRestock.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableRestockSummary().getValueAt(row, 3).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItemsRestock.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableRestockSummary().getValueAt(row, 4).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItemsRestock.addCell(new Cell().add(new Paragraph(formAssetReports.getjTableRestockSummary().getValueAt(row, 5).toString())).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
                }
                document.add(tableItemsRestock.setMarginBottom(20f));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(formAssetReports, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
