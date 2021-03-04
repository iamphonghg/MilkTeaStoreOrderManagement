package view;

import model.MyColor;
import model.MyFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class HistoryPanel extends JPanel {
    public DefaultTableModel tableModelHistory, tableModelHistoryDetail;
    public JTable tblHistory, tblHistoryDetail;
    public JLabel lblHistoryNumber, lblHistoryIDStaff, lblCode, lblValueDiscount,
            lblHistoryValueTotalCost, lblHistoryValueTotalDiscount,
            lblHistoryValueFinalTotalCost;


    public HistoryPanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel pnlHistoryList = new JPanel();
        pnlHistoryList.setLayout(null);
        pnlHistoryList.setBackground(MyColor.CANVAS);
        pnlHistoryList.setBounds(10, 10, 610, 616);
        this.add(pnlHistoryList);

        tableModelHistory = new DefaultTableModel();
        tableModelHistory.addColumn("Số HD");
        tableModelHistory.addColumn("Thời gian tạo");
        tableModelHistory.addColumn("Thời gian hoàn thành");
        tableModelHistory.addColumn("Tổng thu");
        tblHistory = new JTable(tableModelHistory);
        tblHistory.setFont(MyFont.MAIN_FONT);
        tblHistory.setForeground(MyColor.TAB_LABEL);
        tblHistory.setDefaultEditor(Object.class, null);
        tblHistory.setFocusable(false);
        JTableHeader headerHistory = tblHistory.getTableHeader();
        headerHistory.setReorderingAllowed(false);
        headerHistory.setBackground(Color.WHITE);
        headerHistory.setForeground(MyColor.TAB_LABEL);
        headerHistory.setFont(MyFont.MAIN_FONT);
        JScrollPane scrHistory = new JScrollPane(tblHistory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrHistory.setBounds(10, 10, 590, 596);
        pnlHistoryList.add(scrHistory);

        JPanel pnlHistoryDetailBill = new JPanel();
        pnlHistoryDetailBill.setLayout(null);
        pnlHistoryDetailBill.setBackground(MyColor.CANVAS);
        pnlHistoryDetailBill.setBounds(630, 10, 350, 616);
        this.add(pnlHistoryDetailBill);

        JLabel lblHistoryBillNumber = new JLabel("Số HD", SwingConstants.CENTER);
        lblHistoryBillNumber.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryBillNumber.setOpaque(true);
        lblHistoryBillNumber.setBackground(MyColor.BACKGROUND_LOGO);
        lblHistoryBillNumber.setForeground(MyColor.TAB_LABEL);
        lblHistoryBillNumber.setBounds(10, 10, 165, 50);
        pnlHistoryDetailBill.add(lblHistoryBillNumber);

        lblHistoryNumber = new JLabel("", SwingConstants.RIGHT);
        lblHistoryNumber.setOpaque(true);
        lblHistoryNumber.setBackground(Color.WHITE);
        lblHistoryNumber.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryNumber.setForeground(MyColor.TAB_LABEL);
        lblHistoryNumber.setBounds(185, 10, 155, 50);
        pnlHistoryDetailBill.add(lblHistoryNumber);

        JLabel lblHistoryIDStaffOrdered = new JLabel("ID Nhân viên", SwingConstants.CENTER);
        lblHistoryIDStaffOrdered.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryIDStaffOrdered.setOpaque(true);
        lblHistoryIDStaffOrdered.setBackground(MyColor.BACKGROUND_LOGO);
        lblHistoryIDStaffOrdered.setForeground(MyColor.TAB_LABEL);
        lblHistoryIDStaffOrdered.setBounds(10, 70, 165, 50);
        pnlHistoryDetailBill.add(lblHistoryIDStaffOrdered);

        lblHistoryIDStaff = new JLabel("", SwingConstants.RIGHT);
        lblHistoryIDStaff.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryIDStaff.setOpaque(true);
        lblHistoryIDStaff.setBackground(Color.WHITE);
        lblHistoryIDStaff.setForeground(MyColor.TAB_LABEL);
        lblHistoryIDStaff.setBounds(185, 70, 155, 50);
        pnlHistoryDetailBill.add(lblHistoryIDStaff);

        tableModelHistoryDetail = new DefaultTableModel();
        tableModelHistoryDetail.addColumn("Tên món");
        tableModelHistoryDetail.addColumn("Size");
        tableModelHistoryDetail.addColumn("Giảm giá");
        tableModelHistoryDetail.addColumn("Số lượng");
        tableModelHistoryDetail.addColumn("Thành tiền");
        tblHistoryDetail = new JTable(tableModelHistoryDetail);
        tblHistoryDetail.setFont(MyFont.DETAILBILL_FONT);
        tblHistoryDetail.setForeground(MyColor.TAB_LABEL);
        tblHistoryDetail.setDefaultEditor(Object.class, null);
        tblHistoryDetail.setFocusable(false);
        JTableHeader headerHistoryDetail = tblHistoryDetail.getTableHeader();
        headerHistoryDetail.setReorderingAllowed(false);
        headerHistoryDetail.setForeground(MyColor.TAB_LABEL);
        headerHistoryDetail.setBackground(Color.WHITE);
        headerHistoryDetail.setFont(MyFont.DETAILBILL_FONT);
        JScrollPane scrHistoryDetail = new JScrollPane(tblHistoryDetail, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrHistoryDetail.setBounds(10, 130, 330, 200);
        pnlHistoryDetailBill.add(scrHistoryDetail);

        JLabel lblHistoryDiscountCode = new JLabel("Mã giảm giá", SwingConstants.CENTER);
        lblHistoryDiscountCode.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryDiscountCode.setOpaque(true);
        lblHistoryDiscountCode.setBackground(MyColor.BACKGROUND_LOGO);
        lblHistoryDiscountCode.setForeground(MyColor.TAB_LABEL);
        lblHistoryDiscountCode.setBounds(10, 340, 165, 50);
        pnlHistoryDetailBill.add(lblHistoryDiscountCode);

        lblCode = new JLabel("", SwingConstants.RIGHT);
        lblCode.setFont(MyFont.MAIN_FONT_BIGGER);
        lblCode.setOpaque(true);
        lblCode.setBackground(Color.WHITE);
        lblCode.setForeground(MyColor.TAB_LABEL);
        lblCode.setBounds(185, 340, 155, 50);
        pnlHistoryDetailBill.add(lblCode);

        lblValueDiscount = new JLabel("", SwingConstants.RIGHT);
        lblValueDiscount.setFont(MyFont.DETAILBILL_FONT);
        lblValueDiscount.setOpaque(true);
        lblValueDiscount.setBackground(Color.WHITE);
        lblValueDiscount.setForeground(MyColor.TAB_LABEL);
        lblValueDiscount.setBounds(185, 400, 155, 30);
        pnlHistoryDetailBill.add(lblValueDiscount);

        JLabel lblHistoryTotalCost = new JLabel("Tổng tiền", SwingConstants.CENTER);
        lblHistoryTotalCost.setOpaque(true);
        lblHistoryTotalCost.setBackground(MyColor.BACKGROUND_LOGO);
        lblHistoryTotalCost.setForeground(MyColor.TAB_LABEL);
        lblHistoryTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryTotalCost.setBounds(10, 440, 165, 50);
        pnlHistoryDetailBill.add(lblHistoryTotalCost);

        lblHistoryValueTotalCost = new JLabel("", SwingConstants.RIGHT);
        lblHistoryValueTotalCost.setOpaque(true);
        lblHistoryValueTotalCost.setBackground(Color.WHITE);
        lblHistoryValueTotalCost.setForeground(MyColor.TAB_LABEL);
        lblHistoryValueTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryValueTotalCost.setBounds(185, 440, 155, 50);
        pnlHistoryDetailBill.add(lblHistoryValueTotalCost);

        JLabel lblHistoryTotalDiscount = new JLabel("Tổng giảm", SwingConstants.CENTER);
        lblHistoryTotalDiscount.setOpaque(true);
        lblHistoryTotalDiscount.setBackground(MyColor.BACKGROUND_LOGO);
        lblHistoryTotalDiscount.setForeground(MyColor.TAB_LABEL);
        lblHistoryTotalDiscount.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryTotalDiscount.setBounds(10, 500, 165, 50);
        pnlHistoryDetailBill.add(lblHistoryTotalDiscount);

        lblHistoryValueTotalDiscount = new JLabel("", SwingConstants.RIGHT);
        lblHistoryValueTotalDiscount.setOpaque(true);
        lblHistoryValueTotalDiscount.setBackground(Color.WHITE);
        lblHistoryValueTotalDiscount.setForeground(MyColor.TAB_LABEL);
        lblHistoryValueTotalDiscount.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryValueTotalDiscount.setBounds(185, 500, 155, 50);
        pnlHistoryDetailBill.add(lblHistoryValueTotalDiscount);

        JLabel lblHistoryFinalTotalCost = new JLabel("TỔNG THU", SwingConstants.CENTER);
        lblHistoryFinalTotalCost.setOpaque(true);
        lblHistoryFinalTotalCost.setBackground(MyColor.OUT_OF_STOCK);
        lblHistoryFinalTotalCost.setForeground(Color.WHITE);
        lblHistoryFinalTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryFinalTotalCost.setBounds(10, 560, 165, 50);
        pnlHistoryDetailBill.add(lblHistoryFinalTotalCost);

        lblHistoryValueFinalTotalCost = new JLabel("", SwingConstants.RIGHT);
        lblHistoryValueFinalTotalCost.setOpaque(true);
        lblHistoryValueFinalTotalCost.setBackground(Color.WHITE);
        lblHistoryValueFinalTotalCost.setForeground(MyColor.TAB_LABEL);
        lblHistoryValueFinalTotalCost.setFont(MyFont.MAIN_FONT_BIGGER);
        lblHistoryValueFinalTotalCost.setBounds(185, 560, 155, 50);
        pnlHistoryDetailBill.add(lblHistoryValueFinalTotalCost);

    }
}
