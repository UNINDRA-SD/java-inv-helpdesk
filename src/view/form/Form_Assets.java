package view.form;

import controller.AssetController;
import dao.BrandDAO;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.BrandModel;
import model.UserModel;
import view.Frame_CreateAsset;
import view.main.Home;


public class Form_Assets extends javax.swing.JPanel {

    private UserModel userLogin;
    AssetController assetController;
    Home home;
    Frame_CreateAsset createAssetView;
    
    //Load Brand List ComboBox
    BrandDAO brandDAO;
    List<BrandModel> brands;
    
    public Form_Assets(UserModel userLogin) {
        initComponents();
        this.userLogin = userLogin;
        getjLabelNameLogin().setText(userLogin.getName());
        getjLabelRoleLogin().setText(userLogin.getRole());
        init();
    }
    
    public JTable getDataTable() {
        return jTableAssets;
    }

    private void init() {
        jTableAssets.fixTable(jScrollPane1);
        

        //  init card data
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new view.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAssets = new view.swing.table.Table();
        jButtonRefreshAsset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNameLogin = new javax.swing.JLabel();
        jLabelRoleLogin = new javax.swing.JLabel();
        jButtonCreateAsset = new javax.swing.JButton();
        jButtonEditAsset = new javax.swing.JButton();
        jButtonDeleteAsset = new javax.swing.JButton();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jTableAssets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand", "Category", "Rack", "Name", "Model", "Part Number", "Serial Number", "Description", "Qty"
            }
        ));
        jScrollPane1.setViewportView(jTableAssets);
        if (jTableAssets.getColumnModel().getColumnCount() > 0) {
            jTableAssets.getColumnModel().getColumn(0).setMinWidth(25);
            jTableAssets.getColumnModel().getColumn(0).setMaxWidth(25);
        }

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

        jButtonRefreshAsset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        jButtonRefreshAsset.setText("Refresh");
        jButtonRefreshAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshAssetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Assets");

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

        jButtonCreateAsset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        jButtonCreateAsset.setText("Create");
        jButtonCreateAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateAssetActionPerformed(evt);
            }
        });

        jButtonEditAsset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        jButtonEditAsset.setText("Edit");
        jButtonEditAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAssetActionPerformed(evt);
            }
        });

        jButtonDeleteAsset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        jButtonDeleteAsset.setText("Delete");
        jButtonDeleteAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAssetActionPerformed(evt);
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
                                .addComponent(jButtonRefreshAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonCreateAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonEditAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDeleteAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jButtonRefreshAsset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreateAsset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditAsset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteAsset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshAssetActionPerformed
        assetController = new AssetController(this, home);
        assetController.showAssets();
    }//GEN-LAST:event_jButtonRefreshAssetActionPerformed

    private void jButtonCreateAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateAssetActionPerformed
        createAssetView = new Frame_CreateAsset(this, home);
        createAssetView.pack();
        createAssetView.setLocationRelativeTo(null);
        createAssetView.setVisible(true);
        
    }//GEN-LAST:event_jButtonCreateAssetActionPerformed

    private void jButtonEditAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAssetActionPerformed
         if (jTableAssets.getSelectedRow()>=0){
            createAssetView = new Frame_CreateAsset(this,this.home);
            createAssetView.pack();
            createAssetView.setLocationRelativeTo(null);
            createAssetView.setAlwaysOnTop(true);
            createAssetView.getjLabelTitle().setText("Edit Data Asset ");
            createAssetView.getjButtonSave().setText("Update");
            createAssetView.getjLabelId().setVisible(false);
            
            createAssetView.getjLabelId().setText(jTableAssets.getValueAt(jTableAssets.getSelectedRow(),0).toString());
            
            String selectedBrand = jTableAssets.getValueAt(jTableAssets.getSelectedRow(), 1).toString();
            if (isItemExist(createAssetView.getjComboBrand(), selectedBrand)) {
                createAssetView.getjComboBrand().setSelectedItem(selectedBrand);
            } else {
                JOptionPane.showMessageDialog(this, "Brand '" + selectedBrand + "' not found in ComboBox!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            String selectedCategory = jTableAssets.getValueAt(jTableAssets.getSelectedRow(), 2).toString();
            if (isItemExist(createAssetView.getjComboCategory(), selectedCategory)) {
                createAssetView.getjComboCategory().setSelectedItem(selectedCategory);
            } else {
                JOptionPane.showMessageDialog(this, "Category '" + selectedCategory + "' not found in ComboBox!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            String selectedRack = jTableAssets.getValueAt(jTableAssets.getSelectedRow(), 3).toString();
            if (isItemExist(createAssetView.getjComboRack(), selectedRack)) {
                createAssetView.getjComboRack().setSelectedItem(selectedRack);
            } else {
                JOptionPane.showMessageDialog(this, "Rack '" + selectedRack + "' not found in ComboBox!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            createAssetView.getjTextName().setText((String) jTableAssets.getValueAt(jTableAssets.getSelectedRow(),4));
            createAssetView.getjTextModelNumber().setText((String) jTableAssets.getValueAt(jTableAssets.getSelectedRow(),5));
            createAssetView.getjTextPartNumber().setText((String) jTableAssets.getValueAt(jTableAssets.getSelectedRow(),6));
            createAssetView.getjTextSerialNumber().setText((String) jTableAssets.getValueAt(jTableAssets.getSelectedRow(),7));
            createAssetView.getjTextDescription().setText((String) jTableAssets.getValueAt(jTableAssets.getSelectedRow(),8));
            int qty = (int) jTableAssets.getValueAt(jTableAssets.getSelectedRow(), 9);
            String qtyString = String.valueOf(qty);
            createAssetView.getjTextQty().setText(qtyString);
            
            createAssetView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to edit!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditAssetActionPerformed

    private void jButtonDeleteAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAssetActionPerformed
        if (jTableAssets.getSelectedRow() >= 0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Do you want to delete this asset?","INFO",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                assetController = new AssetController(this, this.home);
                String id = jTableAssets.getValueAt(jTableAssets.getSelectedRow(),0).toString();
                assetController.deleteAsset(id);
                assetController.showAssets();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to delete!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteAssetActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateAsset;
    private javax.swing.JButton jButtonDeleteAsset;
    private javax.swing.JButton jButtonEditAsset;
    private javax.swing.JButton jButtonRefreshAsset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNameLogin;
    private javax.swing.JLabel jLabelRoleLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.table.Table jTableAssets;
    private view.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables

    
    private boolean isItemExist(JComboBox comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).toString().equals(item)) {
                return true;
            }
        }
        return false;
    }
    
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
