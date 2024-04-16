/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TicketModel;

/**
 *
 * @author Aspire
 */
public class TicketTable extends AbstractTableModel {
        List<TicketModel> tickets;
    
    private final String[] columnNames = {"ID", "Customer", "Problem", "Description", "Status"};
    
    public TicketTable(List<TicketModel> tickets) {
        this.tickets = tickets;
    }
    
    @Override
    public int getRowCount() {
        return tickets.size();
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
        TicketModel ticket = tickets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ticket.getId();
            case 1:
                return ticket.getCustomerNameById(ticket.getId());
            case 2:
                return ticket.getProblem();
            case 3:
                return ticket.getDescription();
            case 4:
                return ticket.getStatus();
            default:
                return null;
        }
    }
}
