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
import model.CategoryModel;
import view.main.Home;

/**
 *
 * @author Farhan
 */
public class CategoryDAO {
    Connection sql = MysqlDB.connection();
    Home home;
    
    public CategoryDAO(Home home) {
        this.home = home;
    }
    
    public List<CategoryModel> getCategories() {
        
        List<CategoryModel> categories = null;
        
        try {
            String query = "select * from categories order by id asc";
           
            categories = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                CategoryModel category = new CategoryModel();
                category.setId(rslt.getInt("id"));
                category.setName(rslt.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
        }
        return categories;
    }
    public boolean saveCategory(CategoryModel requestCategory){

        String name = requestCategory.getName();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO categories (name) VALUES (?)";
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
    
    public boolean updateCategory(CategoryModel requestCategory){


        String name = requestCategory.getName();
        int id = requestCategory.getId();
        boolean isSuccess = false;
        
        try{
            String query = "UPDATE categories SET name=? WHERE id=?";
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
    
    public void deleteCategory(String id){
        
        try{
            
            String query="DELETE FROM categories WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
