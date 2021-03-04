package controller;

import model.Staff;
import view.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaffController {
    public void loadStaffListFromDBToTable(DefaultTableModel tableModel) {
        tableModel.getDataVector().removeAllElements();
        String query = "SELECT * FROM staff ORDER BY staff_name ASC";
        ResultSet resultSet = Main.dbConnect.excuteQuerySelect(query);
        int countIndex = 0;
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("staff_id");
                String name = resultSet.getString("staff_name");
                String gender = resultSet.getString("gender");
                Date birthday = resultSet.getDate("birthday");
                String position = resultSet.getString("position");
                String phoneNumber = resultSet.getString("phone_number");
                String status = resultSet.getString("staff_status");
                String[] staff = {Integer.toString(++countIndex), id, name, gender, birthday.toString(), position, phoneNumber, status};
                tableModel.addRow(staff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Staff> loadStaffListFromDBToList() {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT * FROM staff ORDER BY staff_name ASC";
        ResultSet resultSet = Main.dbConnect.excuteQuerySelect(query);
        try {
            while (resultSet.next()) {
                Staff staff = new Staff(resultSet.getString("staff_id"), resultSet.getString("staff_name"), resultSet.getString("gender").charAt(0),
                        resultSet.getDate("birthday"), resultSet.getString("position"), resultSet.getString("phone_number"), resultSet.getString("staff_status"));
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public void insertStaffIntoDB(DefaultTableModel tableModel, String id, String name, String gender, String birthday, String position, String phoneNumber) {
        String query;
        if (phoneNumber != null) {
            query = "INSERT INTO staff VALUES ('" + id + "', '" + name + "', '" + gender + "', '" + birthday
                    + "', '" + position + "', '" + phoneNumber + "', 'đang làm việc')";
        } else {
            query = "INSERT INTO staff VALUES ('" + id + "', '" + name + "', '" + gender + "', '" + birthday
                    + "', '" + position + "', " + phoneNumber + ", 'đang làm việc')";
        }
        Main.dbConnect.excuteQueryUpdate(query);
        loadStaffListFromDBToTable(tableModel);
    }

    public void updateStaffIntoDB(DefaultTableModel tableModel, String id, String newName, String newGender, String newBirthday, String newPosition, String newPhoneNumber) {
        String query;
        if (newPhoneNumber != null) {
            query = "UPDATE staff " +
                    "SET staff_name = '" + newName + "', " +
                    "gender = '" + newGender + "', " +
                    "birthday = '" + newBirthday + "', " +
                    "position = '" + newPosition + "', " +
                    "phone_number = '" + newPhoneNumber + "' " +
                    "WHERE staff_id = '" + id + "'";
        } else {
            query = "UPDATE staff " +
                    "SET staff_name = '" + newName + "', " +
                    "gender = '" + newGender + "', " +
                    "birthday = '" + newBirthday + "', " +
                    "position = '" + newPosition + "', " +
                    "phone_number = " + newPhoneNumber + " " +
                    "WHERE staff_id = '" + id + "'";
        }
        System.out.println(query);
        Main.dbConnect.excuteQueryUpdate(query);
        loadStaffListFromDBToTable(tableModel);
    }

    public void updateStaffStatusIntoDB(DefaultTableModel tableModel, String id) {
        String query = "UPDATE staff SET staff_status = 'đã thôi việc' " +
                "WHERE staff_id = '" + id + "'";
        Main.dbConnect.excuteQueryUpdate(query);
        loadStaffListFromDBToTable(tableModel);
    }

    public boolean checkDuplicateID(String id, int rowCount, JTable table) {
        for (int i = 0; i < rowCount; i++) {
            if (table.getValueAt(i, 1).equals(id)) {
                return false;
            }
        }
        return true;   //true la khong trung
    }

    public String randomGenID(int rowCount, JTable table) {
        Random random = new Random();
        String newId = null;
        do {
            newId = "NV" + (random.nextInt(9999 - 1000 + 1) + 1000);
        } while (!checkDuplicateID(newId, rowCount, table));
        return newId;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

}

