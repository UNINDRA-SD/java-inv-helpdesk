/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ActivityReportDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.ActivityReportModel;
import table.ActivityReportTable;
import view.Frame_CreateActivityReport;
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
}
