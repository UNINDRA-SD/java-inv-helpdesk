/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.BrandModel;

/**
 *
 * @author dandy
 */
public class BrandTable extends AbstractTableModel {
    
    List<BrandModel> brands;
    
    private final String[] columnNames = {"ID", "Brand Name"};
    
    public BrandTable(List<BrandModel> brands) {
        this.brands = brands;
    }
    
    @Override
    public int getRowCount() {
        return brands.size();
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
        BrandModel brand = brands.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return brand.getId();
            case 1:
                return brand.getName();
            default:
                return null;
        }
    }
}
