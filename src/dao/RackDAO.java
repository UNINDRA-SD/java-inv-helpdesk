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
import model.RackModel;
import view.main.Home;

/**
 *
 * @author AGUS NUGROGHO S
 */
public class RackDAO {
//    Connection sql = MysqlDB.connection();
    Connection sql = PostgresDB.connection();
    Home home;
    
    public RackDAO(Home home) {
        this.home = home;
    }
    
    public List<RackModel> getRacks() {
        
        List<RackModel> racks = null;
        
        try {
            String query = "select * from racks order by id asc";
           
            racks = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                RackModel rack = new RackModel();
                rack.setId(rslt.getInt("id"));
                rack.setName(rslt.getString("name"));
                racks.add(rack);
            }
        } catch (SQLException e) {
        }
        return racks;
    }
    
    public boolean saveRack(RackModel requestRack){

        String name = requestRack.getName();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO racks (name) VALUES (?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setString(1,name);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public boolean updateRack(RackModel requestRack){


        String name = requestRack.getName();
        int id = requestRack.getId();
        boolean isSuccess = false;
        
        try{
            String query = "UPDATE racks SET name=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setString(1,name);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteRack(String id){
        
        try{
            
            String query="DELETE FROM racks WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
