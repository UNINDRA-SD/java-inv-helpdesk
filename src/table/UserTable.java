/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.UserModel;
/**
 *
 * @author dandy
 */
public class UserTable extends AbstractTableModel {
    
    List<UserModel> users;
    private final String[] columnNames = {"ID", "Email", "Name", "Role"};
    
    public UserTable(List<UserModel> users) {
        this.users = users;
    }
    
    @Override
    public int getRowCount() {
        return users.size();
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
        UserModel user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getEmail();
            case 2:
                return user.getName();
            case 3:
                return user.getRole();
            default:
                return null;
        }
    }
}
