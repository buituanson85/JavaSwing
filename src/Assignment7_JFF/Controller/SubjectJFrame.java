
package Assignment7_JFF.Controller;

import Assignment7_JFF.Dao.DBConnection;
import Assignment7_JFF.Dao.SubjectDAO;
import Assignment7_JFF.Model.Subject;
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

public class SubjectJFrame extends javax.swing.JFrame {
        List<Subject> subjectList;
        DefaultTableModel tableModel;

    public SubjectJFrame() {
        initComponents();
        tableModel = (DefaultTableModel) tableSub.getModel();
        showClass();
        
        tableSub.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tableSub.getSelectedRow();
                Subject subject = subjectList.get(index);
                txtNameSub.setText(subject.getName());
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
        subjectList = SubjectDAO.findALl();
        tableModel.setRowCount(0); 
        subjectList.forEach((subject) -> {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                subject.getId(),
                subject.getName()
            });
            });
    }
    
    private void resetData(){
            txtIdSub.setText("");
            txtNameSub.setText("");
            lbIdSub.setText("");
            lbNameSub.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdSub = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNameSub = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSub = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbIdSub = new javax.swing.JLabel();
        lbNameSub = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Add Subject");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Id subject: ");

        txtIdSub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name subject: ");

        txtNameSub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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

        tableSub.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableSub.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableSub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Id subject", "Name subject"
            }
        ));
        jScrollPane1.setViewportView(tableSub);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Danh sách môn học");

        lbIdSub.setForeground(new java.awt.Color(255, 0, 0));
        lbIdSub.setText("  ");

        lbNameSub.setForeground(new java.awt.Color(255, 0, 0));
        lbNameSub.setText("  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(377, 377, 377))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNameSub, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addComponent(txtIdSub, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbIdSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbNameSub, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(btnRest, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdSub, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addComponent(lbIdSub)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameSub, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNameSub)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
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
        Subject subject = new Subject();
        //Kt người nhập đã nhập chưa
        if (txtIdSub.getText().isEmpty() || txtNameSub.getText().isEmpty() || txtNameSub.getText().contains(" ") || txtIdSub.getText().contains(" ")){
            lbIdSub.setText("Error");
            lbNameSub.setText("Error");
            JOptionPane.showMessageDialog(null, "No information entered");
            lbIdSub.setText("");
            lbNameSub.setText("");
            return;
        }
        //kiểm tra đúng định dạng
        boolean check = subject.checkName(txtNameSub.getText());
        boolean check_ = subject.checkValidateRollNo(txtIdSub.getText());
        if(check != true || check_ != true){
        lbIdSub.setText("Error");
        lbNameSub.setText("Error");
        JOptionPane.showMessageDialog(null, "Id or Name entered in wrong format");
        resetData();
        return;
        }
        //check trùng id
        for (Subject _subject : subjectList) {
            if (!_subject.getId().equalsIgnoreCase(txtIdSub.getText()) && !_subject.getName().equalsIgnoreCase(txtNameSub.getText())) {
                lbIdSub.setText("Error");
                lbNameSub.setText("Error");
                JOptionPane.showMessageDialog(null, "The id or name already exists");
                resetData();
                return;

            }
        }
        
        String idSub = txtIdSub.getText();
        String nameSub = txtNameSub.getText();
        SubjectDAO.create( idSub, nameSub);
        JOptionPane.showMessageDialog(this, "Enter successfully");
        showClass();
        resetData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        //Hàm update y/c ko nhập tên đã tồn tại trong mảng
        int index = tableSub.getSelectedRow();
        Subject subject = subjectList.get(index);

        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC update_subject_by_id @nameSub = ?, @idSub = ?";
                preparedStatement = connection.prepareStatement(sql);
                
                boolean check = subject.checkName(txtNameSub.getText());
                if (check != true) {
                    lbNameSub.setText("Error");
                    JOptionPane.showMessageDialog(this, "name already exists");
                    lbNameSub.setText("");
                    return;
                }
                for (Subject subject_ : subjectList) {
                    if (subject_.getName().equalsIgnoreCase(txtNameSub.getText())) {
                        lbNameSub.setText("Error");
                        JOptionPane.showMessageDialog(null, "Name entered in wrong format");
                        lbNameSub.setText("");
                        return;
                    }
                }
                String nameSub = txtNameSub.getText();
                preparedStatement.setString(1, nameSub);
                preparedStatement.setString(2, subject.getId());
                preparedStatement.execute();
                JOptionPane.showMessageDialog(this, "Update was successful");
            } catch (HeadlessException | SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SubjectJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        showClass();
        resetData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

       String input = JOptionPane.showInputDialog(this, "Enter the name you want to search: ");

        if (input != null && input.length() > 0) {
            subjectList = SubjectDAO.searchByName(input);
            tableModel.setRowCount(0);

            subjectList.forEach((subject) -> {
                tableModel.addRow(new Object[]{
                    tableModel.getRowCount() + 1,
                    subject.getId(),
                    subject.getName()
                });
           });
        }else{
            showClass();
        }
        resetData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

         //xóa theo id
        int index = tableSub.getSelectedRow();

        if (index >= 0) {
            Subject subjects = subjectList.get(index);
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this id");
            System.out.println("option: " + option);
            if (option == 0) {
                SubjectDAO.delete(subjects.getId());
                showClass();
            }
        }
        resetData();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new SubjectJFrame().setVisible(true);
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
    private javax.swing.JLabel lbIdSub;
    private javax.swing.JLabel lbNameSub;
    private javax.swing.JTable tableSub;
    private javax.swing.JTextField txtIdSub;
    private javax.swing.JTextField txtNameSub;
    // End of variables declaration//GEN-END:variables
}
