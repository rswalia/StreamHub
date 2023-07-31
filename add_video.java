import java.io.*;
import java.util.*;
import javax.swing.*;

public class add_video extends javax.swing.JFrame 
{
    Vector<String> catlist;
    File selectedPoster, selectedVideo;
    
    public add_video() 
    {
        initComponents();
        
        setSize(500, 600);
        setTitle("Add New Video");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        loadCategory();
        
        // show category names of Vector in combobox
        jComboBox1.setModel(new DefaultComboBoxModel<>(catlist));
    }
    
    void loadCategory()
    {
        catlist = new Vector<>();   // give memory
        
        String ans = MyClient.getCategoryFromServer();
//      ans = Action,src/uploads/categories/action.png;
    
        StringTokenizer st  = new StringTokenizer(ans,";");
        
        int n = st.countTokens();
        
        for(int i=1; i<=n; i++)
        {
            String singledata = st.nextToken();     // Action,src/uploads/categories/action.png
            
            StringTokenizer st2 = new StringTokenizer(singledata,",");  // Action
            
            String catname = st2.nextToken();
//            String photo = st2.nextToken();
            
            catlist.add(catname);
            
//            System.out.println(catname);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_title = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_desc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bt_poster = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bt_video = new javax.swing.JButton();
        lb_poster = new javax.swing.JLabel();
        lb_video = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_trailer = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_runtime = new javax.swing.JTextField();
        bt_add = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Video");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 48);

        jLabel2.setText("Title");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 90, 57, 16);
        getContentPane().add(tf_title);
        tf_title.setBounds(180, 90, 230, 22);

        jLabel3.setText("Short Description");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 140, 130, 16);
        getContentPane().add(tf_desc);
        tf_desc.setBounds(180, 140, 233, 22);

        jLabel5.setText("Movie Poster");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 200, 84, 16);

        bt_poster.setText("Select");
        bt_poster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_posterActionPerformed(evt);
            }
        });
        getContentPane().add(bt_poster);
        bt_poster.setBounds(180, 200, 88, 23);

        jLabel6.setText("Video(MP4)");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 260, 84, 16);

        bt_video.setText("Select");
        bt_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_videoActionPerformed(evt);
            }
        });
        getContentPane().add(bt_video);
        bt_video.setBounds(180, 260, 88, 23);

        lb_poster.setText("jLabel7");
        getContentPane().add(lb_poster);
        lb_poster.setBounds(300, 200, 200, 16);

        lb_video.setText("jLabel8");
        getContentPane().add(lb_video);
        lb_video.setBounds(300, 260, 200, 16);

        jLabel9.setText("Trailer (YouTube Link)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 320, 160, 16);
        getContentPane().add(tf_trailer);
        tf_trailer.setBounds(180, 320, 233, 22);

        jLabel10.setText("Category");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 370, 96, 16);

        jLabel11.setText("Running Time (mints)");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 420, 130, 16);
        getContentPane().add(tf_runtime);
        tf_runtime.setBounds(180, 420, 233, 22);

        bt_add.setText("Add Video");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add);
        bt_add.setBounds(180, 490, 113, 42);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(180, 370, 85, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        String title = tf_title.getText().trim();
        String desc = tf_desc.getText().trim();
        String trailer = tf_trailer.getText().trim();
        String catname = jComboBox1.getSelectedItem().toString();
        int runtime = Integer.parseInt(tf_runtime.getText());
        
        String ans = MyClient.addVideo(title, desc, selectedPoster, selectedVideo, trailer, catname, runtime);
        JOptionPane.showMessageDialog(this, ans);
    }//GEN-LAST:event_bt_addActionPerformed

    private void bt_posterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_posterActionPerformed
        
        int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            selectedPoster = jFileChooser1.getSelectedFile();
            lb_poster.setText(selectedPoster.getName());
        }
    }//GEN-LAST:event_bt_posterActionPerformed

    private void bt_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_videoActionPerformed
        
        int ans = jFileChooser2.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            selectedVideo = jFileChooser2.getSelectedFile();
            lb_video.setText(selectedVideo.getName());
        }
    }//GEN-LAST:event_bt_videoActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new add_video().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_poster;
    private javax.swing.JButton bt_video;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_poster;
    private javax.swing.JLabel lb_video;
    private javax.swing.JTextField tf_desc;
    private javax.swing.JTextField tf_runtime;
    private javax.swing.JTextField tf_title;
    private javax.swing.JTextField tf_trailer;
    // End of variables declaration//GEN-END:variables
}