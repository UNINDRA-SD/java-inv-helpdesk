/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.RackModel;

/**
 *
 * @author AGUS NUGROGHO S
 */
public class RackTable extends AbstractTableModel {
     List<RackModel> racks;
    
    private final String[] columnNames = {"ID", "Racks Name"};
    
    public RackTable(List<RackModel> racks) {
        this.racks = racks;
    }
    
    @Override
    public int getRowCount() {
        return racks.size();
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
        RackModel rack = racks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rack.getId();
            case 1:
                return rack.getName();
            default:
                return null;
        }
    }
    
}
