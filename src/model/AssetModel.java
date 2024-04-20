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
 * @author dandy
 */
public class AssetModel {
    private int id;
    private int brandId;
    private int categoryId;
    private int rackId;
    private String name;
    private String modelNumber;
    private String partNumber;
    private String serialNumber;
    private String description;
    private int qty;
    
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
     * @return the brandId
     */
    public int getBrandId() {
        return brandId;
    }

    /**
     * @param brandId the brandId to set
     */
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
    
    public String getBrandNameById(int brandId) {
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
    
    public int getBrandIdByName(String brandName) {
        int brand = 0;

        try {
            String query = "SELECT id FROM brands WHERE name=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setString(1, brandName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                brand = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return brand;
    }


    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getCategoryNameById(int categoryId) {
        String categoryName = null;

        try {
            String query = "SELECT name FROM categories WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                categoryName = rs.getString("name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return categoryName;
    }
    
    public int getCategoryIdByName(String categoryName) {
        int category = 0;

        try {
            String query = "SELECT id FROM categories WHERE name=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                category = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return category;
    }

    /**
     * @return the rackId
     */
    public int getRackId() {
        return rackId;
    }

    /**
     * @param rackId the rackId to set
     */
    public void setRackId(int rackId) {
        this.rackId = rackId;
    }
    
    public String getRackNameById(int rackId) {
        String rackName = null;

        try {
            String query = "SELECT name FROM racks WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, rackId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rackName = rs.getString("name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return rackName;
    }
    
    public int getRackIdByName(String rackName) {
        int rack = 0;

        try {
            String query = "SELECT id FROM racks WHERE name=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setString(1, rackName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rack = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return rack;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the modelNumber
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * @param modelNumber the modelNumber to set
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * @return the partNumber
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * @param partNumber the partNumber to set
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    
}
