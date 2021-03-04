package view;

import model.MyColor;
import model.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirthdayChooseFormPanel extends JPanel {
    public JComboBox<Integer> cbxDay, cbxMonth, cbxYear;
    public int selectedYear, selectedMonth, selectedDay;


    public BirthdayChooseFormPanel() {
        this.setLayout(null);
        this.setBackground(null);
        this.setBounds(140, 220, 200, 50);

        cbxYear = new JComboBox<>();
        cbxYear.setFont(MyFont.MAIN_FONT);
        cbxYear.setBackground(Color.WHITE);
        cbxYear.setForeground(MyColor.TAB_LABEL);
        ((JLabel) cbxYear.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 2020; i > 1904; i--) {
            cbxYear.addItem(i);
        }
        cbxYear.setBounds(120, 0, 80, 50);
        this.add(cbxYear);

        cbxMonth = new JComboBox<>();
        cbxMonth.setFont(MyFont.MAIN_FONT);
        cbxMonth.setBackground(Color.WHITE);
        cbxMonth.setForeground(MyColor.TAB_LABEL);
        ((JLabel) cbxMonth.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 1; i < 13; i++) {
            cbxMonth.addItem(i);
        }
        cbxMonth.setBounds(60, 0, 50, 50);
        this.add(cbxMonth);

        cbxDay = new JComboBox<>();
        cbxDay.setFont(MyFont.MAIN_FONT);
        cbxDay.setBackground(Color.WHITE);
        cbxDay.setForeground(MyColor.TAB_LABEL);
        ((JLabel) cbxDay.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        cbxDay.setBounds(0, 0, 50, 50);
        this.add(cbxDay);

        Events();
    }

    public void Events() {
        cbxYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbxDay.removeAllItems();
                selectedYear = Integer.parseInt(cbxYear.getSelectedItem().toString());
                if (cbxYear.getSelectedIndex() != -1) {
                    addDayAfterCheckMonthAndYear();
                }
            }
        });

        cbxMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbxDay.removeAllItems();
                selectedMonth = Integer.parseInt(cbxMonth.getSelectedItem().toString());
                if (cbxMonth.getSelectedIndex() != -1) {
                    addDayAfterCheckMonthAndYear();
                }
            }
        });
    }

    public void addDayAfterCheckMonthAndYear() {
        if (checkLeapYear(selectedYear) && selectedMonth == 2) {
            addItemCbxDay(29);
        } else if (!checkLeapYear(selectedYear) && selectedMonth == 2) {
            addItemCbxDay(28);
        } else {
            switch (selectedMonth) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    addItemCbxDay(31);
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    addItemCbxDay(30);
                    break;
                }
            }
        }
    }

    private boolean checkLeapYear(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0));
    }

    private void addItemCbxDay(int maxDay) {
        for (int i = 1; i < maxDay + 1; i++) {
            cbxDay.addItem(i);
        }
    }
}
