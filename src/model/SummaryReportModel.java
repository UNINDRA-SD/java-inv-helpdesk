/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dandy
 */
public class SummaryReportModel {
    private int ticketId;
    private String problem;
    private String actionTaken;
    private int assetId;
    private String assetName;
    private int assetQty;
    private String settleNotes;

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
     * @return the assetId
     */
    public int getAssetId() {
        return assetId;
    }

    /**
     * @param assetId the assetId to set
     */
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    /**
     * @return the assetName
     */
    public String getAssetName() {
        return assetName;
    }

    /**
     * @param assetName the assetName to set
     */
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    /**
     * @return the assetQty
     */
    public int getAssetQty() {
        return assetQty;
    }

    /**
     * @param assetQty the assetQty to set
     */
    public void setAssetQty(int assetQty) {
        this.assetQty = assetQty;
    }

    /**
     * @return the settleNotes
     */
    public String getSettleNotes() {
        return settleNotes;
    }

    /**
     * @param settleNotes the settleNotes to set
     */
    public void setSettleNotes(String settleNotes) {
        this.settleNotes = settleNotes;
    }
    
    
}
