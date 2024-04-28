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
import model.CustomerModel;
import view.main.Home;

/**
 *
 * @author LENOVO
 */
public class CustomerDAO {
    Connection sql = MysqlDB.connection();
    Home home;
    
    public CustomerDAO(Home home) {
        this.home = home;
    }
    
    public List<CustomerModel> getCustomers() {
        
        List<CustomerModel> customers = null;
        
        try {
            String query = "SELECT * FROM customers ORDER BY id ASC";
           
            customers = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                CustomerModel customer = new CustomerModel();
                customer.setId(rslt.getInt("id"));
                customer.setName(rslt.getString("name"));
                customer.setPhone(rslt.getString("phone"));
                customer.setAddress(rslt.getString("address"));
                customer.setDescription(rslt.getString("description"));
                customers.add(customer);
            }
        } catch (SQLException e) {
        }
        return customers;
    }
    
    public boolean saveCustomer(CustomerModel requestCustomer){

        String name = requestCustomer.getName();
        String phone = requestCustomer.getPhone();
        String address = requestCustomer.getAddress();
        String description = requestCustomer.getDescription();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO customers (name, phone, address, description) VALUES (?,?,?,?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setString(1,name);
            stmt.setString(2, phone);
            stmt.setString(3, address);
            stmt.setString(4, description);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true; 

            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    
    public boolean updateCustomer(CustomerModel requestCustomer){


        String name = requestCustomer.getName();
        String phone = requestCustomer.getPhone();
        String address = requestCustomer.getAddress();
        String description = requestCustomer.getDescription();
        int id = requestCustomer.getId();
        boolean isSuccess = false;
        
        try{
            String query = "UPDATE customers SET name=?, phone=?, address=?, description=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setString(1,name);
            stmt.setString(2,phone);
            stmt.setString(3,address);
            stmt.setString(4,description);
            stmt.setInt(5,id);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteCustomer(String id){
        
        try{
            
            String query="DELETE FROM customers WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
