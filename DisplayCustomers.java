/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGui;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CoOl
 */
public class DisplayCustomers extends javax.swing.JPanel {

    /**
     * Creates new form DisplayConnections
     */
    DefaultTableModel dtm;
    public DisplayCustomers() {
        initComponents();
        dtm=(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        
        Statement st=DBConnection.statementObject();
        String sql="SELECT * FROM customer";
        try{
            ResultSet rs=st.executeQuery(sql);
        
          while(rs.next()){
              dtm.addRow(new Object[]{rs.getInt("cid"),rs.getString("firstname"),rs.getString("middlename"),rs.getString("lastname"),rs.getString("gender"),rs.getString("fathername"),rs.getString("city"),rs.getString("address"),rs.getString("phone"),rs.getString("email"),rs.getString("meterno"),rs.getString("connectiontype"),rs.getString("date")});
          }
            System.out.println("data displayed");
        }catch(Exception e){
            System.out.println("data not displayed");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Customers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 24))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cid", "First Name", "Middle Name", "Last Name", "Gender", "Father's Name", "City", "Address", "Phone", "Email", "Meterno", "Connection Type", "Date of connection"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.PNG"))); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editUser.png"))); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jButton1)
                .addGap(97, 97, 97)
                .addComponent(jButton2)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(175, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int noofselectedrows=jTable1.getSelectedRowCount();
        if(noofselectedrows==1){
         int rowno =jTable1.getSelectedRow();
         Object cid=jTable1.getValueAt(rowno,0);
         
         Statement st=DBConnection.statementObject();
         String sql="Delete FROM customer WHERE cid = "+cid;
          try{
             st.executeUpdate(sql);
             dtm.removeRow(rowno);
             System.out.println("data deleted succesfully");
         }catch(Exception e){
             System.out.println("data not deleted");
         }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int noofselectedrows=jTable1.getSelectedRowCount();
        if(noofselectedrows==1){
            int rowno=jTable1.getSelectedRow();
            Object cid=jTable1.getValueAt(rowno,0);
        MainFrame.ChangePanel(new EditCustomer(cid));
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}