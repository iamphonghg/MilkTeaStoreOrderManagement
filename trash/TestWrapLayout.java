package trash;

import model.WrapLayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestWrapLayout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setSize(610, 636);

                JPanel pnl = new JPanel();
                f.add(pnl);
                pnl.setLayout(null);
                JButton btn = new JButton("MILK TEA");
                btn.setBounds(10, 10, 50, 50);
                pnl.add(btn);
                //btn.setPreferredSize(new Dimension(100, 100));
                JSpinner spinner = new JSpinner();
                spinner.setBounds(10, 100 , 50, 50);
                pnl.add(spinner);
                btn.addMouseListener(new PopUpClickListener());
            }
        });

    }

    public static class PopUp extends JPopupMenu {

        public PopUp() {
            JPanel pnl = new JPanel();
            this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            this.setPopupSize(100, 100);
            pnl.setLayout(null);
            //pnl.setSize(100, 100);
            pnl.setBackground(Color.WHITE);
            JButton btn1 = new JButton("1");
            btn1.setBounds(10, 10, 50, 50);
            JLabel lbl = new JLabel("Label");
            lbl.setBounds(10, 60, 100, 10);
            pnl.add(btn1);
            pnl.add(lbl);
            //SpinnerModel sm = new SpinnerNumberModel();
            JSpinner sp = new JSpinner();
            sp.setBounds(10, 70, 50, 50);
            pnl.add(sp);

            this.add(pnl);
        }

    }

    static class PopUpClickListener implements MouseListener {


        public void doPop(MouseEvent e) {
            PopUp p = new PopUp();
            p.show(e.getComponent(), e.getX(), e.getY());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            doPop(e);
        }

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