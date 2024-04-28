/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DOAssetModel;

/**
 *
 * @author ACER
 */
public class DOAssetTable extends AbstractTableModel {
    List<DOAssetModel> doAssets;
    
    private final String[] columnNames = {"ID", "Asset ID", "Brand", "Name", "Model/PN", "Serial Number", "Qty"};
    
    public DOAssetTable(List<DOAssetModel> doAssets) {
        this.doAssets = doAssets;
    }
    
    @Override
    public int getRowCount() {
        return doAssets.size();
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
        DOAssetModel doAsset = doAssets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return doAsset.getId();
            case 1:
                return doAsset.getAssetId();
            case 2:
                return doAsset.getAssetBrandById(doAsset.getAssetId());
            case 3:
                return doAsset.getAssetCategoryById(doAsset.getAssetId()) + "/" + doAsset.getAssetNameById(doAsset.getAssetId());
            case 4:
                return doAsset.getAssetModelById(doAsset.getAssetId());
            case 5:
                return doAsset.getAssetSerialNumberById(doAsset.getAssetId());
            case 6:
                return doAsset.getQty();
            default:
                return null;
        }
    }
}
