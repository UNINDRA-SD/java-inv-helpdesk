/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.AssetModel;

/**
 *
 * @author dandy
 */
public class AssetTable extends AbstractTableModel {
    List<AssetModel> assets;
    
    private final String[] columnNames = {"ID", "Brand", "Category", "Rack", "Name", "Model", "Part Number", "Serial Number", "Description", "Qty"};
    
    public AssetTable(List<AssetModel> assets) {
        this.assets = assets;
    }
    
    @Override
    public int getRowCount() {
        return assets.size();
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
        AssetModel asset = assets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return asset.getId();
            case 1:
                return asset.getBrandNameById(asset.getBrandId());
            case 2:
                return asset.getCategoryNameById(asset.getCategoryId());
            case 3:
                return asset.getRackNameById(asset.getRackId());
            case 4:
                return asset.getName();
            case 5:
                return asset.getModelNumber();
            case 6:
                return asset.getPartNumber();
            case 7:
                return asset.getSerialNumber();
            case 8:
                return asset.getDescription();
            case 9:
                return asset.getQty();
            default:
                return null;
        }
    }
}
