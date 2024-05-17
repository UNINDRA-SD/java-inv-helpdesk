/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MysqlDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DOAssetModel;

/**
 *
 * @author ACER
 */
public class DOAssetDAO {
    Connection sql = MysqlDB.connection();
    
    public List<DOAssetModel> getDOAssets(int doId) {
        List<DOAssetModel> doAssets = new ArrayList<>();

        try {
            String query = "SELECT * FROM do_assets WHERE delivery_order_id=?";
            PreparedStatement stmt = sql.prepareStatement(query);

            // Set parameter
            stmt.setInt(1, doId);

            // Execute query
            ResultSet rslt = stmt.executeQuery();

            // Process results
            while (rslt.next()) {
                DOAssetModel doAsset = new DOAssetModel();
                doAsset.setId(rslt.getInt("id"));
                doAsset.setDeliveryOrderId(rslt.getInt("delivery_order_id"));
                doAsset.setAssetId(rslt.getInt("asset_id"));
                doAsset.setQty(rslt.getInt("qty"));
                doAsset.setStatus(rslt.getString("status"));
                doAssets.add(doAsset);
            }

            // Close ResultSet and PreparedStatement
            rslt.close();
            stmt.close();
        } catch (SQLException err) {
            // Handle SQL exception
            err.printStackTrace();
        }

        return doAssets;
    }
    
    public boolean saveDOAsset(DOAssetModel requestDOAsset){

        int doId = requestDOAsset.getDeliveryOrderId();
        int assetId = requestDOAsset.getAssetId();
        int qty = requestDOAsset.getQty();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO do_assets (delivery_order_id, asset_id, qty, status) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,doId);
            stmt.setInt(2,assetId);
            stmt.setInt(3,qty);
            stmt.setString(4, "Deliver");
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteDOAsset(Connection connection, String id) throws SQLException {
        String query = "DELETE FROM do_assets WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Setel parameter ID dalam query
            stmt.setInt(1, Integer.parseInt(id));
            // Jalankan pernyataan
            stmt.executeUpdate();
        }
    }

//    public void deleteDOAsset(String id){
//        
//        try{
//            
//            String query="DELETE FROM do_assets WHERE id="+id;
//            PreparedStatement stmt = sql.prepareStatement(query);
//            stmt.executeUpdate();
//            stmt.close();
//            
//        }catch(SQLException err){
//            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    public int getDOSettlementIDByDOAssetId(int id) {
        int doSettlementID = -1;
        try {
            String query = "SELECT id FROM do_settlements WHERE do_asset_id = ?";

            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                doSettlementID = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return doSettlementID;
    }

}
