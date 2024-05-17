/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dandy
 */
public class ActivityReportModel {
    private int id;
    private int deliveryOrderId;
    private String actionTaken;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the deliveryOrderId
     */
    public int getDeliveryOrderId() {
        return deliveryOrderId;
    }

    /**
     * @param deliveryOrderId the deliveryOrderId to set
     */
    public void setDeliveryOrderId(int deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    /**
     * @return the actionTaken
     */
    public String getActionTaken() {
        return actionTaken;
    }

    /**
     * @param actionTaken the actionTaken to set
     */
    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
}
