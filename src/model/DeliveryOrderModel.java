/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.MysqlDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class DeliveryOrderModel {
    private int id;
    private int ticketId;
    private int userId; //warehouse tim
    private String notes;
    
    Connection sql = MysqlDB.connection();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }
    
    public String getTicketStatusById(int ticket) {
        String ticketStatus = null;

        try {
            String query = "SELECT status FROM tickets WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, ticket);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ticketStatus = rs.getString("status");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return ticketStatus;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUserWHNameById(int userId) {
        String userName = null;

        try {
            String query = "SELECT name FROM users WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userName = rs.getString("name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return userName;
    }
     
      public int getUserWHIdByName(String userName) {
        int user = 0;

        try {
            String query = "SELECT id FROM users WHERE name=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return user;
    }

    /**
     * @return the description
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the description to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getCustomerNameByTicketId(int ticketId) {
        String customerName = null;

        try {
            String query = "SELECT c.name " +
                           "FROM tickets t " +
                           "JOIN customers c ON t.customer_id = c.id " +
                           "WHERE t.id = ?";

            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setInt(1, ticketId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customerName = rs.getString("name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }

        return customerName;
    }
    
    public String getEngineerNameByTicketId(int ticketId) {
        String userName = null;

        try {
            String query = "SELECT u.name " +
                           "FROM tickets t " +
                           "JOIN users u ON t.user_id = u.id " +
                           "WHERE t.id = ?";

            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setInt(1, ticketId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userName = rs.getString("name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }

        return userName;
    }
    
    public String getTicketProblemById(int ticketId) {
        String ticketProblem = null;

        try {
            String query = "SELECT problem FROM tickets WHERE id = ?";

            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setInt(1, ticketId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ticketProblem = rs.getString("problem");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }

        return ticketProblem;
    }
    
    public String getTicketDescriptionById(int ticketId) {
        String ticketDescription = null;

        try {
            String query = "SELECT description FROM tickets WHERE id = ?";

            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setInt(1, ticketId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ticketDescription = rs.getString("description");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }

        return ticketDescription;
    }

}
