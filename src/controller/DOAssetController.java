/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DOAssetDAO;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import config.MysqlDB;
import model.AssetModel;
import model.DOAssetModel;
import table.DOAssetTable;
import view.Frame_AddDOAsset;
import view.form.Form_DeliveryOrders;
import view.Frame_DetailDeliveryOrder;

/**
 *
 * @author ACER
 */
public class DOAssetController {
    Form_DeliveryOrders formDeliveryOrders;
    Frame_DetailDeliveryOrder detailDeliveryOrder;
    Frame_AddDOAsset addDOAssetView;
    DOAssetDAO doAssetDAO;
    List<DOAssetModel> doAssets;
    
    public DOAssetController(Frame_DetailDeliveryOrder detailDeliveryOrder) {
        this.detailDeliveryOrder = detailDeliveryOrder;
        doAssetDAO = new DOAssetDAO();
    }
    
    public void showDOAssets(int doId) {
        doAssets = doAssetDAO.getDOAssets(doId);
        DOAssetTable doAssetTable = new DOAssetTable(doAssets);
        detailDeliveryOrder.getDataTable().setModel(doAssetTable);

        // Panggil metode hideIdColumn untuk menyembunyikan kolom ID
        detailDeliveryOrder.hideIdColumn();
    }

    
    public void saveDOAsset(Frame_AddDOAsset addDOAssetView) {
        Connection connection = null;
        try {
            connection = MysqlDB.connection();
            connection.setAutoCommit(false); // Mulai transaksi

            // Pastikan input tidak kosong
            if (addDOAssetView.getjComboAsset().getSelectedItem() != null
                && !addDOAssetView.getjTextQty().getText().trim().isEmpty()
                && !addDOAssetView.getjLabelId().getText().trim().isEmpty()) {

                DOAssetModel doAsset = new DOAssetModel();
                doAsset.setDeliveryOrderId(Integer.parseInt(addDOAssetView.getjLabelId().getText()));

                // Ambil data aset yang dipilih
                String selectedAsset = (String) addDOAssetView.getjComboAsset().getSelectedItem();
                String[] assetDetails = selectedAsset.split("\\|");
                int assetId = Integer.parseInt(assetDetails[0].trim());
                doAsset.setAssetId(assetId);

                // Periksa stok aset saat ini
                int currentQty = AssetModel.getQtyByAssetId(connection, assetId);
                int inputQty = Integer.parseInt(addDOAssetView.getjTextQty().getText());

                if (currentQty >= inputQty) {
                    doAsset.setQty(inputQty);

                    // Simpan data DO Asset
                    if (doAssetDAO.saveDOAsset(doAsset)) {
                        // Kurangi stok aset
                        AssetModel.setMinQtyByAssetId(connection, assetId, inputQty);
                        JOptionPane.showMessageDialog(addDOAssetView, "Data saved successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                        // Komit transaksi jika semua operasi berhasil
                        connection.commit();

                        addDOAssetView.setVisible(false);
                    } else {
                        throw new SQLException("Failed to save data!");
                    }
                } else {
                    JOptionPane.showMessageDialog(addDOAssetView, "Qty is out of stock!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(addDOAssetView, "Input cannot be empty!", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            // Rollback transaksi jika terjadi kesalahan
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    System.out.println("Failed to rollback transaction: " + rollbackEx);
                }
            }
            System.out.println("Error during transaction: " + e);
            JOptionPane.showMessageDialog(addDOAssetView, "Failed to save data!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Pastikan connection ditutup
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Kembalikan ke mode auto-commit
                } catch (SQLException closeEx) {
                    System.out.println("Failed to close connection: " + closeEx);
                }
            }
        }
    }

    
//    public void saveDOAsset(Frame_AddDOAsset addDOAssetView) {
//        if (addDOAssetView.getjComboAsset().getSelectedItem() != null
//            && !addDOAssetView.getjTextQty().getText().trim().isEmpty()
//            && !addDOAssetView.getjLabelId().getText().trim().isEmpty()){
//            
//            DOAssetModel doAsset = new DOAssetModel();
//            
//            doAsset.setDeliveryOrderId(Integer.parseInt(addDOAssetView.getjLabelId().getText()));
//            
//            String selectedAsset = (String) addDOAssetView.getjComboAsset().getSelectedItem();
//            String[] assetDetails = selectedAsset.split("\\|");
//            int assetId = Integer.parseInt(assetDetails[0].trim());
//            doAsset.setAssetId(assetId);
//                        
//            // check Asset current stock Qty
//            int qty = AssetModel.getQtyByAssetId(assetId);
//            if(qty >= Integer.parseInt(addDOAssetView.getjTextQty().getText()))
//            {
//                doAsset.setQty(Integer.parseInt(addDOAssetView.getjTextQty().getText()));
//                if(doAssetDAO.saveDOAsset(doAsset)) {
//                    // set reduced stock Qty
//                    AssetModel.setMinQtyByAssetId(assetId, Integer.parseInt(addDOAssetView.getjTextQty().getText()));
//                    JOptionPane.showMessageDialog(addDOAssetView, "Data saved successfully!","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
//                    addDOAssetView.setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(addDOAssetView, "Failed to save data!","ERROR",JOptionPane.ERROR_MESSAGE);
//                }
//            }
//            else {
//                JOptionPane.showMessageDialog(addDOAssetView, "Qty is out of stock!","WARNING",JOptionPane.WARNING_MESSAGE);
//            }
//            
//        } else {
//            JOptionPane.showMessageDialog(addDOAssetView, "Input cannot be empty!","WARNING",JOptionPane.WARNING_MESSAGE);
//        }
//    }
    
    public void deleteDOAsset(String id, int assetId, int qty, Frame_DetailDeliveryOrder deliveryOrderView) {
        Connection connection = null;
        try {
            connection = MysqlDB.connection();
            connection.setAutoCommit(false); // Mulai transaksi

            // Tambahkan kembali kuantitas ke aset
            AssetModel.setAddQtyByAssetId(connection, assetId, qty);

            // Hapus DO Asset
            doAssetDAO.deleteDOAsset(connection, id);

            // Commit transaksi
            connection.commit();

            // Beri tahu pengguna bahwa kuantitas telah dikembalikan
            int totalQty = AssetModel.getQtyByAssetId(connection, assetId);
            JOptionPane.showMessageDialog(deliveryOrderView,
                "Qty stock: | " + qty + " | has been returned to Asset ID: | " + assetId + " | Total Qty stock: | " + totalQty + " |",
                "INFO",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            // Rollback transaksi jika terjadi kesalahan
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    System.out.println("Failed to rollback transaction: " + rollbackEx);
                }
            }
            System.out.println("Error during transaction: " + e);
            JOptionPane.showMessageDialog(deliveryOrderView, "Failed to delete DO Asset!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Pastikan untuk menutup koneksi
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Kembalikan ke mode auto-commit
                } catch (SQLException closeEx) {
                    System.out.println("Failed to close connection: " + closeEx);
                }
            }
        }
    }

    
//    public void deleteDOAsset(String id, int assetId, int qty, Frame_DetailDeliveryOrder deliveryOrderView){           
//        AssetModel.setAddQtyByAssetId(assetId, qty);
//        JOptionPane.showMessageDialog(deliveryOrderView,"Qty stock: | "+ qty +" | has been returned to Asset ID : | "+ assetId + " | Total Qty stock : | " + AssetModel.getQtyByAssetId(assetId) + " |","INFO",JOptionPane.INFORMATION_MESSAGE);
//        doAssetDAO.deleteDOAsset(id);
//    }
    
    public void printDO(Frame_DetailDeliveryOrder detailDeliveryOrder, String dir){
        
    }
    
    public int getDOSettlementByDOAssetId(int id){
        return doAssetDAO.getDOSettlementIDByDOAssetId(id);
    }
}
