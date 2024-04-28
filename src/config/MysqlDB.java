/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dandy
 */
public class MysqlDB {
    static Connection con;
    
    public static Connection connection() {
    
        if (con == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPortNumber(3306);
            dataSource.setDatabaseName("java");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            try {
                con = dataSource.getConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Unable to connect to the database.\n" +
                        "Please check the server settings and try again.",
                        "Database Connection Error",
                        JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
                System.out.println("[ERROR] Database Can't Connect, Application Will Automatically Shutdown!");
                System.exit(0);
            }
        }
    
        return con;
    }
}
