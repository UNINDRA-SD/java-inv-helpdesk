/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ActivityReportModel;

/**
 *
 * @author dandy
 */
public class ActivityReportTable extends AbstractTableModel {
    List<ActivityReportModel> activityReports;
    
    private final String[] columnNames = {"ID", "DO ID", "Action Taken", "Start Date", "End Date"};
    
    public ActivityReportTable(List<ActivityReportModel> activityReports) {
        this.activityReports = activityReports;
    }
    
    @Override
    public int getRowCount() {
        return activityReports.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ActivityReportModel activityReport = activityReports.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return activityReport.getId();
            case 1:
                return activityReport.getDeliveryOrderId();
            case 2:
                return activityReport.getActionTaken();
            case 3:
                return activityReport.getStartDate() + " | " + activityReport.getStartTime();
            case 4:
                return activityReport.getEndDate() + " | " + activityReport.getEndTime();
            default:
                return null;
        }
    }
}
