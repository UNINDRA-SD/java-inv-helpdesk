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
public class DOAssetModel {
    private int id;
    private int deliveryOrderId;
    private int assetId;
    private int qty;
    private String status;
    
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
     * @return the deliveryOrderId
     */
    public int getDeliveryOrderId() {
        return deliveryOrderId;
    }

    /**
     * @param deliveryOrderId the deliveryOrderId to set
     */
    public void setDeliveryOrderId(int deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    /**
     * @return the assetId
     */
    public int getAssetId() {
        return assetId;
    }

    /**
     * @param assetId the assetId to set
     */
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }
    
    public String getAssetBrandById(int assetId) {
        String assetBrand = null;

        try {
            String query = """
                           SELECT brands.name AS brand_name
                           FROM do_assets
                           INNER JOIN assets ON do_assets.asset_id = assets.id
                           INNER JOIN brands ON assets.brand_id = brands.id
                           WHERE do_assets.asset_id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetBrand = rs.getString("brand_name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetBrand;
    }
    
    public String getAssetCategoryById(int assetId) {
        String assetCategory = null;

        try {
            String query = """
                           SELECT categories.name AS category_name
                           FROM do_assets
                           INNER JOIN assets ON do_assets.asset_id = assets.id
                           INNER JOIN categories ON assets.category_id = categories.id
                           WHERE do_assets.asset_id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetCategory = rs.getString("category_name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetCategory;
    }
    
    public String getAssetNameById(int assetId) {
        String assetName = null;

        try {
            String query = """
                           SELECT name
                           FROM assets
                           WHERE id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetName = rs.getString("name");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetName;
    }
    
    public String getAssetModelById(int assetId) {
        String assetModel = null;

        try {
            String query = """
                           SELECT model_number
                           FROM assets
                           WHERE id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetModel = rs.getString("model_number");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetModel;
    }
    
    public String getAssetPartNumberById(int assetId) {
        String assetPN = null;

        try {
            String query = """
                           SELECT part_number
                           FROM assets
                           WHERE id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetPN = rs.getString("part_number");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetPN;
    }
    
    public String getAssetSerialNumberById(int assetId) {
        String assetSN = null;

        try {
            String query = """
                           SELECT serial_number
                           FROM assets
                           WHERE id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetSN = rs.getString("serial_number");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetSN;
    }
    
    public String getAssetDescriptionById(int assetId) {
        String assetDesc = null;

        try {
            String query = """
                           SELECT description
                           FROM assets
                           WHERE id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetDesc = rs.getString("description");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetDesc;
    }
    
    public int getAssetQtyById(int assetId) {
        int assetQty = 0;

        try {
            String query = """
                           SELECT qty
                           FROM assets
                           WHERE id = ?;""";
            PreparedStatement stmt = sql.prepareStatement(query);

            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                assetQty = rs.getInt("qty");
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assetQty;
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

    

    
    
    
}
