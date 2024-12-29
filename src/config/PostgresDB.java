package config;

import org.postgresql.ds.PGSimpleDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dandy
 */
public class PostgresDB {
    static Connection con;
    
    public static Connection connection() {
    
        if (con == null) {
            PGSimpleDataSource dataSource = new PGSimpleDataSource();
            dataSource.setServerName("aws-0-ap-southeast-1.pooler.supabase.com");
            dataSource.setPortNumber(5432);
            dataSource.setDatabaseName("postgres");
            dataSource.setUser("postgres.ungrigzxcktkoirwwgjy");  // Ganti dengan username PostgreSQL Anda
            dataSource.setPassword("unindra-kkp-s7d");  // Ganti dengan password PostgreSQL Anda
            
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
