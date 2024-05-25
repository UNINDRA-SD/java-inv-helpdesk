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
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import dao.SummaryReportDAO;
import java.util.List;
import model.SummaryReportModel;
import table.SummaryReportTable;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import view.card.ModelCard;
import view.form.Form_SummaryReports;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class SummaryReportController {
    Home home;
    Form_SummaryReports formSummaryReport;
    SummaryReportDAO summaryReportDAO;
    List<SummaryReportModel> summaryReports;
    SummaryReportTable summaryReportTable;
    
    public SummaryReportController(Form_SummaryReports formSummaryReport, Home home) {
        this.home = home;
        this.formSummaryReport = formSummaryReport;
        summaryReportDAO = new SummaryReportDAO();
    }
    
    public void showSummaryReport() {
        summaryReports = summaryReportDAO.getSummaryReports();
        summaryReportTable = new SummaryReportTable(summaryReports);
        formSummaryReport.getDataTable().setModel(summaryReportTable);
    }
    
    public void setCardTicket() {
        int totalTickets = summaryReportDAO.getTotalTickets();
        int openedTickets = summaryReportDAO.getOpenedTickets();
        int closedTickets = summaryReportDAO.getClosedTickets();

        formSummaryReport.getCard1().setData(new ModelCard(null, null, null, String.valueOf(totalTickets), "Total Ticket"));
        formSummaryReport.getCard2().setData(new ModelCard(null, Color.GREEN, Color.GREEN, String.valueOf(openedTickets), "Opened Ticket"));
        formSummaryReport.getCard3().setData(new ModelCard(null, Color.RED, Color.RED, String.valueOf(closedTickets), "Closed Ticket"));
    }
    
    public void printSummaryReport(Form_SummaryReports formSummaryReports, String dir) {
        try {
            PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(new File(dir + ".pdf")));
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
            try (Document document = new Document(pdfDocument)) {
                float twoCol = 1140f;
                float twoCol150 = twoCol + 150f;
                float threeCol = 570f;
                float threeColumnWidth[] = {threeCol, threeCol, threeCol};
                float eightColumnWidth[] = {63f, 343f, 343f, 423f, 343f, 343f, 343f, 343f};
                float fullwidth[] = {threeCol*3};
                Paragraph oneSp = new Paragraph("\n");
                
                Table tableLetterHead = new Table(threeColumnWidth);
                tableLetterHead.addCell(new Cell().add(new Paragraph("Summary Report").setFontSize(20f).setBold()).setBorder(Border.NO_BORDER));
                tableLetterHead.addCell(new Cell().add(new Paragraph("").setFontSize(20f).setBold()).setBorder(Border.NO_BORDER));
                
                Table tableLetterHeadInside = new Table(new float[]{twoCol / 2, twoCol / 2});
                tableLetterHeadInside.addCell(getHeaderTextCell("Reporter :"));
                tableLetterHeadInside.addCell(getHeaderTextCellValue(formSummaryReports.getjLabelNameLogin().getText()));
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
                
                Table tableTitleInfo = new Table(threeColumnWidth);
                tableTitleInfo.addCell(getBillingShippingCell(formSummaryReports.getCard1().getValues() + " Total Ticket"));
                tableTitleInfo.addCell(getBillingShippingCell(formSummaryReports.getCard2().getValues() + " Opened Ticket"));
                tableTitleInfo.addCell(getBillingShippingCell(formSummaryReports.getCard3().getValues() + " Closed Ticket"));
                document.add(tableTitleInfo.setMarginBottom(12f));
                
                Table tableDivider = new Table(fullwidth);
                Border dashedBorder = new DashedBorder(new DeviceRgb(128, 128, 128), 0.5f);
                document.add(oneSp);
                document.add(tableDivider.setBorder(dashedBorder));
                Paragraph product = new Paragraph("# DO Settlements Report");
                document.add(product.setBold());
                
                Table tableItemHead = new Table(eightColumnWidth);
                tableItemHead.setBackgroundColor(new DeviceRgb(0, 0, 0), 0.7f);
                tableItemHead.addCell(new Cell().add(new Paragraph("#")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Ticket ID")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Problem")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Action Taken")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Asset ID")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Asset Name")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Asset Qty")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableItemHead.addCell(new Cell().add(new Paragraph("Settle Notes")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableItemHead);
                
                Table tableItems = new Table(eightColumnWidth);
                int rowCount = formSummaryReports.getjTableSummary().getRowCount();

                // Loop through each row
                for (int row = 0; row < rowCount; row++) {
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 0).toString())).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 1).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 2).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 3).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 4).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 5).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 6).toString())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                    tableItems.addCell(new Cell().add(new Paragraph(formSummaryReports.getjTableSummary().getValueAt(row, 7).toString())).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
                }

                // Add the table to the document with margin bottom
                document.add(tableItems.setMarginBottom(20f));
                
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(formSummaryReports, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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
}
