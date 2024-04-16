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
 * @author Aspire
 */
public class TicketModel {
    private int id;
    private int customerId;
    private String status;
    private String problem;
    private String description;

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
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }
    
     public String getCustomerNameById(int customerId) {
        Connection sql = MysqlDB.connection();
        String customerName = null;

        try {
            String query = "SELECT name FROM customers WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, customerId);
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
     
      public int getCustomerIdByName(String customerName) {
        Connection sql = MysqlDB.connection();
        int customer = 0;

        try {
            String query = "SELECT id FROM customers WHERE name=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setString(1, customerName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return customer;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
    
 public String getBrandNameById(int brandId) {
        Connection sql = MysqlDB.connection();
        String brandName = null;

        try {
            String query = "SELECT name FROM brands WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, brandId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                brandName = rs.getString("name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return brandName;
    }
}
