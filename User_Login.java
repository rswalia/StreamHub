import javax.swing.JOptionPane;

public class User_Login extends javax.swing.JFrame 
{
    public User_Login() 
    {
        initComponents();
        setSize(300,400);
        setTitle("User Login");
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pf = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bt_signup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 6, 300, 41);

        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 80, 125, 16);
        getContentPane().add(tf);
        tf.setBounds(40, 100, 211, 33);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 150, 125, 16);
        getContentPane().add(pf);
        pf.setBounds(40, 170, 211, 33);

        bt_login.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        bt_login.setText("LOGIN");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_login);
        bt_login.setBounds(40, 220, 211, 33);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("New User?");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(41, 289, 66, 16);

        bt_signup.setBackground(new java.awt.Color(204, 204, 255));
        bt_signup.setText("Signup");
        bt_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_signupActionPerformed(evt);
            }
        });
        getContentPane().add(bt_signup);
        bt_signup.setBounds(119, 286, 101, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        String u = tf.getText().trim();
        String p = pf.getText().trim();
        
        String ans = MyClient.checkLogin(u, p);
        JOptionPane.showMessageDialog(this, ans);
        
        if(ans.equalsIgnoreCase("Login Successfull ..."))
        {
            System.out.println("if executed");
            
            welcome obj = new welcome(u);
            obj.setVisible(true);
        }
    }//GEN-LAST:event_bt_loginActionPerformed

    private void bt_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_signupActionPerformed
        User_Signup obj = new User_Signup();
        
        obj.setVisible(true);
    }//GEN-LAST:event_bt_signupActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_login;
    private javax.swing.JButton bt_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pf;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}