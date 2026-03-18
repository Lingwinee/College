package StudentEnrollmentPackage;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CourseEnrollmentForm extends javax.swing.JFrame {

    private final Student student;
    private final Map<String, Course> enrolledCourseMap = new HashMap<String, Course>();
    private DefaultTableModel enrolledModel;

    public CourseEnrollmentForm(Student student) {
        this.student = student;
        initComponents();
        setLocationRelativeTo(null);
        initializeTable();
        loadCourses();
        updateStudentLabels();
        updateTotalUnitsLabel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        detailsPanel = new javax.swing.JPanel();
        lblStudent = new javax.swing.JLabel();
        lblStudentValue = new javax.swing.JLabel();
        lblProgram = new javax.swing.JLabel();
        lblProgramValue = new javax.swing.JLabel();
        selectionPanel = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        cmbCourse = new javax.swing.JComboBox<Course>();
        btnPanel = new javax.swing.JPanel();
        btnEnroll = new javax.swing.JButton();
        btnDrop = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        scrollEnrolled = new javax.swing.JScrollPane();
        tblEnrolled = new javax.swing.JTable();
        lblTotalUnits = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Course Enrollment");
        setMinimumSize(new java.awt.Dimension(880, 540));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setLayout(new java.awt.BorderLayout(0, 10));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0, 120, 90));
        lblHeader.setText("Step 2 - Course Enrollment");
        headerPanel.add(lblHeader);

        mainPanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        detailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        detailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Student and Program"));
        detailsPanel.setLayout(new java.awt.GridBagLayout());

        lblStudent.setText("Student:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 8);
        detailsPanel.add(lblStudent, gridBagConstraints);

        lblStudentValue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStudentValue.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 8);
        detailsPanel.add(lblStudentValue, gridBagConstraints);

        lblProgram.setText("Program:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 8);
        detailsPanel.add(lblProgram, gridBagConstraints);

        lblProgramValue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProgramValue.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 8);
        detailsPanel.add(lblProgramValue, gridBagConstraints);

        mainPanel.add(detailsPanel, java.awt.BorderLayout.WEST);

        selectionPanel.setBackground(new java.awt.Color(255, 255, 255));
        selectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Course"));
        selectionPanel.setLayout(new java.awt.GridBagLayout());

        lblCourse.setText("Available Courses:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        selectionPanel.add(lblCourse, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        selectionPanel.add(cmbCourse, gridBagConstraints);

        btnPanel.setBackground(new java.awt.Color(255, 255, 255));
        btnPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));

        btnEnroll.setBackground(new java.awt.Color(0, 153, 102));
        btnEnroll.setForeground(new java.awt.Color(255, 255, 255));
        btnEnroll.setText("Enroll");
        btnEnroll.setFocusPainted(false);
        btnEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollActionPerformed(evt);
            }
        });
        btnPanel.add(btnEnroll);

        btnDrop.setBackground(new java.awt.Color(204, 102, 0));
        btnDrop.setForeground(new java.awt.Color(255, 255, 255));
        btnDrop.setText("Drop Selected");
        btnDrop.setFocusPainted(false);
        btnDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropActionPerformed(evt);
            }
        });
        btnPanel.add(btnDrop);

        btnBack.setBackground(new java.awt.Color(70, 70, 70));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        btnPanel.add(btnBack);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 6, 8);
        selectionPanel.add(btnPanel, gridBagConstraints);

        mainPanel.add(selectionPanel, java.awt.BorderLayout.NORTH);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enrolled Courses"));
        tablePanel.setLayout(new java.awt.BorderLayout(0, 8));

        tblEnrolled.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Title", "Units"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        scrollEnrolled.setViewportView(tblEnrolled);

        tablePanel.add(scrollEnrolled, java.awt.BorderLayout.CENTER);

        lblTotalUnits.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalUnits.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalUnits.setText("Total Units: 0 / 24");
        tablePanel.add(lblTotalUnits, java.awt.BorderLayout.PAGE_END);

        mainPanel.add(tablePanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
        Course selectedCourse = (Course) cmbCourse.getSelectedItem();
        if (selectedCourse == null) {
            showMessage("Select a course to enroll.");
            return;
        }
        if (enrolledCourseMap.containsKey(selectedCourse.getCode())) {
            showMessage("Course is already enrolled.");
            return;
        }
        if (!student.enrollCourse(selectedCourse)) {
            showMessage("Cannot enroll. Maximum allowed is " + Student.MAX_UNITS + " units.");
            return;
        }

        enrolledCourseMap.put(selectedCourse.getCode(), selectedCourse);
        enrolledModel.addRow(new Object[]{
            selectedCourse.getCode(),
            selectedCourse.getTitle(),
            Integer.valueOf(selectedCourse.getUnits())
        });
        updateTotalUnitsLabel();
    }//GEN-LAST:event_btnEnrollActionPerformed

    private void btnDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropActionPerformed
        int selectedRow = tblEnrolled.getSelectedRow();
        if (selectedRow < 0) {
            showMessage("Select a course in the table to drop.");
            return;
        }

        String courseCode = String.valueOf(enrolledModel.getValueAt(selectedRow, 0));
        Course course = enrolledCourseMap.remove(courseCode);
        if (course != null) {
            student.dropCourse(course);
        }

        enrolledModel.removeRow(selectedRow);
        updateTotalUnitsLabel();
    }//GEN-LAST:event_btnDropActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void initializeTable() {
        enrolledModel = (DefaultTableModel) tblEnrolled.getModel();
        enrolledModel.setRowCount(0);
    }

    private void loadCourses() {
        DefaultComboBoxModel<Course> model = new DefaultComboBoxModel<Course>();
        if (student.getDegreeProgram() != null) {
            for (Course course : student.getDegreeProgram().getCourses()) {
                model.addElement(course);
            }
        }
        cmbCourse.setModel(model);
    }

    private void updateStudentLabels() {
        lblStudentValue.setText(student.getStudentNumber() + " - " + student.getFullName());
        lblProgramValue.setText(student.getDegreeProgram().getSchool().getName() + " | "
                + student.getDegreeProgram().toString());
    }

    private void updateTotalUnitsLabel() {
        lblTotalUnits.setText("Total Units: " + student.getTotalUnits() + " / " + Student.MAX_UNITS);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Enrollment", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDrop;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JComboBox<Course> cmbCourse;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblProgram;
    private javax.swing.JLabel lblProgramValue;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblStudentValue;
    private javax.swing.JLabel lblTotalUnits;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollEnrolled;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tblEnrolled;
    // End of variables declaration//GEN-END:variables
}
