import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;

public class welcome extends javax.swing.JFrame
{
//    File bg = new File("src/uploads/Background/bg.jpg");
    
    public welcome(String u)
    {
        initComponents();
        
        // Name
        lb_welcome.setText("Welcome "+u);
        
        // Photo
        String ph = MyClient.getUserDetailFromServer(u);
        ImageIcon icon = new ImageIcon(ph);
        lb_photo.setIcon(icon);
        
//        try
//        {
//            BufferedImage bi = ImageIO.read(bg);
//            bi = scale(bi, 1200, 600);
//            jLabel1.setIcon(new ImageIcon(bi));
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
        
        setSize(1200,600);
        setTitle("Welcome Screen");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        lb_welcome = new javax.swing.JLabel();
        lb_photo = new javax.swing.JLabel();
        bt_load_cat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb_welcome.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lb_welcome.setForeground(new java.awt.Color(255, 51, 51));
        lb_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_welcome.setText("jLabel1");
        getContentPane().add(lb_welcome);
        lb_welcome.setBounds(10, 10, 380, 80);

        lb_photo.setText("photo");
        getContentPane().add(lb_photo);
        lb_photo.setBounds(560, 10, 170, 170);

        bt_load_cat.setBackground(new java.awt.Color(204, 204, 255));
        bt_load_cat.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        bt_load_cat.setText("Load Category");
        bt_load_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_load_catActionPerformed(evt);
            }
        });
        getContentPane().add(bt_load_cat);
        bt_load_cat.setBounds(150, 110, 230, 60);

        jLabel1.setText("Bg");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_load_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_load_catActionPerformed
        
        String ans = MyClient.getCategoryFromServer();
        
//        JOptionPane.showMessageDialog(this, ans);
//        System.out.println(ans);
        
        drawDynamicButtons(ans);
    }//GEN-LAST:event_bt_load_catActionPerformed

    
    void drawDynamicButtons(String ans)
    {
        StringTokenizer st  = new StringTokenizer(ans,";");
        
        int n = st.countTokens();
        
//        System.out.println("No of tokens "+n);
        
        for(int i=1; i<=n; i++)
        {
            String singledata = st.nextToken();
            
            StringTokenizer st2 = new StringTokenizer(singledata,",");
            
            String catname = st2.nextToken();   // Action
            String photo = st2.nextToken();     // https://picsum.photos/200/300?random=1
            
            JButton bt = new JButton();
            
//            System.out.println(catname);
//            System.out.println(photo);
            
            // NAME
            bt.setText(catname);
            
            bt.setVerticalTextPosition(SwingConstants.BOTTOM);
            bt.setHorizontalTextPosition(SwingConstants.CENTER);

            // Online PHOTO
            try
            {
//                URL imageURL = new URL(photo);
                ImageIcon icon = new ImageIcon(photo);
                bt.setIcon(icon);
                
//                System.out.println(photo);
            }
            catch(Exception ex)
            {
              ex.printStackTrace();
            }
            
            bt.setBounds((220*i),300,200,200);
            
            add(bt);
            
            bt.addActionListener(new ActionListener() 
            {
                // Anonymous Inner Class
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    // logic
                    View_Videos obj = new View_Videos(catname);
                    obj.setVisible(true);
                }
            });
        }
        
        setVisible(false);
        setVisible(true);
    }

    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_load_cat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_photo;
    private javax.swing.JLabel lb_welcome;
    // End of variables declaration//GEN-END:variables
}