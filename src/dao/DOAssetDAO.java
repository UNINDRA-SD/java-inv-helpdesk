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

}
