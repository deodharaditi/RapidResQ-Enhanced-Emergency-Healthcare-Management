/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Doctor;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Medication.Medicine;
import business.Medication.Prescription;
import business.Network.Network;
import business.Organization.Organization;
import business.Stakeholders.Doctor;
import business.Stakeholders.Patient;
import business.UserAccount.UserAccount;
import business.WorkQueue.GeneralDoctorWorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

/**
 *
 * @author apara
 */
public class PrescriptionJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    //private Prescription prescription;
    private GeneralDoctorWorkRequest docreq;
    private Network network;
    private EcoSystem system;
    private static final String filePath = "./prescription data.txt";
    private Patient patient;
    private Doctor doctor;

    /**
     * Creates new form PrescriptionJPanel
     */
    public PrescriptionJPanel(JPanel workArea, EcoSystem system, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, Patient patient) {
        //System.out.println("Dummycheck1");
        initComponents();
        this.workArea = workArea;
        //this.doctor = doctor;
        //this.patient = patient;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.organization = organization;
        this.network = network;
        this.system = system;
        this.patient = patient;
        //System.out.println("Dummy");
        populatefields();
        populateMedicineCmb();
    }

    public void populatefields() {
        txtName.setText(this.patient.getPatientName());
        txtAge.setText(String.valueOf(this.patient.getAge()));
        txtGender.setText(this.patient.getGender());
    }

    public void populateMedicineCmb() {
        cbMedicine.removeAllItems();
        cbMedicine.addItem("Select");

        for (Medicine med : system.getMedicineDirectory().getMedicineList()) {
            cbMedicine.addItem(med.getMedicineName());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbMedicine = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        noofTimesTxt = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        noofDaysTxt = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 204, 255));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name :");
        add(jLabel2);
        jLabel2.setBounds(638, 171, 50, 21);

        txtName.setEditable(false);
        add(txtName);
        txtName.setBounds(738, 168, 167, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age:");
        add(jLabel3);
        jLabel3.setBounds(656, 216, 32, 21);

        txtAge.setEditable(false);
        add(txtAge);
        txtAge.setBounds(738, 213, 167, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gender:");
        add(jLabel4);
        jLabel4.setBounds(633, 261, 55, 21);

        txtGender.setEditable(false);
        add(txtGender);
        txtGender.setBounds(738, 258, 167, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Medicine:");
        add(jLabel5);
        jLabel5.setBounds(621, 306, 67, 21);

        cbMedicine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbMedicine);
        cbMedicine.setBounds(738, 303, 167, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Times a Day:");
        add(jLabel6);
        jLabel6.setBounds(592, 351, 96, 21);
        add(noofTimesTxt);
        noofTimesTxt.setBounds(738, 348, 167, 22);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("For:");
        add(jLabel7);
        jLabel7.setBounds(648, 396, 40, 21);
        add(noofDaysTxt);
        noofDaysTxt.setBounds(738, 393, 167, 22);

        btnAdd.setText("Add to Prescription");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd);
        btnAdd.setBounds(571, 461, 182, 22);

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 102));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(22, 20, 90, 39);

        jButton2.setText("Send Prescription To Customer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(783, 461, 267, 22);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DOCTOR PRESCRIPTION");
        add(jLabel1);
        jLabel1.setBounds(638, 77, 312, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Doctor/prescription.png"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(1150, 0, 570, 620);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Doctor/final bg.png"))); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(0, 0, 1980, 1100);
    }// </editor-fold>//GEN-END:initComponents

    public void saveRecord(String network, String disease, String medicine, int times, int days) {
        try {
            FileWriter file = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(file);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("Medicine Name - " + medicine + ", No of Times " + times + ", No of Days" + days);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PrescriptionJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Prescription p = new Prescription();
        p.setMedicineName(cbMedicine.getSelectedItem().toString());
        p.setNoofTimesInaday((Integer) noofTimesTxt.getValue());
        p.setTotalDays((Integer) noofDaysTxt.getValue());
        p.setNetworkName(network.getName());

        String age = txtAge.getText();
        boolean flag = true;
        try {
            Integer.parseInt(age);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be integer!");
            flag = false;
            return;
        }

        if (((Integer) noofTimesTxt.getValue()) == 0 || ((Integer) noofDaysTxt.getValue()) == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the no of days or no times !");
            flag = false;
            return;
        }

        System.out.println("cbMedicine.getSelectedIndex() " + cbMedicine.getSelectedIndex());
        if (cbMedicine.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null, "Please select the Medication Name !");
            flag = false;
        }

        if (flag == true) {
            system.getPatientDirectory().deletePatient(patient);
            this.patient.getPrescriptionlist().addPrescription(p);
            system.getPatientDirectory().addPatient(patient);
            //populateWorkRequestTable();
            //saveRecord(p.getNetworkName(),p.getDaignosis(),p.getMedicineName(),p.getNoofTimesInaday(),p.getTotalDays());
            noofTimesTxt.setValue(0);
            noofDaysTxt.setValue(0);
            cbMedicine.setSelectedIndex(0);

        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String prescrip = "";
        for (Prescription prescription : patient.getPrescriptionlist().getPrescriptionList()) {

            prescrip += "Medicine Name : " + prescription.getMedicineName();
            prescrip += ", No of times a Day : " + prescription.getNoofTimesInaday();
            prescrip += ", No of Days" + prescription.getTotalDays();

        }

        //SendEmail(patient.getEmailAddress(),prescrip);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cbMedicine;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner noofDaysTxt;
    private javax.swing.JSpinner noofTimesTxt;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
