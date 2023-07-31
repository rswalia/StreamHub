import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class User_Signup extends javax.swing.JFrame 
{
    File selectedFile;
    
    public User_Signup() 
    {
        initComponents();
        setSize(300, 500);
        setTitle("User Signup");
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pf = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_mobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bt_photo = new javax.swing.JButton();
        bt_signup = new javax.swing.JButton();
        bt_login = new javax.swing.JButton();
        lb_photo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Signup");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 48);

        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 70, 103, 16);
        getContentPane().add(tf_username);
        tf_username.setBounds(40, 90, 217, 22);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 120, 103, 16);
        getContentPane().add(pf);
        pf.setBounds(40, 140, 217, 22);

        jLabel4.setText("Mobile");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 180, 103, 16);
        getContentPane().add(tf_email);
        tf_email.setBounds(40, 260, 217, 22);

        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 240, 103, 16);
        getContentPane().add(tf_mobile);
        tf_mobile.setBounds(40, 200, 217, 22);

        jLabel6.setText("Profile Photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 300, 103, 16);

        bt_photo.setText("Select");
        bt_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_photoActionPerformed(evt);
            }
        });
        getContentPane().add(bt_photo);
        bt_photo.setBounds(120, 300, 108, 23);

        bt_signup.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        bt_signup.setText("SIGNUP");
        bt_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_signupActionPerformed(evt);
            }
        });
        getContentPane().add(bt_signup);
        bt_signup.setBounds(40, 350, 217, 40);

        bt_login.setBackground(new java.awt.Color(204, 204, 255));
        bt_login.setText("Go Back To Login");
        bt_login.setBorder(null);
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_login);
        bt_login.setBounds(40, 400, 220, 40);

        lb_photo.setText("jLabel7");
        getContentPane().add(lb_photo);
        lb_photo.setBounds(240, 300, 330, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_signupActionPerformed
        String u = tf_username.getText().trim();
        String p = pf.getText().trim();
        String m = tf_mobile.getText().trim();
        String e = tf_email.getText().trim();
        
        // check
        if(u.equals("") ||p.equals("") ||m.equals("") ||e.equals(""))
        {
            JOptionPane.showMessageDialog(this, "All Fields are compulsary !!!");
        }
        else if(selectedFile==null)
        {
            JOptionPane.showMessageDialog(this, "Select a photo");
        }
        else
        {
            String ans = MyClient.signupUsingServer(u, p, m, e, selectedFile);
            JOptionPane.showMessageDialog(this, ans);
        }
    }//GEN-LAST:event_bt_signupActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        User_Login obj = new User_Login();
        
        obj.setVisible(true);
    }//GEN-LAST:event_bt_loginActionPerformed

    private void bt_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_photoActionPerformed
        
        int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans==JFileChooser.APPROVE_OPTION)
        {
            selectedFile = jFileChooser1.getSelectedFile();
            lb_photo.setText(selectedFile.getName());
        }
    }//GEN-LAST:event_bt_photoActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_login;
    private javax.swing.JButton bt_photo;
    private javax.swing.JButton bt_signup;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb_photo;
    private javax.swing.JPasswordField pf;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_mobile;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}