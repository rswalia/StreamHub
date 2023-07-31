import java.awt.Color;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MyServer_GUI extends javax.swing.JFrame
{
    MyServer obj;
    boolean isServerRunning = false;
    
    public MyServer_GUI() 
    {
        initComponents();
        setSize(400,300);
        setTitle("MyServer_GUI");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_stop = new javax.swing.JButton();
        bt_start = new javax.swing.JButton();
        lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bt_stop.setBackground(new java.awt.Color(255, 102, 102));
        bt_stop.setText("STOP");
        bt_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_stopActionPerformed(evt);
            }
        });
        getContentPane().add(bt_stop);
        bt_stop.setBounds(220, 50, 130, 55);

        bt_start.setBackground(new java.awt.Color(153, 255, 153));
        bt_start.setText("START");
        bt_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_startActionPerformed(evt);
            }
        });
        getContentPane().add(bt_start);
        bt_start.setBounds(50, 50, 130, 55);

        lb.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Click To Start Server");
        getContentPane().add(lb);
        lb.setBounds(0, 150, 400, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_startActionPerformed
        try 
        {
            if(isServerRunning)
            {
                JOptionPane.showMessageDialog(this, "Server is already running");
            }
            else
            {
                obj = new MyServer(9000);
            
                lb.setText("Server Started ...");
                lb.setForeground(Color.BLUE);
                isServerRunning = true;
            }
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_bt_startActionPerformed

    private void bt_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_stopActionPerformed
        
        obj.shutdown();
        
        lb.setText("Server Stopped !!!");
        lb.setForeground(Color.red);
        isServerRunning = false;
    }//GEN-LAST:event_bt_stopActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyServer_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_start;
    private javax.swing.JButton bt_stop;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}