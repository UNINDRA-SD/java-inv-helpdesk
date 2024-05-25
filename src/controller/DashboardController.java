/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DashboardDAO;
import java.util.List;
import model.DashboardModel;
import table.DashboardTable;
import view.card.ModelCard;
import view.form.Form_Dashboard;

/**
 *
 * @author dandy
 */
public class DashboardController {
    private DashboardDAO dashboardDAO;
    private Form_Dashboard formDashboard;

    public DashboardController(Form_Dashboard formDashboard) {
        this.formDashboard = formDashboard;
        this.dashboardDAO = new DashboardDAO();
    }
    
    public void setCardTicket() {
        int totalTickets = dashboardDAO.getTotalTickets();
        int pendingTickets = dashboardDAO.getPendingTickets();
        int progressTickets = dashboardDAO.getProgressTickets();

        formDashboard.getCard1().setData(new ModelCard(null, null, null, String.valueOf(totalTickets), "Total Ticket"));
        formDashboard.getCard2().setData(new ModelCard(null, null, null, String.valueOf(pendingTickets), "Pending Ticket"));
        formDashboard.getCard3().setData(new ModelCard(null, null, null, String.valueOf(progressTickets), "Progress Ticket"));
    }

    public void showDashboardData() {
        List<DashboardModel> dashboardData = dashboardDAO.getDashboardData();
        DashboardTable dashboardTable = new DashboardTable(dashboardData);
        formDashboard.getDataTable().setModel(dashboardTable);
        formDashboard.setColumnWidths();
    }
}
