/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DeliveryOrderDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.DeliveryOrderModel;
import table.DeliveryOrderTable;
import view.Frame_CreateDeliveryOrder;
import view.form.Form_DeliveryOrders;
import view.main.Home;

/**
 *
 * @author ACER
 */
public class DeliveryOrderController {
    Home home;
    Form_DeliveryOrders formDeliveryOrders;
    DeliveryOrderDAO deliveryOrderDAO;
    List<DeliveryOrderModel> deliveryOrders;
    
    public DeliveryOrderController(Form_DeliveryOrders formDeliveryOrders, Home home) {
        this.home = home;
        this.formDeliveryOrders = formDeliveryOrders;
        deliveryOrderDAO = new DeliveryOrderDAO(this.home);
    }
    
    public void showDeliveryOrders() {
        deliveryOrders = deliveryOrderDAO.getDeliveryOrders();
        DeliveryOrderTable deliveryOrderTable = new DeliveryOrderTable(deliveryOrders);
        formDeliveryOrders.getDataTable().setModel(deliveryOrderTable);
    }
    
    public void saveDeliveryOrder(Frame_CreateDeliveryOrder createDeliveryOrderView) {
        if (createDeliveryOrderView.getjComboTicketId().getSelectedItem() != null
            && createDeliveryOrderView.getjComboTeamWH().getSelectedItem() != null
            && !createDeliveryOrderView.getjTextNotes().getText().trim().isEmpty()){
            
            DeliveryOrderModel deliveryOrder = new DeliveryOrderModel();
            
            String selectedTicket = (String) createDeliveryOrderView.getjComboTicketId().getSelectedItem();
            deliveryOrder.setTicketId(Integer.parseInt(selectedTicket));
            String selectedUser = (String) createDeliveryOrderView.getjComboTeamWH().getSelectedItem();
            deliveryOrder.setUserId(deliveryOrder.getUserWHIdByName(selectedUser));
            deliveryOrder.setNotes(createDeliveryOrderView.getjTextNotes().getText());
            if(deliveryOrderDAO.saveDeliveryOrder(deliveryOrder)) {
                JOptionPane.showMessageDialog(createDeliveryOrderView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createDeliveryOrderView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createDeliveryOrderView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateDeliveryOrder(Frame_CreateDeliveryOrder createDeliveryOrderView) {
        if (createDeliveryOrderView.getjComboTicketId().getSelectedItem() != null
            && createDeliveryOrderView.getjComboTeamWH().getSelectedItem() != null
            && !createDeliveryOrderView.getjTextNotes().getText().trim().isEmpty()){
            
            DeliveryOrderModel deliveryOrder = new DeliveryOrderModel();
            
            deliveryOrder.setId(Integer.parseInt(createDeliveryOrderView.getjLabelId().getText()));
            String selectedTicket = (String) createDeliveryOrderView.getjComboTicketId().getSelectedItem();
            deliveryOrder.setTicketId(Integer.parseInt(selectedTicket));
            String selectedUser = (String) createDeliveryOrderView.getjComboTeamWH().getSelectedItem();
            deliveryOrder.setUserId(deliveryOrder.getUserWHIdByName(selectedUser));
            deliveryOrder.setNotes(createDeliveryOrderView.getjTextNotes().getText());
            if(deliveryOrderDAO.updateDeliveryOrder(deliveryOrder)) {
                JOptionPane.showMessageDialog(createDeliveryOrderView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createDeliveryOrderView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createDeliveryOrderView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteDeliveryOrder(String id){           
        deliveryOrderDAO.deleteDeliveryOrder(id);
    }
}
