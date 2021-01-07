package MiniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniGame implements ActionListener {
    JFrame f;

    public MiniGame() {
        f = new JFrame("Hello");
        f.setSize(920, 400);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JButton b = new JButton();
                b.setBounds(i * 100, j * 40, 100, 40);
                b.addActionListener(this);
                f.add(b);
            }
        }

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int kq = (int) Math.round(Math.random() * 10);

        ((JButton) e.getSource()).setText(String.valueOf(kq));
        ((JButton) e.getSource()).setEnabled(false);

        if (kq == 1) {
//            JOptionPane.showMessageDialog(f, "End game ...");
            int a = JOptionPane.showConfirmDialog(f, "Co choi nua ko ?");
            if (a == JOptionPane.YES_OPTION) {
                Component[] components = f.getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JButton) {
                        ((JButton) component).setEnabled(true);
                        ((JButton) component).setText("");
                    }
                }
            } else {
                System.exit(0);
            }
        }
    }

    public static void main(String[] a) {
        new MiniGame();
    }
}
