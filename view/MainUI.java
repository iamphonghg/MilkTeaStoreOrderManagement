package view;

import controller.ItemController;
import model.Item;
import model.MyColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class MainUI extends JFrame {
    private final FunctionButton btnOrder, btnProcessing, btnHistoryOrder, btnItem, btnStaffList,
            btnShift, btnDiscountCode, btnAttendance, btnSalary, btnStatistics;
    private final CardLayout cardLayoutFunction = new CardLayout();
    private final JPanel pnlDisplay;
    private OrderPanel pnlOrder;

    public MainUI(String title) throws SQLException {
        super(title);
        ImageIcon logo = new ImageIcon("src/order.png");
        setIconImage(logo.getImage());

        Container container = getContentPane();
        container.setLayout(null);

        JPanel pnlLogo = new JPanel();
        pnlLogo.setLayout(new BorderLayout());
        pnlLogo.setBounds(0, 0, 194, 117);
        pnlLogo.setBackground(MyColor.BACKGROUND_LOGO);
        container.add(pnlLogo);

        JLabel lblLogo = new JLabel(logo);
        pnlLogo.add(lblLogo, BorderLayout.CENTER);

        JPanel pnlFunction = new JPanel();
        pnlFunction.setLayout(null);
        pnlFunction.setBounds(0, 117, 194, 549);
        pnlFunction.setBackground(MyColor.TAB_LABEL);
        container.add(pnlFunction);

        pnlDisplay = new JPanel();
        pnlDisplay.setLayout(cardLayoutFunction);
        pnlDisplay.setBounds(194, 0, 990, 666);
        pnlDisplay.setBackground(Color.WHITE);
        container.add(pnlDisplay);

        btnOrder = new FunctionButton("Order", "Order");
        btnOrder.setBounds(0, 0, 194, 50);
        btnOrder.setBackground(Color.WHITE);
        btnOrder.setForeground(MyColor.TAB_LABEL);
        pnlFunction.add(btnOrder);

        btnProcessing = new FunctionButton("Đang làm", "Processing");
        btnProcessing.setBounds(0, 50, 194, 50);
        pnlFunction.add(btnProcessing);

        btnHistoryOrder = new FunctionButton("Lịch sử đơn", "HistoryOrder");
        btnHistoryOrder.setBounds(0, 100, 194, 50);
        pnlFunction.add(btnHistoryOrder);

        btnItem = new FunctionButton("Món", "Item");
        btnItem.setBounds(0, 150, 194, 50);
        pnlFunction.add(btnItem);

        btnStaffList = new FunctionButton("Nhân viên", "StaffList");
        btnStaffList.setBounds(0, 200, 194, 50);
        pnlFunction.add(btnStaffList);

        btnShift = new FunctionButton("Ca làm việc", "Shift");
        btnShift.setBounds(0, 250, 194, 50);
        pnlFunction.add(btnShift);

        btnDiscountCode = new FunctionButton("Mã giảm giá", "DiscountCode");
        btnDiscountCode.setBounds(0, 300, 194, 50);
        pnlFunction.add(btnDiscountCode);

        btnAttendance = new FunctionButton("Chấm công", "Attendance");
        btnAttendance.setBounds(0, 350, 194, 50);
        pnlFunction.add(btnAttendance);

        btnSalary = new FunctionButton("Tính lương", "Salary");
        btnSalary.setBounds(0, 400, 194, 50);
        pnlFunction.add(btnSalary);

        btnStatistics = new FunctionButton("Thống kê", "Statistics");
        btnStatistics.setBounds(0, 450, 194, 50);
        pnlFunction.add(btnStatistics);

        FunctionButton[] allFunctionButton = {btnOrder, btnProcessing, btnHistoryOrder, btnItem, btnStaffList, btnShift,
                btnDiscountCode, btnAttendance, btnSalary, btnStatistics};

        OrderPanel pnlOrder = new OrderPanel();
        pnlDisplay.add(pnlOrder, "Order");

        JPanel pnlProcessing = new ProcessingPanel();
        pnlDisplay.add(pnlProcessing, "Processing");

        JPanel pnlHistoryOrder = new HistoryPanel();
        pnlDisplay.add(pnlHistoryOrder, "HistoryOrder");

        JPanel pnlItem = new ItemPanel();
        pnlDisplay.add(pnlItem, "Item");

        JPanel pnlStaffList = new StaffPanel();
        pnlDisplay.add(pnlStaffList, "StaffList");

        JPanel pnlShift = new ShiftPanel();
        pnlDisplay.add(pnlShift, "Shift");

        JPanel pnlDiscountCode = new DiscountCodePanel();
        pnlDisplay.add(pnlDiscountCode, "DiscountCode");

        JPanel pnlAttendance = new JPanel();
        pnlAttendance.setBackground(Color.LIGHT_GRAY);
        pnlDisplay.add(pnlAttendance, "Attendance");

        JPanel pnlSalary = new JPanel();
        pnlSalary.setBackground(MyColor.FOOD);
        pnlDisplay.add(pnlSalary, "Salary");

        JPanel pnlStatistics = new JPanel();
        pnlStatistics.setBackground(Color.GRAY);
        pnlDisplay.add(pnlStatistics, "Statistics");

        addEvents(allFunctionButton);
        showWindow();
    }

    private void addEvents(FunctionButton[] allFunctionButton) {
        for (FunctionButton b : allFunctionButton) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changColorButton(allFunctionButton, b);
                    cardLayoutFunction.show(pnlDisplay, b.getNamePanelDisplay());
                }
            });
        }
    }

    private void changColorButton(FunctionButton[] allFunctionButton, FunctionButton btnSelected) {
        btnSelected.setBackground(Color.WHITE);
        btnSelected.setForeground(MyColor.TAB_LABEL);
        for (FunctionButton b : allFunctionButton) {
            if (b != btnSelected) {
                b.setBackground(MyColor.TAB_LABEL);
                b.setForeground(Color.WHITE);
            }
        }
    }

    private void showWindow() {
        this.setSize(1200, 675);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
