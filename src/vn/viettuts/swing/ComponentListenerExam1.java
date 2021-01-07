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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
 
public class ComponentListenerExam1 {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
 
    public ComponentListenerExam1() {
        prepareGUI();
    }
 
    public static void main(String[] args) {
        ComponentListenerExam1 demo = new ComponentListenerExam1();
        demo.showComponentListenerDemo();
    }
 
    private void prepareGUI() {
        mainFrame = new JFrame("");
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
 
    private void showComponentListenerDemo() {
        headerLabel.setText("Listener: ComponentListener");
 
        JPanel panel = new JPanel();
        panel.setBackground(Color.magenta);
        JLabel msglabel = new JLabel("Vi du ComponentListener trong Java Swing."
                , JLabel.CENTER);
        panel.add(msglabel);
 
        msglabel.addComponentListener(new CustomComponentListener());
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
 
    class CustomComponentListener implements ComponentListener {
 
        public void componentResized(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText() 
                    + e.getComponent().getClass().getSimpleName() + " resized. ");
        }
 
        public void componentMoved(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText() 
                    + e.getComponent().getClass().getSimpleName() + " moved. ");
        }
 
        public void componentShown(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText() 
                    + e.getComponent().getClass().getSimpleName() + " shown. ");
        }
 
        public void componentHidden(ComponentEvent e) {
            statusLabel.setText(statusLabel.getText() 
                    + e.getComponent().getClass().getSimpleName() + " hidden. ");
        }
    }
}
