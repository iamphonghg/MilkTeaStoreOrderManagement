package view;

import controller.ItemController;
import controller.StaffController;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class OrderPanel extends JPanel {
    public final CardLayout cardLayoutItemChoose = new CardLayout();
    public JPanel pnlItemButton;
    public JLabel lblNotiDiscountCodeStatus, lblValueTotalCost, lblValueTotalDiscount, lblValueFinalTotalCost;
    public JComboBox<String> cbxIDStaffOrdered;
    public DefaultTableModel tableModelDetailBill;
    public JTable tblDetailBill;
    public JTextField txtDiscountCode;
    public JButton btnCheckDiscountCode, btnConfirm;
    public List<Item> itemList = (new ItemController()).loadItemListFromDBToList();
    public static Boolean[] itemIsChanged = {false, false, false, false, false};
    public static List<Staff> staffList = (new StaffController()).loadStaffListFromDBToList();


    public OrderPanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel pnlItemChoose = new JPanel();
        pnlItemChoose.setLayout(null);
        pnlItemChoose.setBackground(MyColor.CANVAS);
        pnlItemChoose.setBounds(10, 10, 610, 616);
        this.add(pnlItemChoose);

        JPanel pnlCategory = new JPanel();
        pnlCategory.setLayout(null);
        pnlCategory.setBackground(null);
        pnlCategory.setBounds(0, 0, 610, 110);
        pnlItemChoose.add(pnlCategory);

        JButton btnMilkTea = new JButton("Trà sữa");
        btnMilkTea.setBounds(10, 10, 110, 90);
        btnMilkTea.setFont(MyFont.MEDIUM_FONT);
        btnMilkTea.setForeground(MyColor.TAB_LABEL);
        btnMilkTea.setBorderPainted(false);
        btnMilkTea.setFocusPainted(false);
        btnMilkTea.setBackground(MyColor.MILK_TEA);
        pnlCategory.add(btnMilkTea);

        JButton btnFruitTea = new JButton("Trà hoa quả");
        btnFruitTea.setBounds(130, 10, 110, 90);
        btnFruitTea.setFont(MyFont.MEDIUM_FONT);
        btnFruitTea.setForeground(MyColor.TAB_LABEL);
        btnFruitTea.setBorderPainted(false);
        btnFruitTea.setFocusPainted(false);
        btnFruitTea.setBackground(MyColor.FRUIT_TEA);
        pnlCategory.add(btnFruitTea);

        JButton btnMacchiato = new JButton("Macchiato");
        btnMacchiato.setBounds(250, 10, 110, 90);
        btnMacchiato.setFont(MyFont.MEDIUM_FONT);
        btnMacchiato.setForeground(MyColor.TAB_LABEL);
        btnMacchiato.setBorderPainted(false);
        btnMacchiato.setFocusPainted(false);
        btnMacchiato.setBackground(MyColor.MACCHIATO);
        pnlCategory.add(btnMacchiato);

        JButton btnTopping = new JButton("Trân châu");
        btnTopping.setBounds(370, 10, 110, 90);
        btnTopping.setFont(MyFont.MEDIUM_FONT);
        btnTopping.setForeground(MyColor.TAB_LABEL);
        btnTopping.setBorderPainted(false);
        btnTopping.setFocusPainted(false);
        btnTopping.setBackground(MyColor.TOPPING);
        pnlCategory.add(btnTopping);

        JButton btnFood = new JButton("Đồ ăn vặt");
        btnFood.setBounds(490, 10, 110, 90);
        btnFood.setFont(MyFont.MEDIUM_FONT);
        btnFood.setForeground(MyColor.TAB_LABEL);
        btnFood.setBorderPainted(false);
        btnFood.setFocusPainted(false);
        btnFood.setBackground(MyColor.FOOD);
        pnlCategory.add(btnFood);

        pnlItemButton = new JPanel();
        pnlItemButton.setLayout(cardLayoutItemChoose);
        pnlItemButton.setBounds(0, 110, 610, 506);
        pnlItemChoose.add(pnlItemButton);

        JPanel pnlMilkTea = new JPanel();
        pnlMilkTea.setBounds(0, 110, 610, 506);
        pnlMilkTea.setBackground(MyColor.MILK_TEA);
        pnlMilkTea.setLayout(new WrapLayout(SwingConstants.CENTER, 10, 10));
        JScrollPane scrMilkTea = new JScrollPane(pnlMilkTea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrMilkTea.getVerticalScrollBar().setUnitIncrement(10);
        pnlItemButton.add(scrMilkTea, "MilkTea");
        reloadItemButton(pnlMilkTea, "TRÀ SỮA");

        JPanel pnlFruitTea = new JPanel();
        pnlFruitTea.setBounds(0, 110, 610, 506);
        pnlFruitTea.setBackground(MyColor.FRUIT_TEA);
        pnlFruitTea.setLayout(new WrapLayout(SwingConstants.CENTER, 10, 10));
        JScrollPane scrFruitTea = new JScrollPane(pnlFruitTea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrFruitTea.getVerticalScrollBar().setUnitIncrement(10);
        pnlItemButton.add(scrFruitTea, "FruitTea");
        reloadItemButton(pnlFruitTea, "TRÀ HOA QUẢ");

        JPanel pnlMacchiato = new JPanel();
        pnlMacchiato.setBounds(0, 110, 610, 506);
        pnlMacchiato.setBackground(MyColor.MACCHIATO);
        pnlMacchiato.setLayout(new WrapLayout(SwingConstants.CENTER, 10, 10));
        JScrollPane scrMacchiato = new JScrollPane(pnlMacchiato, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrMacchiato.getVerticalScrollBar().setUnitIncrement(10);
        pnlItemButton.add(scrMacchiato, "Macchiato");
        reloadItemButton(pnlMacchiato, "MACCHIATO");

        JPanel pnlTopping = new JPanel();
        pnlTopping.setBounds(0, 110, 610, 506);
        pnlTopping.setBackground(MyColor.TOPPING);
        pnlTopping.setLayout(new WrapLayout(SwingConstants.CENTER, 10, 10));
        JScrollPane scrTopping = new JScrollPane(pnlTopping, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrTopping.getVerticalScrollBar().setUnitIncrement(10);
        pnlItemButton.add(scrTopping, "Topping");
        reloadItemButton(pnlTopping, "TOPPING");

        JPanel pnlFood = new JPanel();
        pnlFood.setBounds(0, 110, 610, 506);
        pnlFood.setBackground(MyColor.FOOD);
        pnlFood.setLayout(new WrapLayout(SwingConstants.CENTER, 10, 10));
        JScrollPane scrFood = new JScrollPane(pnlFood, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrFood.getVerticalScrollBar().setUnitIncrement(10);
        pnlItemButton.add(scrFood, "Food");
        reloadItemButton(pnlFood, "ĐỒ ĂN VẶT");

        JPanel pnlDetailBill = new JPanel();
        pnlDetailBill.setLayout(null);
        pnlDetailBill.setBackground(MyColor.CANVAS);
        pnlDetailBill.setBounds(630, 10, 350, 616);
        this.add(pnlDetailBill);

        JLabel lblIDStaffOrdered = new JLabel("ID Nhân viên", SwingConstants.CENTER);
        lblIDStaffOrdered.setFont(MyFont.MAIN_FONT_BIGGER);
        lblIDStaffOrdered.setOpaque(true);
        lblIDStaffOrdered.setBackground(MyColor.BACKGROUND_LOGO);
        lblIDStaffOrdered.setForeground(MyColor.TAB_LABEL);
        lblIDStaffOrdered.setBounds(10, 10, 165, 50);
        pnlDetailBill.add(lblIDStaffOrdered);

        cbxIDStaffOrdered = new JComboBox<>();
        cbxIDStaffOrdered.setFont(MyFont.MEDIUM_FONT);
        cbxIDStaffOrdered.setBackground(Color.WHITE);
        cbxIDStaffOrdered.setForeground(MyColor.TAB_LABEL);
        cbxIDStaffOrdered.setBounds(185, 10, 125, 50);
        ((JLabel) cbxIDStaffOrdered.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        pnlDetailBill.add(cbxIDStaffOrdered);
        for (Staff s : staffList) {
            if (s.getStatus().equalsIgnoreCase("đang làm việc")) {
                cbxIDStaffOrdered.addItem(s.getId());
            }
        }

        JButton btnReloadNameStaffList = new JButton();
        btnReloadNameStaffList.setIcon(new ImageIcon("src/refresh.png"));
        btnReloadNameStaffList.setBackground(null);
        btnReloadNameStaffList.setFocusPainted(false);
        btnReloadNameStaffList.setBorderPainted(false);
        btnReloadNameStaffList.setBounds(315, 20, 25, 25);
        pnlDetailBill.add(btnReloadNameStaffList);

        tableModelDetailBill = new DefaultTableModel();
        tableModelDetailBill.addColumn("Tên món");
        tableModelDetailBill.addColumn("Size");
        tableModelDetailBill.addColumn("Đơn giá");
        tableModelDetailBill.addColumn("Giảm giá");
        tableModelDetailBill.addColumn("SL");
        tblDetailBill = new JTable(tableModelDetailBill);
        tblDetailBill.setFont(MyFont.DETAILBILL_FONT);
        tblDetailBill.setForeground(MyColor.TAB_LABEL);
        tblDetailBill.setDefaultEditor(Object.class, null);
        tblDetailBill.setFocusable(false);
        JTableHeader headerDetailBill = tblDetailBill.getTableHeader();
        headerDetailBill.setReorderingAllowed(false);
        headerDetailBill.setForeground(MyColor.TAB_LABEL);
        headerDetailBill.setBackground(Color.WHITE);
        headerDetailBill.setFont(MyFont.DETAILBILL_FONT);
        JScrollPane scrDetailBill = new JScrollPane(tblDetailBill, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrDetailBill.setBounds(10, 70, 330, 170);
        pnlDetailBill.add(scrDetailBill);

        JButton btnMinus = new JButton();
        btnMinus.setIcon(new ImageIcon("src/minus.png"));
        btnMinus.setBackground(null);
        btnMinus.setFocusPainted(false);
        btnMinus.setBorderPainted(false);
        btnMinus.setBounds(145, 245, 20, 20);
        pnlDetailBill.add(btnMinus);

        JButton btnPlus = new JButton();
        btnPlus.setIcon(new ImageIcon("src/plus.png"));
        btnPlus.setBackground(null);
        btnPlus.setFocusPainted(false);
        btnPlus.setBorderPainted(false);
        btnPlus.setBounds(170, 245, 20, 20);
        pnlDetailBill.add(btnPlus);

        JButton btnClear = new JButton("xoá");
        btnClear.setFont(MyFont.DETAILBILL_FONT);
        btnClear.setFocusPainted(false);
        btnClear.setBorderPainted(false);
        btnClear.setBackground(MyColor.OUT_OF_STOCK);
        btnClear.setForeground(Color.WHITE);
        btnClear.setBounds(200, 245, 60, 20);
        pnlDetailBill.add(btnClear);

        JButton btnClearAll = new JButton("xoá hết");
        btnClearAll.setFont(MyFont.DETAILBILL_FONT);
        btnClearAll.setFocusPainted(false);
        btnClearAll.setBorderPainted(false);
        btnClearAll.setBackground(MyColor.OUT_OF_STOCK);
        btnClearAll.setForeground(Color.WHITE);
        btnClearAll.setBounds(270, 245, 70, 20);
        pnlDetailBill.add(btnClearAll);

        JLabel lblDiscountCode = new JLabel("Mã giảm giá", SwingConstants.CENTER);
        lblDiscountCode.setFont(MyFont.MAIN_FONT_BIGGER);
        lblDiscountCode.setOpaque(true);
        lblDiscountCode.setBackground(MyColor.BACKGROUND_LOGO);
        lblDiscountCode.setForeground(MyColor.TAB_LABEL);
        lblDiscountCode.setBounds(10, 280, 165, 50);
        pnlDetailBill.add(lblDiscountCode);

        txtDiscountCode = new JTextField();
        txtDiscountCode.setForeground(MyColor.TAB_LABEL);
        txtDiscountCode.setFont(MyFont.MAIN_FONT_BIGGER);
        txtDiscountCode.setBorder(BorderFactory.createLineBorder(MyColor.IN_STOCK));
        txtDiscountCode.setHorizontalAlignment(SwingConstants.CENTER);
        txtDiscountCode.setBounds(185, 280, 155, 50);
        pnlDetailBill.add(txtDiscountCode);

        btnCheckDiscountCode = new JButton("DÙNG");
        btnCheckDiscountCode.setFont(MyFont.MAIN_FONT);
        btnCheckDiscountCode.setBorderPainted(false);
        btnCheckDiscountCode.setFocusPainted(false);
        btnCheckDiscountCode.setBackground(MyColor.TAB_LABEL);
        btnCheckDiscountCode.setForeground(Color.WHITE);
        btnCheckDiscountCode.setBounds(85, 340, 90, 30);
        pnlDetailBill.add(btnCheckDiscountCode);

        lblNotiDiscountCodeStatus = new JLabel("", SwingConstants.RIGHT);
        lblNotiDiscountCodeStatus.setBounds(185, 340, 155, 30);
        lblNotiDiscountCodeStatus.setOpaque(true);
        lblNotiDiscountCodeStatus.setBackground(Color.WHITE);
        lblNotiDiscountCodeStatus.setForeground(MyColor.TAB_LABEL);
        lblNotiDiscountCodeStatus.setFont(MyFont.DETAILBILL_FONT);
        pnlDetailBill.add(lblNotiDiscountCodeStatus);

        JLabel lblTotalCost = new JLabel("Tổng tiền", SwingConstants.CENTER);
        lblTotalCost.setOpaque(true);
        lblTotalCost.setBackground(MyColor.BACKGROUND_LOGO);
        lblTotalCost.setForeground(MyColor.TAB_LABEL);
        lblTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblTotalCost.setBounds(10, 380, 165, 50);
        pnlDetailBill.add(lblTotalCost);

        lblValueTotalCost = new JLabel("", SwingConstants.CENTER);
        lblValueTotalCost.setOpaque(true);
        lblValueTotalCost.setBackground(Color.WHITE);
        lblValueTotalCost.setForeground(MyColor.TAB_LABEL);
        lblValueTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblValueTotalCost.setBounds(185, 380, 155, 50);
        pnlDetailBill.add(lblValueTotalCost);

        JLabel lblTotalDiscount = new JLabel("Tổng giảm", SwingConstants.CENTER);
        lblTotalDiscount.setOpaque(true);
        lblTotalDiscount.setBackground(MyColor.BACKGROUND_LOGO);
        lblTotalDiscount.setForeground(MyColor.TAB_LABEL);
        lblTotalDiscount.setFont(MyFont.MAIN_FONT_BIGGER);
        lblTotalDiscount.setBounds(10, 440, 165, 50);
        pnlDetailBill.add(lblTotalDiscount);

        lblValueTotalDiscount = new JLabel("", SwingConstants.CENTER);
        lblValueTotalDiscount.setOpaque(true);
        lblValueTotalDiscount.setBackground(Color.WHITE);
        lblValueTotalDiscount.setForeground(MyColor.TAB_LABEL);
        lblValueTotalDiscount.setFont(MyFont.MAIN_FONT_BIGGER);
        lblValueTotalDiscount.setBounds(185, 440, 155, 50);
        pnlDetailBill.add(lblValueTotalDiscount);

        JLabel lblFinalTotalCost = new JLabel("TỔNG THU", SwingConstants.CENTER);
        lblFinalTotalCost.setOpaque(true);
        lblFinalTotalCost.setBackground(MyColor.OUT_OF_STOCK);
        lblFinalTotalCost.setForeground(Color.WHITE);
        lblFinalTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblFinalTotalCost.setBounds(10, 500, 165, 50);
        pnlDetailBill.add(lblFinalTotalCost);

        lblValueFinalTotalCost = new JLabel("", SwingConstants.CENTER);
        lblValueFinalTotalCost.setOpaque(true);
        lblValueFinalTotalCost.setBackground(Color.WHITE);
        lblValueFinalTotalCost.setForeground(MyColor.TAB_LABEL);
        lblValueFinalTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblValueFinalTotalCost.setBounds(185, 500, 155, 50);
        pnlDetailBill.add(lblValueFinalTotalCost);

        btnConfirm = new JButton("XÁC NHẬN");
        btnConfirm.setFont(MyFont.MAIN_FONT_BIGGER);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setBackground(MyColor.TAB_LABEL);
        btnConfirm.setBounds(185, 560, 155, 50);
        pnlDetailBill.add(btnConfirm);

        btnMilkTea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutItemChoose.show(pnlItemButton, "MilkTea");
                if (itemIsChanged[0]) {
                    itemList = (new ItemController()).loadItemListFromDBToList();
                    pnlMilkTea.removeAll();
                    reloadItemButton(pnlMilkTea, "TRÀ SỮA");
                    itemIsChanged[0] = false;
                }
            }
        });

        btnFruitTea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutItemChoose.show(pnlItemButton, "FruitTea");
                if (itemIsChanged[1]) {
                    itemList = (new ItemController()).loadItemListFromDBToList();
                    pnlFruitTea.removeAll();
                    reloadItemButton(pnlFruitTea, "TRÀ HOA QUẢ");
                    itemIsChanged[1] = false;
                }
            }
        });

        btnMacchiato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutItemChoose.show(pnlItemButton, "Macchiato");
                if (itemIsChanged[2]) {
                    itemList = (new ItemController()).loadItemListFromDBToList();
                    pnlMacchiato.removeAll();
                    reloadItemButton(pnlMacchiato, "MACCHIATO");
                    itemIsChanged[2] = false;
                }
            }
        });

        btnTopping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutItemChoose.show(pnlItemButton, "Topping");
                if (itemIsChanged[3]) {
                    itemList = (new ItemController()).loadItemListFromDBToList();
                    pnlTopping.removeAll();
                    reloadItemButton(pnlTopping, "TOPPING");
                    itemIsChanged[3] = false;
                }
            }
        });

        btnFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutItemChoose.show(pnlItemButton, "Food");
                if (itemIsChanged[4]) {
                    itemList = (new ItemController()).loadItemListFromDBToList();
                    pnlFood.removeAll();
                    reloadItemButton(pnlFood, "ĐỒ ĂN VẶT");
                    itemIsChanged[4] = false;
                }
            }
        });

        btnReloadNameStaffList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbxIDStaffOrdered.removeAllItems();
                for (Staff s : staffList) {
                    if (s.getStatus().equalsIgnoreCase("đang làm việc")) {
                        cbxIDStaffOrdered.addItem(s.getId());
                    }
                }
            }
        });

        btnClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelDetailBill.setRowCount(0);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblDetailBill.getSelectedRow();
                if (selectedRow != -1) {
                    tableModelDetailBill.removeRow(selectedRow);
                }
            }
        });

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblDetailBill.getSelectedRow();
                if (selectedRow != -1) {
                    tableModelDetailBill.setValueAt(Integer.parseInt(tblDetailBill.getValueAt(selectedRow, 4).toString()) + 1, selectedRow, 4);
                }
            }
        });

        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblDetailBill.getSelectedRow();
                if (selectedRow != -1) {
                    int selectedQuantity = Integer.parseInt(tblDetailBill.getValueAt(selectedRow, 4).toString());
                    if (selectedQuantity > 1) {
                        tableModelDetailBill.setValueAt(selectedQuantity - 1, selectedRow, 4);
                    }
                }
            }
        });
    }

    public void reloadItemButton(JPanel pnl, String type) {

        for (Item i : itemList) {
            PopUpItemListener popUpItemListener = new PopUpItemListener();
            if (i.getType().equals(type)) {
                JButton btnItem = new JButton();
                btnItem.setText(i.getName());
                btnItem.setFont(MyFont.MEDIUM_FONT);
                btnItem.setPreferredSize(new Dimension(107, 107));
                btnItem.setBackground(null);
                btnItem.setFocusPainted(false);
                btnItem.setForeground(MyColor.TAB_LABEL);
                btnItem.setBorder(BorderFactory.createLineBorder(MyColor.TAB_LABEL));
                pnl.add(btnItem);

                btnItem.addMouseListener(popUpItemListener);

                if (i.getPriceL() == 0) {
                    popUpItemListener.popUpItem.btnL.setEnabled(false);
                }
                if (i.getStatus().equalsIgnoreCase("hết")) {
                    btnItem.setEnabled(false);
                    btnItem.removeMouseListener(popUpItemListener);
                }

                popUpItemListener.popUpItem.btnAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String size = null;
                        if (popUpItemListener.popUpItem.btnM.getBackground() == MyColor.TAB_LABEL) {
                            size = "M";
                        } else {
                            size = "L";
                        }
                        int checkDuplicated = -1;
                        for (int j = 0; j < tblDetailBill.getRowCount(); j++) {
                            if (tblDetailBill.getValueAt(j, 0).equals(i.getName()) && tblDetailBill.getValueAt(j, 1).equals(size)) {
                                checkDuplicated = j;
                                break;
                            }
                        }
                        if (checkDuplicated != -1) {
                            tableModelDetailBill.setValueAt((Integer.parseInt(tblDetailBill.getValueAt(checkDuplicated, 4).toString()) + 1), checkDuplicated, 4);
                            recalculateCost();
                        } else {
                            int unitPrice;
                            if (size.equals("M")) {
                                unitPrice = i.getPriceM();
                            } else {
                                unitPrice = i.getPriceL();
                            }
                            int promo = i.getPromo();
                            int quantity = Integer.parseInt(popUpItemListener.popUpItem.spnChooseQuantity.getValue().toString());
                            String[] itemOrdered = {i.getName(), size, String.valueOf(unitPrice), String.valueOf(promo), String.valueOf(quantity)};
                            tableModelDetailBill.addRow(itemOrdered);

                            recalculateCost();
                        }
                    }
                });
            }
        }
    }

    public void recalculateCost() {
        int totalCost = 0, totalPromo = 0, valueDiscountCode = 0, totalDiscount, finalTotalCost = 0 ;
        if (!lblNotiDiscountCodeStatus.getText().isBlank()) {
            valueDiscountCode = Integer.parseInt(lblNotiDiscountCodeStatus.getText());
        }

        for (int j = 0; j < tblDetailBill.getRowCount(); j++) {
            totalCost = totalCost + Integer.parseInt(tblDetailBill.getValueAt(j, 2).toString()) * Integer.parseInt(tblDetailBill.getValueAt(j, 4).toString());
            totalPromo = totalPromo + Integer.parseInt(tblDetailBill.getValueAt(j, 3).toString()) * Integer.parseInt(tblDetailBill.getValueAt(j, 4).toString());
        }
        totalDiscount = valueDiscountCode + totalPromo;
        lblValueTotalCost.setText(String.valueOf(totalCost));
        lblValueTotalDiscount.setText(String.valueOf(totalDiscount));
        lblValueFinalTotalCost.setText(String.valueOf(totalCost - totalDiscount));
    }

    private static class PopUpItem extends JPopupMenu {
        public JButton btnM, btnL, btnAdd;
        public JSpinner spnChooseQuantity;

        public PopUpItem() {
            this.setPopupSize(100, 90);
            this.setBorder(BorderFactory.createLineBorder(MyColor.TAB_LABEL));

            JPanel pnl = new JPanel();
            pnl.setLayout(null);
            pnl.setBackground(Color.WHITE);
            this.add(pnl);

            btnM = new JButton("M");
            btnM.setFont(MyFont.MAIN_FONT);
            btnM.setFocusPainted(false);
            btnM.setBorder(BorderFactory.createLineBorder(MyColor.TAB_LABEL));
            btnM.setBackground(MyColor.TAB_LABEL);
            btnM.setForeground(Color.WHITE);
            btnM.setBounds(10, 10, 40, 30);
            pnl.add(btnM);

            btnL = new JButton("L");
            btnL.setFont(MyFont.MAIN_FONT);
            btnL.setFocusPainted(false);
            btnL.setBorder(BorderFactory.createLineBorder(MyColor.TAB_LABEL));
            btnL.setBackground(Color.WHITE);
            btnL.setForeground(MyColor.TAB_LABEL);
            btnL.setBounds(50, 10, 40, 30);
            pnl.add(btnL);

            SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 50, 1);
            spnChooseQuantity = new JSpinner(spinnerModel);
            spnChooseQuantity.setBounds(10, 50, 40, 30);
            spnChooseQuantity.setFont(MyFont.MAIN_FONT);
            pnl.add(spnChooseQuantity);

            btnAdd = new JButton();
            btnAdd.setFont(MyFont.MAIN_FONT);
            btnAdd.setFocusPainted(false);
            btnAdd.setBorderPainted(false);
            btnAdd.setForeground(Color.WHITE);
            btnAdd.setBackground(null);
            btnAdd.setIcon(new ImageIcon("src/add.png"));
            btnAdd.setBounds(60, 50, 30, 30);
            pnl.add(btnAdd);

            Events();
        }

        public void Events() {
            btnM.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnM.setBackground(MyColor.TAB_LABEL);
                    btnM.setForeground(Color.WHITE);
                    btnL.setBackground(Color.WHITE);
                    btnL.setForeground(MyColor.TAB_LABEL);
                }
            });

            btnL.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnL.setBackground(MyColor.TAB_LABEL);
                    btnL.setForeground(Color.WHITE);
                    btnM.setBackground(Color.WHITE);
                    btnM.setForeground(MyColor.TAB_LABEL);
                }
            });
        }
    }

    private static class PopUpItemListener implements MouseListener {
        public PopUpItem popUpItem = new PopUpItem();
        private void showPopUp(MouseEvent e) {
            popUpItem.show(e.getComponent(), e.getX(), e.getY());
        }

        @Override
        public void mouseClicked(MouseEvent e) { showPopUp(e); }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
}
