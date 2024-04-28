/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.CustomerModel;
import table.CustomerTable;
import view.Frame_CreateCustomer;
import view.form.Form_Customers;
import view.main.Home;

/**
 *
 * @author LENOVO
 */
public class CustomerController {
    Home home;
    Form_Customers formCustomers;
    CustomerDAO customerDAO;
    List<CustomerModel> customers;
    
    public CustomerController(Form_Customers formCustomers, Home home) {
        this.home = home;
        this.formCustomers = formCustomers;
        customerDAO = new CustomerDAO(this.home);
    }
    
    public void showCustomers() {
        customers = customerDAO.getCustomers();
        CustomerTable customerTable = new CustomerTable(customers);
        formCustomers.getDataTable().setModel(customerTable);
    }   
    
    public void saveCustomer(Frame_CreateCustomer createCustomerView) {
        if (!createCustomerView.getjTextName().getText().trim().isEmpty()
                && !createCustomerView.getjTextPhone().getText().trim().isEmpty()
                && !createCustomerView.getjTextAddress().getText().trim().isEmpty()
                && !createCustomerView.getjTextDescription().getText().trim().isEmpty()){
            
            CustomerModel customer = new CustomerModel();
            customer.setName(createCustomerView.getjTextName().getText());
            customer.setPhone(createCustomerView.getjTextPhone().getText());
            customer.setAddress(createCustomerView.getjTextAddress().getText());
            customer.setDescription(createCustomerView.getjTextDescription().getText());
            
            if(customerDAO.saveCustomer(customer)) {
                JOptionPane.showMessageDialog(createCustomerView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createCustomerView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createCustomerView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    public void updateCustomer(Frame_CreateCustomer createCustomerView){
        
        if (!createCustomerView.getjTextName().getText().trim().isEmpty()
                && !createCustomerView.getjTextPhone().getText().trim().isEmpty()
                && !createCustomerView.getjTextAddress().getText().trim().isEmpty()
                && !createCustomerView.getjTextDescription().getText().trim().isEmpty()){
            
            CustomerModel customer = new CustomerModel();
            customer.setId(Integer.parseInt(createCustomerView.getjLabelId().getText()));
            customer.setName(createCustomerView.getjTextName().getText());
            customer.setPhone(createCustomerView.getjTextPhone().getText());
            customer.setAddress(createCustomerView.getjTextAddress().getText());
            customer.setDescription(createCustomerView.getjTextDescription().getText());
            if(customerDAO.updateCustomer(customer)) {
                JOptionPane.showMessageDialog(createCustomerView, "Data updated successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createCustomerView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createCustomerView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteCustomer(String id){           
        customerDAO.deleteCustomer(id);
    }
}
