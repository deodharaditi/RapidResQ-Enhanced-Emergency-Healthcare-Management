/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Doctor;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.JSONUtil.Store;
import business.Network.Network;
import business.Organization.LabOrg;
import business.Organization.Organization;
import business.Stakeholders.Doctor;
import business.Stakeholders.Patient;
import business.UserAccount.UserAccount;
import business.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author apara
 */
public class RequestDocLabJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestDocLabJPanel
     */
    JPanel workArea;
    Enterprise enterprise;
    UserAccount userAccount;
    Patient patient;
    EcoSystem ecosystem;
    Organization organization;
    Doctor doctor;
    Network network;

    public RequestDocLabJPanel(JPanel workArea, EcoSystem ecoSystem, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, Doctor doctor, Patient patient) {
        initComponents();
        this.ecosystem = ecoSystem;
        this.workArea = workArea;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.patient = patient;
        this.doctor = doctor;
        this.organization = organization;
        this.network = network;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMessage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnReq = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });
        add(txtMessage);
        txtMessage.setBounds(489, 206, 576, 185);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Message for Patient");
        add(jLabel1);
        jLabel1.setBounds(660, 160, 370, 32);

        btnReq.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnReq.setForeground(new java.awt.Color(0, 0, 102));
        btnReq.setText("Send");
        btnReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReqActionPerformed(evt);
            }
        });
        add(btnReq);
        btnReq.setBounds(746, 409, 72, 27);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 102));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(6, 14, 72, 27);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Doctor/final bg.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 0, 1980, 1100);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMessageActionPerformed

    private void btnReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReqActionPerformed
        // TODO add your handling code here:
        String message = txtMessage.getText();

        LabTestWorkRequest request = new LabTestWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Requested");
        request.setPatient(patient);
        request.setDoctor(doctor);
        request.setLabTestAdminFeedback("Pending");
        request.setRequestdate(new Date());
        System.out.println(patient.getPatientName());

        Organization org = null;
        for (Organization organization : ecosystem.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof LabOrg) {
                org = organization;
                ecosystem.getOrganizationDirectory().getOrganizationList().remove(org);
                org.getWorkQueue().addWorkRequest(request);
                userAccount.getWorkQueue().addWorkRequest(request);
                ecosystem.getOrganizationDirectory().getOrganizationList().add(org);
                Store.save(ecosystem);
                break;
            }
        }
        Store.save(ecosystem);
        JOptionPane.showMessageDialog(null, "Request message sent");
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnReqActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReq;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
}
