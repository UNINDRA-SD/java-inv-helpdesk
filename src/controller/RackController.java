/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.RackDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.RackModel;
import table.RackTable;
import view.Frame_CreateRack;
import view.form.Form_Racks;
import view.main.Home;

/**
 *
 * @author AGUS NUGROGHO S
 */
public class RackController {
    Home home;
    Form_Racks formRacks;
    RackDAO rackDAO;
    List<RackModel> racks;
    
    public RackController(Form_Racks formRacks, Home home) {
        this.home = home;
        this.formRacks = formRacks;
        rackDAO = new RackDAO(this.home);
    }
    
    public void showRacks() {
        racks = rackDAO.getRacks();
        RackTable rackTable = new RackTable(racks);
        formRacks.getDataTable().setModel(rackTable);
    }
    
    public void saveRack(Frame_CreateRack createRackView) {
        if (!createRackView.getjTextName().getText().trim().isEmpty()){
            
            RackModel rack = new RackModel();
            rack.setName(createRackView.getjTextName().getText());
            
            if(rackDAO.saveRack(rack)) {
                JOptionPane.showMessageDialog(createRackView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createRackView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createRackView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateRack(Frame_CreateRack createRackView){
        
        if (!createRackView.getjTextName().getText().trim().isEmpty()){
            
            RackModel rack = new RackModel();
            rack.setId(Integer.parseInt(createRackView.getjLabelId().getText()));
            rack.setName(createRackView.getjTextName().getText());
            if(rackDAO.updateRack(rack)) {
                JOptionPane.showMessageDialog(createRackView, "Data updated successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createRackView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createRackView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteRack(String id){           
        rackDAO.deleteRack(id);
    }
    
}
