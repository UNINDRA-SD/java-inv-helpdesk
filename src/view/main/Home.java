package view.main;

import controller.ActivityReportController;
import controller.AssetController;
import controller.AssetReportController;
import controller.BrandController;
import controller.CategoryController;
import controller.CustomerController;
import controller.DashboardController;
import controller.DeliveryOrderController;
import controller.RackController;
import controller.SummaryReportController;
import controller.TicketController;
import controller.UserController;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import model.UserModel;
import view.form.Form_ActivityReports;
import view.form.Form_AssetReports;
import view.form.Form_Assets;
import view.form.Form_Brands;
import view.form.Form_Dashboard;
import view.form.Form_Empty;
import view.form.Form_Users;
import view.menu.EventMenuSelected;
import view.form.Form_Customers;
import view.form.Form_Categories;
import view.form.Form_DeliveryOrders;
import view.form.Form_Racks;
import view.form.Form_SummaryReports;
import view.form.Form_Tickets;
import view.form.Form_Unauthorized;

public class Home extends javax.swing.JFrame {
    
    private static Home main;
    private UserModel userLogin;
    
    // Form Unauthorized
    Form_Unauthorized formUnauthorized;
    
    //  Form Dashboard
    DashboardController dashboardController;
    Form_Dashboard formDashboard;
    
    //  Form Users
    UserController userController;
    Form_Users formUsers;
    
    //  Form Brands
    BrandController brandController;
    Form_Brands formBrands;
    
    //  Form Categories
    CategoryController categoryController;
    Form_Categories formCategories;
    
    //  Form Racks
    RackController rackController;
    Form_Racks formRacks;

    // Form Summary Report
    SummaryReportController summaryReportController;
    Form_SummaryReports formSummaryReport;
    
    // Form Asset Report
    AssetReportController assetReportController;
    Form_AssetReports formAssetReports;
    
    //  Form Customers
    CustomerController customerController;
    Form_Customers formCustomers;

    //  Form Tickets
    TicketController ticketController;
    Form_Tickets formTickets;
    
    //  Form Assets
    AssetController assetController;
    Form_Assets formAssets;
    
    //  Form Delivery Orders
    DeliveryOrderController deliveryOrderController;
    Form_DeliveryOrders formDeliveryOrders;

    //  Activity Reports
    ActivityReportController activityReportController;
    Form_ActivityReports formActivityReports;
       
    public Home(UserModel userLogin) {
        this.userLogin = userLogin;
        
        // Form Unauthorized
        formUnauthorized = new Form_Unauthorized(userLogin);
        
        // Form Dashboard
        formDashboard = new Form_Dashboard(userLogin); 
        dashboardController = new DashboardController(formDashboard);
        dashboardController.showDashboardData();
        dashboardController.setCardTicket();
        
        // Form Users
        formUsers = new Form_Users(userLogin); 
        userController = new UserController(formUsers, this);
        userController.showUsers();
        
        // Form Brands
        formBrands = new Form_Brands(userLogin);
        brandController = new BrandController(formBrands, this);
        brandController.showBrands();
        
        // Form Categories
        formCategories = new Form_Categories(userLogin);
        categoryController = new CategoryController(formCategories, this);
        categoryController.showCategories();
        
        // Form Racks
        formRacks = new Form_Racks(userLogin);
        rackController = new RackController(formRacks, this);
        rackController.showRacks();

        // Form Summary Report
        formSummaryReport = new Form_SummaryReports(userLogin);
        summaryReportController = new SummaryReportController(formSummaryReport, this);
        summaryReportController.showSummaryReport();
        summaryReportController.setCardTicket();
        
        // Form Asset Report
        formAssetReports = new Form_AssetReports(userLogin);
        assetReportController = new AssetReportController(formAssetReports, this);
        assetReportController.showAvailableStockSummary();
        assetReportController.showNeedToRestockSummary();

        // Form Customers
        formCustomers = new Form_Customers(userLogin);
        customerController = new CustomerController(formCustomers, this);
        customerController.showCustomers();

        // Form Tickets
        formTickets = new Form_Tickets(userLogin);
        ticketController = new TicketController(formTickets, this);
        ticketController.showTickets();
        
        // Form Assets
        formAssets = new Form_Assets(userLogin);
        assetController = new AssetController(formAssets);
        assetController.showAssets();
        
        // Form Delivery Orders
        formDeliveryOrders = new Form_DeliveryOrders(userLogin);
        deliveryOrderController = new DeliveryOrderController(formDeliveryOrders, this);
        deliveryOrderController.showDeliveryOrders();

        // Form Delivery Orders
        formActivityReports = new Form_ActivityReports(userLogin);
        activityReportController = new ActivityReportController(formActivityReports, this);
        activityReportController.showActivityReports();

        initComponents();
        init();
        ImageIcon icon = new ImageIcon(getClass().getResource("/asset/inv2.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }
    
    private void init() {
        main = this;
        titleBar.initJFram(this);
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                if (index == 0 && indexSubMenu == 0) {
                    showForm(formDashboard);
                } else if(index == 1 && indexSubMenu == 0) {
                    if(userLogin.getRole().equalsIgnoreCase("management")) {
                        showForm(formUsers);
                    } else {
                        showForm(formUnauthorized);
                    }
                } else if(index == 2 && indexSubMenu == 1) {
                    if(userLogin.getRole().equalsIgnoreCase("management")) {
                        showForm(formBrands);
                    } else {
                        showForm(formUnauthorized);
                    }
                } else if(index == 2 && indexSubMenu == 2) {
                    if(userLogin.getRole().equalsIgnoreCase("management")) {
                        showForm(formCategories);
                    } else {
                        showForm(formUnauthorized);
                    }
                } else if(index == 2 && indexSubMenu == 3) {
                    if(userLogin.getRole().equalsIgnoreCase("management")) {
                        showForm(formRacks);
                    } else {
                        showForm(formUnauthorized);
                    }
                } else if(index == 3 && indexSubMenu == 1) {
                    if(userLogin.getRole().equalsIgnoreCase("management")) {
                        showForm(formSummaryReport);
                    } else {
                        showForm(formUnauthorized);
                    }
                } else if(index == 3 && indexSubMenu == 2) {
                    if(userLogin.getRole().equalsIgnoreCase("management")) {
                        showForm(formAssetReports);
                    } else {
                        showForm(formUnauthorized);
                    }
                } else if(index == 4 && indexSubMenu == 0) {
                    showForm(formCustomers);
                } else if(index == 5 && indexSubMenu == 0) {
                    showForm(formTickets);
                } else if(index == 6 && indexSubMenu == 0) {
                    showForm(formAssets);
                } else if(index == 7 && indexSubMenu == 0) {
                    showForm(formDeliveryOrders);
                } else if(index == 8 && indexSubMenu == 0) {
                    showForm(formActivityReports);
                }
                else {
                    showForm(new Form_Empty(index + " " + indexSubMenu));
                }
            }
        });
        menu.setSelectedIndex(0, 0);
    }
    
    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }
    
    public static Home getMain() {
        return main;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        menu = new view.menu.Menu();
        titleBar = new view.swing.titlebar.TitleBar();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(245, 245, 245));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel body;
    private view.menu.Menu menu;
    private javax.swing.JPanel panelMenu;
    private view.swing.titlebar.TitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
