/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DeliveryOrderModel;

/**
 *
 * @author ACER
 */
public class DeliveryOrderTable extends AbstractTableModel {
    List<DeliveryOrderModel> deliveryOrders;
    
    private final String[] columnNames = {"ID", "Ticket ID", "PIC Warehouse", "Notes"};
    
    public DeliveryOrderTable(List<DeliveryOrderModel> deliveryOrders) {
        this.deliveryOrders = deliveryOrders;
    }
    
    @Override
    public int getRowCount() {
        return deliveryOrders.size();
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
        DeliveryOrderModel deliveryOrder = deliveryOrders.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return deliveryOrder.getId();
            case 1:
                return deliveryOrder.getTicketId();
            case 2:
                return deliveryOrder.getUserWHNameById(deliveryOrder.getUserId());
            case 3:
                return deliveryOrder.getNotes();
            default:
                return null;
        }
    }
}
