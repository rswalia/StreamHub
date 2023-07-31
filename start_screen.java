public class start_screen extends javax.swing.JFrame 
{
    public start_screen() 
    {
        initComponents();
        setSize(500,400);
        setTitle("Start Screen");
        
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bt_login = new javax.swing.JButton();
        bt_signup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to MY VOD Project");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 6, 500, 60);

        bt_login.setBackground(new java.awt.Color(255, 153, 153));
        bt_login.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        bt_login.setText("Login Here");
        bt_login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_login);
        bt_login.setBounds(150, 90, 220, 60);

        bt_signup.setBackground(new java.awt.Color(153, 153, 255));
        bt_signup.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        bt_signup.setText("Click here to Signup");
        bt_signup.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        bt_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_signupActionPerformed(evt);
            }
        });
        getContentPane().add(bt_signup);
        bt_signup.setBounds(150, 190, 220, 60);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Made By : Rohit Singh Walia");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 320, 190, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/start_bg.jpg"))); // NOI18N
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 500, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        
        User_Login obj = new User_Login();
        obj.setVisible(true);
        
//        dispose();
    }//GEN-LAST:event_bt_loginActionPerformed

    private void bt_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_signupActionPerformed
        
        User_Signup obj = new User_Signup();
        obj.setVisible(true);
        
//        dispose();
    }//GEN-LAST:event_bt_signupActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new start_screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_login;
    private javax.swing.JButton bt_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}