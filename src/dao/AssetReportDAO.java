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
import java.util.ArrayList;
import java.util.List;
import model.AssetReportModel;
/**
 *
 * @author dandy
 */
public class AssetReportDAO {
//    Connection sql = MysqlDB.connection();
    Connection sql = PostgresDB.connection();
    
    public List<AssetReportModel> getAvailableStockSummary() {
        List<AssetReportModel> assetReports = new ArrayList<>();
        String query = "SELECT "
            + "a.brand_id, "
            + "a.category_id, "
            + "MAX(b.name) AS brand_name, "
            + "MAX(c.name) AS category_name, "
            + "SUM(a.qty) AS total "
            + "FROM assets a "
            + "JOIN brands b ON a.brand_id = b.id "
            + "JOIN categories c ON a.category_id = c.id "
            + "GROUP BY a.brand_id, a.category_id";

        try (PreparedStatement stmt = sql.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AssetReportModel assetReport = new AssetReportModel();
                assetReport.setBrandName(rs.getString("brand_name"));
                assetReport.setCategoryName(rs.getString("category_name"));
                assetReport.setTotal(rs.getInt("total"));
                assetReports.add(assetReport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assetReports;
    }
    
    public List<AssetReportModel> getNeedToRestockSummary() {
        List<AssetReportModel> assetReports = new ArrayList<>();
        String query = "SELECT a.id AS asset_id, "
                     + "b.name AS brand_name, "
                     + "c.name AS category_name, "
                     + "a.name AS asset_name, "
                     + "a.model_number AS asset_model, "
                     + "a.qty AS qty "
                     + "FROM assets a "
                     + "JOIN brands b ON a.brand_id = b.id "
                     + "JOIN categories c ON a.category_id = c.id "
                     + "WHERE a.qty < 5";

        try (PreparedStatement stmt = sql.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AssetReportModel assetReport = new AssetReportModel();
                assetReport.setAssetId(rs.getInt("asset_id"));
                assetReport.setBrandName(rs.getString("brand_name"));
                assetReport.setCategoryName(rs.getString("category_name"));
                assetReport.setAssetName(rs.getString("asset_name"));
                assetReport.setAssetModel(rs.getString("asset_model"));
                assetReport.setQty(rs.getInt("qty"));
                assetReports.add(assetReport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assetReports;
    }
}
