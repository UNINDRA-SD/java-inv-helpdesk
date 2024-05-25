/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.AssetReportModel;

/**
 *
 * @author dandy
 */
public class AssetReportTable extends AbstractTableModel {
    private List<AssetReportModel> assetReports;
    private String[] columnNames;
    private boolean isAvailableStockSummary; // True for Available Stock Summary, false for Need To Restock Summary
    
    public AssetReportTable(List<AssetReportModel> assetReports, boolean isAvailableStockSummary) {
        this.assetReports = assetReports;
        this.isAvailableStockSummary = isAvailableStockSummary;
        
        if (isAvailableStockSummary) {
            this.columnNames = new String[] {"#", "Brand Name", "Category Name", "Total"};
        } else {
            this.columnNames = new String[] {"Asset ID", "Brand Name", "Category Name", "Asset Name", "Asset Model", "Quantity"};
        }
    }
    
    @Override
    public int getRowCount() {
        return assetReports.size();
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
        AssetReportModel assetReport = assetReports.get(rowIndex);
        
        if (isAvailableStockSummary) {
            switch (columnIndex) {
                case 0: return rowIndex + 1;
                case 1: return assetReport.getBrandName();
                case 2: return assetReport.getCategoryName();
                case 3: return assetReport.getTotal();
                default: return null;
            }
        } else {
            switch (columnIndex) {
                case 0: return assetReport.getAssetId();
                case 1: return assetReport.getBrandName();
                case 2: return assetReport.getCategoryName();
                case 3: return assetReport.getAssetName();
                case 4: return assetReport.getAssetModel();
                case 5: return assetReport.getQty();
                default: return null;
            }
        }
    }
}
