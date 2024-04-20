/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DOAssetDAO;
import java.util.List;
import model.DOAssetModel;
import table.DOAssetTable;
import view.form.Form_DeliveryOrders;
import view.Frame_DetailDeliveryOrder;

/**
 *
 * @author ACER
 */
public class DOAssetController {
    Form_DeliveryOrders formDeliveryOrders;
    Frame_DetailDeliveryOrder detailDeliveryOrder;
    DOAssetDAO doAssetDAO;
    List<DOAssetModel> doAssets;
    
    public DOAssetController(Frame_DetailDeliveryOrder detailDeliveryOrder, Form_DeliveryOrders formDeliveryOrders) {
        this.formDeliveryOrders = formDeliveryOrders;
        this.detailDeliveryOrder = detailDeliveryOrder;
        doAssetDAO = new DOAssetDAO();
    }
    
    public void showDOAssets(int doId) {
        doAssets = doAssetDAO.getDOAssets(doId);
        DOAssetTable doAssetTable = new DOAssetTable(doAssets);
        detailDeliveryOrder.getDataTable().setModel(doAssetTable);
    }
}
