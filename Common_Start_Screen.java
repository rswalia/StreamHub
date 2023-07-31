public class Common_Start_Screen extends javax.swing.JFrame 
{
    public Common_Start_Screen() 
    {
        initComponents();
        setSize(600, 370);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_admin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bt_user = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bt_admin.setText("ADMIN");
        bt_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adminActionPerformed(evt);
            }
        });
        getContentPane().add(bt_admin);
        bt_admin.setBounds(320, 100, 230, 210);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome To My VOD Project");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 60);

        bt_user.setText("USER");
        bt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_userActionPerformed(evt);
            }
        });
        getContentPane().add(bt_user);
        bt_user.setBounds(50, 100, 230, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adminActionPerformed
        
        Admin_Login obj = new Admin_Login();
        obj.setVisible(true);
    }//GEN-LAST:event_bt_adminActionPerformed

    private void bt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_userActionPerformed
        
        start_screen obj = new start_screen();
        obj.setVisible(true);
    }//GEN-LAST:event_bt_userActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Common_Start_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_admin;
    private javax.swing.JButton bt_user;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}