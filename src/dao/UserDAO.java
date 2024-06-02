/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import config.MysqlDB;
import config.PostgresDB;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.UserModel;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class UserDAO {
//    Connection sql = MysqlDB.connection();
    Connection sql = PostgresDB.connection();
    Home home;
    
    public UserDAO(Home home) {
        this.home = home;
    }
    
    public List<UserModel> getUsers() {
        
        List<UserModel> users = null;
        
        try {
            String query = "SELECT * FROM users ORDER BY id ASC";
           
            users = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                UserModel user = new UserModel();
                user.setId(rslt.getInt("id"));
                user.setEmail(rslt.getString("email"));
                user.setName(rslt.getString("name"));
                user.setRole(rslt.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
        }
        return users;
    }
    
    public List<UserModel> getEngineers() {
        
        List<UserModel> users = null;
        
        try {
            String query = "SELECT * FROM users WHERE role = 'Engineer' ORDER BY id ASC";
           
            users = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                UserModel user = new UserModel();
                user.setId(rslt.getInt("id"));
                user.setEmail(rslt.getString("email"));
                user.setName(rslt.getString("name"));
                user.setRole(rslt.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
        }
        return users;
    }
    
    public List<UserModel> getWarehouses() {
        
        List<UserModel> users = null;
        
        try {
            String query = "SELECT * FROM users WHERE role = 'Warehouse' ORDER BY id ASC";
           
            users = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                UserModel user = new UserModel();
                user.setId(rslt.getInt("id"));
                user.setEmail(rslt.getString("email"));
                user.setName(rslt.getString("name"));
                user.setRole(rslt.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
        }
        return users;
    }
    
    public boolean saveUser(UserModel requestUser){

        String email = requestUser.getEmail();
        String name = requestUser.getName();
        String password = get_SHA_512_SecurePassword(requestUser.getPassword(),"aplikasi");
        String role = requestUser.getRole();
        boolean isSuccess = false;
        
        try{
            String query = "INSERT INTO users (email, name, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setString(1,email);
            stmt.setString(2,name);
            stmt.setString(3,password);
            stmt.setString(4,role);
            stmt.executeUpdate();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public boolean updateUser(UserModel requestUser){

        String email = requestUser.getEmail();
        String name = requestUser.getName();
        String password = get_SHA_512_SecurePassword(requestUser.getPassword(),"aplikasi");
        String role = requestUser.getRole();
        int id = requestUser.getId();
        boolean isSuccess;
        
        try{
            String query = "UPDATE users SET email=?, name=?, password=?, role=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setString(1,email);
            stmt.setString(2,name);
            stmt.setString(3,password);
            stmt.setString(4,role);
            stmt.setInt(5,id);
            stmt.executeUpdate();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteUser(String id){
        
        try{
            
            String query="DELETE FROM users WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public UserModel loadUserLogin(String email, String pass) {
        UserModel user = null;

        try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, pass);
            ResultSet rslt = stmt.executeQuery();

            if (rslt.next()) {
                user = new UserModel();
                user.setId(rslt.getInt("id"));
                user.setEmail(rslt.getString("email"));
                user.setName(rslt.getString("name"));
                user.setRole(rslt.getString("role"));
                user.setPassword(rslt.getString("password"));
            }
        } catch (SQLException err) {
        }
        return user;
    }
    
    public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
            try {
                md.update(salt.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             byte[] bytes = null;
            try {
                bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             StringBuilder sb = new StringBuilder();
             for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             generatedPassword = sb.toString();
            } 
           catch (NoSuchAlgorithmException e){
            e.printStackTrace();
           }
        return generatedPassword;
    }
}
