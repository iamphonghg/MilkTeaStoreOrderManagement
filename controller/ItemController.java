package controller;

import model.Item;
import view.Main;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemController {
    public void loadItemListFromDBToTable(DefaultTableModel tableModel, String itemType) {
        tableModel.getDataVector().removeAllElements();
        List<Item> itemList = new ArrayList<>();
        String query = "SELECT * FROM item WHERE item_type = '" + itemType + "' ORDER BY item_name ASC";
        ResultSet resultSet = Main.dbConnect.excuteQuerySelect(query);
        int countIndex = 0;
        try {
            while (resultSet.next()) {
                String name = resultSet.getString("item_name");
                Integer priceM = resultSet.getInt("price_sizem");
                Integer priceL = resultSet.getInt("price_sizel");
                String finalPriceL = null;
                if (priceL != 0) {
                    finalPriceL = String.valueOf(priceL);
                }
                String status = resultSet.getString("item_status");
                Integer promo = resultSet.getInt("discount_promo");
                String finalPromo = null;
                if (promo != 0) {
                    finalPromo = String.valueOf(promo);
                }
                String[] itemTable = {Integer.toString(++countIndex), name, String.valueOf(priceM), finalPriceL, status, finalPromo};
                Item item = new Item(name, itemType, priceM, priceL, status, promo);
                itemList.add(item);
                tableModel.addRow(itemTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Item> loadItemListFromDBToList() {
        List<Item> itemList = new ArrayList<>();
        String query = "SELECT * FROM item ORDER BY item_name ASC";
        ResultSet resultSet = Main.dbConnect.excuteQuerySelect(query);
        try {
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString("item_name"), resultSet.getString("item_type").trim(),
                        resultSet.getInt("price_sizem"), resultSet.getInt("price_sizel"),
                        resultSet.getString("item_status"), resultSet.getInt("discount_promo"));
                itemList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public void insertItemIntoDB(DefaultTableModel tableModel, String name, String type, Integer priceM, Integer priceL, Integer promo) {
        String query = "INSERT INTO item VALUES ('" + name + "', '" + type + "', " + priceM + ", " + priceL
                + ", 'còn', " + promo + ")";;
        Main.dbConnect.excuteQueryUpdate(query);
        loadItemListFromDBToTable(tableModel, type);
    }

    public void updateItemIntoDB(DefaultTableModel tableModel, String oldName, String newName, String newType, Integer newPriceM, Integer newPriceL, Integer newPromo) {
        String query = "UPDATE item " +
                "SET item_name = '" + newName + "', " +
                "item_type = '" + newType + "', " +
                "price_sizem = " + newPriceM + ", " +
                "price_sizel = " + newPriceL + ", " +
                "discount_promo = " + newPromo + " " +
                "WHERE item_name = '" + oldName + "'";
        Main.dbConnect.excuteQueryUpdate(query);
        loadItemListFromDBToTable(tableModel, newType);
    }

    public void updateStockStatus(DefaultTableModel tableModel, String name, String type, String status) {
        String query = "UPDATE item " +
                "SET item_status = '" + status + "' " +
                "WHERE item_name = '" + name + "'";
        Main.dbConnect.excuteQueryUpdate(query);
        loadItemListFromDBToTable(tableModel, type);
    }
}
