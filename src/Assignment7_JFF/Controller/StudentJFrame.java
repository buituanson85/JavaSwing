
package Assignment7_JFF.Controller;

import Assignment7_JFF.Model.Classs;
import Assignment7_JFF.Dao.ClasssDAO;
import Assignment7_JFF.Dao.DBConnection;
import Assignment7_JFF.Model.Student;
import Assignment7_JFF.Dao.StudentDAO;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentJFrame extends javax.swing.JFrame {
    List<Classs> classList;
    List<Student> studentList;
    DefaultTableModel tableModel;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public StudentJFrame() {
        initComponents();
        classList = ClasssDAO.findALl();
        
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) cbNameClass.getModel();
        comboBoxModel.removeAllElements();
        classList.forEach((classs) -> {
            comboBoxModel.addElement(classs.getName());
        });
        
        tableModel = (DefaultTableModel) tableStudent.getModel();
        
        showStudent();
        
        tableStudent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tableStudent.getSelectedRow();
                Student student = studentList.get(index);
                txtNameStudent.setText(student.getName());
                btnDelete.setEnabled(true);
                btnUpdate.setEnabled(true);
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
        private void showStudent(){
            studentList = StudentDAO.findAll();
            tableModel.setRowCount(0); 
            studentList.forEach((student) ->{
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                student.getId(),
                student.getName(),
                student.getAgeStudent(),
                student.getDateStudent(),
                student.getGenderStudent(),
                student.getAddressStudent(),
                student.getPhoneStudent(),
                student.getNameClass()
            });
        });
             }
         private void resetData(){
            txtNameStudent.setText("");
            cbNameClass.setSelectedIndex(0);
            txtIdStudent.setText("");
            txtAgeStudent.setText("");
            txtAddressStudent.setText("");
            txtPhoneStudent.setText("");
            lbIdStudent.setText("");
            lbAge.setText("");
            lbNameStudent.setText("");
            lbAddress.setText("");
            lbPhone.setText("");
         }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNameStudent = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudent = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAgeStudent = new javax.swing.JTextField();
        txtIdStudent = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAddressStudent = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhoneStudent = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbNameClass = new javax.swing.JComboBox<>();
        dateStudents = new com.toedter.calendar.JDateChooser();
        radioMale = new javax.swing.JRadioButton();
        radioFamale = new javax.swing.JRadioButton();
        lbStudentId = new javax.swing.JLabel();
        lbIdStudent = new javax.swing.JLabel();
        lbNameStudent = new javax.swing.JLabel();
        lbAge = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Add Student");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Id student: ");

        txtNameStudent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name student: ");

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

        tableStudent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableStudent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Id student", "Name student", "Age student", "Date student", "Gender student", "Address student", "Phone student", "Name class"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableStudent);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Danh sách sinh vien");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Age student: ");

        txtAgeStudent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtIdStudent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Date student: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Gender student: ");

        txtAddressStudent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Phone student: ");

        txtPhoneStudent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Address student: ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Class name: ");

        cbNameClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbNameClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu" }));
        cbNameClass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dateStudents.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(radioMale);
        radioMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioMale.setSelected(true);
        radioMale.setText("Male");

        buttonGroup1.add(radioFamale);
        radioFamale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        radioFamale.setText("Famale");

        lbStudentId.setForeground(new java.awt.Color(255, 0, 0));
        lbStudentId.setText(" ");

        lbIdStudent.setForeground(new java.awt.Color(255, 0, 0));
        lbIdStudent.setText(" ");

        lbNameStudent.setForeground(new java.awt.Color(255, 0, 0));
        lbNameStudent.setText(" ");

        lbAge.setForeground(new java.awt.Color(255, 0, 0));
        lbAge.setText(" ");

        lbAddress.setForeground(new java.awt.Color(255, 0, 0));
        lbAddress.setText(" ");

        lbPhone.setForeground(new java.awt.Color(255, 0, 0));
        lbPhone.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
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
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(391, 391, 391)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(384, 384, 384)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lbIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lbNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtAgeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(lbAge, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPhoneStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(lbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dateStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(87, 87, 87)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbNameClass, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddressStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioMale)
                        .addGap(18, 18, 18)
                        .addComponent(radioFamale))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lbStudentId))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lbIdStudent))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNameStudent)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(txtAgeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(lbAge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddressStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAddress)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radioMale)
                    .addComponent(radioFamale))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNameClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(txtPhoneStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lbPhone)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
        Student student_ = new Student();
        if(txtIdStudent.getText().isEmpty() || txtIdStudent.getText().contains(" ") || txtNameStudent.getText().isEmpty()
                || txtAddressStudent.getText().isEmpty() || txtPhoneStudent.getText().isEmpty() || txtPhoneStudent.getText().contains(" ")){
            lbIdStudent.setText("Error.");
            lbAge.setText("Error.");
            lbNameStudent.setText("Error.");
            lbAddress.setText("Error");
            lbPhone.setText("Error.");
            JOptionPane.showMessageDialog(null, "No information entered.");
            lbIdStudent.setText("");
            lbAge.setText("");
            lbNameStudent.setText("");
            lbAddress.setText("");
            lbPhone.setText("");
            return;
        }
        //validate 
        if (txtNameStudent.getText().length() <= 3 || txtAddressStudent.getText().length() <= 3 || txtPhoneStudent.getText().length() != 10 
                || Integer.parseInt(txtAgeStudent.getText()) <= 0 || Integer.parseInt(txtAgeStudent.getText()) >= 200) {
                lbAddress.setToolTipText("Error");
                lbPhone.setText("Error.");
                lbNameStudent.setText("Error.");
                lbAge.setText("Error.");
                JOptionPane.showMessageDialog(null, "Entered in wrong format.");
                lbAge.setText("");
                lbNameStudent.setText("");
                lbAddress.setText("");
                lbPhone.setText("");
                return;
        }
        //kiểm tra trùng idStudent
        for (Student student : studentList){
            if (student.getId().equalsIgnoreCase(txtIdStudent.getText())) {
                lbIdStudent.setText("Error.");
                JOptionPane.showMessageDialog(null, "The id already exists.");
                lbIdStudent.setText("");
                return;
            }
        }
        //kiểm tra định dạng idStudent
        boolean check = student_.checkValidateRollNo(txtIdStudent.getText());
        if (check != true) {
            lbIdStudent.setText("Error.");
            JOptionPane.showMessageDialog(null, "The id already exists.");
            lbIdStudent.setText("");
            return;
        }
        
        String idStudent = txtIdStudent.getText();
        String nameStudent = txtNameStudent.getText();
        String genderStudent = "Male";
        if (radioFamale.isSelected()) {
            genderStudent = "Famale";
        }
        int ageStudent = Integer.parseInt(txtAgeStudent.getText());
        String dateStudent = dateFormat.format(this.dateStudents.getDate());

        String addressStudent = txtAddressStudent.getText();
        String phoneStudent = txtPhoneStudent.getText();

        int index = cbNameClass.getSelectedIndex(); 
        Classs classs = classList.get(index);
        String idClass = classs.getId();    
        StudentDAO.insert(idStudent, nameStudent, ageStudent, dateStudent, genderStudent, addressStudent, phoneStudent, idClass);
        JOptionPane.showMessageDialog(this, "Enter successfully.");
        showStudent();
        resetData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        int index = tableStudent.getSelectedRow();
        Student student = studentList.get(index);
        
        String _genderStudent = "Male";
        if (radioFamale.isSelected()) {
            _genderStudent = "Famale";
        }
       
        Connection connection = DBConnection.openConnection();
        if (connection != null) {
            PreparedStatement preparedStatement = null;
            try {
                String sql = "EXEC update_student_by_id @nameStudent = ?, @ageStudent = ?, @dateStudent = ?, @genderStudent = ?,"
                        + " @addressStudent = ?, @phoneStudent = ?, @idClass = ?, @idStudent = ?";
                preparedStatement = connection.prepareStatement(sql);
                    int _index = cbNameClass.getSelectedIndex();
                    Classs classs = classList.get(_index);
                    
                    preparedStatement.setString(1, txtNameStudent.getText());
                    preparedStatement.setInt(2, Integer.parseInt(txtAgeStudent.getText()));
                    preparedStatement.setString(3, dateFormat.format(dateStudents.getDate()));
                    preparedStatement.setString(4, _genderStudent);
                    preparedStatement.setString(5, txtAddressStudent.getText());
                    preparedStatement.setString(6, txtPhoneStudent.getText());
                    preparedStatement.setString(7, classs.getId());
                    preparedStatement.setString(8, student.getId());
                    preparedStatement.execute();
                JOptionPane.showMessageDialog(this, "Update was successful.");
            } catch (HeadlessException | NumberFormatException | SQLException e) {
            }finally{
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        showStudent();
        resetData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String input = JOptionPane.showInputDialog(this, "Enter the name you want to search: ");

        if (input != null && input.length() > 0) {
            studentList = StudentDAO.searchByName(input);
            tableModel.setRowCount(0);

            studentList.forEach((student) -> {
                tableModel.addRow(new Object[]{
                    tableModel.getRowCount() + 1,
                    student.getId(),
                    student.getName(),
                    student.getAgeStudent(),
                    student.getDateStudent(),
                    student.getGenderStudent(),
                    student.getAddressStudent(),
                    student.getPhoneStudent(),
                    student.getNameClass()
                });
            });
        }else{
            showStudent();
        }
        resetData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int index = tableStudent.getSelectedRow();

        if (index >= 0) {
            Student student = studentList.get(index);
            int option = JOptionPane.showConfirmDialog(this, "Do you want to delete this id.");
            System.out.println("Option: " + option);
            if (option == 0) {
                StudentDAO.delete(student.getId());
                showStudent();
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
            new StudentJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRest;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbNameClass;
    private com.toedter.calendar.JDateChooser dateStudents;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbAge;
    private javax.swing.JLabel lbIdStudent;
    private javax.swing.JLabel lbNameStudent;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbStudentId;
    private javax.swing.JRadioButton radioFamale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTable tableStudent;
    private javax.swing.JTextField txtAddressStudent;
    private javax.swing.JTextField txtAgeStudent;
    private javax.swing.JTextField txtIdStudent;
    private javax.swing.JTextField txtNameStudent;
    private javax.swing.JTextField txtPhoneStudent;
    // End of variables declaration//GEN-END:variables
}
