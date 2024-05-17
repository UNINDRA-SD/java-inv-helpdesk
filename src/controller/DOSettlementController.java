/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DOSettlementDAO;
import javax.swing.JOptionPane;
import model.DOSettlementModel;
import view.Frame_CreateSettlement;
import view.Frame_DetailDeliveryOrder;

/**
 *
 * @author dandy
 */
public class DOSettlementController {
    
    DOSettlementDAO doSettlementDAO;
    public DOSettlementController() {
        this.doSettlementDAO = new DOSettlementDAO();
    }
    
    public DOSettlementModel getSettlementById(int id) {
        doSettlementDAO = new DOSettlementDAO();
        return doSettlementDAO.getDOSettlementById(id);
    }
    
    public void saveDOSettlement(Frame_CreateSettlement createSettlementView, Frame_DetailDeliveryOrder detailDeliveryOrderView, int doId) {
        if (!createSettlementView.getjTextNotes().getText().trim().isEmpty()){
            
            DOSettlementModel doSettlement = new DOSettlementModel();
            
            String splitDoAssetId = (String) createSettlementView.getjTextDOAssetId().getText();
            String[] doAssetId = splitDoAssetId.split("\\|");
            doSettlement.setDoAssetId(Integer.parseInt(doAssetId[0].trim()));
            
            String activityReportId = (String) createSettlementView.getjComboActivityReportId().getSelectedItem();
            doSettlement.setActivityReportId(Integer.parseInt(activityReportId));
            doSettlement.setFaultModelNumber(createSettlementView.getjTextFaultyModel().getText());
            doSettlement.setFaultSerialNumber(createSettlementView.getjTextFaultySerialNumber().getText());
            doSettlement.setFaultName(createSettlementView.getjTextFaultyName().getText());
            doSettlement.setFaultQty(Integer.parseInt(createSettlementView.getjTextFaultyQty().getText()));
            doSettlement.setNotes(createSettlementView.getjTextNotes().getText());
            
            
            if(doSettlementDAO.saveSettlement(doSettlement)) {
                // Update Status DO Asset
                doSettlementDAO.updateStatusByDoAssetId(doSettlement.getDoAssetId());
                DOAssetController doAssetController = new DOAssetController(detailDeliveryOrderView);
                doAssetController.showDOAssets(doId);
                JOptionPane.showMessageDialog(createSettlementView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                createSettlementView.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(createSettlementView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createSettlementView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
}
