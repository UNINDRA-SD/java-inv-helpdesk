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
            String faultQtyStr = createSettlementView.getjTextFaultyQty().getText().trim();
            if (faultQtyStr.isEmpty()) {
                doSettlement.setFaultQty(0);
            } else {
                doSettlement.setFaultQty(Integer.parseInt(faultQtyStr));
            }
            doSettlement.setNotes(createSettlementView.getjTextNotes().getText());
            
            // Return un installed stock
            int assetId = Integer.parseInt(doAssetId[1].trim());
            int doQty = Integer.parseInt(createSettlementView.getjLabelDOQty().getText());
            int installedQty = Integer.parseInt(createSettlementView.getjTextQty().getText());
            int returnQty = doQty - installedQty;
            
            if(installedQty <= doQty) {
                if(doSettlementDAO.saveSettlement(doSettlement)) {
                    // Update Status and Qty DO Asset
                    doSettlementDAO.updateStatusAndQtyByDoAssetId(installedQty, doSettlement.getDoAssetId());
                    doSettlementDAO.updateStockAssetId(returnQty,assetId);
                    DOAssetController doAssetController = new DOAssetController(detailDeliveryOrderView);
                    doAssetController.showDOAssets(doId);
                    JOptionPane.showMessageDialog(createSettlementView, "Data settlement is successfully with | Qty : "+returnQty+" | return to WH stock!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    createSettlementView.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(createSettlementView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(createSettlementView, "Installed Qty out of Deliver Qty!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createSettlementView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateDOSettlement(Frame_CreateSettlement createSettlementView, Frame_DetailDeliveryOrder detailDeliveryOrderView, int doId) {
        if (!createSettlementView.getjTextNotes().getText().trim().isEmpty()){
            
            DOSettlementModel doSettlement = new DOSettlementModel();
            
            doSettlement.setId(Integer.parseInt(createSettlementView.getjLabelId().getText()));
            
            String splitDoAssetId = (String) createSettlementView.getjTextDOAssetId().getText();
            String[] doAssetId = splitDoAssetId.split("\\|");
            doSettlement.setDoAssetId(Integer.parseInt(doAssetId[0].trim()));
            
            String activityReportId = (String) createSettlementView.getjComboActivityReportId().getSelectedItem();
            doSettlement.setActivityReportId(Integer.parseInt(activityReportId));
            doSettlement.setFaultModelNumber(createSettlementView.getjTextFaultyModel().getText());
            doSettlement.setFaultSerialNumber(createSettlementView.getjTextFaultySerialNumber().getText());
            doSettlement.setFaultName(createSettlementView.getjTextFaultyName().getText());
            String faultQtyStr = createSettlementView.getjTextFaultyQty().getText().trim();
            if (faultQtyStr.isEmpty()) {
                doSettlement.setFaultQty(0);
            } else {
                doSettlement.setFaultQty(Integer.parseInt(faultQtyStr));
            }
            doSettlement.setNotes(createSettlementView.getjTextNotes().getText());
            
            // Return un installed stock
            int assetId = Integer.parseInt(doAssetId[1].trim());
            int doQty = Integer.parseInt(createSettlementView.getjLabelDOQty().getText());
            int installedQty = Integer.parseInt(createSettlementView.getjTextQty().getText());
            int returnQty = doQty - installedQty;
            
            if(installedQty <= doQty) {
                if(doSettlementDAO.updateSettlement(doSettlement)) {
                    // Update Status and Qty DO Asset
                    doSettlementDAO.updateStatusAndQtyByDoAssetId(installedQty, doSettlement.getDoAssetId());
                    doSettlementDAO.updateStockAssetId(returnQty,assetId);
                    DOAssetController doAssetController = new DOAssetController(detailDeliveryOrderView);
                    doAssetController.showDOAssets(doId);
                    JOptionPane.showMessageDialog(createSettlementView, "Data settlement is successfully with | Qty : "+returnQty+" | return to WH stock!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                    createSettlementView.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(createSettlementView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(createSettlementView, "Installed Qty out of Deliver Qty!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createSettlementView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
}
