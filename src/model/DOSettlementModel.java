/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dandy
 */
public class DOSettlementModel {
    private int id;
    private int doAssetId;
    private int activityReportId;
    private String faultModelNumber;
    private String faultPartNumber;
    private String faultSerialNumber;
    private String faultName;
    private int faultQty;
    private String notes;

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
     * @return the doAssetId
     */
    public int getDoAssetId() {
        return doAssetId;
    }

    /**
     * @param doAssetId the doAssetId to set
     */
    public void setDoAssetId(int doAssetId) {
        this.doAssetId = doAssetId;
    }

    /**
     * @return the activityReportId
     */
    public int getActivityReportId() {
        return activityReportId;
    }

    /**
     * @param activityReportId the activityReportId to set
     */
    public void setActivityReportId(int activityReportId) {
        this.activityReportId = activityReportId;
    }

    /**
     * @return the faultModelNumber
     */
    public String getFaultModelNumber() {
        return faultModelNumber;
    }

    /**
     * @param faultModelNumber the faultModelNumber to set
     */
    public void setFaultModelNumber(String faultModelNumber) {
        this.faultModelNumber = faultModelNumber;
    }

    /**
     * @return the faultPartNumber
     */
    public String getFaultPartNumber() {
        return faultPartNumber;
    }

    /**
     * @param faultPartNumber the faultPartNumber to set
     */
    public void setFaultPartNumber(String faultPartNumber) {
        this.faultPartNumber = faultPartNumber;
    }

    /**
     * @return the faultSerialNumber
     */
    public String getFaultSerialNumber() {
        return faultSerialNumber;
    }

    /**
     * @param faultSerialNumber the faultSerialNumber to set
     */
    public void setFaultSerialNumber(String faultSerialNumber) {
        this.faultSerialNumber = faultSerialNumber;
    }

    /**
     * @return the faultDescription
     */
    public String getFaultName() {
        return faultName;
    }

    /**
     * @param faultDescription the faultDescription to set
     */
    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    /**
     * @return the faultQty
     */
    public int getFaultQty() {
        return faultQty;
    }

    /**
     * @param faultQty the faultQty to set
     */
    public void setFaultQty(int faultQty) {
        this.faultQty = faultQty;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
}
