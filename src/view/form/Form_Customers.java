package view.form;

import controller.CustomerController;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.UserModel;
import view.Frame_CreateCustomer;
import view.main.Home;


public class Form_Customers extends javax.swing.JPanel {

    private UserModel userLogin;
    CustomerController customerController;
    Home home;
    Frame_CreateCustomer createCustomerView;
    
    public Form_Customers(UserModel userLogin) {
        initComponents();
        this.userLogin = userLogin;
        getjLabelNameLogin().setText(userLogin.getName());
        getjLabelRoleLogin().setText(userLogin.getRole());
        init();
    }
    
    public JTable getDataTable() {
        return jTableCustomers;
    }

    private void init() {
        jTableCustomers.fixTable(jScrollPane1);
        

        //  init card data
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new view.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomers = new view.swing.table.Table();
        jButtonRefreshCustomer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNameLogin = new javax.swing.JLabel();
        jLabelRoleLogin = new javax.swing.JLabel();
        jButtonCreateCustomer = new javax.swing.JButton();
        jButtonEditCustomer = new javax.swing.JButton();
        jButtonDeleteCustomer = new javax.swing.JButton();

        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        jTableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Phone", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCustomers);
        if (jTableCustomers.getColumnModel().getColumnCount() > 0) {
            jTableCustomers.getColumnModel().getColumn(0).setMinWidth(25);
            jTableCustomers.getColumnModel().getColumn(0).setMaxWidth(25);
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

        jButtonRefreshCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        jButtonRefreshCustomer.setText("Refresh");
        jButtonRefreshCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshCustomerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Customers");

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

        jButtonCreateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/add.png"))); // NOI18N
        jButtonCreateCustomer.setText("Create");
        jButtonCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateCustomerActionPerformed(evt);
            }
        });

        jButtonEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        jButtonEditCustomer.setText("Edit");
        jButtonEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditCustomerActionPerformed(evt);
            }
        });

        jButtonDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        jButtonDeleteCustomer.setText("Delete");
        jButtonDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCustomerActionPerformed(evt);
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
                                .addComponent(jButtonRefreshCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonCreateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(jButtonRefreshCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCreateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshCustomerActionPerformed
        customerController = new CustomerController(this, home);
        customerController.showCustomers();
    }//GEN-LAST:event_jButtonRefreshCustomerActionPerformed

    private void jButtonCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateCustomerActionPerformed
        createCustomerView = new Frame_CreateCustomer(this, home);
        createCustomerView.pack();
        createCustomerView.setLocationRelativeTo(null);
        createCustomerView.setVisible(true);
        
    }//GEN-LAST:event_jButtonCreateCustomerActionPerformed

    private void jButtonEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditCustomerActionPerformed
         if (jTableCustomers.getSelectedRow()>=0){
            createCustomerView = new Frame_CreateCustomer(this,this.home);
            createCustomerView.pack();
            createCustomerView.setLocationRelativeTo(null);
            createCustomerView.setAlwaysOnTop(true);
            createCustomerView.getjLabelTitle().setText("Edit Data Customer");
            createCustomerView.getjButtonSave().setText("Update");
            createCustomerView.getjLabelId().setVisible(false);
            createCustomerView.getjLabelId().setText(jTableCustomers.getValueAt(jTableCustomers.getSelectedRow(),0).toString());
            createCustomerView.getjTextName().setText((String) jTableCustomers.getValueAt(jTableCustomers.getSelectedRow(),1));
            createCustomerView.getjTextPhone().setText((String) jTableCustomers.getValueAt(jTableCustomers.getSelectedRow(),2));
            createCustomerView.getjTextAddress().setText((String) jTableCustomers.getValueAt(jTableCustomers.getSelectedRow(),3));
            createCustomerView.getjTextDescription().setText((String) jTableCustomers.getValueAt(jTableCustomers.getSelectedRow(),4));
            createCustomerView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to edit!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditCustomerActionPerformed

    private void jButtonDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCustomerActionPerformed
        if (jTableCustomers.getSelectedRow()>=0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Do you want to delete this customer?","INFO",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                customerController = new CustomerController(this, this.home);
                String id = jTableCustomers.getValueAt(jTableCustomers.getSelectedRow(),0).toString();
                customerController.deleteCustomer(id);
                customerController.showCustomers();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select one data to delete!","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteCustomerActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateCustomer;
    private javax.swing.JButton jButtonDeleteCustomer;
    private javax.swing.JButton jButtonEditCustomer;
    private javax.swing.JButton jButtonRefreshCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNameLogin;
    private javax.swing.JLabel jLabelRoleLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.table.Table jTableCustomers;
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
