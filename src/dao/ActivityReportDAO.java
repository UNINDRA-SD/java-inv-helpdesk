/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MysqlDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ActivityReportModel;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class ActivityReportDAO {
    Connection sql = MysqlDB.connection();
    Home home;
    
    public ActivityReportDAO(Home home) {
        this.home = home;
    }
    
    public List<ActivityReportModel> getActivityReports() {
        
        List<ActivityReportModel> activityReports = null;
        
        try {
            String query = "SELECT * FROM activity_reports ORDER BY id ASC";
           
            activityReports = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                ActivityReportModel activityReport = new ActivityReportModel();
                activityReport.setId(rslt.getInt("id"));
                activityReport.setDeliveryOrderId(rslt.getInt("delivery_order_id"));
                activityReport.setActionTaken(rslt.getString("action_taken"));
                activityReport.setStartDate(rslt.getString("start_date"));
                activityReport.setEndDate(rslt.getString("end_date"));
                activityReport.setStartTime(rslt.getString("start_time"));
                activityReport.setEndTime(rslt.getString("end_time"));
                activityReports.add(activityReport);
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
        return activityReports;
    }
    
    public boolean saveActivityReport(ActivityReportModel requestActivityReport){

        int doId = requestActivityReport.getDeliveryOrderId();
        String actionTaken = requestActivityReport.getActionTaken();
        String startDate = requestActivityReport.getStartDate();
        String endDate = requestActivityReport.getEndDate();
        String startTime = requestActivityReport.getStartTime();
        String endTime = requestActivityReport.getEndTime();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO activity_reports (delivery_order_id, action_taken, start_date, end_date, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,doId);
            stmt.setString(2,actionTaken);
            stmt.setString(3,startDate);
            stmt.setString(4,endDate);
            stmt.setString(5,startTime);
            stmt.setString(6,endTime);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public boolean updateActivityReport(ActivityReportModel requestActivityReport){

        int id = requestActivityReport.getId();
        int doId = requestActivityReport.getDeliveryOrderId();
        String actionTaken = requestActivityReport.getActionTaken();
        String startDate = requestActivityReport.getStartDate();
        String endDate = requestActivityReport.getEndDate();
        String startTime = requestActivityReport.getStartTime();
        String endTime = requestActivityReport.getEndTime();
        boolean isSuccess;
        
        try{
            String query = "UPDATE activity_reports SET delivery_order_id=?, action_taken=?, start_date=?, end_date=?, start_time=?, end_time=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,doId);
            stmt.setString(2,actionTaken);
            stmt.setString(3,startDate);
            stmt.setString(4,endDate);
            stmt.setString(5,startTime);
            stmt.setString(6,endTime);
            stmt.setInt(7,id);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteActivityReport(String id){
        try{
            String query="DELETE FROM activity_reports WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
