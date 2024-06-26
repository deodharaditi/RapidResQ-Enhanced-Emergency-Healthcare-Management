/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.AdminUnit;

import business.EcoSystem;
import business.Enterprise.Enterprise;
import business.Network.Network;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aditi
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel workArea;
    EcoSystem ecosystem;
    Network network;
    Enterprise enterprise;
    Organization organization;
    UserAccount account;

    public SystemAdminWorkAreaJPanel(JPanel workArea, EcoSystem ecosystem, Network network, Enterprise enterprise, Organization organization, UserAccount account) {
        initComponents();
        this.workArea = workArea;
        this.ecosystem = ecosystem;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        this.account = account;

        populateEntTable();
        populateOrgTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrg = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnt = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        tblOrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane1.setViewportView(tblOrg);

        add(jScrollPane1);
        jScrollPane1.setBounds(640, 590, 562, 164);

        tblEnt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Type"
            }
        ));
        jScrollPane2.setViewportView(tblEnt);

        add(jScrollPane2);
        jScrollPane2.setBounds(640, 280, 562, 164);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 102));
        jButton3.setText("Log Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(300, 140, 160, 60);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View Enterprises");
        add(jLabel1);
        jLabel1.setBounds(670, 220, 460, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("View Organizations");
        add(jLabel2);
        jLabel2.setBounds(650, 540, 640, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/AdminUnit/MicrosoftTeams-image (2).png"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(-10, -10, 1960, 1080);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        ((java.awt.CardLayout) workArea.getLayout()).previous(workArea);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEnt;
    private javax.swing.JTable tblOrg;
    // End of variables declaration//GEN-END:variables

    private void populateEntTable() {

        ArrayList<Enterprise> enterpriseList = ecosystem.getEnterpriseDirectory().getEnterpriseList();

        DefaultTableModel model = (DefaultTableModel) tblEnt.getModel();
        model.setRowCount(0);

        for (Enterprise e : enterpriseList) {
            Object[] row = new Object[2];
            row[0] = e.getName();
            row[1] = e.getEnterpriseType();

            model.addRow(row);
        }
    }

    private void populateOrgTable() {

        ArrayList<Organization> organizationList = ecosystem.getOrganizationDirectory().getOrganizationList();

        DefaultTableModel model = (DefaultTableModel) tblOrg.getModel();
        model.setRowCount(0);

        for (Organization o : organizationList) {
            Object[] row = new Object[1];
            row[0] = o.getName();

            model.addRow(row);
        }
    }
}
