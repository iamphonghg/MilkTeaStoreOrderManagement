package view;

import controller.ItemController;
import model.Item;
import model.MyColor;
import model.MyFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Locale;

public class ItemPanel extends JPanel {
    public JComboBox<String> cbxCategoryItem, cbxItemType;
    public JTable tblItemList;
    public DefaultTableModel tableModelItemList;
    public JTextField txtItemName, txtItemPriceM, txtItemPriceL, txtItemPromo;
    public JButton btnAddNewItem, btnConfirmAddNew, btnCancelAddNew, btnEditItem, btnDeleteItem, btnInStock, btnOutStock,
            btnConfirmEdit, btnCancelEdit;
    public final ItemController itemController = new ItemController();


    public ItemPanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel pnlItemList = new JPanel();
        pnlItemList.setLayout(null);
        pnlItemList.setBackground(MyColor.CANVAS);
        pnlItemList.setBounds(10, 10, 610, 616);
        this.add(pnlItemList);

        cbxCategoryItem = new JComboBox<>();
        cbxCategoryItem.setFont(MyFont.MAIN_FONT);
        cbxCategoryItem.setBackground(Color.WHITE);
        cbxCategoryItem.setForeground(MyColor.TAB_LABEL);
        cbxCategoryItem.setBounds(230, 10, 150, 30);
        cbxCategoryItem.addItem("TRÀ SỮA");
        cbxCategoryItem.addItem("TRÀ HOA QUẢ");
        cbxCategoryItem.addItem("MACCHIATO");
        cbxCategoryItem.addItem("TOPPING");
        cbxCategoryItem.addItem("ĐỒ ĂN VẶT");
        ((JLabel) cbxCategoryItem.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pnlItemList.add(cbxCategoryItem);

        tableModelItemList = new DefaultTableModel();
        tableModelItemList.addColumn("STT");
        tableModelItemList.addColumn("Tên");
        tableModelItemList.addColumn("Giá cỡ M");
        tableModelItemList.addColumn("Giá cỡ L");
        tableModelItemList.addColumn("Trạng thái");
        tableModelItemList.addColumn("Khuyến mãi");
        tblItemList = new JTable(tableModelItemList);
        tblItemList.setFont(MyFont.DETAILBILL_FONT);
        tblItemList.setForeground(MyColor.TAB_LABEL);
        tblItemList.setDefaultEditor(Object.class, null);
        tblItemList.setFocusable(false);
        JTableHeader tblHeader = tblItemList.getTableHeader();
        tblHeader.setReorderingAllowed(false);
        tblHeader.setForeground(MyColor.TAB_LABEL);
        tblHeader.setBackground(Color.WHITE);
        tblHeader.setFont(MyFont.DETAILBILL_FONT);
        JScrollPane scrItemList = new JScrollPane(tblItemList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrItemList.setBounds(10, 50, 590, 556);
        pnlItemList.add(scrItemList);

        JPanel pnlDetailItem = new JPanel();
        pnlDetailItem.setLayout(null);
        pnlDetailItem.setBackground(MyColor.CANVAS);
        pnlDetailItem.setBounds(630, 10, 350, 616);
        this.add(pnlDetailItem);

        JLabel lblItemName = new JLabel("Tên", SwingConstants.CENTER);
        lblItemName.setOpaque(true);
        lblItemName.setFont(MyFont.MAIN_FONT_BIGGER);
        lblItemName.setBackground(MyColor.BACKGROUND_LOGO);
        lblItemName.setForeground(MyColor.TAB_LABEL);
        lblItemName.setBounds(10, 10, 155, 50);
        pnlDetailItem.add(lblItemName);

        txtItemName = new JTextField();
        txtItemName.setFont(MyFont.MAIN_FONT_BIGGER);
        txtItemName.setBackground(Color.WHITE);
        txtItemName.setForeground(MyColor.TAB_LABEL);
        txtItemName.setBounds(185, 10, 155, 50);
        txtItemName.setBorder(null);
        txtItemName.setHorizontalAlignment(SwingConstants.CENTER);
        pnlDetailItem.add(txtItemName);

        JLabel lblItemType = new JLabel("Loại", SwingConstants.CENTER);
        lblItemType.setOpaque(true);
        lblItemType.setFont(MyFont.MAIN_FONT_BIGGER);
        lblItemType.setBackground(MyColor.BACKGROUND_LOGO);
        lblItemType.setForeground(MyColor.TAB_LABEL);
        lblItemType.setBounds(10, 80, 155, 50);
        pnlDetailItem.add(lblItemType);

        cbxItemType = new JComboBox<>();
        cbxItemType.setFont(MyFont.MAIN_FONT);
        cbxItemType.setBackground(Color.WHITE);
        cbxItemType.setForeground(MyColor.TAB_LABEL);
        cbxItemType.setBorder(null);
        cbxItemType.addItem("TRÀ SỮA");
        cbxItemType.addItem("TRÀ HOA QUẢ");
        cbxItemType.addItem("MACCHIATO");
        cbxItemType.addItem("TOPPING");
        cbxItemType.addItem("ĐỒ ĂN VẶT");
        ((JLabel) cbxItemType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cbxItemType.setBounds(185, 80, 155, 50);
        pnlDetailItem.add(cbxItemType);

        JLabel lblItemPriceM = new JLabel("Giá size M", SwingConstants.CENTER);
        lblItemPriceM.setOpaque(true);
        lblItemPriceM.setFont(MyFont.MAIN_FONT_BIGGER);
        lblItemPriceM.setBackground(MyColor.BACKGROUND_LOGO);
        lblItemPriceM.setForeground(MyColor.TAB_LABEL);
        lblItemPriceM.setBounds(10, 150, 155, 50);
        pnlDetailItem.add(lblItemPriceM);

        txtItemPriceM = new JTextField();
        txtItemPriceM.setFont(MyFont.MAIN_FONT_BIGGER);
        txtItemPriceM.setBackground(Color.WHITE);
        txtItemPriceM.setForeground(MyColor.TAB_LABEL);
        txtItemPriceM.setBounds(185, 150, 155, 50);
        txtItemPriceM.setBorder(null);
        txtItemPriceM.setHorizontalAlignment(SwingConstants.CENTER);
        pnlDetailItem.add(txtItemPriceM);

        JLabel lblItemPriceL = new JLabel("Giá size L", SwingConstants.CENTER);
        lblItemPriceL.setOpaque(true);
        lblItemPriceL.setFont(MyFont.MAIN_FONT_BIGGER);
        lblItemPriceL.setBackground(MyColor.BACKGROUND_LOGO);
        lblItemPriceL.setForeground(MyColor.TAB_LABEL);
        lblItemPriceL.setBounds(10, 220, 155, 50);
        pnlDetailItem.add(lblItemPriceL);

        txtItemPriceL = new JTextField();
        txtItemPriceL.setFont(MyFont.MAIN_FONT_BIGGER);
        txtItemPriceL.setBackground(Color.WHITE);
        txtItemPriceL.setForeground(MyColor.TAB_LABEL);
        txtItemPriceL.setBorder(null);
        txtItemPriceL.setHorizontalAlignment(SwingConstants.CENTER);
        txtItemPriceL.setBounds(185, 220, 155, 50);
        pnlDetailItem.add(txtItemPriceL);

        JLabel lblItemPromo = new JLabel("Khuyến mãi", SwingConstants.CENTER);
        lblItemPromo.setOpaque(true);
        lblItemPromo.setFont(MyFont.MAIN_FONT_BIGGER);
        lblItemPromo.setBackground(MyColor.BACKGROUND_LOGO);
        lblItemPromo.setForeground(MyColor.TAB_LABEL);
        lblItemPromo.setBounds(10, 290, 155, 50);
        pnlDetailItem.add(lblItemPromo);

        txtItemPromo = new JTextField();
        txtItemPromo.setFont(MyFont.MAIN_FONT_BIGGER);
        txtItemPromo.setBackground(Color.WHITE);
        txtItemPromo.setForeground(MyColor.TAB_LABEL);
        txtItemPromo.setBounds(185, 290, 155, 50);
        txtItemPromo.setBorder(null);
        txtItemPromo.setHorizontalAlignment(SwingConstants.CENTER);
        pnlDetailItem.add(txtItemPromo);

        btnAddNewItem = new JButton("THÊM MỚI");
        btnAddNewItem.setFont(MyFont.MAIN_FONT_BIGGER);
        btnAddNewItem.setBorderPainted(false);
        btnAddNewItem.setFocusPainted(false);
        btnAddNewItem.setForeground(Color.WHITE);
        btnAddNewItem.setBackground(MyColor.TAB_LABEL);
        btnAddNewItem.setBounds(185, 360, 155, 50);
        pnlDetailItem.add(btnAddNewItem);

        btnConfirmAddNew = new JButton("XÁC NHẬN");
        btnConfirmAddNew.setFont(MyFont.MAIN_FONT_BIGGER);
        btnConfirmAddNew.setBorderPainted(false);
        btnConfirmAddNew.setFocusPainted(false);
        btnConfirmAddNew.setForeground(Color.WHITE);
        btnConfirmAddNew.setBackground(MyColor.IN_STOCK);
        btnConfirmAddNew.setBounds(185, 360, 155, 50);
        btnConfirmAddNew.setVisible(false);
        pnlDetailItem.add(btnConfirmAddNew);

        btnCancelAddNew = new JButton("HUỶ");
        btnCancelAddNew.setFont(MyFont.MAIN_FONT_BIGGER);
        btnCancelAddNew.setBorderPainted(false);
        btnCancelAddNew.setFocusPainted(false);
        btnCancelAddNew.setForeground(Color.WHITE);
        btnCancelAddNew.setBackground(MyColor.OUT_OF_STOCK);
        btnCancelAddNew.setBounds(10, 360, 155, 50);
        btnCancelAddNew.setVisible(false);
        pnlDetailItem.add(btnCancelAddNew);

        btnEditItem = new JButton("SỬA");
        btnEditItem.setFont(MyFont.MAIN_FONT_BIGGER);
        btnEditItem.setBorderPainted(false);
        btnEditItem.setFocusPainted(false);
        btnEditItem.setForeground(Color.WHITE);
        btnEditItem.setBackground(MyColor.TAB_LABEL);
        btnEditItem.setBounds(185, 430, 155, 50);
        pnlDetailItem.add(btnEditItem);

        btnConfirmEdit = new JButton("XÁC NHẬN");
        btnConfirmEdit.setFont(MyFont.MAIN_FONT_BIGGER);
        btnConfirmEdit.setBorderPainted(false);
        btnConfirmEdit.setFocusPainted(false);
        btnConfirmEdit.setForeground(Color.WHITE);
        btnConfirmEdit.setBackground(MyColor.IN_STOCK);
        btnConfirmEdit.setBounds(185, 430, 155, 50);
        btnConfirmEdit.setVisible(false);
        pnlDetailItem.add(btnConfirmEdit);

        btnCancelEdit = new JButton("HUỶ");
        btnCancelEdit.setFont(MyFont.MAIN_FONT_BIGGER);
        btnCancelEdit.setBorderPainted(false);
        btnCancelEdit.setFocusPainted(false);
        btnCancelEdit.setForeground(Color.WHITE);
        btnCancelEdit.setBackground(MyColor.OUT_OF_STOCK);
        btnCancelEdit.setBounds(10, 430, 155, 50);
        btnCancelEdit.setVisible(false);
        pnlDetailItem.add(btnCancelEdit);

        btnDeleteItem = new JButton("XOÁ");
        btnDeleteItem.setFont(MyFont.MAIN_FONT_BIGGER);
        btnDeleteItem.setBorderPainted(false);
        btnDeleteItem.setFocusPainted(false);
        btnDeleteItem.setForeground(Color.WHITE);
        btnDeleteItem.setBackground(MyColor.TAB_LABEL);
        btnDeleteItem.setBounds(185, 500, 155, 50);
        btnDeleteItem.setEnabled(false);
        pnlDetailItem.add(btnDeleteItem);

        btnInStock = new JButton("Còn");
        btnInStock.setFont(MyFont.MAIN_FONT);
        btnInStock.setBorderPainted(false);
        btnInStock.setFocusPainted(false);
        btnInStock.setForeground(Color.WHITE);
        btnInStock.setBackground(MyColor.IN_STOCK);
        btnInStock.setBounds(185, 560, 73, 46);
        pnlDetailItem.add(btnInStock);

        btnOutStock = new JButton("Hết");
        btnOutStock.setFont(MyFont.MAIN_FONT);
        btnOutStock.setBorderPainted(false);
        btnOutStock.setFocusPainted(false);
        btnOutStock.setForeground(Color.WHITE);
        btnOutStock.setBackground(MyColor.OUT_OF_STOCK);
        btnOutStock.setBounds(268, 560, 72, 46);
        pnlDetailItem.add(btnOutStock);

        itemController.loadItemListFromDBToList();
        tableModelItemList.getDataVector().removeAllElements();
        itemController.loadItemListFromDBToTable(tableModelItemList, "TRÀ SỮA");
        Events();
    }

    public void Events() {
        cbxCategoryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItemType = cbxCategoryItem.getSelectedItem().toString();
                itemController.loadItemListFromDBToTable(tableModelItemList, selectedItemType);
            }
        });

        btnAddNewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddNewItem.setVisible(false);
                btnConfirmAddNew.setVisible(true);
                btnCancelAddNew.setVisible(true);
                btnEditItem.setEnabled(false);
                btnInStock.setEnabled(false);
                btnOutStock.setEnabled(false);
                tblItemList.setEnabled(false);

                txtItemName.setEditable(true);
                txtItemName.setForeground(MyColor.TAB_LABEL);
                txtItemName.setText("");
                cbxItemType.setEnabled(true);
                cbxItemType.setSelectedItem(cbxCategoryItem.getSelectedItem());
                txtItemPriceM.setEditable(true);
                txtItemPriceM.setForeground(MyColor.TAB_LABEL);
                txtItemPriceM.setText("");
                txtItemPriceL.setEditable(true);
                txtItemPriceL.setForeground(MyColor.TAB_LABEL);
                txtItemPriceL.setText("");
                txtItemPromo.setEditable(true);
                txtItemPromo.setForeground(MyColor.TAB_LABEL);
                txtItemPromo.setText("");


            }
        });

        btnConfirmAddNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddNewItem.setVisible(true);
                btnConfirmAddNew.setVisible(false);
                btnCancelAddNew.setVisible(false);
                btnEditItem.setEnabled(true);
                btnInStock.setEnabled(true);
                btnOutStock.setEnabled(true);
                tblItemList.setEnabled(true);

                String name = txtItemName.getText();
                String type = cbxItemType.getSelectedItem().toString();
                Integer priceM = Integer.parseInt(txtItemPriceM.getText());
                Integer priceL = null;
                if (!txtItemPriceL.getText().isBlank()) {
                    priceL = Integer.parseInt(txtItemPriceL.getText());
                }
                Integer promo = null;
                if (!txtItemPromo.getText().isBlank()) {
                    promo = Integer.parseInt(txtItemPromo.getText());
                }
                System.out.println(name);
                System.out.println(type);
                System.out.println(priceM);
                System.out.println(priceL);
                System.out.println(promo);

                itemController.insertItemIntoDB(tableModelItemList, name, type, priceM, priceL, promo);
                checkItemIsChanged(type);
            }
        });

        btnCancelAddNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddNewItem.setVisible(true);
                btnConfirmAddNew.setVisible(false);
                btnCancelAddNew.setVisible(false);
                btnEditItem.setEnabled(true);
                btnInStock.setEnabled(true);
                btnOutStock.setEnabled(true);
                tblItemList.setEnabled(true);

                txtItemName.setText("");
                txtItemPriceM.setText("");
                txtItemPriceL.setText("");
                txtItemPromo.setText("");
            }
        });

        btnEditItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int checkIsSelected = 0;
                for (int i = 0; i < tblItemList.getRowCount(); i++) {
                    if (tblItemList.isRowSelected(i)) {
                        checkIsSelected++;
                    }
                }
                if (checkIsSelected != 0) {
                    btnEditItem.setVisible(false);
                    btnConfirmEdit.setVisible(true);
                    btnCancelEdit.setVisible(true);
                    btnAddNewItem.setEnabled(false);
                    btnInStock.setEnabled(false);
                    btnOutStock.setEnabled(false);
                    tblItemList.setEnabled(false);

                    txtItemName.setEditable(true);
                    txtItemName.setForeground(MyColor.TAB_LABEL);
                    cbxItemType.setEnabled(true);
                    txtItemPriceM.setEditable(true);
                    txtItemPriceM.setForeground(MyColor.TAB_LABEL);
                    txtItemPriceL.setEditable(true);
                    txtItemPriceL.setForeground(MyColor.TAB_LABEL);
                    txtItemPromo.setEditable(true);
                    txtItemPromo.setForeground(MyColor.TAB_LABEL);
                }
            }
        });

        btnConfirmEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditItem.setVisible(true);
                btnConfirmEdit.setVisible(false);
                btnCancelEdit.setVisible(false);
                btnAddNewItem.setEnabled(true);
                btnInStock.setEnabled(true);
                btnOutStock.setEnabled(true);
                tblItemList.setEnabled(true);

                int selectedRow = tblItemList.getSelectedRow();
                String oldName = tblItemList.getValueAt(selectedRow, 1).toString();
                String newName = txtItemName.getText();
                String oldType = cbxCategoryItem.getSelectedItem().toString();
                String newType = cbxItemType.getSelectedItem().toString();
                Integer oldPriceM = Integer.parseInt(tblItemList.getValueAt(selectedRow, 2).toString());
                Integer newPriceM = Integer.parseInt(txtItemPriceM.getText());
                Object selectedOldPriceL = tblItemList.getValueAt(selectedRow, 3);
                Integer oldPriceL = null;
                if (selectedOldPriceL != null) {
                    oldPriceL = Integer.parseInt(selectedOldPriceL.toString());
                }
                Integer newPriceL = null;
                if (!txtItemPriceL.getText().isBlank()) {
                    newPriceL = Integer.parseInt(txtItemPriceL.getText());
                }
                Object selectedOldPromo = tblItemList.getValueAt(selectedRow, 5);
                Integer oldPromo = null;
                if (selectedOldPromo != null) {
                    oldPromo = Integer.parseInt(selectedOldPromo.toString());
                }
                Integer newPromo = null;
                if (!txtItemPromo.getText().isBlank()) {
                    newPromo = Integer.parseInt(txtItemPromo.getText());
                }

                String oldValues = oldName + oldType + oldPriceM + oldPriceL + oldPromo;
                String newValues = newName + newType + newPriceM + newPriceL + newPromo;

                if (!oldValues.equals(newValues)) {
                    itemController.updateItemIntoDB(tableModelItemList, oldName, newName, newType, newPriceM, newPriceL, newPromo);
                    cbxCategoryItem.setSelectedItem(cbxItemType.getSelectedItem());
                    checkItemIsChanged(newType);
                } else {
                    System.out.println("Chưa có giá trị nào thay đổi!");
                }
            }
        });

        btnCancelEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditItem.setVisible(true);
                btnConfirmEdit.setVisible(false);
                btnCancelEdit.setVisible(false);
                btnAddNewItem.setEnabled(true);
                btnInStock.setEnabled(true);
                btnOutStock.setEnabled(true);
                tblItemList.setEnabled(true);

                txtItemName.setEditable(false);
                txtItemName.setForeground(Color.GRAY);
                cbxItemType.setEnabled(false);
                txtItemPriceM.setEditable(false);
                txtItemPriceM.setForeground(Color.GRAY);
                txtItemPriceL.setEditable(false);
                txtItemPriceL.setForeground(Color.GRAY);
                txtItemPromo.setEditable(false);
                txtItemPromo.setForeground(Color.GRAY);
            }
        });

        btnInStock.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { updateStatus("còn"); }});

        btnOutStock.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { updateStatus("hết"); }});

        tblItemList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblItemList.getSelectedRow();
                if (selectedRow != -1) {
                    txtItemName.setText(tblItemList.getValueAt(selectedRow, 1).toString());
                    cbxItemType.setSelectedItem(cbxCategoryItem.getSelectedItem());
                    txtItemPriceM.setText(tblItemList.getValueAt(selectedRow, 2).toString());
                    Object selectedPriceL = tblItemList.getValueAt(selectedRow, 3);
                    if (selectedPriceL != null) {
                        txtItemPriceL.setText(selectedPriceL.toString());
                    } else {
                        txtItemPriceL.setText("");
                    }
                    Object selectedPromo = tblItemList.getValueAt(selectedRow, 5);
                    if (selectedPromo != null) {
                        txtItemPromo.setText(selectedPromo.toString());
                    } else {
                        txtItemPromo.setText("");
                    }

                    txtItemName.setEditable(false);
                    txtItemName.setForeground(Color.GRAY);
                    cbxItemType.setEnabled(false);
                    txtItemPriceM.setEditable(false);
                    txtItemPriceM.setForeground(Color.GRAY);
                    txtItemPriceL.setEditable(false);
                    txtItemPriceL.setForeground(Color.GRAY);
                    txtItemPromo.setEditable(false);
                    txtItemPromo.setForeground(Color.GRAY);
                }
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
    }

    private void updateStatus(String newStatus) {
        int selectedRow = tblItemList.getSelectedRow();
        if (selectedRow != -1) {
            if (!tblItemList.getValueAt(selectedRow, 4).toString().equalsIgnoreCase(newStatus)) {
                itemController.updateStockStatus(tableModelItemList, tblItemList.getValueAt(selectedRow, 1).toString(),
                        cbxCategoryItem.getSelectedItem().toString(), newStatus);
                String type = cbxItemType.getSelectedItem().toString();
                checkItemIsChanged(type);
            }
        }
    }

    private void checkItemIsChanged(String type) {
        switch (type) {
            case "TRÀ SỮA": {
                OrderPanel.itemIsChanged[0] = true;
                break;
            }
            case "TRÀ HOA QUẢ": {
                OrderPanel.itemIsChanged[1] = true;
                break;
            }
            case "MACCHIATO": {
                OrderPanel.itemIsChanged[2] = true;
                break;
            }
            case "TOPPING": {
                OrderPanel.itemIsChanged[3] = true;
                break;
            }
            case "ĐỒ ĂN VẶT": {
                OrderPanel.itemIsChanged[4] = true;
                break;
            }
        }
    }
}
