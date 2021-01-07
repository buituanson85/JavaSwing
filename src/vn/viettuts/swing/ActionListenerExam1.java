/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.viettuts.swing;

/**
 *
 * @author Admin
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
 
public class ActionListenerExam1 {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
 
    public ActionListenerExam1(){
       prepareGUI();
    }
 
    public static void main(String[] args) {
        ActionListenerExam1 demo = new ActionListenerExam1();
        demo.showActionListenerDemo();
    }
 
    private void prepareGUI() {
        mainFrame = new JFrame("Vi du Java Swing");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
        mainFrame.setTitle("Ví dụ ActionListener trong Java Swing");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
 
    private void showActionListenerDemo() {
        headerLabel.setText("Listener in action: ActionListener");
        JPanel panel = new JPanel();
        panel.setBackground(Color.magenta);
 
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new CustomActionListener());
        panel.add(okButton);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
 
    class CustomActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            statusLabel.setText("Ok Button Clicked.");
        }
    }
}
