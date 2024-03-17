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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BrandModel;
import model.UserModel;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class BrandDAO {
    Connection sql = MysqlDB.connection();
    Home home;
    
    public BrandDAO(Home home) {
        this.home = home;
    }
    
    public List<BrandModel> getBrands() {
        
        List<BrandModel> brands = null;
        
        try {
            String query = "select * from brands order by id asc";
           
            brands = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                BrandModel brand = new BrandModel();
                brand.setId(rslt.getInt("id"));
                brand.setName(rslt.getString("name"));
                brands.add(brand);
            }
        } catch (SQLException e) {
        }
        return brands;
    }
    
    public boolean saveBrand(BrandModel requestBrand){

        String name = requestBrand.getName();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO brands (name) VALUES (?)";
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
    
    public boolean updateBrand(BrandModel requestBrand){


        String name = requestBrand.getName();
        int id = requestBrand.getId();
        boolean isSuccess = false;
        
        try{
            String query = "UPDATE brands SET name=? WHERE id=?";
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
    
    public void deleteBrand(String id){
        
        try{
            
            String query="DELETE FROM brands WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
