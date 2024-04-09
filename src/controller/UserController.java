/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.UserModel;
import table.UserTable;
import view.Frame_CreateUser;
import view.form.Form_Users;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class UserController {
    
    Home home;
    Form_Users formUsers;
    UserDAO userDAO;
    List<UserModel> users;
    
    public UserController(Form_Users formUsers, Home home) {
        this.home = home;
        this.formUsers = formUsers;
        userDAO = new UserDAO(this.home);
    }
    
    public void showUsers() {
        users = userDAO.getUsers();
        UserTable userTable = new UserTable(users);
        formUsers.getDataTable().setModel(userTable);
    }
    
    public void saveUser(Frame_CreateUser createUserView) {
        if (!createUserView.getjTextEmail().getText().trim().isEmpty()
                && !createUserView.getjTextName().getText().trim().isEmpty()
                && !createUserView.getjTextPassword().getText().trim().isEmpty()){
            
            UserModel user = new UserModel();
            
            user.setEmail(createUserView.getjTextEmail().getText());
            user.setName(createUserView.getjTextName().getText());
            user.setPassword(createUserView.getjTextPassword().getText());
            String selectedRole = (String) createUserView.getjComboRole().getSelectedItem();
            user.setRole(selectedRole);
            if(userDAO.saveUser(user)) {
                JOptionPane.showMessageDialog(createUserView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createUserView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createUserView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateUser(Frame_CreateUser createUserView){
        
        if (!createUserView.getjTextEmail().getText().trim().isEmpty()
                && !createUserView.getjTextName().getText().trim().isEmpty()
                && !createUserView.getjTextPassword().getText().trim().isEmpty()){
            
            UserModel user = new UserModel();
            
            user.setId(Integer.parseInt(createUserView.getjLabelId().getText()));
            user.setEmail(createUserView.getjTextEmail().getText());
            user.setName(createUserView.getjTextName().getText());
            user.setPassword(createUserView.getjTextPassword().getText());
            String selectedRole = (String) createUserView.getjComboRole().getSelectedItem();
            user.setRole(selectedRole);
            if(userDAO.updateUser(user)) {
                JOptionPane.showMessageDialog(createUserView, "Data updated successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createUserView, "Failed to update data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createUserView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteUser(String id){           
        userDAO.deleteUser(id);
    }
}
