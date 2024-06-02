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
import static controller.DOAssetController.getBillingShippingCell;
import static controller.DOAssetController.getCell10Left;
import static controller.DOAssetController.getHeaderTextCell;
import static controller.DOAssetController.getHeaderTextCellValue;
import dao.ActivityReportDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import model.ActivityReportModel;
import table.ActivityReportTable;
import view.Frame_CreateActivityReport;
import view.Frame_DetailActivityReport;
import view.form.Form_ActivityReports;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class ActivityReportController {
    Home home;
    Form_ActivityReports formActivityReports;
    ActivityReportDAO activityReportDAO;
    List<ActivityReportModel> activityReports;
    
    public ActivityReportController(Form_ActivityReports formActivityReports, Home home) {
        this.home = home;
        this.formActivityReports = formActivityReports;
        activityReportDAO = new ActivityReportDAO(this.home);
    }
    
    public void showActivityReports() {
        activityReports = activityReportDAO.getActivityReports();
        ActivityReportTable activityReportTable = new ActivityReportTable(activityReports);
        formActivityReports.getDataTable().setModel(activityReportTable);
    }
    
    public void saveActivityReport(Frame_CreateActivityReport createActivityReportView) {
        if (createActivityReportView.getjComboDOId().getSelectedItem() != null
            && !createActivityReportView.getjTextActionTaken().getText().trim().isEmpty()
            && !createActivityReportView.getjTextStartDate().getText().trim().isEmpty()
            && !createActivityReportView.getjTextEndDate().getText().trim().isEmpty()
            && !createActivityReportView.getjFormattedStartTime().getText().trim().isEmpty()
            && !createActivityReportView.getjFormattedEndTime().getText().trim().isEmpty()){
            
            ActivityReportModel activityReport = new ActivityReportModel();
            
            String selectedDOId = (String) createActivityReportView.getjComboDOId().getSelectedItem();
            activityReport.setDeliveryOrderId(Integer.parseInt(selectedDOId));
            activityReport.setActionTaken(createActivityReportView.getjTextActionTaken().getText());
            activityReport.setStartDate(createActivityReportView.getjTextStartDate().getText());
            activityReport.setEndDate(createActivityReportView.getjTextEndDate().getText());
            activityReport.setStartTime(createActivityReportView.getjFormattedStartTime().getText());
            activityReport.setEndTime(createActivityReportView.getjFormattedEndTime().getText());
            
            if(activityReportDAO.saveActivityReport(activityReport)) {
                JOptionPane.showMessageDialog(createActivityReportView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createActivityReportView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createActivityReportView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateActivityReport(Frame_CreateActivityReport createActivityReportView) {
        if (createActivityReportView.getjComboDOId().getSelectedItem() != null
            && !createActivityReportView.getjTextActionTaken().getText().trim().isEmpty()
            && !createActivityReportView.getjTextStartDate().getText().trim().isEmpty()
            && !createActivityReportView.getjTextEndDate().getText().trim().isEmpty()
            && !createActivityReportView.getjFormattedStartTime().getText().trim().isEmpty()
            && !createActivityReportView.getjFormattedEndTime().getText().trim().isEmpty()){
            
            ActivityReportModel activityReport = new ActivityReportModel();
            
            activityReport.setId(Integer.parseInt(createActivityReportView.getjLabelId().getText()));
            String selectedDOId = (String) createActivityReportView.getjComboDOId().getSelectedItem();
            activityReport.setDeliveryOrderId(Integer.parseInt(selectedDOId));
            activityReport.setActionTaken(createActivityReportView.getjTextActionTaken().getText());
            activityReport.setStartDate(createActivityReportView.getjTextStartDate().getText());
            activityReport.setEndDate(createActivityReportView.getjTextEndDate().getText());
            activityReport.setStartTime(createActivityReportView.getjFormattedStartTime().getText());
            activityReport.setEndTime(createActivityReportView.getjFormattedEndTime().getText());
            
            if(activityReportDAO.updateActivityReport(activityReport)) {
                JOptionPane.showMessageDialog(createActivityReportView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createActivityReportView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createActivityReportView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteActivityReport(String id){           
        activityReportDAO.deleteActivityReport(id);
    }
    
    public void printReport(Frame_DetailActivityReport detailActivityReport, String dir){
        try {
            PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(new File(dir + ".pdf")));
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            try (Document document = new Document(pdfDocument)) {
                float twoCol = 285f;
                float twoCol150 = twoCol + 150f;
                float twoColumnWidth[] = {twoCol150, twoCol};
                float threeCol = 190f;
                float fullwidth[] = {threeCol*3};
                Paragraph oneSp = new Paragraph("\n");
                
                Table tableLetterHead = new Table(twoColumnWidth);
                tableLetterHead.addCell(new Cell().add(new Paragraph("Activity Report").setFontSize(20f).setBold()).setBorder(Border.NO_BORDER));
                
                Table tableLetterHeadInside = new Table(new float[]{twoCol / 2, twoCol / 2});
                tableLetterHeadInside.addCell(getHeaderTextCell("DO / Ticket :"));
                tableLetterHeadInside.addCell(getHeaderTextCellValue(detailActivityReport.getjTextDOTicket().getText()));
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
                
                Table tableTitleInfo = new Table(twoColumnWidth);
                tableTitleInfo.addCell(getBillingShippingCell("Ticket Information"));
                tableTitleInfo.addCell(getBillingShippingCell("PIC Information"));
                document.add(tableTitleInfo.setMarginBottom(12f));
                
                Table tableTicketInfo = new Table(twoColumnWidth);
                tableTicketInfo.addCell(getCell10Left("Engineer", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Name", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextEngineer().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextCustomer().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("Problem", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Phone", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextProblem().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextPhone().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Customer Info", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("", Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextDescription().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("Ticket Description", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("Address", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextTicketDescription().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextAddress().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("Start Date", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("End Date", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextStartDate().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextEndDate().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left("Start Time", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left("End Time", Boolean.TRUE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextStartTime().getText(), Boolean.FALSE));
                tableTicketInfo.addCell(getCell10Left(detailActivityReport.getjTextEndTime().getText(), Boolean.FALSE));
                document.add(tableTicketInfo);
                
                
                Table tableDivider = new Table(fullwidth);
                Border dashedBorder = new DashedBorder(new DeviceRgb(128, 128, 128), 0.5f);
                document.add(tableDivider.setBorder(dashedBorder));
                
                Paragraph product = new Paragraph("# Job Details");
                document.add(product.setBold());
                Paragraph actionTaken = new Paragraph(detailActivityReport.getjTextActionTaken().getText());
                document.add(actionTaken);
                
                document.add(oneSp);
                document.add(tableDivider.setBorder(dashedBorder));
                
                Paragraph feedback = new Paragraph("# Customer Feedback");
                document.add(feedback.setBold());
                Paragraph feed = new Paragraph("How would you rate your level of satisfaction with reference to this job?");
                document.add(feed);
                Paragraph feedChoose = new Paragraph("|  | Very Satisfied - |  | Satisfied - |  | Dissastisfied - |  | Very Dissatisfied");
                document.add(feedChoose.setTextAlignment(TextAlignment.CENTER));
                
                document.add(tableDivider.setBorder(dashedBorder));
                
                Paragraph approval = new Paragraph("# Approval");
                document.add(approval.setBold());
                Table tableTTD = new Table(twoColumnWidth);
                tableTTD.addCell(new Cell().add(new Paragraph("Engineer Team")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableTTD.addCell(new Cell().add(new Paragraph("PIC Customer")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableTTD);
                document.add(oneSp);
                document.add(oneSp);
                document.add(oneSp);
                Table tableTTDName = new Table(twoColumnWidth);
                tableTTDName.addCell(new Cell().add(new Paragraph(detailActivityReport.getjTextEngineer().getText())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
                tableTTDName.addCell(new Cell().add(new Paragraph(detailActivityReport.getjTextCustomer().getText())).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER)).setMarginRight(15f);
                document.add(tableTTDName);
                document.add(divider);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(detailActivityReport, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
