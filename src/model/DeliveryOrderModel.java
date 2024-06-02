/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.MysqlDB;
import config.PostgresDB;
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
    
//    Connection sql = MysqlDB.connection();
    Connection sql = PostgresDB.connection();
    
    private String status;
    private String problem;
    private String description;
    private String customerName;
    private String customerDescription;
    private String customerPhone;
    private String customerAddress;
    private String engineerName;

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

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerDescription
     */
    public String getCustomerDescription() {
        return customerDescription;
    }

    /**
     * @param customerDescription the customerDescription to set
     */
    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    /**
     * @return the engineerName
     */
    public String getEngineerName() {
        return engineerName;
    }

    /**
     * @param engineerName the engineerName to set
     */
    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    /**
     * @return the customerPhone
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * @param customerPhone the customerPhone to set
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * @return the customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
