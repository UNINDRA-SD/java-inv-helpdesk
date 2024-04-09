package view.form;

import controller.BrandController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.UserModel;
import view.Frame_CreateBrand;
import view.main.Home;


public class Form_Brands extends javax.swing.JPanel {

    private UserModel userLogin;
    BrandController brandController;
    Home home;
    Frame_CreateBrand createBrandView;
    
    public Form_Brands(UserModel userLogin) {
        initComponents();
        this.userLogin = userLogin;
        getjLabelNameLogin().setText(userLogin.getName());
        getjLabelRoleLogin().setText(userLogin.getRole());
        init();
    }
    
    public JTable getDataTable() {
        return jTableBrands;
    }

    private void init() {
        jTableBrands.fixTable(jScrollPane1);
        

        //  init card data
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new view.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBrands = new view.swing.table.Table();
        jButtonRefreshBrand = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNameLogin = new javax.swing.JLabel();
        jLabelRoleLogin = new javax.swing.JLabel();
        jButtonCreateBrand = new javax.swing.JButton();
        jButtonEditBrand = new javax.swing.JButton();
        jButtonDeleteBrand = new javax.swing.JButton();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jTableBrands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBrands);

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

        jButtonRefreshBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        jButtonRefreshBrand.setText("Refresh");
        jButtonRefreshBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshBrandActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Brands");

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

        jButtonCreateBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        jButtonCreateBrand.setText("Create");
        jButtonCreateBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateBrandActionPerformed(evt);
            }
        });

        jButtonEditBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        jButtonEditBrand.setText("Edit");
        jButtonEditBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditBrandActionPerformed(evt);
            }
        });

        jButtonDeleteBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        jButtonDeleteBrand.setText("Delete");
        jButtonDeleteBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteBrandActionPerformed(evt);
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
                                .addComponent(jButtonRefreshBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonCreateBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonEditBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDeleteBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jButtonRefreshBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreateBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshBrandActionPerformed
        brandController = new BrandController(this, home);
        brandController.showBrands();
    }//GEN-LAST:event_jButtonRefreshBrandActionPerformed

    private void jButtonCreateBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateBrandActionPerformed
        createBrandView = new Frame_CreateBrand(this, home);
        createBrandView.pack();
        createBrandView.setLocationRelativeTo(null);
        createBrandView.setVisible(true);
        
    }//GEN-LAST:event_jButtonCreateBrandActionPerformed

    private void jButtonEditBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditBrandActionPerformed
         if (jTableBrands.getSelectedRow()>=0){
            createBrandView = new Frame_CreateBrand(this,this.home);
            createBrandView.pack();
            createBrandView.setLocationRelativeTo(null);
            createBrandView.setAlwaysOnTop(true);
            createBrandView.getjLabelTitle().setText("Edit Data Brand");
            createBrandView.getjButtonSave().setText("Update");
            createBrandView.getjLabelId().setVisible(false);
            createBrandView.getjLabelId().setText(jTableBrands.getValueAt(jTableBrands.getSelectedRow(),0).toString());
            createBrandView.getjTextName().setText((String) jTableBrands.getValueAt(jTableBrands.getSelectedRow(),1));
            createBrandView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to edit!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditBrandActionPerformed

    private void jButtonDeleteBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteBrandActionPerformed
        if (jTableBrands.getSelectedRow()>=0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Do you want to delete this brand?","INFO",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                brandController = new BrandController(this, this.home);
                String id = jTableBrands.getValueAt(jTableBrands.getSelectedRow(),0).toString();
                brandController.deleteBrand(id);
                brandController.showBrands();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to delete!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteBrandActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateBrand;
    private javax.swing.JButton jButtonDeleteBrand;
    private javax.swing.JButton jButtonEditBrand;
    private javax.swing.JButton jButtonRefreshBrand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNameLogin;
    private javax.swing.JLabel jLabelRoleLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.table.Table jTableBrands;
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
