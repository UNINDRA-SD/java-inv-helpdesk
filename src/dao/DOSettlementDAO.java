/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MysqlDB;
import model.DOSettlementModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author dandy
 */
public class DOSettlementDAO {
    Connection sql = MysqlDB.connection();
    
    public DOSettlementModel getDOSettlementById(int id) {
        DOSettlementModel doSettlement = null;

        try {
            String query = "SELECT * FROM do_settlements WHERE id = ?";
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rslt = stmt.executeQuery();

            if (rslt.next()) {
                doSettlement = new DOSettlementModel();
                doSettlement.setId(rslt.getInt("id"));
                doSettlement.setDoAssetId(rslt.getInt("do_asset_id"));
                doSettlement.setActivityReportId(rslt.getInt("activity_report_id"));
                doSettlement.setFaultModelNumber(rslt.getString("fault_model_number"));
                doSettlement.setFaultPartNumber(rslt.getString("fault_part_number"));
                doSettlement.setFaultSerialNumber(rslt.getString("fault_serial_number"));
                doSettlement.setFaultName(rslt.getString("fault_name"));
                doSettlement.setFaultQty(rslt.getInt("fault_qty"));
                doSettlement.setNotes(rslt.getString("notes"));
            }

            rslt.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }

        return doSettlement;
    }
    
    public boolean saveSettlement(DOSettlementModel requestSettlement) {
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO do_settlements (do_asset_id, activity_report_id, fault_model_number, fault_part_number, fault_serial_number, fault_name, fault_qty, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,requestSettlement.getDoAssetId());
            stmt.setInt(2,requestSettlement.getActivityReportId());
            stmt.setString(3,requestSettlement.getFaultModelNumber());
            stmt.setString(4,requestSettlement.getFaultModelNumber());
            stmt.setString(5,requestSettlement.getFaultSerialNumber());
            stmt.setString(6,requestSettlement.getFaultName());
            stmt.setInt(7,requestSettlement.getFaultQty());
            stmt.setString(8,requestSettlement.getNotes());
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public boolean updateSettlement(DOSettlementModel requestSettlement) {
        boolean isSuccess;
        
        try{
            var query = "UPDATE do_settlements SET do_asset_id=?, activity_Report_id=?, fault_model_number=?, fault_part_number=?, fault_serial_number=?, fault_name=?, fault_qty=?, notes=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,requestSettlement.getDoAssetId());
            stmt.setInt(2,requestSettlement.getActivityReportId());
            stmt.setString(3,requestSettlement.getFaultModelNumber());
            stmt.setString(4,requestSettlement.getFaultModelNumber());
            stmt.setString(5,requestSettlement.getFaultSerialNumber());
            stmt.setString(6,requestSettlement.getFaultName());
            stmt.setInt(7,requestSettlement.getFaultQty());
            stmt.setString(8,requestSettlement.getNotes());
            stmt.setInt(9,requestSettlement.getId());
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void updateStatusAndQtyByDoAssetId(int qty, int id) {
        String query = "UPDATE do_assets SET status='Installed', qty=? WHERE id=?";
        try (PreparedStatement stmt = sql.prepareStatement(query)) {
            stmt.setInt(1, qty);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException err) {
            System.out.println(err);
        }
    }
    
    public void updateStockAssetId(int qty, int id) {
        String query = "UPDATE assets SET qty=qty+? WHERE id=?";
        try (PreparedStatement stmt = sql.prepareStatement(query)) {
            stmt.setInt(1, qty);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException err) {
            System.out.println(err);
        }
    }

}
