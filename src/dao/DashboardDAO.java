/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import config.MysqlDB;
import config.PostgresDB;
import java.util.ArrayList;
import java.util.List;
import model.DashboardModel;

/**
 *
 * @author dandy
 */
public class DashboardDAO {
//    Connection sql = MysqlDB.connection();
    Connection sql = PostgresDB.connection();
    
    public List<DashboardModel> getDashboardData() {
        List<DashboardModel> dashboardData = new ArrayList<>();
        String query = "SELECT t.id AS ticket_id, c.name AS customer_name, c.phone AS customer_phone, " +
                       "c.address AS customer_address, u.name AS user_name, t.problem, t.status, " +
                       "(SELECT id FROM delivery_orders WHERE ticket_id = t.id LIMIT 1) AS do_id " +
                       "FROM tickets t " +
                       "JOIN customers c ON t.customer_id = c.id " +
                       "JOIN users u ON t.user_id = u.id";

        try (PreparedStatement stmt = sql.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                DashboardModel model = new DashboardModel();
                model.setTicketId(rs.getInt("ticket_id"));
                model.setCustomerName(rs.getString("customer_name"));
                model.setCustomerPhone(rs.getString("customer_phone"));
                model.setCustomerAddress(rs.getString("customer_address"));
                model.setUserName(rs.getString("user_name"));
                model.setProblem(rs.getString("problem"));
                model.setStatus(rs.getString("status"));
                model.setDoId(rs.getInt("do_id")); // Can be null, hence default value will be handled in model
                
                dashboardData.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dashboardData;
    }

    public int getTotalTickets() {
        int totalTickets = 0;
        try {
            String query = "SELECT COUNT(*) FROM tickets";
            PreparedStatement stmt = sql.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalTickets = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalTickets;
    }

    public int getProgressTickets() {
        int progressTickets = 0;
        try {
            String query = "SELECT COUNT(*) FROM tickets WHERE status = 'Progress'";
            PreparedStatement stmt = sql.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                progressTickets = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progressTickets;
    }

    public int getPendingTickets() {
        int pendingTickets = 0;
        try {
            String query = "SELECT COUNT(*) FROM tickets WHERE status = 'Pending'";
            PreparedStatement stmt = sql.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pendingTickets = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingTickets;
    }
}
