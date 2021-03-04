package view;

import connect.DBConnect;
import controller.StaffController;
import model.MyColor;
import model.MyFont;
import model.Staff;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StaffPanel extends JPanel {
    public DefaultTableModel tableModelStaffList;
    public JTable tblStaffList;
    public JLabel lblID;
    public JTextField txtStaffName, txtPhoneNumber;
    public JComboBox<String> cbxStaffGender, cbxStaffPosition;
    public JButton btnAddNewStaff, btnEditStaff, btnUpdateStatus,
            btnConfirmEdit, btnCancelEdit, btnConfirmAddNew, btnCancelAddNew;
    private final StaffController staffController = new StaffController();
    private final BirthdayChooseFormPanel pnlBirthDayChoose;


    public StaffPanel() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);

        JPanel pnlStaffList = new JPanel();
        pnlStaffList.setLayout(null);
        pnlStaffList.setBackground(MyColor.CANVAS);
        pnlStaffList.setBounds(10, 10, 610, 616);
        this.add(pnlStaffList);

        tableModelStaffList = new DefaultTableModel();
        tableModelStaffList.addColumn("STT");
        tableModelStaffList.addColumn("ID");
        tableModelStaffList.addColumn("Họ tên");
        tableModelStaffList.addColumn("Giới tính");
        tableModelStaffList.addColumn("Ngày sinh");
        tableModelStaffList.addColumn("Chức vụ");
        tableModelStaffList.addColumn("SĐT");
        tableModelStaffList.addColumn("Tình trạng");
        tblStaffList = new JTable(tableModelStaffList);
        tblStaffList.setFont(MyFont.DETAILBILL_FONT);
        tblStaffList.setForeground(MyColor.TAB_LABEL);
        tblStaffList.setDefaultEditor(Object.class, null);
        tblStaffList.setFocusable(false);
        JTableHeader header = tblStaffList.getTableHeader();
        header.setReorderingAllowed(false);
        header.setForeground(MyColor.TAB_LABEL);
        header.setBackground(Color.WHITE);
        header.setFont(MyFont.DETAILBILL_FONT);
        JScrollPane scrStaffList = new JScrollPane(tblStaffList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrStaffList.setBounds(10, 10, 590, 596);
        pnlStaffList.add(scrStaffList);

        JPanel pnlDetailStaff = new JPanel();
        pnlDetailStaff.setLayout(null);
        pnlDetailStaff.setBackground(MyColor.CANVAS);
        pnlDetailStaff.setBounds(630, 10, 350, 616);
        this.add(pnlDetailStaff);

        JLabel lblStaffID = new JLabel("ID", SwingConstants.CENTER);
        lblStaffID.setOpaque(true);
        lblStaffID.setFont(MyFont.MAIN_FONT);
        lblStaffID.setBackground(MyColor.BACKGROUND_LOGO);
        lblStaffID.setForeground(MyColor.TAB_LABEL);
        lblStaffID.setBounds(10, 10, 110, 50);
        pnlDetailStaff.add(lblStaffID);

        lblID = new JLabel("", SwingConstants.CENTER);
        lblID.setOpaque(true);
        lblID.setFont(MyFont.MAIN_FONT);
        lblID.setBackground(Color.WHITE);
        lblID.setForeground(Color.GRAY);
        lblID.setBounds(140, 10, 200, 50);
        pnlDetailStaff.add(lblID);

        JLabel lblStaffName = new JLabel("Họ tên", SwingConstants.CENTER);
        lblStaffName.setOpaque(true);
        lblStaffName.setFont(MyFont.MAIN_FONT);
        lblStaffName.setBackground(MyColor.BACKGROUND_LOGO);
        lblStaffName.setForeground(MyColor.TAB_LABEL);
        lblStaffName.setBounds(10, 80, 110, 50);
        pnlDetailStaff.add(lblStaffName);

        txtStaffName = new JTextField();
        txtStaffName.setFont(MyFont.MAIN_FONT);
        txtStaffName.setBackground(Color.WHITE);
        txtStaffName.setForeground(MyColor.TAB_LABEL);
        txtStaffName.setBorder(null);
        txtStaffName.setHorizontalAlignment(SwingConstants.CENTER);
        txtStaffName.setBounds(140, 80, 200, 50);
        pnlDetailStaff.add(txtStaffName);

        JLabel lblStaffGender = new JLabel("Giới tính", SwingConstants.CENTER);
        lblStaffGender.setOpaque(true);
        lblStaffGender.setFont(MyFont.MAIN_FONT);
        lblStaffGender.setBackground(MyColor.BACKGROUND_LOGO);
        lblStaffGender.setForeground(MyColor.TAB_LABEL);
        lblStaffGender.setBounds(10, 150, 110, 50);
        pnlDetailStaff.add(lblStaffGender);

        cbxStaffGender = new JComboBox<>();
        cbxStaffGender.setFont(MyFont.MAIN_FONT);
        cbxStaffGender.setBackground(Color.WHITE);
        cbxStaffGender.setForeground(MyColor.TAB_LABEL);
        cbxStaffGender.addItem("Nam");
        cbxStaffGender.addItem("Nữ");
        cbxStaffGender.addItem("Khác");
        ((JLabel) cbxStaffGender.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cbxStaffGender.setBounds(140, 150, 200, 50);
        pnlDetailStaff.add(cbxStaffGender);

        JLabel lblStaffBirthday = new JLabel("Ngày sinh", SwingConstants.CENTER);
        lblStaffBirthday.setOpaque(true);
        lblStaffBirthday.setFont(MyFont.MAIN_FONT);
        lblStaffBirthday.setBackground(MyColor.BACKGROUND_LOGO);
        lblStaffBirthday.setForeground(MyColor.TAB_LABEL);
        lblStaffBirthday.setBounds(10, 220, 110, 50);
        pnlDetailStaff.add(lblStaffBirthday);

        pnlBirthDayChoose = new BirthdayChooseFormPanel();
        pnlDetailStaff.add(pnlBirthDayChoose);

        pnlBirthDayChoose.cbxMonth.setSelectedItem(1);
        pnlBirthDayChoose.cbxYear.setSelectedItem(2020);

        JLabel lblStaffPosition = new JLabel("Chức vụ", SwingConstants.CENTER);
        lblStaffPosition.setOpaque(true);
        lblStaffPosition.setFont(MyFont.MAIN_FONT);
        lblStaffPosition.setBackground(MyColor.BACKGROUND_LOGO);
        lblStaffPosition.setForeground(MyColor.TAB_LABEL);
        lblStaffPosition.setBounds(10, 290, 110, 50);
        pnlDetailStaff.add(lblStaffPosition);

        cbxStaffPosition = new JComboBox<>();
        cbxStaffPosition.setFont(MyFont.MAIN_FONT);
        cbxStaffPosition.setBackground(Color.WHITE);
        cbxStaffPosition.setForeground(MyColor.TAB_LABEL);
        cbxStaffPosition.addItem("Phục vụ");
        cbxStaffPosition.addItem("Quản lý");
        ((JLabel) cbxStaffPosition.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cbxStaffPosition.setBounds(140, 290, 200, 50);
        pnlDetailStaff.add(cbxStaffPosition);

        JLabel lblPhoneNumber = new JLabel("SĐT", SwingConstants.CENTER);
        lblPhoneNumber.setOpaque(true);
        lblPhoneNumber.setFont(MyFont.MAIN_FONT);
        lblPhoneNumber.setBackground(MyColor.BACKGROUND_LOGO);
        lblPhoneNumber.setForeground(MyColor.TAB_LABEL);
        lblPhoneNumber.setBounds(10, 360, 110, 50);
        pnlDetailStaff.add(lblPhoneNumber);

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
        txtPhoneNumber.setFont(MyFont.MAIN_FONT);
        txtPhoneNumber.setBackground(Color.WHITE);
        txtPhoneNumber.setForeground(MyColor.TAB_LABEL);
        txtPhoneNumber.setBorder(null);
        txtPhoneNumber.setBounds(140, 360, 200, 50);
        pnlDetailStaff.add(txtPhoneNumber);

        btnAddNewStaff = new JButton("THÊM MỚI");
        btnAddNewStaff.setFont(MyFont.MAIN_FONT_BIGGER);
        btnAddNewStaff.setBorderPainted(false);
        btnAddNewStaff.setFocusPainted(false);
        btnAddNewStaff.setForeground(Color.WHITE);
        btnAddNewStaff.setBackground(MyColor.TAB_LABEL);
        btnAddNewStaff.setBounds(185, 430, 155, 50);
        pnlDetailStaff.add(btnAddNewStaff);

        btnConfirmAddNew = new JButton("XÁC NHẬN");
        btnConfirmAddNew.setFont(MyFont.MAIN_FONT_BIGGER);
        btnConfirmAddNew.setBorderPainted(false);
        btnConfirmAddNew.setFocusPainted(false);
        btnConfirmAddNew.setForeground(Color.WHITE);
        btnConfirmAddNew.setBackground(MyColor.IN_STOCK);
        btnConfirmAddNew.setBounds(185, 430, 155, 50);
        btnConfirmAddNew.setVisible(false);
        pnlDetailStaff.add(btnConfirmAddNew);

        btnCancelAddNew = new JButton("HUỶ");
        btnCancelAddNew.setFont(MyFont.MAIN_FONT_BIGGER);
        btnCancelAddNew.setBorderPainted(false);
        btnCancelAddNew.setFocusPainted(false);
        btnCancelAddNew.setForeground(Color.WHITE);
        btnCancelAddNew.setBackground(MyColor.OUT_OF_STOCK);
        btnCancelAddNew.setBounds(10, 430, 155, 50);
        btnCancelAddNew.setVisible(false);
        pnlDetailStaff.add(btnCancelAddNew);

        btnEditStaff = new JButton("SỬA");
        btnEditStaff.setFont(MyFont.MAIN_FONT_BIGGER);
        btnEditStaff.setBorderPainted(false);
        btnEditStaff.setFocusPainted(false);
        btnEditStaff.setForeground(Color.WHITE);
        btnEditStaff.setBackground(MyColor.TAB_LABEL);
        btnEditStaff.setBounds(185, 490, 155, 50);
        pnlDetailStaff.add(btnEditStaff);

        btnConfirmEdit = new JButton("XÁC NHẬN");
        btnConfirmEdit.setFont(MyFont.MAIN_FONT_BIGGER);
        btnConfirmEdit.setBorderPainted(false);
        btnConfirmEdit.setFocusPainted(false);
        btnConfirmEdit.setForeground(Color.WHITE);
        btnConfirmEdit.setBackground(MyColor.IN_STOCK);
        btnConfirmEdit.setBounds(185, 490, 155, 50);
        btnConfirmEdit.setVisible(false);
        pnlDetailStaff.add(btnConfirmEdit);

        btnCancelEdit = new JButton("HUỶ");
        btnCancelEdit.setFont(MyFont.MAIN_FONT_BIGGER);
        btnCancelEdit.setBorderPainted(false);
        btnCancelEdit.setFocusPainted(false);
        btnCancelEdit.setForeground(Color.WHITE);
        btnCancelEdit.setBackground(MyColor.OUT_OF_STOCK);
        btnCancelEdit.setBounds(10, 490, 155, 50);
        btnCancelEdit.setVisible(false);
        pnlDetailStaff.add(btnCancelEdit);

        btnUpdateStatus = new JButton("NGHỈ VIỆC");
        btnUpdateStatus.setFont(MyFont.MAIN_FONT_BIGGER);
        btnUpdateStatus.setBorderPainted(false);
        btnUpdateStatus.setFocusPainted(false);
        btnUpdateStatus.setForeground(Color.WHITE);
        btnUpdateStatus.setBackground(MyColor.OUT_OF_STOCK);
        btnUpdateStatus.setBounds(185, 550, 155, 50);
        pnlDetailStaff.add(btnUpdateStatus);


        staffController.loadStaffListFromDBToTable(tableModelStaffList);

        Events();
    }



    public void Events() {
        btnAddNewStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddNewStaff.setVisible(false);
                btnConfirmAddNew.setVisible(true);
                btnCancelAddNew.setVisible(true);
                btnEditStaff.setEnabled(false);
                btnUpdateStatus.setEnabled(false);
                tblStaffList.setEnabled(false);

                lblID.setText(staffController.randomGenID(tblStaffList.getRowCount(), tblStaffList));
                txtStaffName.setEditable(true);
                txtStaffName.setText("");
                txtStaffName.setForeground(MyColor.TAB_LABEL);
                cbxStaffGender.setEnabled(true);
                cbxStaffGender.setSelectedItem("Nam");
                pnlBirthDayChoose.cbxDay.setEnabled(true);
                pnlBirthDayChoose.cbxMonth.setEnabled(true);
                pnlBirthDayChoose.cbxYear.setEnabled(true);
                pnlBirthDayChoose.cbxMonth.setSelectedItem(1);
                pnlBirthDayChoose.cbxYear.setSelectedItem(2020);
                cbxStaffPosition.setEnabled(true);
                cbxStaffPosition.setSelectedItem("Phục vụ");
                txtPhoneNumber.setEditable(true);
                txtPhoneNumber.setText("");
                txtPhoneNumber.setForeground(MyColor.TAB_LABEL);

            }
        });

        btnConfirmAddNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddNewStaff.setVisible(true);
                btnConfirmAddNew.setVisible(false);
                btnCancelAddNew.setVisible(false);
                btnEditStaff.setEnabled(true);
                btnUpdateStatus.setEnabled(true);
                tblStaffList.setEnabled(true);

                String id = lblID.getText();
                String name = txtStaffName.getText();
                String genderSelected = cbxStaffGender.getSelectedItem().toString();
                String gender = null;
                if (genderSelected.equals("Nam")) {
                    gender = "M";
                } else if (genderSelected.equals("Nữ")) {
                    gender = "F";
                } else {
                    gender = "O";
                }
                String birthday = pnlBirthDayChoose.cbxYear.getSelectedItem().toString() + "-" + pnlBirthDayChoose.cbxMonth.getSelectedItem().toString()
                                    + "-" + pnlBirthDayChoose.cbxDay.getSelectedItem().toString();
                String position = cbxStaffPosition.getSelectedItem().toString();
                String phoneNumber = null;
                if (!txtPhoneNumber.getText().isBlank()) {
                    phoneNumber = txtPhoneNumber.getText();
                }

                staffController.insertStaffIntoDB(tableModelStaffList, id, name, gender, birthday, position, phoneNumber);
                OrderPanel.staffList = staffController.loadStaffListFromDBToList();
            }
        });

        btnCancelAddNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddNewStaff.setVisible(true);
                btnConfirmAddNew.setVisible(false);
                btnCancelAddNew.setVisible(false);
                btnEditStaff.setEnabled(true);
                btnUpdateStatus.setEnabled(true);
                tblStaffList.setEnabled(true);

                lblID.setText("");
                txtStaffName.setText("");
                cbxStaffGender.setSelectedItem("Nam");
                pnlBirthDayChoose.cbxMonth.setSelectedItem(1);
                pnlBirthDayChoose.cbxYear.setSelectedItem(2020);
                cbxStaffPosition.setSelectedItem("Phục vụ");
                txtPhoneNumber.setText("");
            }
        });


        btnEditStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblStaffList.getSelectedRow();
                if (selectedRow != -1) {
                    btnEditStaff.setVisible(false);
                    btnConfirmEdit.setVisible(true);
                    btnCancelEdit.setVisible(true);
                    btnAddNewStaff.setEnabled(false);
                    btnUpdateStatus.setEnabled(false);
                    tblStaffList.setEnabled(false);

                    txtStaffName.setEditable(true);
                    txtStaffName.setForeground(MyColor.TAB_LABEL);
                    cbxStaffGender.setEnabled(true);
                    pnlBirthDayChoose.cbxDay.setEnabled(true);
                    pnlBirthDayChoose.cbxMonth.setEnabled(true);
                    pnlBirthDayChoose.cbxYear.setEnabled(true);
                    cbxStaffPosition.setEnabled(true);
                    txtPhoneNumber.setEditable(true);
                    txtPhoneNumber.setForeground(MyColor.TAB_LABEL);
                }
            }
        });

        btnConfirmEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditStaff.setVisible(true);
                btnConfirmEdit.setVisible(false);
                btnCancelEdit.setVisible(false);
                btnAddNewStaff.setEnabled(true);
                btnUpdateStatus.setEnabled(true);
                tblStaffList.setEnabled(true);

                int selectedRow = tblStaffList.getSelectedRow();
                String id = lblID.getText();
                String oldName = tblStaffList.getValueAt(selectedRow, 2).toString();
                String newName = txtStaffName.getText();
                String oldGender = tblStaffList.getValueAt(selectedRow, 3).toString();
                String newGender = cbxStaffGender.getSelectedItem().toString();
                if (newGender.equals("Nam")) {
                    newGender = "M";
                } else if (newGender.equals("Nữ")) {
                    newGender = "F";
                } else {
                    newGender = "O";
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String oldDay = null;
                String oldMonth = null;
                String oldYear = null;
                try {
                    Date birthday = dateFormat.parse(tblStaffList.getValueAt(selectedRow, 4).toString());
                    oldDay = Integer.toString(birthday.getDate());
                    oldMonth = Integer.toString(birthday.getMonth() + 1);
                    oldYear = Integer.toString(birthday.getYear() + 1900);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                String newDay = pnlBirthDayChoose.cbxDay.getSelectedItem().toString();
                String newMonth = pnlBirthDayChoose.cbxMonth.getSelectedItem().toString();
                String newYear = pnlBirthDayChoose.cbxYear.getSelectedItem().toString();

                String oldBirthday = oldYear + "-" + oldMonth + "-" + oldDay;
                String newBirthday = newYear + "-" + newMonth + "-" + newDay;

                String oldPosition = tblStaffList.getValueAt(selectedRow, 5).toString();
                String newPosition = cbxStaffPosition.getSelectedItem().toString();
                Object selectedPhoneNumber = tblStaffList.getValueAt(selectedRow, 6);
                String oldPhoneNumber = null;
                if (selectedPhoneNumber != null) {
                    oldPhoneNumber = selectedPhoneNumber.toString();
                }
                String newPhoneNumber = null;
                if (!txtPhoneNumber.getText().isEmpty()) {
                    newPhoneNumber = txtPhoneNumber.getText();
                }

                String oldValues = oldName + oldGender + oldBirthday + oldPosition + oldPhoneNumber;
                String newValues = newName + newGender + newBirthday + newPosition + newPhoneNumber;

                if (!oldValues.equals(newValues)) {
                    staffController.updateStaffIntoDB(tableModelStaffList, id, newName, newGender, newBirthday, newPosition, newPhoneNumber);
                    OrderPanel.staffList = staffController.loadStaffListFromDBToList();
                } else {
                    System.out.println("Chưa có giá trị nào bị thay đổi");
                }
            }
        });

        btnCancelEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditStaff.setVisible(true);
                btnConfirmEdit.setVisible(false);
                btnCancelEdit.setVisible(false);
                btnAddNewStaff.setEnabled(true);
                btnUpdateStatus.setEnabled(true);
                tblStaffList.setEnabled(true);

                txtStaffName.setEditable(false);
                txtStaffName.setForeground(Color.GRAY);
                cbxStaffGender.setEnabled(false);
                pnlBirthDayChoose.cbxDay.setEnabled(false);
                pnlBirthDayChoose.cbxMonth.setEnabled(false);
                pnlBirthDayChoose.cbxYear.setEnabled(false);
                cbxStaffPosition.setEnabled(false);
                txtPhoneNumber.setEditable(false);
                txtPhoneNumber.setForeground(Color.GRAY);
            }
        });

        btnUpdateStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblStaffList.getSelectedRow();
                if (selectedRow != -1) {
                    if (tblStaffList.getValueAt(selectedRow, 7).toString().equalsIgnoreCase("đang làm việc")) {
                        staffController.updateStaffStatusIntoDB(tableModelStaffList, tblStaffList.getValueAt(selectedRow, 1).toString());
                        OrderPanel.staffList = staffController.loadStaffListFromDBToList();
                    }
                }
            }
        });

        tblStaffList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblStaffList.getSelectedRow();
                if (selectedRow != -1) {
                    lblID.setText(tblStaffList.getValueAt(selectedRow, 1).toString());

                    txtStaffName.setText(tblStaffList.getValueAt(selectedRow, 2).toString());

                    char gender = tblStaffList.getValueAt(selectedRow, 3).toString().charAt(0);
                    switch (gender) {
                        case 'M': { cbxStaffGender.setSelectedItem("Nam"); break; }
                        case 'F': { cbxStaffGender.setSelectedItem("Nữ"); break; }
                        case 'O': { cbxStaffGender.setSelectedItem("Khác"); break; }
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date birthday = dateFormat.parse(tblStaffList.getValueAt(selectedRow, 4).toString());
                        pnlBirthDayChoose.cbxYear.setSelectedItem(birthday.getYear() + 1900);
                        pnlBirthDayChoose.cbxMonth.setSelectedItem(birthday.getMonth() + 1);
                        pnlBirthDayChoose.cbxDay.setSelectedItem(birthday.getDate());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }

                    String position = tblStaffList.getValueAt(selectedRow, 5).toString();
                    if (position.equalsIgnoreCase("Quản lý") || position.equalsIgnoreCase("Quản lí")) {
                        cbxStaffPosition.setSelectedItem("Quản lý");
                    } else if (position.equalsIgnoreCase("Phục vụ")) {
                        cbxStaffPosition.setSelectedItem("Phục vụ");
                    }

                    Object selectedPhonenumber = tblStaffList.getValueAt(selectedRow, 6);
                    if (selectedPhonenumber != null) {
                        txtPhoneNumber.setText(selectedPhonenumber.toString());
                    } else {
                        txtPhoneNumber.setText("");
                    }
                    txtStaffName.setEditable(false);
                    txtStaffName.setForeground(Color.GRAY);
                    cbxStaffGender.setEnabled(false);
                    pnlBirthDayChoose.cbxDay.setEnabled(false);
                    pnlBirthDayChoose.cbxMonth.setEnabled(false);
                    pnlBirthDayChoose.cbxYear.setEnabled(false);
                    cbxStaffPosition.setEnabled(false);
                    txtPhoneNumber.setEditable(false);
                    txtPhoneNumber.setForeground(Color.GRAY);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

}
