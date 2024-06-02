/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MysqlDB;
import config.PostgresDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.AssetModel;

/**
 *
 * @author dandy
 */
public class AssetDAO {
//    Connection sql = MysqlDB.connection();
    Connection sql = PostgresDB.connection();
    
    public List<AssetModel> getAssets() {
        
        List<AssetModel> assets = null;
        
        try {
            String query = "select * from assets order by id asc";
           
            assets = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                AssetModel asset = new AssetModel();
                asset.setId(rslt.getInt("id"));
                asset.setBrandId(rslt.getInt("brand_id"));
                asset.setCategoryId(rslt.getInt("category_id"));
                asset.setRackId(rslt.getInt("rack_id"));
                asset.setName(rslt.getString("name"));
                asset.setModelNumber(rslt.getString("model_number"));
                asset.setPartNumber(rslt.getString("part_number"));
                asset.setSerialNumber(rslt.getString("serial_number"));
                asset.setDescription(rslt.getString("description"));
                asset.setQty(rslt.getInt("qty"));
                assets.add(asset);
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assets;
    }
            
    public List<AssetModel> getAvailableAssets() {
        
        List<AssetModel> assets = null;
        
        try {
            String query = "SELECT * FROM assets WHERE qty > 0 ORDER BY id ASC";
           
            assets = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                AssetModel asset = new AssetModel();
                asset.setId(rslt.getInt("id"));
                asset.setBrandId(rslt.getInt("brand_id"));
                asset.setCategoryId(rslt.getInt("category_id"));
                asset.setRackId(rslt.getInt("rack_id"));
                asset.setName(rslt.getString("name"));
                asset.setModelNumber(rslt.getString("model_number"));
                asset.setPartNumber(rslt.getString("part_number"));
                asset.setSerialNumber(rslt.getString("serial_number"));
                asset.setDescription(rslt.getString("description"));
                asset.setQty(rslt.getInt("qty"));
                assets.add(asset);
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
        return assets;
    }
    
    public boolean saveAsset(AssetModel requestAsset){

        int brandId = requestAsset.getBrandId();
        int categoryId = requestAsset.getCategoryId();
        int rackId = requestAsset.getRackId();
        String name = requestAsset.getName();
        String modelNumber = requestAsset.getModelNumber();
        String partNumber = requestAsset.getPartNumber();
        String serialNumber = requestAsset.getSerialNumber();
        String description = requestAsset.getDescription();
        int qty = requestAsset.getQty();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO assets (brand_id, category_id, rack_id, name, model_number, part_number, serial_number, description, qty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,brandId);
            stmt.setInt(2,categoryId);
            stmt.setInt(3,rackId);
            stmt.setString(4,name);
            stmt.setString(5,modelNumber);
            stmt.setString(6,partNumber);
            stmt.setString(7,serialNumber);
            stmt.setString(8,description);
            stmt.setInt(9,qty);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public boolean updateAsset(AssetModel requestAsset){

        int brandId = requestAsset.getBrandId();
        int categoryId = requestAsset.getCategoryId();
        int rackId = requestAsset.getRackId();
        String name = requestAsset.getName();
        String modelNumber = requestAsset.getModelNumber();
        String partNumber = requestAsset.getPartNumber();
        String serialNumber = requestAsset.getSerialNumber();
        String description = requestAsset.getDescription();
        int qty = requestAsset.getQty();
        int id = requestAsset.getId();
        boolean isSuccess;
        
        try{
            String query = "UPDATE assets SET brand_id=?, category_id=?, rack_id=?, name=?, model_number=?, part_number=?, serial_number=?, description=?, qty=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,brandId);
            stmt.setInt(2,categoryId);
            stmt.setInt(3,rackId);
            stmt.setString(4,name);
            stmt.setString(5,modelNumber);
            stmt.setString(6,partNumber);
            stmt.setString(7,serialNumber);
            stmt.setString(8,description);
            stmt.setInt(9,qty);
            stmt.setInt(10, id);
            stmt.executeLargeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteAsset(String id){
        
        try{
            
            String query="DELETE FROM assets WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
