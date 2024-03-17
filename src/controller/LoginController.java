/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import javax.swing.JOptionPane;
import view.Frame_Login;
import view.main.Home;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserModel;

/**
 *
 * @author dandy
 */
public class LoginController {
    Frame_Login login;
    Home home;
    UserDAO userDAO;
    UserModel user = null;
    
    public LoginController(Frame_Login login) {
        this.login = login;
        userDAO = new UserDAO(this.home);
    }
    
    public void checkLogin(Frame_Login data) {
        if (!data.getEmail().getText().trim().isEmpty()
                && !data.getPassword().getText().trim().isEmpty()){
            
            String nama = data.getEmail().getText();
            String pass = get_SHA_512_SecurePassword(data.getPassword().getText(),"aplikasi");
            
            user = userDAO.loadUserLogin(nama, pass);
            
            if (user != null){
                home = new Home(user);
                home.setVisible(true);
                login.setVisible(false);
                
            } else {
                JOptionPane.showMessageDialog(data, "Username atau Password tidak cocok!","Pesan Kesalahan",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(data, "Isi Username dan Password!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
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
           }
        return generatedPassword;
    }
    
/*    public void checkLogin(Frame_Login data) {
        
        Connection sql = new MysqlDB().connection();
        if (!data.getEmail().getText().trim().isEmpty()
                && !data.getPassword().getText().trim().isEmpty()){
            
            String email = data.getEmail().getText();
            String password = data.getPassword().getText();
            
            String hashedPassword = null;
            String query = "SELECT password FROM users WHERE email = ?";
            try (PreparedStatement statement = sql.prepareStatement(query)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        hashedPassword = resultSet.getString("password");
                    }
                }
            } catch (SQLException e) {
            }

            if (hashedPassword != null && BCrypt.checkpw(password, hashedPassword)) {
                users = userDAO.loadUserLogin(email);
                home.setVisible(true);
                login.setVisible(false);
                
            } else {
                JOptionPane.showMessageDialog(data, "Username atau Password tidak cocok!","Pesan Kesalahan",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(data, "Isi Username dan Password!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }**/
}
