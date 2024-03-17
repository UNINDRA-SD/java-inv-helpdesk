/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BrandDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.BrandModel;
import model.UserModel;
import table.BrandTable;
import view.Frame_CreateBrand;
import view.Frame_CreateUser;
import view.form.Form_Brands;
import view.main.Home;

/**
 *
 * @author dandy
 */
public class BrandController {
    Home home;
    Form_Brands formBrands;
    BrandDAO brandDAO;
    List<BrandModel> brands;
    
    public BrandController(Form_Brands formBrands, Home home) {
        this.home = home;
        this.formBrands = formBrands;
        brandDAO = new BrandDAO(this.home);
    }
    
    public void showBrands() {
        brands = brandDAO.getBrands();
        BrandTable brandTable = new BrandTable(brands);
        formBrands.getDataTable().setModel(brandTable);
    }
    
    public void saveBrand(Frame_CreateBrand createBrandView) {
        if (!createBrandView.getjTextName().getText().trim().isEmpty()){
            
            BrandModel brand = new BrandModel();
            brand.setName(createBrandView.getjTextName().getText());
            
            if(brandDAO.saveBrand(brand)) {
                JOptionPane.showMessageDialog(createBrandView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createBrandView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createBrandView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateBrand(Frame_CreateBrand createBrandView){
        
        if (!createBrandView.getjTextName().getText().trim().isEmpty()){
            
            BrandModel brand = new BrandModel();
            brand.setId(Integer.parseInt(createBrandView.getjLabelId().getText()));
            brand.setName(createBrandView.getjTextName().getText());
            if(brandDAO.updateBrand(brand)) {
                JOptionPane.showMessageDialog(createBrandView, "Data updated successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createBrandView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createBrandView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteBrand(String id){           
        brandDAO.deleteBrand(id);
    }
}
