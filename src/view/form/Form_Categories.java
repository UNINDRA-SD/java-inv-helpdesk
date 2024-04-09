package view.form;

import controller.CategoryController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.UserModel;
import view.Frame_CreateCategory;
import view.main.Home;


public class Form_Categories extends javax.swing.JPanel {

    private UserModel userLogin;
    CategoryController categoryController;
    Home home;
    Frame_CreateCategory createCategoryView;
    
    public Form_Categories(UserModel userLogin) {
        initComponents();
        this.userLogin = userLogin;
        getjLabelNameLogin().setText(userLogin.getName());
        getjLabelRoleLogin().setText(userLogin.getRole());
        init();
    }
    
    public JTable getDataTable() {
        return jTableCategories;
    }

    private void init() {
        jTableCategories.fixTable(jScrollPane1);
        

        //  init card data
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new view.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategories = new view.swing.table.Table();
        jButtonRefreshCategory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNameLogin = new javax.swing.JLabel();
        jLabelRoleLogin = new javax.swing.JLabel();
        jButtonCreateCategory = new javax.swing.JButton();
        jButtonEditCategory = new javax.swing.JButton();
        jButtonDeleteCategory = new javax.swing.JButton();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jTableCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCategories);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jButtonRefreshCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        jButtonRefreshCategory.setText("Refresh");
        jButtonRefreshCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshCategoryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Categories");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("My Profile"));

        jLabelNameLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNameLogin.setText("Dandy Bagus Prasetyo");

        jLabelRoleLogin.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNameLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jLabelRoleLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelNameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRoleLogin)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButtonCreateCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        jButtonCreateCategory.setText("Create");
        jButtonCreateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateCategoryActionPerformed(evt);
            }
        });

        jButtonEditCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        jButtonEditCategory.setText("Edit");
        jButtonEditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditCategoryActionPerformed(evt);
            }
        });

        jButtonDeleteCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        jButtonDeleteCategory.setText("Delete");
        jButtonDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRefreshCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonCreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRefreshCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreateCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshCategoryActionPerformed
        categoryController = new CategoryController(this, home);
        categoryController.showCategories();
    }//GEN-LAST:event_jButtonRefreshCategoryActionPerformed

    private void jButtonCreateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateCategoryActionPerformed
        createCategoryView = new Frame_CreateCategory(this, home);
        createCategoryView.pack();
        createCategoryView.setLocationRelativeTo(null);
        createCategoryView.setVisible(true);
        
    }//GEN-LAST:event_jButtonCreateCategoryActionPerformed

    private void jButtonEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditCategoryActionPerformed
         if (jTableCategories.getSelectedRow()>=0){
            createCategoryView = new Frame_CreateCategory(this,this.home);
            createCategoryView.pack();
            createCategoryView.setLocationRelativeTo(null);
            createCategoryView.setAlwaysOnTop(true);
            createCategoryView.getjLabelTitle().setText("Edit Data Brand");
            createCategoryView.getjButtonSave().setText("Update");
            createCategoryView.getjLabelId().setVisible(false);
            createCategoryView.getjLabelId().setText(jTableCategories.getValueAt(jTableCategories.getSelectedRow(),0).toString());
            createCategoryView.getjTextName().setText((String) jTableCategories.getValueAt(jTableCategories.getSelectedRow(),1));
            createCategoryView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to edit!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditCategoryActionPerformed

    private void jButtonDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCategoryActionPerformed
        if (jTableCategories.getSelectedRow()>=0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Do you want to delete this category?","INFO",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                categoryController = new CategoryController(this, this.home);
                String id = jTableCategories.getValueAt(jTableCategories.getSelectedRow(),0).toString();
                categoryController.deleteCategory(id);
                categoryController.showCategories();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to delete!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteCategoryActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateCategory;
    private javax.swing.JButton jButtonDeleteCategory;
    private javax.swing.JButton jButtonEditCategory;
    private javax.swing.JButton jButtonRefreshCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNameLogin;
    private javax.swing.JLabel jLabelRoleLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.table.Table jTableCategories;
    private view.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables


    public javax.swing.JLabel getjLabelNameLogin() {
        return jLabelNameLogin;
    }

    public void setjLabelNameLogin(javax.swing.JLabel jLabelNameLogin) {
        this.jLabelNameLogin = jLabelNameLogin;
    }

    public javax.swing.JLabel getjLabelRoleLogin() {
        return jLabelRoleLogin;
    }

    public void setjLabelRoleLogin(javax.swing.JLabel jLabelRoleLogin) {
        this.jLabelRoleLogin = jLabelRoleLogin;
    }
}
