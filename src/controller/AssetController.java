/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AssetDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.AssetModel;
import table.AssetTable;
import view.Frame_CreateAsset;
import view.form.Form_Assets;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class AssetController {
    Home home;
    Form_Assets formAssets;
    AssetDAO assetDAO;
    List<AssetModel> assets;
    
    public AssetController(Form_Assets formAssets, Home home) {
        this.home = home;
        this.formAssets = formAssets;
        assetDAO = new AssetDAO(this.home);
    }
    
    public void showAssets() {
        assets = assetDAO.getAssets();
        AssetTable assetTable = new AssetTable(assets);
        formAssets.getDataTable().setModel(assetTable);
    }
    
    public void saveAsset(Frame_CreateAsset createAssetView) {
        if (createAssetView.getjComboBrand().getSelectedItem() != null
            && createAssetView.getjComboCategory().getSelectedItem() != null
            && createAssetView.getjComboRack().getSelectedItem() != null
            && !createAssetView.getjTextName().getText().trim().isEmpty()) {
            
            AssetModel asset = new AssetModel();
            
            String selectedBrand = (String) createAssetView.getjComboBrand().getSelectedItem();
            asset.setBrandId(asset.getBrandIdByName(selectedBrand));
            String selectedCategory = (String) createAssetView.getjComboCategory().getSelectedItem();
            asset.setCategoryId(asset.getCategoryIdByName(selectedCategory));
            String selectedRack = (String) createAssetView.getjComboRack().getSelectedItem();
            asset.setRackId(asset.getRackIdByName(selectedRack));
            asset.setName(createAssetView.getjTextName().getText());
            asset.setModelNumber(createAssetView.getjTextModelNumber().getText());
            asset.setPartNumber(createAssetView.getjTextPartNumber().getText());
            asset.setSerialNumber(createAssetView.getjTextSerialNumber().getText());
            asset.setDescription(createAssetView.getjTextDescription().getText());
            int qty = Integer.parseInt(createAssetView.getjTextQty().getText());
            asset.setQty(qty);
            if(assetDAO.saveAsset(asset)) {
                JOptionPane.showMessageDialog(createAssetView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createAssetView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createAssetView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateAsset(Frame_CreateAsset createAssetView) {
        if (createAssetView.getjComboBrand().getSelectedItem() != null
            && createAssetView.getjComboCategory().getSelectedItem() != null
            && createAssetView.getjComboRack().getSelectedItem() != null
            && !createAssetView.getjTextName().getText().trim().isEmpty()) {
            
            AssetModel asset = new AssetModel();
            
            asset.setId(Integer.parseInt(createAssetView.getjLabelId().getText()));
            String selectedBrand = (String) createAssetView.getjComboBrand().getSelectedItem();
            asset.setBrandId(asset.getBrandIdByName(selectedBrand));
            String selectedCategory = (String) createAssetView.getjComboCategory().getSelectedItem();
            asset.setCategoryId(asset.getCategoryIdByName(selectedCategory));
            String selectedRack = (String) createAssetView.getjComboRack().getSelectedItem();
            asset.setRackId(asset.getRackIdByName(selectedRack));
            asset.setName(createAssetView.getjTextName().getText());
            asset.setModelNumber(createAssetView.getjTextModelNumber().getText());
            asset.setPartNumber(createAssetView.getjTextPartNumber().getText());
            asset.setSerialNumber(createAssetView.getjTextSerialNumber().getText());
            asset.setDescription(createAssetView.getjTextDescription().getText());
            int qty = Integer.parseInt(createAssetView.getjTextQty().getText());
            asset.setQty(qty);
            if(assetDAO.updateAsset(asset)) {
                JOptionPane.showMessageDialog(createAssetView, "Data updated successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createAssetView, "Failed to update data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createAssetView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteAsset(String id){           
        assetDAO.deleteAsset(id);
    }
}
