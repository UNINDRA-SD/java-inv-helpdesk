/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TicketDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.AssetModel;
import model.TicketModel;
import table.TicketTable;
import view.Frame_CreateTicket;
import view.form.Form_Tickets;
import view.main.Home;


/**
 *
 * @author Aspire
 */
public class TicketController {
    Home home;
    Form_Tickets formTickets;
    TicketDAO ticketDAO;
    List<TicketModel> tickets;
    
    public TicketController(Form_Tickets formTickets, Home home) {
        this.home = home;
        this.formTickets = formTickets;
        ticketDAO = new TicketDAO(this.home);
    }
    
    public void showTickets() {
        tickets = ticketDAO.getTickets();
        TicketTable ticketTable = new TicketTable(tickets);
        formTickets.getDataTable().setModel(ticketTable);
    }
    
    public void saveTicket(Frame_CreateTicket createTicketView) {
        if (createTicketView.getjComboCustomer().getSelectedItem() != null
            && createTicketView.getjComboStatus().getSelectedItem() != null
            && !createTicketView.getjTextProblem().getText().trim().isEmpty()
            && !createTicketView.getjTextDescription().getText().trim().isEmpty()){
            
            TicketModel ticket = new TicketModel();
            
            String selectedCustomer = (String) createTicketView.getjComboCustomer().getSelectedItem();
            ticket.setCustomerId(ticket.getCustomerIdByName(selectedCustomer));
            String selectedStatus = (String) createTicketView.getjComboStatus().getSelectedItem();
            ticket.setStatus(selectedStatus);
            ticket.setProblem(createTicketView.getjTextProblem().getText());
            ticket.setDescription(createTicketView.getjTextDescription().getText());
            if(ticketDAO.saveTicket(ticket)) {
                JOptionPane.showMessageDialog(createTicketView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createTicketView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createTicketView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateTicket(Frame_CreateTicket createTicketView) {
        if (createTicketView.getjComboCustomer().getSelectedItem() != null
            && createTicketView.getjComboStatus().getSelectedItem() != null
            && !createTicketView.getjTextProblem().getText().trim().isEmpty()
            && !createTicketView.getjTextDescription().getText().trim().isEmpty()){
            
            TicketModel ticket = new TicketModel();
            
            ticket.setId(Integer.parseInt(createTicketView.getjLabelId().getText()));
            String selectedCustomer = (String) createTicketView.getjComboCustomer().getSelectedItem();
            ticket.setCustomerId(ticket.getCustomerIdByName(selectedCustomer));
            String selectedStatus = (String) createTicketView.getjComboStatus().getSelectedItem();
            ticket.setStatus(selectedStatus);
            ticket.setProblem(createTicketView.getjTextProblem().getText());
            ticket.setDescription(createTicketView.getjTextDescription().getText());
            System.out.println("ticket : " + ticket.getId() + "| customer : " + ticket.getCustomerId() + "| status : " + ticket.getStatus() + "probelm : " + ticket.getProblem());
            if(ticketDAO.updateTicket(ticket)) {
                JOptionPane.showMessageDialog(createTicketView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createTicketView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createTicketView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteTicket(String id){           
        ticketDAO.deleteTicket(id);
    }
}
