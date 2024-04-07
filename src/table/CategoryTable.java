/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.CategoryModel;

/**
 *
 * @author Farhan
 */
public class CategoryTable extends AbstractTableModel {
    List<CategoryModel> categories;
    
    private final String[] columnNames = {"ID", "Category Name"};
    
    public CategoryTable(List<CategoryModel> categories) {
        this.categories = categories;
    }
    
    @Override
    public int getRowCount() {
        return categories.size();
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
        CategoryModel category = categories.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return category.getId();
            case 1:
                return category.getName();
            default:
                return null;
        }
    }
    
}
