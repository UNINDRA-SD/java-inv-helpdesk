/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.CustomerModel;

/**
 *
 * @author LENOVO
 */
public class CustomerTable extends AbstractTableModel {
        List<CustomerModel> customers;
    
    private final String[] columnNames = {"ID", "Customer Name", "Phone", "Address" };
    
    public CustomerTable(List<CustomerModel> customers) {
        this.customers = customers;
    }
    
    @Override
    public int getRowCount() {
        return customers.size();
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
        CustomerModel customer = customers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getId();
            case 1:
                return customer.getName();
            case 2:
                return customer.getPhone();
            case 3:
                return customer.getAddress();
            default:
                return null;
        }
    }
}
