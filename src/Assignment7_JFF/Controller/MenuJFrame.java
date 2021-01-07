
package Assignment7_JFF.Controller;

public class MenuJFrame extends javax.swing.JFrame {

    public MenuJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnCLass = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        btnStudent = new javax.swing.JMenuItem();
        btnSub = new javax.swing.JMenuItem();
        btnSem = new javax.swing.JMenuItem();
        btnMark = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("H:\\JavaApplication\\libs\\abc.png")); // NOI18N
        jLabel1.setLabelFor(this);
        jLabel1.setToolTipText("");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jLabel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(1000, 800));
        jLabel1.setMinimumSize(new java.awt.Dimension(1000, 800));
        jLabel1.setNextFocusableComponent(this);
        jLabel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCLass.setText("Menu");
        btnCLass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setText("Class");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        btnCLass.add(jMenuItem1);

        btnStudent.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnStudent.setText("Student");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        btnCLass.add(btnStudent);

        btnSub.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSub.setText("Subject");
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });
        btnCLass.add(btnSub);

        btnSem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSem.setText("Semester");
        btnSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemActionPerformed(evt);
            }
        });
        btnCLass.add(btnSem);

        btnMark.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMark.setText("Mark");
        btnMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkActionPerformed(evt);
            }
        });
        btnCLass.add(btnMark);

        jMenuBar1.add(btnCLass);

        jMenu2.setText("User");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu9.setText("Edit");
        jMenu9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        this.toBack();
        setVisible(false);
        ClassJFrame cjf = new ClassJFrame();
        cjf.toFront();
        cjf.setState(java.awt.Frame.NORMAL);
        cjf.setLocationRelativeTo(null);
        cjf.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed

        this.toBack();
        setVisible(false);
        StudentJFrame stjf = new StudentJFrame();
        stjf.toFront();
        stjf.setState(java.awt.Frame.NORMAL);
        stjf.setLocationRelativeTo(null);
        stjf.setVisible(true);
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed

        this.toBack();
        setVisible(false);
        SubjectJFrame sjf = new SubjectJFrame();
        sjf.toFront();
        sjf.setState(java.awt.Frame.NORMAL);
        sjf.setLocationRelativeTo(null);
        sjf.setVisible(true);
    }//GEN-LAST:event_btnSubActionPerformed

    private void btnSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemActionPerformed

        this.toBack();
        setVisible(false);
        SemesterJFrame sejf = new SemesterJFrame();
        sejf.toFront();
        sejf.setState(java.awt.Frame.NORMAL);
        sejf.setLocationRelativeTo(null);
        sejf.setVisible(true);
    }//GEN-LAST:event_btnSemActionPerformed

    private void btnMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkActionPerformed

        this.toBack();
        setVisible(false);
        MarkJFrame mjf = new MarkJFrame();
        mjf.toFront();
        mjf.setState(java.awt.Frame.NORMAL);
        mjf.setLocationRelativeTo(null);
        mjf.setVisible(true);
    }//GEN-LAST:event_btnMarkActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            MenuJFrame mjf = new MenuJFrame();
            mjf.setLocationRelativeTo(null);
            mjf.setSize(1050, 850);           
            mjf.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnCLass;
    private javax.swing.JMenuItem btnMark;
    private javax.swing.JMenuItem btnSem;
    private javax.swing.JMenuItem btnStudent;
    private javax.swing.JMenuItem btnSub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
