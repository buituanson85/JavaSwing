package JavaII.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {
    private JButton btnStudentList;
    private JButton btnClassList;
    private JPanel panel1;

    public Application() {
        btnStudentList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnClassList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Quản lý sinh viên");
        Application app = new Application();
        jFrame.setContentPane(app.panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setResizable(false);
        jFrame.setSize(200,300);
        jFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
