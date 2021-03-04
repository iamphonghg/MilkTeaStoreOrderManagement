package view;

import connect.DBConnect;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static DBConnect dbConnect = new DBConnect();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainUI mainUI = new MainUI("MILK TEA STORE");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
