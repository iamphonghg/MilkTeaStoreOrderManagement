package view;

import model.MyColor;
import model.MyFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ProcessingPanel extends JPanel {
    public DefaultTableModel tableModelProcessing, tableModelProcessingDetail;
    public JTable tblProcessingBill, tblProcessingDetail;
    public JLabel lblProcessingNumber, lblProcessingIDStaff;
    public JButton btnDone;

    public ProcessingPanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel pnlProcessingList = new JPanel();
        pnlProcessingList.setLayout(null);
        pnlProcessingList.setBackground(MyColor.CANVAS);
        pnlProcessingList.setBounds(10, 10, 610, 616);
        this.add(pnlProcessingList);

        tableModelProcessing = new DefaultTableModel();
        tableModelProcessing.addColumn("Số HD");
        tableModelProcessing.addColumn("Thời gian tạo");
        tableModelProcessing.addColumn("Số lượng món");
        tblProcessingBill = new JTable(tableModelProcessing);
        tblProcessingBill.setFont(MyFont.MAIN_FONT_BIGGER);
        tblProcessingBill.setForeground(MyColor.TAB_LABEL);
        tblProcessingBill.setDefaultEditor(Object.class, null);
        tblProcessingBill.setFocusable(false);
        JTableHeader headerBill = tblProcessingBill.getTableHeader();
        headerBill.setReorderingAllowed(false);
        headerBill.setFont(MyFont.MAIN_FONT_BIGGER);
        headerBill.setBackground(Color.WHITE);
        headerBill.setForeground(MyColor.TAB_LABEL);
        JScrollPane scrProcessingList = new JScrollPane(tblProcessingBill, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrProcessingList.setBounds(10, 10, 590, 596);
        pnlProcessingList.add(scrProcessingList);

        JPanel pnlProcessingDetailBill = new JPanel();
        pnlProcessingDetailBill.setLayout(null);
        pnlProcessingDetailBill.setBackground(MyColor.CANVAS);
        pnlProcessingDetailBill.setBounds(630, 10, 350, 616);
        this.add(pnlProcessingDetailBill);

        JLabel lblProcessingBillNumber = new JLabel("Số HD", SwingConstants.CENTER);
        lblProcessingBillNumber.setFont(MyFont.MAIN_FONT_BIGGER);
        lblProcessingBillNumber.setOpaque(true);
        lblProcessingBillNumber.setBackground(MyColor.BACKGROUND_LOGO);
        lblProcessingBillNumber.setForeground(MyColor.TAB_LABEL);
        lblProcessingBillNumber.setBounds(10, 10, 165, 50);
        pnlProcessingDetailBill.add(lblProcessingBillNumber);

        lblProcessingNumber = new JLabel();
        lblProcessingNumber.setOpaque(true);
        lblProcessingNumber.setBackground(Color.WHITE);
        lblProcessingNumber.setFont(MyFont.MAIN_FONT_BIGGER);
        lblProcessingNumber.setForeground(MyColor.TAB_LABEL);
        lblProcessingNumber.setBounds(185, 10, 155, 50);
        pnlProcessingDetailBill.add(lblProcessingNumber);

        JLabel lblProcessingIDStaffOrdered = new JLabel("ID Nhân viên", SwingConstants.CENTER);
        lblProcessingIDStaffOrdered.setFont(MyFont.MAIN_FONT_BIGGER);
        lblProcessingIDStaffOrdered.setOpaque(true);
        lblProcessingIDStaffOrdered.setBackground(MyColor.BACKGROUND_LOGO);
        lblProcessingIDStaffOrdered.setForeground(MyColor.TAB_LABEL);
        lblProcessingIDStaffOrdered.setBounds(10, 70, 165, 50);
        pnlProcessingDetailBill.add(lblProcessingIDStaffOrdered);

        lblProcessingIDStaff = new JLabel();
        lblProcessingIDStaff.setFont(MyFont.MAIN_FONT_BIGGER);
        lblProcessingIDStaff.setOpaque(true);
        lblProcessingIDStaff.setBackground(Color.WHITE);
        lblProcessingIDStaff.setForeground(MyColor.TAB_LABEL);
        lblProcessingIDStaff.setBounds(185, 70, 155, 50);
        pnlProcessingDetailBill.add(lblProcessingIDStaff);

        tableModelProcessingDetail = new DefaultTableModel();
        tableModelProcessingDetail.addColumn("Tên món");
        tableModelProcessingDetail.addColumn("Size");
        tableModelProcessingDetail.addColumn("Số lượng");
        tblProcessingDetail = new JTable(tableModelProcessingDetail);
        tblProcessingDetail.setFont(MyFont.MEDIUM_FONT);
        tblProcessingDetail.setForeground(MyColor.TAB_LABEL);
        tblProcessingDetail.setDefaultEditor(Object.class, null);
        tblProcessingDetail.setFocusable(false);
        JTableHeader headerDetail = tblProcessingDetail.getTableHeader();
        headerDetail.setReorderingAllowed(false);
        headerDetail.setFont(MyFont.MEDIUM_FONT);
        headerDetail.setForeground(MyColor.TAB_LABEL);
        headerDetail.setBackground(Color.WHITE);
        JScrollPane scrProcessingDetail = new JScrollPane(tblProcessingDetail, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrProcessingDetail.setBounds(10, 130, 330, 390);
        pnlProcessingDetailBill.add(scrProcessingDetail);

        btnDone = new JButton("ĐÃ HOÀN THÀNH");
        btnDone.setFont(MyFont.MAIN_FONT_BIGGER);
        btnDone.setBorderPainted(false);
        btnDone.setFocusPainted(false);
        btnDone.setForeground(Color.WHITE);
        btnDone.setBackground(MyColor.TAB_LABEL);
        btnDone.setBounds(120, 536, 220, 70);
        pnlProcessingDetailBill.add(btnDone);
    }

}
