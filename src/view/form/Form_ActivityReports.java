package view.form;

import controller.ActivityReportController;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.UserModel;
import view.Frame_CreateActivityReport;
import view.main.Home;


public class Form_ActivityReports extends javax.swing.JPanel {

    private UserModel userLogin;
    ActivityReportController activityReportController;
    Home home;
    
    Frame_CreateActivityReport createActivityReportView;
    
//    DOAssetController doAssetController;
//    Frame_DetailDeliveryOrder detailDeliveryOrderView;
    
    public Form_ActivityReports(UserModel userLogin) {
        initComponents();
        this.userLogin = userLogin;
        getjLabelNameLogin().setText(userLogin.getName());
        getjLabelRoleLogin().setText(userLogin.getRole());
        
        init();
    }
    
    public JTable getDataTable() {
        return jTableActivityReports;
    }

    private void init() {
        jTableActivityReports.fixTable(jScrollPane1);
        

        //  init card data
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new view.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActivityReports = new view.swing.table.Table();
        jButtonRefreshActivityReport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNameLogin = new javax.swing.JLabel();
        jLabelRoleLogin = new javax.swing.JLabel();
        jButtonCreateActivityReport = new javax.swing.JButton();
        jButtonEditActivityReport = new javax.swing.JButton();
        jButtonDeleteActivityReport = new javax.swing.JButton();
        jButtonDetailActivityReport = new javax.swing.JButton();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jTableActivityReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ticket ID", "Tim WH", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTableActivityReports);
        if (jTableActivityReports.getColumnModel().getColumnCount() > 0) {
            jTableActivityReports.getColumnModel().getColumn(0).setMinWidth(25);
            jTableActivityReports.getColumnModel().getColumn(0).setMaxWidth(25);
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

        jButtonRefreshActivityReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        jButtonRefreshActivityReport.setText("Refresh");
        jButtonRefreshActivityReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActivityReportActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Activity Reports");

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

        jButtonCreateActivityReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        jButtonCreateActivityReport.setText("Create");
        jButtonCreateActivityReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActivityReportActionPerformed(evt);
            }
        });

        jButtonEditActivityReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        jButtonEditActivityReport.setText("Edit");
        jButtonEditActivityReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActivityReportActionPerformed(evt);
            }
        });

        jButtonDeleteActivityReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        jButtonDeleteActivityReport.setText("Delete");
        jButtonDeleteActivityReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActivityReportActionPerformed(evt);
            }
        });

        jButtonDetailActivityReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/detail.png"))); // NOI18N
        jButtonDetailActivityReport.setText("Detail");
        jButtonDetailActivityReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailActivityReportActionPerformed(evt);
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
                                .addComponent(jButtonRefreshActivityReport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonCreateActivityReport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonEditActivityReport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDeleteActivityReport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDetailActivityReport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jButtonRefreshActivityReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreateActivityReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditActivityReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteActivityReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDetailActivityReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshActivityReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActivityReportActionPerformed
        activityReportController = new ActivityReportController(this, home);
        activityReportController.showActivityReports();
    }//GEN-LAST:event_jButtonRefreshActivityReportActionPerformed

    private void jButtonCreateActivityReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActivityReportActionPerformed
        createActivityReportView = new Frame_CreateActivityReport(this, home);
        createActivityReportView.pack();
        createActivityReportView.setLocationRelativeTo(null);
        createActivityReportView.setVisible(true);
        createActivityReportView.showTime();
        
    }//GEN-LAST:event_jButtonCreateActivityReportActionPerformed

    private void jButtonEditActivityReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActivityReportActionPerformed
         if (jTableActivityReports.getSelectedRow() >= 0){
            createActivityReportView = new Frame_CreateActivityReport(this,this.home);
            createActivityReportView.pack();
            createActivityReportView.setLocationRelativeTo(null);
            createActivityReportView.setAlwaysOnTop(true);
            createActivityReportView.getjLabelTitle().setText("Edit Activity Report");
            createActivityReportView.getjButtonSave().setText("Update");
            createActivityReportView.getjLabelId().setVisible(false);
            createActivityReportView.showTime();
            
            createActivityReportView.getjLabelId().setText(jTableActivityReports.getValueAt(jTableActivityReports.getSelectedRow(),0).toString());
            
            String selectedDOId = jTableActivityReports.getValueAt(jTableActivityReports.getSelectedRow(), 1).toString();
            if (isItemExist(createActivityReportView.getjComboDOId(), selectedDOId)) {
                createActivityReportView.getjComboDOId().setSelectedItem(selectedDOId);
            } else {
                JOptionPane.showMessageDialog(this, "DO ID '" + selectedDOId + "' not found in ComboBox!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            createActivityReportView.getjTextActionTaken().setText((String) jTableActivityReports.getValueAt(jTableActivityReports.getSelectedRow(),2));
            String dateTimeStr = (String) jTableActivityReports.getValueAt(jTableActivityReports.getSelectedRow(), 3);

            String[] dateTimeParts = dateTimeStr.split("\\|");

            if (dateTimeParts.length == 2) {
                createActivityReportView.getjTextStartDate().setText(dateTimeParts[0].trim());
                createActivityReportView.getjFormattedStartTime().setText(dateTimeParts[1].trim());
            }

            String dateTimeStr2 = (String) jTableActivityReports.getValueAt(jTableActivityReports.getSelectedRow(), 4);
            String[] dateTimeParts2 = dateTimeStr2.split("\\|");

            if (dateTimeParts2.length == 2) {
                createActivityReportView.getjTextEndDate().setText(dateTimeParts2[0].trim());
                createActivityReportView.getjFormattedEndTime().setText(dateTimeParts2[1].trim());
            }

            createActivityReportView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to edit!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditActivityReportActionPerformed

    private void jButtonDeleteActivityReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActivityReportActionPerformed
        if (jTableActivityReports.getSelectedRow() >= 0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Do you want to delete this activity report?","INFO",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                activityReportController = new ActivityReportController(this, this.home);
                String id = jTableActivityReports.getValueAt(jTableActivityReports.getSelectedRow(),0).toString();
                activityReportController.deleteActivityReport(id);
                activityReportController.showActivityReports();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to delete!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteActivityReportActionPerformed

    private void jButtonDetailActivityReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailActivityReportActionPerformed
//        if (jTableDeliveryOrders.getSelectedRow() >= 0){
//            detailDeliveryOrderView = new Frame_DetailDeliveryOrder(this,this.home);
//            detailDeliveryOrderView.pack();
//            detailDeliveryOrderView.setLocationRelativeTo(null);
//            detailDeliveryOrderView.setAlwaysOnTop(true);
//            detailDeliveryOrderView.getjLabelId().setVisible(false);
//            
//            String doIdString = jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(), 0).toString();
//            detailDeliveryOrderView.getjLabelId().setText(doIdString);
//            String ticketIdString = jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(),1).toString();
//            detailDeliveryOrderView.getjTextTicketId().setText(ticketIdString);
//            detailDeliveryOrderView.getjTextTeamWarehouse().setText((String) jTableDeliveryOrders.getValueAt(jTableDeliveryOrders.getSelectedRow(),2));
//            
//            
//            DeliveryOrderModel deliveryOrder = new DeliveryOrderModel();
//            String ticketStatus = deliveryOrder.getTicketStatusById(Integer.parseInt(ticketIdString));
//            String customerName = deliveryOrder.getCustomerNameByTicketId(Integer.parseInt(ticketIdString));
//            String ticketProblem = deliveryOrder.getTicketProblemById(Integer.parseInt(ticketIdString));
//            String ticketDescription = deliveryOrder.getTicketDescriptionById(Integer.parseInt(ticketIdString));
//            String ticketEngineer = deliveryOrder.getEngineerNameByTicketId(Integer.parseInt(ticketIdString));
//            String customerDescription = deliveryOrder.getCustomerDescriptionByTicketId(Integer.parseInt(ticketIdString));
//            
//            detailDeliveryOrderView.getjTextTicketStatus().setText(ticketStatus);
//            detailDeliveryOrderView.getjTextCustomerName().setText(customerName);
//            detailDeliveryOrderView.getjTextProblem().setText(ticketProblem);
//            detailDeliveryOrderView.getjTextTeamEngineer().setText(ticketEngineer);
//            detailDeliveryOrderView.getjTextTicketDescription().setText(ticketDescription);
//            detailDeliveryOrderView.getjTextCustomerDescription().setText(customerDescription);
//            
//            
//            int doId = Integer.parseInt(doIdString);
//            doAssetController = new DOAssetController(detailDeliveryOrderView);
//            doAssetController.showDOAssets(doId);
//            
//            detailDeliveryOrderView.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(this, "Select one data to show detail!","WARNING",JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_jButtonDetailActivityReportActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateActivityReport;
    private javax.swing.JButton jButtonDeleteActivityReport;
    private javax.swing.JButton jButtonDetailActivityReport;
    private javax.swing.JButton jButtonEditActivityReport;
    private javax.swing.JButton jButtonRefreshActivityReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNameLogin;
    private javax.swing.JLabel jLabelRoleLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.table.Table jTableActivityReports;
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
