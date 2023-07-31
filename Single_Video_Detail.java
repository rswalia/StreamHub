import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Single_Video_Detail extends javax.swing.JFrame 
{
    int vid;
    String vname, description, photo, videolink, trailerlink, catname;
    int runningtime;
    
    public Single_Video_Detail(int vid) 
    {
        initComponents();
        
        lb_photo.setSize(300,350);
        
        setSize(630, 370);
        setTitle("Single Video Detail");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        fetchVideoDetail(vid);
    }
    
    // vid use internally to fetch video details
    void fetchVideoDetail(int vid)
    {
        String ans = MyClient.getSingleVideoDetailFromServer(vid);
        
//        JOptionPane.showMessageDialog(this, ans);
        
        StringTokenizer st = new StringTokenizer(ans, ",");
        
        vname = st.nextToken();
        description = st.nextToken();
        photo = st.nextToken();
        videolink = st.nextToken();
        trailerlink = st.nextToken();
        catname = st.nextToken();
        runningtime = Integer.parseInt(st.nextToken());
        
        
            // PHOTO
            try
            {
                BufferedImage bi = ImageIO.read(new File(photo));
                
                bi = scale(bi, 300, 300);
                
                lb_photo.setIcon(new ImageIcon(bi));
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        
        lb_name.setText(vname);
        jTextArea1.setText(description);
        lb_running.setText(runningtime +" minutes");
        lb_cat.setText(catname);
        
    }

    public BufferedImage scale(BufferedImage src, int w, int h)
    {
        BufferedImage img = 
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_photo = new javax.swing.JLabel();
        lb_cat = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_running = new javax.swing.JLabel();
        bt_movie = new javax.swing.JButton();
        bt_trailer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb_photo.setText("jLabel1");
        getContentPane().add(lb_photo);
        lb_photo.setBounds(0, 0, 270, 340);

        lb_cat.setText("Category");
        getContentPane().add(lb_cat);
        lb_cat.setBounds(340, 140, 190, 16);

        lb_name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lb_name.setText("Name");
        getContentPane().add(lb_name);
        lb_name.setBounds(340, 6, 230, 30);

        lb_running.setText("Running Time");
        getContentPane().add(lb_running);
        lb_running.setBounds(340, 170, 190, 16);

        bt_movie.setText("Play Movie");
        bt_movie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_movieActionPerformed(evt);
            }
        });
        getContentPane().add(bt_movie);
        bt_movie.setBounds(340, 260, 170, 50);

        bt_trailer.setText("Play Trailer");
        bt_trailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_trailerActionPerformed(evt);
            }
        });
        getContentPane().add(bt_trailer);
        bt_trailer.setBounds(340, 200, 170, 50);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 50, 250, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_trailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_trailerActionPerformed
        
        // Desktop class is used to open Desktop applications on the behalf of OS
        try
        {
            Desktop.getDesktop().browse(URI.create(trailerlink));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_bt_trailerActionPerformed

    private void bt_movieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_movieActionPerformed
        
        MyClient.playMovie(videolink);
        
    }//GEN-LAST:event_bt_movieActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Single_Video_Detail(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_movie;
    private javax.swing.JButton bt_trailer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lb_cat;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_photo;
    private javax.swing.JLabel lb_running;
    // End of variables declaration//GEN-END:variables
}