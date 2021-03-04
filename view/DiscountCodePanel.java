package view;

import model.MyColor;
import model.MyFont;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.function.ObjIntConsumer;

public class DiscountCodePanel extends JPanel {
    public DefaultTableModel tableModelDiscountCodeList;
    public JTable tblDiscountCodeList;
    public JLabel lblTextCode;
    public JComboBox<String> cbxCodeType;
    public JTextField txtValueDiscount, txtMinimumValue;


    public DiscountCodePanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel pnlDiscountCodeList = new JPanel();
        pnlDiscountCodeList.setLayout(null);
        pnlDiscountCodeList.setBackground(MyColor.CANVAS);
        pnlDiscountCodeList.setBounds(10, 10, 610, 616);
        this.add(pnlDiscountCodeList);

        tableModelDiscountCodeList = new DefaultTableModel();
        tableModelDiscountCodeList.addColumn("STT");
        tableModelDiscountCodeList.addColumn("Mã");
        tableModelDiscountCodeList.addColumn("Loại");
        tableModelDiscountCodeList.addColumn("Giảm");
        tableModelDiscountCodeList.addColumn("% giảm ");
        tableModelDiscountCodeList.addColumn("HĐ tối thiểu");
        tableModelDiscountCodeList.addColumn("Giảm tối đa");
        tableModelDiscountCodeList.addColumn("Ngày tạo");
        tableModelDiscountCodeList.addColumn("HSD");
        tableModelDiscountCodeList.addColumn("Trạng thái");
        tableModelDiscountCodeList.addColumn("Ngày sử dụng");
        tblDiscountCodeList = new JTable(tableModelDiscountCodeList);
        tblDiscountCodeList.setFont(MyFont.DETAILBILL_FONT);
        tblDiscountCodeList.setForeground(MyColor.TAB_LABEL);
        tblDiscountCodeList.setDefaultEditor(Object.class, null);
        tblDiscountCodeList.setFocusable(false);
        JTableHeader header = tblDiscountCodeList.getTableHeader();
        header.setReorderingAllowed(false);
        header.setFont(MyFont.DETAILBILL_FONT);
        header.setForeground(MyColor.TAB_LABEL);
        header.setBackground(Color.WHITE);
        JScrollPane scrDiscountCodeList = new JScrollPane(tblDiscountCodeList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrDiscountCodeList.setBounds(10, 10, 590, 596);
        pnlDiscountCodeList.add(scrDiscountCodeList);

        JPanel pnlDetailDiscountCode = new JPanel();
        pnlDetailDiscountCode.setLayout(null);
        pnlDetailDiscountCode.setBackground(MyColor.CANVAS);
        pnlDetailDiscountCode.setBounds(630, 10, 350, 616);
        this.add(pnlDetailDiscountCode);

        JLabel lblCode = new JLabel("Mã", SwingConstants.CENTER);
        lblCode.setOpaque(true);
        lblCode.setFont(MyFont.MAIN_FONT);
        lblCode.setForeground(MyColor.TAB_LABEL);
        lblCode.setBackground(MyColor.BACKGROUND_LOGO);
        lblCode.setBounds(10, 10, 110, 50);
        pnlDetailDiscountCode.add(lblCode);

        lblTextCode = new JLabel("", SwingConstants.CENTER);
        lblTextCode.setOpaque(true);
        lblTextCode.setFont(MyFont.MAIN_FONT);
        lblTextCode.setForeground(MyColor.TAB_LABEL);
        lblTextCode.setBackground(Color.WHITE);
        lblTextCode.setBounds(140, 10, 200, 50);
        pnlDetailDiscountCode.add(lblTextCode);

        JLabel lblType = new JLabel("Loại", SwingConstants.CENTER);
        lblType.setOpaque(true);
        lblType.setFont(MyFont.MAIN_FONT);
        lblType.setForeground(MyColor.TAB_LABEL);
        lblType.setBackground(MyColor.BACKGROUND_LOGO);
        lblType.setBounds(10, 80, 110, 50);
        pnlDetailDiscountCode.add(lblType);

        cbxCodeType = new JComboBox<>();
        cbxCodeType.setFont(MyFont.MAIN_FONT);
        cbxCodeType.setBackground(Color.WHITE);
        cbxCodeType.setForeground(MyColor.TAB_LABEL);
        cbxCodeType.addItem("Giảm trực tiếp");
        cbxCodeType.addItem("Giảm theo %");
        ((JLabel) cbxCodeType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cbxCodeType.setBounds(140, 80, 200, 50);
        pnlDetailDiscountCode.add(cbxCodeType);

        JLabel lblValueDiscount = new JLabel("Mức giảm", SwingConstants.CENTER);
        lblValueDiscount.setOpaque(true);
        lblValueDiscount.setFont(MyFont.MAIN_FONT);
        lblValueDiscount.setForeground(MyColor.TAB_LABEL);
        lblValueDiscount.setBackground(MyColor.BACKGROUND_LOGO);
        lblValueDiscount.setBounds(10, 150, 110, 50);
        pnlDetailDiscountCode.add(lblValueDiscount);

        txtValueDiscount = new JTextField();
        txtValueDiscount.setHorizontalAlignment(SwingConstants.CENTER);
        txtValueDiscount.setFont(MyFont.MAIN_FONT);
        txtValueDiscount.setBorder(null);
        txtValueDiscount.setForeground(MyColor.TAB_LABEL);
        txtValueDiscount.setBackground(Color.WHITE);
        txtValueDiscount.setBounds(140, 150, 200, 50);
        pnlDetailDiscountCode.add(txtValueDiscount);

        JLabel lblMinimumValue = new JLabel("HĐ tối thiểu", SwingConstants.CENTER);
        lblMinimumValue.setOpaque(true);
        lblMinimumValue.setFont(MyFont.MAIN_FONT);
        lblMinimumValue.setForeground(MyColor.TAB_LABEL);
        lblMinimumValue.setBackground(MyColor.BACKGROUND_LOGO);
        lblMinimumValue.setBounds(10, 220, 110, 50);
        pnlDetailDiscountCode.add(lblMinimumValue);

        txtMinimumValue = new JTextField();
        txtMinimumValue.setHorizontalAlignment(SwingConstants.CENTER);
        txtMinimumValue.setFont(MyFont.MAIN_FONT);
        txtMinimumValue.setBorder(null);
        txtMinimumValue.setForeground(MyColor.TAB_LABEL);
        txtMinimumValue.setBackground(Color.WHITE);
        txtMinimumValue.setBounds(140, 220, 200, 50);
        pnlDetailDiscountCode.add(txtMinimumValue);

        JLabel lblExpiryDate = new JLabel("HSD", SwingConstants.CENTER);
        lblExpiryDate.setOpaque(true);
        lblExpiryDate.setFont(MyFont.MAIN_FONT);
        lblExpiryDate.setForeground(MyColor.TAB_LABEL);
        lblExpiryDate.setBackground(MyColor.BACKGROUND_LOGO);
        lblExpiryDate.setBounds(10, 290, 110, 50);
        pnlDetailDiscountCode.add(lblExpiryDate);




    }
}
