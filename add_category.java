import java.io.*;
import javax.swing.*;

public class add_category extends javax.swing.JFrame 
{
    File selectedFile;
    
    public add_category()
    {
        initComponents();
        setSize(400,300);
        setTitle("Add Category");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bt_photo = new javax.swing.JButton();
        lb_photo = new javax.swing.JLabel();
        bt_add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Category Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 70, 98, 16);
        getContentPane().add(tf);
        tf.setBounds(180, 70, 169, 22);

        jLabel2.setText("Photo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 120, 74, 16);

        bt_photo.setText("Select");
        bt_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_photoActionPerformed(evt);
            }
        });
        getContentPane().add(bt_photo);
        bt_photo.setBounds(180, 120, 80, 23);

        lb_photo.setText("jLabel3");
        getContentPane().add(lb_photo);
        lb_photo.setBounds(280, 120, 120, 16);

        bt_add.setText("Add");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add);
        bt_add.setBounds(180, 180, 90, 33);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Add New Category");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 400, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        String catname = tf.getText().trim();
        
        String ans = MyClient.addCategory(catname, selectedFile);
        
        JOptionPane.showMessageDialog(this, ans);
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_photoActionPerformed
        int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans==JFileChooser.APPROVE_OPTION)    // OK
        {
            selectedFile = jFileChooser1.getSelectedFile();
            lb_photo.setText(selectedFile.getName());
        }
    }//GEN-LAST:event_bt_photoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_photo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb_photo;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}