/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframes;

import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class WelcomeScreen extends javax.swing.JFrame {

    /**
     * Creates new form WelcomeScreen
     */
    public WelcomeScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadinglab = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(1650, 950));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadinglab.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loadinglab.setText("Please Wait...");
        jPanel1.add(loadinglab, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 210, 50));

        LoadingBar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LoadingBar.setForeground(new java.awt.Color(255, 153, 51));
        LoadingBar.setStringPainted(true);
        jPanel1.add(LoadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 760, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vidusha\\Desktop\\New folder (4)\\book.gif")); // NOI18N
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WelcomeScreen load = new WelcomeScreen();
        load.setVisible(true);
        
        try
        {
            for(int i = 0; i < 100; i++)
            {
                Thread.sleep(100);
               
                
                if(i == 10){
                    load.loadinglab.setText("Turnning on Modules...");
                }
                if(i == 20){
                    load.loadinglab.setText("Loading Modules...");
                }
                if(i == 50){
                    load.loadinglab.setText("Connecting to Database...");
                }
                if(i == 70){
                    load.loadinglab.setText("Connection Successfull !");
                }
                if(i == 80){
                    load.loadinglab.setText("Launching Application...");
                }
                
                load.LoadingBar.setValue(i);
            }
            load.setVisible(false);
            LoginUp log = new LoginUp();
            log.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

        /* Create and display the form*/
        try{
            
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                   
                }
            }
        }
        catch(ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loadinglab;
    // End of variables declaration//GEN-END:variables
}
