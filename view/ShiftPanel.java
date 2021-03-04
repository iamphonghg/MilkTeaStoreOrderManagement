package view;

import model.MyColor;
import model.MyFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ShiftPanel extends JPanel {
    public DefaultTableModel tableModelShiftList;
    public JTable tblShiftList;
    public JTextField txtShiftName, txtHoursWork;
    public JButton btnAddNewShift, btnEditShift, btnDeleteShift;

    public ShiftPanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel pnlShiftList = new JPanel();
        pnlShiftList.setLayout(null);
        pnlShiftList.setBackground(MyColor.CANVAS);
        pnlShiftList.setBounds(10, 10, 610, 616);
        this.add(pnlShiftList);

        tableModelShiftList = new DefaultTableModel();
        tableModelShiftList.addColumn("STT");
        tableModelShiftList.addColumn("Tên ca");
        tableModelShiftList.addColumn("Số giờ");
        tblShiftList = new JTable(tableModelShiftList);
        tblShiftList.setFont(MyFont.MAIN_FONT_BIGGER);
        tblShiftList.setForeground(MyColor.TAB_LABEL);
        tblShiftList.setDefaultEditor(Object.class, null);
        tblShiftList.setFocusable(false);
        JTableHeader header = tblShiftList.getTableHeader();
        header.setReorderingAllowed(false);
        header.setFont(MyFont.MAIN_FONT_BIGGER);
        header.setForeground(MyColor.TAB_LABEL);
        header.setBackground(Color.WHITE);
        JScrollPane scrShiftList = new JScrollPane(tblShiftList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrShiftList.setBounds(10, 10, 590, 596);
        pnlShiftList.add(scrShiftList);

        JPanel pnlDetailShift = new JPanel();
        pnlDetailShift.setLayout(null);
        pnlDetailShift.setBackground(MyColor.CANVAS);
        pnlDetailShift.setBounds(630, 10, 350, 616);
        this.add(pnlDetailShift);

        JLabel lblShiftName = new JLabel("Tên ca làm", SwingConstants.CENTER);
        lblShiftName.setOpaque(true);
        lblShiftName.setFont(MyFont.MAIN_FONT_BIGGER);
        lblShiftName.setForeground(MyColor.TAB_LABEL);
        lblShiftName.setBackground(MyColor.BACKGROUND_LOGO);
        lblShiftName.setBounds(10, 10, 155, 50);
        pnlDetailShift.add(lblShiftName);

        txtShiftName = new JTextField();
        txtShiftName.setFont(MyFont.MAIN_FONT_BIGGER);
        txtShiftName.setBackground(Color.WHITE);
        txtShiftName.setForeground(MyColor.TAB_LABEL);
        txtShiftName.setBounds(185, 10, 155, 50);
        txtShiftName.setBorder(null);
        txtShiftName.setHorizontalAlignment(SwingConstants.CENTER);
        pnlDetailShift.add(txtShiftName);

        JLabel lblHoursWork = new JLabel("Số giờ làm", SwingConstants.CENTER);
        lblHoursWork.setOpaque(true);
        lblHoursWork.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHoursWork.setForeground(MyColor.TAB_LABEL);
        lblHoursWork.setBackground(MyColor.BACKGROUND_LOGO);
        lblHoursWork.setBounds(10, 80, 155, 50);
        pnlDetailShift.add(lblHoursWork);

        txtHoursWork = new JTextField();
        txtHoursWork.setFont(MyFont.MAIN_FONT_BIGGER);
        txtHoursWork.setBackground(Color.WHITE);
        txtHoursWork.setForeground(MyColor.TAB_LABEL);
        txtHoursWork.setBounds(185, 80, 155, 50);
        txtHoursWork.setBorder(null);
        txtHoursWork.setHorizontalAlignment(SwingConstants.CENTER);
        pnlDetailShift.add(txtHoursWork);

        btnAddNewShift = new JButton("THÊM MỚI");
        btnAddNewShift.setFont(MyFont.MAIN_FONT_BIGGER);
        btnAddNewShift.setBorderPainted(false);
        btnAddNewShift.setFocusPainted(false);
        btnAddNewShift.setForeground(Color.WHITE);
        btnAddNewShift.setBackground(MyColor.TAB_LABEL);
        btnAddNewShift.setBounds(185, 150, 155, 50);
        pnlDetailShift.add(btnAddNewShift);

        btnEditShift = new JButton("SỬA");
        btnEditShift.setFont(MyFont.MAIN_FONT_BIGGER);
        btnEditShift.setBorderPainted(false);
        btnEditShift.setFocusPainted(false);
        btnEditShift.setForeground(Color.WHITE);
        btnEditShift.setBackground(MyColor.TAB_LABEL);
        btnEditShift.setBounds(185, 220, 155, 50);
        pnlDetailShift.add(btnEditShift);

        btnDeleteShift = new JButton("XOÁ");
        btnDeleteShift.setFont(MyFont.MAIN_FONT_BIGGER);
        btnDeleteShift.setBorderPainted(false);
        btnDeleteShift.setFocusPainted(false);
        btnDeleteShift.setForeground(Color.WHITE);
        btnDeleteShift.setBackground(MyColor.TAB_LABEL);
        btnDeleteShift.setBounds(185, 290, 155, 50);
        pnlDetailShift.add(btnDeleteShift);


    }
}
