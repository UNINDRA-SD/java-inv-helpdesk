/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MysqlDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SummaryReportModel;

/**
 *
 * @author dandy
 */
public class SummaryReportDAO {
    
    Connection sql = MysqlDB.connection();
    
    public List<SummaryReportModel> getSummaryReports() {
        List<SummaryReportModel> summaryReports = new ArrayList<>();
        String query = "SELECT "
                     + "t.id AS ticket_id, "
                     + "t.problem, "
                     + "ar.action_taken, "
                     + "a.id AS asset_id, "
                     + "a.name AS asset_name, "
                     + "da.qty AS asset_qty, "
                     + "ds.notes AS settle_notes "
                     + "FROM tickets t "
                     + "JOIN delivery_orders do ON t.id = do.ticket_id "
                     + "JOIN do_assets da ON do.id = da.delivery_order_id "
                     + "JOIN assets a ON da.asset_id = a.id "
                     + "JOIN do_settlements ds ON da.id = ds.do_asset_id "
                     + "JOIN activity_reports ar ON ds.activity_report_id = ar.id";

        try (PreparedStatement stmt = sql.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SummaryReportModel summaryReport = new SummaryReportModel();
                summaryReport.setTicketId(rs.getInt("ticket_id"));
                summaryReport.setProblem(rs.getString("problem"));
                summaryReport.setActionTaken(rs.getString("action_taken"));
                summaryReport.setAssetId(rs.getInt("asset_id"));
                summaryReport.setAssetName(rs.getString("asset_name"));
                summaryReport.setAssetQty(rs.getInt("asset_qty"));
                summaryReport.setSettleNotes(rs.getString("settle_notes"));
                summaryReports.add(summaryReport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return summaryReports;
    }
    
    public int getTotalTickets() {
        String query = "SELECT COUNT(*) AS total FROM tickets";
        try (PreparedStatement stmt = sql.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int getOpenedTickets() {
        String query = "SELECT COUNT(*) AS total FROM tickets WHERE status = 'Open'";
        try (PreparedStatement stmt = sql.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int getClosedTickets() {
        String query = "SELECT COUNT(*) AS total FROM tickets WHERE status = 'Close'";
        try (PreparedStatement stmt = sql.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
