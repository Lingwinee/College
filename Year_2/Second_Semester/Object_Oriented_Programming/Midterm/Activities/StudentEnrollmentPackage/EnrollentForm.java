package StudentEnrollmentPackage;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author joopa04
 */
public class EnrollentForm extends javax.swing.JFrame {

    private final List<School> schools = new ArrayList<School>();

    /**
     * Creates new form EnrollentForm
     */
    public EnrollentForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadCatalog();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        lblStudentNumber = new javax.swing.JLabel();
        txtStudentNumber = new javax.swing.JTextField();
        lblStudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        lblSchool = new javax.swing.JLabel();
        cmbSchool = new javax.swing.JComboBox<School>();
        lblDegree = new javax.swing.JLabel();
        cmbDegreeProgram = new javax.swing.JComboBox<DegreeProgram>();
        btnPanel = new javax.swing.JPanel();
        btnProceed = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnViewCourseList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Enrollment - Step 1");
        setMinimumSize(new java.awt.Dimension(760, 420));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setLayout(new java.awt.BorderLayout(0, 8));

        titlePanel.setBackground(new java.awt.Color(255, 255, 255));
        titlePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        titlePanel.setLayout(new java.awt.GridLayout(2, 1));

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0, 102, 153));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Student Enrollment System");
        titlePanel.add(lblHeader);

        subtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitleLabel.setText("Step 1: Student and Program Selection");
        titlePanel.add(subtitleLabel);

        mainPanel.add(titlePanel, java.awt.BorderLayout.PAGE_START);

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Information"));
        formPanel.setLayout(new java.awt.GridBagLayout());

        lblStudentNumber.setText("Student Number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(lblStudentNumber, gridBagConstraints);

        txtStudentNumber.setColumns(18);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(txtStudentNumber, gridBagConstraints);

        lblStudentName.setText("Student Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(lblStudentName, gridBagConstraints);

        txtStudentName.setColumns(24);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(txtStudentName, gridBagConstraints);

        lblSchool.setText("School:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(lblSchool, gridBagConstraints);

        cmbSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSchoolActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(cmbSchool, gridBagConstraints);

        lblDegree.setText("Degree Program:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(lblDegree, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 8, 6, 8);
        formPanel.add(cmbDegreeProgram, gridBagConstraints);

        btnPanel.setBackground(new java.awt.Color(255, 255, 255));
        btnPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));

        btnProceed.setBackground(new java.awt.Color(0, 153, 102));
        btnProceed.setForeground(new java.awt.Color(255, 255, 255));
        btnProceed.setText("Proceed to Course Enrollment");
        btnProceed.setFocusPainted(false);
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });
        btnPanel.add(btnProceed);

        btnClear.setBackground(new java.awt.Color(153, 51, 51));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.setFocusPainted(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        btnPanel.add(btnClear);

        btnViewCourseList.setBackground(new java.awt.Color(70, 70, 70));
        btnViewCourseList.setForeground(new java.awt.Color(255, 255, 255));
        btnViewCourseList.setText("View Program Courses");
        btnViewCourseList.setFocusPainted(false);
        btnViewCourseList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCourseListActionPerformed(evt);
            }
        });
        btnPanel.add(btnViewCourseList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(12, 8, 6, 8);
        formPanel.add(btnPanel, gridBagConstraints);

        mainPanel.add(formPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSchoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSchoolActionPerformed
        loadDegreePrograms((School) cmbSchool.getSelectedItem());
    }//GEN-LAST:event_cmbSchoolActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        Student student = buildStudentFromForm();
        if (student == null) {
            return;
        }

        CourseEnrollmentForm courseWindow = new CourseEnrollmentForm(student);
        courseWindow.setVisible(true);
    }//GEN-LAST:event_btnProceedActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtStudentNumber.setText("");
        txtStudentName.setText("");
        if (cmbSchool.getItemCount() > 0) {
            cmbSchool.setSelectedIndex(0);
            loadDegreePrograms((School) cmbSchool.getSelectedItem());
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnViewCourseListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCourseListActionPerformed
        DegreeProgram degreeProgram = (DegreeProgram) cmbDegreeProgram.getSelectedItem();
        if (degreeProgram == null) {
            showMessage("Select a degree program first.");
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Program: ").append(degreeProgram.toString()).append("\n\n");
        for (Course course : degreeProgram.getCourses()) {
            builder.append("- ").append(course.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, builder.toString(),
                "Available Courses", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnViewCourseListActionPerformed

    private void loadCatalog() {
        schools.clear();
        schools.addAll(EnrollmentCatalog.createSchools());

        DefaultComboBoxModel<School> schoolModel = new DefaultComboBoxModel<School>();
        for (School school : schools) {
            schoolModel.addElement(school);
        }
        cmbSchool.setModel(schoolModel);

        if (schoolModel.getSize() > 0) {
            cmbSchool.setSelectedIndex(0);
            loadDegreePrograms((School) cmbSchool.getSelectedItem());
        }
    }

    private void loadDegreePrograms(School school) {
        DefaultComboBoxModel<DegreeProgram> degreeModel = new DefaultComboBoxModel<DegreeProgram>();
        if (school != null) {
            for (DegreeProgram degreeProgram : school.getDegreePrograms()) {
                degreeModel.addElement(degreeProgram);
            }
        }
        cmbDegreeProgram.setModel(degreeModel);
    }

    private Student buildStudentFromForm() {
        String studentNumber = txtStudentNumber.getText().trim();
        String studentName = txtStudentName.getText().trim();
        School school = (School) cmbSchool.getSelectedItem();
        DegreeProgram degreeProgram = (DegreeProgram) cmbDegreeProgram.getSelectedItem();

        if (studentNumber.isEmpty() || studentName.isEmpty()) {
            showMessage("Enter student number and student name.");
            return null;
        }
        if (school == null || degreeProgram == null) {
            showMessage("Select school and degree program.");
            return null;
        }
        if (degreeProgram.getSchool() != school) {
            showMessage("Selected degree program does not belong to the selected school.");
            return null;
        }

        return new Student(studentNumber, studentName, degreeProgram);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Enrollment", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnrollentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnrollentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnrollentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnrollentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnrollentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnProceed;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnViewCourseList;
    private javax.swing.JComboBox<DegreeProgram> cmbDegreeProgram;
    private javax.swing.JComboBox<School> cmbSchool;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel lblDegree;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblSchool;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblStudentNumber;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JTextField txtStudentNumber;
    // End of variables declaration//GEN-END:variables
}
