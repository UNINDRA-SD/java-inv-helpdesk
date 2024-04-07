/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import java.util.List;
import javax.swing.JOptionPane;
import model.CategoryModel;
import table.CategoryTable;
import view.Frame_CreateCategory;
import view.form.Form_Categories;
import view.main.Home;

/**
 *
 * @author Farhan
 */
public class CategoryController {
    Home home;
    Form_Categories formCategories;
    CategoryDAO categoryDAO;
    List<CategoryModel> categories;
    
    public CategoryController(Form_Categories formCategories, Home home) {
        this.home = home;
        this.formCategories = formCategories;
        categoryDAO = new CategoryDAO(this.home);
    }
    
    public void showCategories() {
        categories = categoryDAO.getCategories();
        CategoryTable categoryTable = new CategoryTable(categories);
        formCategories.getDataTable().setModel(categoryTable);
    }
    public void saveCategory(Frame_CreateCategory createCategoryView) {
        if (!createCategoryView.getjTextName().getText().trim().isEmpty()){
            
            CategoryModel category = new CategoryModel();
            category.setName(createCategoryView.getjTextName().getText());
            
            if(categoryDAO.saveCategory(category)) {
                JOptionPane.showMessageDialog(createCategoryView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createCategoryView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createCategoryView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateCategory(Frame_CreateCategory createCategoryView){
        
        if (!createCategoryView.getjTextName().getText().trim().isEmpty()){
            
            CategoryModel category = new CategoryModel();
            category.setId(Integer.parseInt(createCategoryView.getjLabelId().getText()));
            category.setName(createCategoryView.getjTextName().getText());
            if(categoryDAO.updateCategory(category)) {
                JOptionPane.showMessageDialog(createCategoryView, "Data updated successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(createCategoryView, "Failed to Save Data!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(createCategoryView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deleteCategory(String id){           
        categoryDAO.deleteCategory(id);
    }
    
}
