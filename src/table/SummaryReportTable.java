/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.SummaryReportModel;

/**
 *
 * @author dandy
 */
public class SummaryReportTable extends AbstractTableModel {
    
    List<SummaryReportModel> sumReports;
    
    private final String[] columnNames = {"#", "Ticket ID", "Problem", "Action Taken", "Asset ID", "Asset Name", "Asset Qty", "Asset Notes"};
    
    public SummaryReportTable(List<SummaryReportModel> sumReports) {
        this.sumReports = sumReports;
    }
    
    @Override
    public int getRowCount() {
        return sumReports.size();
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
        SummaryReportModel sumReport = sumReports.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return sumReport.getTicketId();
            case 2:
                return sumReport.getProblem();
            case 3:
                return sumReport.getActionTaken();
            case 4:
                return sumReport.getAssetId();
            case 5:
                return sumReport.getAssetName();
            case 6:
                return sumReport.getAssetQty();
            case 7:
                return sumReport.getSettleNotes();
            default:
                return null;
        }
    }
}
