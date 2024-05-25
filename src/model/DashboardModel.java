/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dandy
 */
public class DashboardModel {
    private int ticketId;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String userName;
    private String problem;
    private int doId;
    private String status;

    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerPhone
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * @param customerPhone the customerPhone to set
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * @return the customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the doId
     */
    public int getDoId() {
        return doId;
    }

    /**
     * @param doId the doId to set
     */
    public void setDoId(int doId) {
        this.doId = doId;
    }
}
