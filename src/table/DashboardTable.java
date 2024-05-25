/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DashboardModel;

/**
 *
 * @author dandy
 */
public class DashboardTable extends AbstractTableModel {
    private final List<DashboardModel> dashboardData;
    private final String[] columnNames = {"Ticket ID", "Customer Name", "Customer Phone", "Customer Address", "Engineer", "Problem", "DO ID", "Status"};

    public DashboardTable(List<DashboardModel> dashboardData) {
        this.dashboardData = dashboardData;
    }

    @Override
    public int getRowCount() {
        return dashboardData.size();
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
        DashboardModel dashboardModel = dashboardData.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dashboardModel.getTicketId();
            case 1:
                return dashboardModel.getCustomerName();
            case 2:
                return dashboardModel.getCustomerPhone();
            case 3:
                return dashboardModel.getCustomerAddress();
            case 4:
                return dashboardModel.getUserName();
            case 5:
                return dashboardModel.getProblem();
            case 6:
                int doId = dashboardModel.getDoId();
                return doId > 0 ? doId : "Not Created";
            case 7:
                return dashboardModel.getStatus();
            default:
                return null;
        }
    }
}
