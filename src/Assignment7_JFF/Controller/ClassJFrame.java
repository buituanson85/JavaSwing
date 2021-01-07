
package Assignment7_JFF.Controller;

import Assignment7_JFF.Dao.ClasssDAO;
import Assignment7_JFF.Dao.DBConnection;
import Assignment7_JFF.Model.Classs;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClassJFrame extends javax.swing.JFrame {
    List<Classs> classList;
    DefaultTableModel tableModel;

    public ClassJFrame() {
        initComponents();
        
        tableModel = (DefaultTableModel) tableClass.getModel();
        showClass();
        
        tableClass.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tableClass.getSelectedRow();
                Classs classs = classList.get(index);
                txtNameClass.setText(classs.getName());
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
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

    private void showClass(){
        classList = ClasssDAO.findALl();
        tableModel.setRowCount(0); 
        classList.forEach((classs) -> {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,  //tạo cột số thự tự, tự động tăng lên 1 khi thêm dòng
                classs.getId(),
                classs.getName()
            });
        });
    }
    
    private void resetData(){
        txtNameClass.setText("");
        txtIdClass.setText("");
        lbIdClass.setText("");
        lbNameClass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdClass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNameClass = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClass = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbIdClass = new javax.swing.JLabel();
        lbNameClass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Add Class");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Id class: ");

        txtIdClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name class: ");

        txtNameClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRest.setText("Reset");
        btnRest.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tableClass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Id class", "Name class"
            }
        ));
        jScrollPane1.setViewportView(tableClass);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Danh sách lớp học");

        lbIdClass.setForeground(new java.awt.Color(255, 0, 0));
        lbIdClass.setText("           ");

        lbNameClass.setForeground(new java.awt.Color(255, 0, 0));
        lbNameClass.setText("     ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(401, 401, 401))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(387, 387, 387))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 117, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnRest, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(90, 90, 90)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNameClass, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                                    .addComponent(txtIdClass, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbIdClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbNameClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(168, 168, 168))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdClass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addComponent(lbIdClass)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameClass, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNameClass)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        //y/c người nhập đúng và đủ ký tự theo hàm checkName, checkValidateRollNo, id và tên lớp không nhập trùng 
        Classs classs = new Classs();
        //Kt người nhập đã nhập chưa
        if (txtIdClass.getText().isEmpty() || txtNameClass.getText().isEmpty() || txtNameClass.getText().contains(" ") || txtIdClass.getText().contains(" ")){
            lbIdClass.setText("Error.");
            lbNameClass.setText("Error.");
            JOptionPane.showMessageDialog(null, "No information entered.");
            lbIdClass.setText("");
            lbNameClass.setText("");
            return;
        }
        //kiểm tra đúng định dạng
        boolean check_ = classs.checkName(txtNameClass.getText());
        boolean __check = classs.checkValidateRollNo(txtIdClass.getText());
        if(check_ != true || __check != true){
            lbIdClass.setText("Error.");
            lbNameClass.setText("Error.");
            JOptionPane.showMessageDialog(null, "Id or Name entered in wrong format.");
            resetData();
            return;
        }
        //check trùng id
        for (Classs _classs : classList) {
            if (_classs.getId().equalsIgnoreCase(txtNameClass.getText()) && _classs.getName().equalsIgnoreCase(txtNameClass.getText())) {
                lbIdClass.setText("Error.");
                lbNameClass.setText("Error.");
                JOptionPane.showMessageDialog(null, "The id or name already exists.");
                resetData();
                return;
            }
        }
        
        String idClass = txtIdClass.getText();
        String nameClass = txtNameClass.getText();
        ClasssDAO.create( idClass, nameClass);
        JOptionPane.showMessageDialog(this, "Enter successfully.");
        showClass();
        resetData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        //Hàm update y/c ko nhập tên đã tồn tại trong mảng
        int index = tableClass.getSelectedRow();
        Classs classs = classList.get(index);
        
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC update_class_by_id @nameClass = ?, @idClass = ?";
                preparedStatement = connection.prepareStatement(sql);

                boolean check = classs.checkName(txtNameClass.getText());
                if (check != true) {
                    lbNameClass.setText("Error.");
                    JOptionPane.showMessageDialog(this, "Name already exists.");
                    lbNameClass.setText("");
                    return;
                }
                for (Classs classs_ : classList) {
                     if (classs_.getName().equalsIgnoreCase(txtNameClass.getText())) {
                         lbNameClass.setText("Error.");
                         JOptionPane.showMessageDialog(null, "Name entered in wrong format.");
                         lbNameClass.setText("");
                         return;
                     }
                 }
                 String nameClass = txtNameClass.getText();
                 preparedStatement.setString(1, nameClass);
                 preparedStatement.setString(2, classs.getId());
                 preparedStatement.execute();
                 JOptionPane.showMessageDialog(this, "Update was successful.");
            } catch (HeadlessException | SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClassJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
         showClass();
         resetData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        //xóa theo id
        int index = tableClass.getSelectedRow();
        
        if (index >= 0) {
            Classs classs = classList.get(index);
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this id.");
            System.out.println("option: " + option);
            if (option == 0) {
                ClasssDAO.delete(classs.getId());
                showClass();
            }
        }
        resetData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        //Hàm tìm kiếm theo tên 
        String input = JOptionPane.showInputDialog(this, "Enter the name you want to search: ");
        
        if (input != null && input.length() > 0) {
            classList = ClasssDAO.searchByName(input);
            tableModel.setRowCount(0);
            
            classList.forEach((classs) -> {
                tableModel.addRow(new Object[]{
                    tableModel.getRowCount() + 1,
                    classs.getId(),
                    classs.getName()
                });
            });
        }else{
            showClass();
        }
        resetData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestActionPerformed

        resetData();
    }//GEN-LAST:event_btnRestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        this.toBack();
        setVisible(false);
        MenuJFrame mjf = new MenuJFrame();
        mjf.toFront();
        mjf.setState(java.awt.Frame.NORMAL);
        mjf.setLocationRelativeTo(null);
        mjf.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed
   
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ClassJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRest;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIdClass;
    private javax.swing.JLabel lbNameClass;
    private javax.swing.JTable tableClass;
    private javax.swing.JTextField txtIdClass;
    private javax.swing.JTextField txtNameClass;
    // End of variables declaration//GEN-END:variables
}
