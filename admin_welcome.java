public class admin_welcome extends javax.swing.JFrame 
{
    public admin_welcome()
    {
        initComponents();
        setSize(500,300);
        setTitle("Admin Welcome");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_vid = new javax.swing.JButton();
        bt_cat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bt_vid.setText("Add Video");
        bt_vid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_vidActionPerformed(evt);
            }
        });
        getContentPane().add(bt_vid);
        bt_vid.setBounds(280, 120, 140, 84);

        bt_cat.setText("Add Category");
        bt_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_catActionPerformed(evt);
            }
        });
        getContentPane().add(bt_cat);
        bt_cat.setBounds(60, 120, 150, 84);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome Admin");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_catActionPerformed
        
        add_category obj = new add_category();
        obj.setVisible(true);
    }//GEN-LAST:event_bt_catActionPerformed

    private void bt_vidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_vidActionPerformed
        
        add_video obj = new add_video();
        obj.setVisible(true);
    }//GEN-LAST:event_bt_vidActionPerformed

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
            java.util.logging.Logger.getLogger(admin_welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cat;
    private javax.swing.JButton bt_vid;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}