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
import model.TicketModel;
import view.main.Home;

/**
 *
 * @author Aspire
 */
public class TicketDAO {
    
//    Connection sql = MysqlDB.connection();
    Connection sql = PostgresDB.connection();
    Home home;
    
    public TicketDAO(Home home) {
        this.home = home;
    }
    
    public List<TicketModel> getTickets() {
        
        List<TicketModel> tickets = null;
        
        try {
            String query = "select * from tickets order by id asc";
           
            tickets = new ArrayList<>();
            Statement stmt = sql.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            
            while(rslt.next()) {
                TicketModel ticket = new TicketModel();
                ticket.setId(rslt.getInt("id"));
                ticket.setCustomerId(rslt.getInt("customer_id"));
                ticket.setUserId(rslt.getInt("user_id"));
                ticket.setProblem(rslt.getString("problem"));
                ticket.setDescription(rslt.getString("description"));
                ticket.setStatus(rslt.getString("status"));
                tickets.add(ticket);
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
        return tickets;
    }
    
    public boolean saveTicket(TicketModel requestTicket){

        int customerId = requestTicket.getCustomerId();
        int userId = requestTicket.getUserId();
        String status = requestTicket.getStatus();
        String problem = requestTicket.getProblem();     
        String description = requestTicket.getDescription();
        boolean isSuccess;
        
        try{
            String query = "INSERT INTO tickets (customer_id, user_id, status, problem, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,customerId);
            stmt.setInt(2,userId);
            stmt.setString(3,status);
            stmt.setString(4,problem);
            stmt.setString(5,description);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public boolean updateTicket(TicketModel requestTicket){

        int customerId = requestTicket.getCustomerId();
        int userId = requestTicket.getUserId();
        String status = requestTicket.getStatus();
        String problem = requestTicket.getProblem();     
        String description = requestTicket.getDescription();
        int id = requestTicket.getId();
        boolean isSuccess;
        
        try{
            String query = "UPDATE tickets SET customer_id=?, user_id=?, status=?, problem=?, description=? WHERE id=?";
            PreparedStatement stmt = sql.prepareStatement(query);
            
            stmt.setInt(1,customerId);
            stmt.setInt(2,userId);
            stmt.setString(3,status);
            stmt.setString(4,problem);
            stmt.setString(5,description);
            stmt.setInt(6, id);
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
            
        }catch(SQLException err){
            System.out.println(err);
            isSuccess = false;
        }
        return isSuccess;
    }
    
    public void deleteTicket(String id){
        
        try{
            
            String query="DELETE FROM tickets WHERE id="+id;
            PreparedStatement stmt = sql.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Data failed to be delete!","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
