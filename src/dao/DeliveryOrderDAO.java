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
import model.DeliveryOrderModel;
import view.main.Home;

/**
 *
 * @author ACER
 */
public class DeliveryOrderDAO {
    Connection sql = MysqlDB.connection();
    Home home;
    
    public DeliveryOrderDAO(Home home) {
        this.home = home;
    }
    
    public List<DeliveryOrderModel> getDeliveryOrders() {
        
        List<DeliveryOrderModel> deliveryOrders = null;
        
        try {
            String query = "SELECT * FROM delivery_orders ORDER BY id ASC";
           
            deliveryOrders = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                DeliveryOrderModel deliveryOrder = new DeliveryOrderModel();
                deliveryOrder.setId(rslt.getInt("id"));
                deliveryOrder.setTicketId(rslt.getInt("ticket_id"));
                deliveryOrder.setUserId(rslt.getInt("user_id"));
                deliveryOrder.setNotes(rslt.getString("notes"));
                deliveryOrders.add(deliveryOrder);
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
        return deliveryOrders;
    }
    
    public boolean saveDeliveryOrder(DeliveryOrderModel requestDeliveryOrder){

        int ticketId = requestDeliveryOrder.getTicketId();
        int userWHId = requestDeliveryOrder.getUserId();   
        String notes = requestDeliveryOrder.getNotes();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO delivery_orders (ticket_id, user_id, notes) VALUES (?, ?, ?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,ticketId);
            stmt.setInt(2,userWHId);
            stmt.setString(3,notes);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public boolean updateDeliveryOrder(DeliveryOrderModel requestDeliveryOrder){

        int ticketId = requestDeliveryOrder.getTicketId();
        int userWHId = requestDeliveryOrder.getUserId();   
        String notes = requestDeliveryOrder.getNotes();
        int id = requestDeliveryOrder.getId();
        boolean isSuccess;
        
        try{
            String query = "UPDATE delivery_orders SET ticket_id=?, user_id=?, notes=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,ticketId);
            stmt.setInt(2,userWHId);
            stmt.setString(3,notes);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteDeliveryOrder(String id){
        
        try{
            
            String query="DELETE FROM delivery_orders WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public DeliveryOrderModel getTicketDetailsById(int ticketId) {
        DeliveryOrderModel deliveryOrder = new DeliveryOrderModel();

        try {
            String query = "SELECT t.id, t.status, t.problem, t.description, " +
                           "c.name AS customer_name, c.description AS customer_description, " +
                           "c.phone AS customer_phone, c.address AS customer_address, " +
                           "u.name AS engineer_name " +
                           "FROM tickets t " +
                           "JOIN customers c ON t.customer_id = c.id " +
                           "JOIN users u ON t.user_id = u.id " +
                           "WHERE t.id = ?";

            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.setInt(1, ticketId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                deliveryOrder.setId(rs.getInt("id"));
                deliveryOrder.setStatus(rs.getString("status"));
                deliveryOrder.setProblem(rs.getString("problem"));
                deliveryOrder.setDescription(rs.getString("description"));
                deliveryOrder.setCustomerName(rs.getString("customer_name"));
                deliveryOrder.setCustomerDescription(rs.getString("customer_description"));
                deliveryOrder.setCustomerPhone(rs.getString("customer_phone"));
                deliveryOrder.setCustomerAddress(rs.getString("customer_address"));
                deliveryOrder.setEngineerName(rs.getString("engineer_name"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException err) {
            System.out.println(err);
        }

        return deliveryOrder;
    }
}
