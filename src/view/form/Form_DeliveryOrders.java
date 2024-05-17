package view.form;

import controller.DOAssetController;
import controller.DeliveryOrderController;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DeliveryOrderModel;
import model.UserModel;
import view.Frame_CreateDeliveryOrder;
import view.Frame_DetailDeliveryOrder;
import view.main.Home;


public class Form_DeliveryOrders extends javax.swing.JPanel {

    private UserModel userLogin;
    DeliveryOrderController deliveryOrderController;
    Home home;
    Frame_CreateDeliveryOrder createDeliveryOrderView;
    
    DOAssetController doAssetController;
    Frame_DetailDeliveryOrder detailDeliveryOrderView;
    
    public Form_DeliveryOrders(UserModel userLogin) {
        initComponents();
        this.userLogin = userLogin;
        getjLabelNameLogin().setText(userLogin.getName());
        getjLabelRoleLogin().setText(userLogin.getRole());
        
        init();
    }
    
    public JTable getDataTable() {
        return jTableDeliveryOrders;
    }

    private void init() {
        jTableDeliveryOrders.fixTable(jScrollPane1);
        

        //  init card data
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new view.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDeliveryOrders = new view.swing.table.Table();
        jButtonRefreshDeliveryOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNameLogin = new javax.swing.JLabel();
        jLabelRoleLogin = new javax.swing.JLabel();
        jButtonCreateDeliveryOrder = new javax.swing.JButton();
        jButtonEditDeliveryOrder = new javax.swing.JButton();
        jButtonDeleteDeliveryOrder = new javax.swing.JButton();
        jButtonDetailDeliveryOrder = new javax.swing.JButton();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jTableDeliveryOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ticket ID", "Tim WH", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTableDeliveryOrders);
        if (jTableDeliveryOrders.getColumnModel().getColumnCount() > 0) {
            jTableDeliveryOrders.getColumnModel().getColumn(0).setMinWidth(25);
            jTableDeliveryOrders.getColumnModel().getColumn(0).setMaxWidth(25);
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

        jButtonRefreshDeliveryOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        jButtonRefreshDeliveryOrder.setText("Refresh");
        jButtonRefreshDeliveryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshDeliveryOrderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Delivery Orders");

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

        jButtonCreateDeliveryOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        jButtonCreateDeliveryOrder.setText("Create");
        jButtonCreateDeliveryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateDeliveryOrderActionPerformed(evt);
            }
        });

        jButtonEditDeliveryOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        jButtonEditDeliveryOrder.setText("Edit");
        jButtonEditDeliveryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditDeliveryOrderActionPerformed(evt);
            }
        });

        jButtonDeleteDeliveryOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        jButtonDeleteDeliveryOrder.setText("Delete");
        jButtonDeleteDeliveryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteDeliveryOrderActionPerformed(evt);
            }
        });

        jButtonDetailDeliveryOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/detail.png"))); // NOI18N
        jButtonDetailDeliveryOrder.setText("Detail");
        jButtonDetailDeliveryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailDeliveryOrderActionPerformed(evt);
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
                                .addComponent(jButtonRefreshDeliveryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonCreateDeliveryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonEditDeliveryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDeleteDeliveryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDetailDeliveryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jButtonRefreshDeliveryOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreateDeliveryOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditDeliveryOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteDeliveryOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDetailDeliveryOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshDeliveryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshDeliveryOrderActionPerformed
        deliveryOrderController = new DeliveryOrderController(this, home);
        deliveryOrderController.showDeliveryOrders();
    }//GEN-LAST:event_jButtonRefreshDeliveryOrderActionPerformed

    private void jButtonCreateDeliveryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateDeliveryOrderActionPerformed
        createDeliveryOrderView = new Frame_CreateDeliveryOrder(this, home);
        createDeliveryOrderView.pack();
        createDeliveryOrderView.setLocationRelativeTo(null);
        createDeliveryOrderView.setVisible(true);
        
    }//GEN-LAST:event_jButtonCreateDeliveryOrderActionPerformed

    private void jButtonEditDeliveryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditDeliveryOrderActionPerformed
         if (jTableDeliveryOrders.getSelectedRow()>=0){
            createDeliveryOrderView = new Frame_CreateDeliveryOrder(this,this.home);
            createDeliveryOrderView.pack();
            createDeliveryOrderView.setLocationRelativeTo(null);
            createDeliveryOrderView.setAlwaysOnTop(true);
            createDeliveryOrderView.getjLabelTitle().setText("Edit Delivery Order");
            createDeliveryOrderView.getjButtonSave().setText("Update");
            createDeliveryOrderView.getjLabelId().setVisible(false);
            
            createDeliveryOrderView.getjLabelId().setText(jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(),0).toString());
            
            String selectedTicket = jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(), 1).toString();
            if (isItemExist(createDeliveryOrderView.getjComboTicketId(), selectedTicket)) {
                createDeliveryOrderView.getjComboTicketId().setSelectedItem(selectedTicket);
            } else {
                JOptionPane.showMessageDialog(this, "Ticket ID '" + selectedTicket + "' not found in ComboBox!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            String selectedUserWH = jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(), 2).toString();
            if (isItemExist(createDeliveryOrderView.getjComboTeamWH(), selectedUserWH)) {
                createDeliveryOrderView.getjComboTeamWH().setSelectedItem(selectedUserWH);
            } else {
                JOptionPane.showMessageDialog(this, "User Team WH '" + selectedUserWH + "' not found in ComboBox!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            createDeliveryOrderView.getjTextNotes().setText((String) jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(),3));
            createDeliveryOrderView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to edit!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditDeliveryOrderActionPerformed

    private void jButtonDeleteDeliveryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteDeliveryOrderActionPerformed
        if (jTableDeliveryOrders.getSelectedRow() >= 0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Do you want to delete this delivery order?","INFO",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                deliveryOrderController = new DeliveryOrderController(this, this.home);
                String id = jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(),0).toString();
                deliveryOrderController.deleteDeliveryOrder(id);
                deliveryOrderController.showDeliveryOrders();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to delete!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteDeliveryOrderActionPerformed

    private void jButtonDetailDeliveryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailDeliveryOrderActionPerformed
        if (jTableDeliveryOrders.getSelectedRow() >= 0){
            detailDeliveryOrderView = new Frame_DetailDeliveryOrder(this,this.home);
            detailDeliveryOrderView.pack();
            detailDeliveryOrderView.setLocationRelativeTo(null);
            detailDeliveryOrderView.setAlwaysOnTop(true);
            detailDeliveryOrderView.getjLabelId().setVisible(false);
            
            String doIdString = jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(), 0).toString();
            detailDeliveryOrderView.getjLabelId().setText(doIdString);
            String ticketIdString = jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(),1).toString();
            detailDeliveryOrderView.getjTextTicketId().setText(ticketIdString);
            detailDeliveryOrderView.getjTextTeamWarehouse().setText((String) jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(),2));
            
            
            DeliveryOrderModel deliveryOrder = new DeliveryOrderModel();
            String ticketStatus = deliveryOrder.getTicketStatusById(Integer.parseInt(ticketIdString));
            String customerName = deliveryOrder.getCustomerNameByTicketId(Integer.parseInt(ticketIdString));
            String ticketProblem = deliveryOrder.getTicketProblemById(Integer.parseInt(ticketIdString));
            String ticketDescription = deliveryOrder.getTicketDescriptionById(Integer.parseInt(ticketIdString));
            String ticketEngineer = deliveryOrder.getEngineerNameByTicketId(Integer.parseInt(ticketIdString));
            String customerDescription = deliveryOrder.getCustomerDescriptionByTicketId(Integer.parseInt(ticketIdString));
            
            detailDeliveryOrderView.getjTextTicketStatus().setText(ticketStatus);
            detailDeliveryOrderView.getjTextCustomerName().setText(customerName);
            detailDeliveryOrderView.getjTextProblem().setText(ticketProblem);
            detailDeliveryOrderView.getjTextTeamEngineer().setText(ticketEngineer);
            detailDeliveryOrderView.getjTextTicketDescription().setText(ticketDescription);
            detailDeliveryOrderView.getjTextCustomerDescription().setText(customerDescription);
            
            
            int doId = Integer.parseInt(doIdString);
            doAssetController = new DOAssetController(detailDeliveryOrderView);
            doAssetController.showDOAssets(doId);
            
            detailDeliveryOrderView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to show detail!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDetailDeliveryOrderActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateDeliveryOrder;
    private javax.swing.JButton jButtonDeleteDeliveryOrder;
    private javax.swing.JButton jButtonDetailDeliveryOrder;
    private javax.swing.JButton jButtonEditDeliveryOrder;
    private javax.swing.JButton jButtonRefreshDeliveryOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNameLogin;
    private javax.swing.JLabel jLabelRoleLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.table.Table jTableDeliveryOrders;
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
