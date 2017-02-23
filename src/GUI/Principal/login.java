/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Principal;

import Bean.Amigo;
import Bean.UsuarioLogueado;
import GUI.NodoLocal.InsertarLocal;
import Ruteador.Servidor.TestRemote;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

/**
 *
 * @author USUARIO
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    private UsuarioLogueado usuario = new UsuarioLogueado();

    public login() {
        initComponents();
        // Import ImageIcon     
        ImageIcon iconLogo = new ImageIcon("logo.png");
        // In init() method write this code
        jLabel3.setIcon(iconLogo);
        setResizable(false);
        Image icono = Toolkit.getDefaultToolkit().getImage("minilogo.png");
        this.setIconImage(icono);
        centrarPantalla();
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
        jTUsuarioNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTPasword = new javax.swing.JPasswordField();
        jBLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBLogin1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FeniXtreaming v1.0");
        setPreferredSize(new java.awt.Dimension(400, 350));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(20.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 350));

        jTUsuarioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTUsuarioNombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario :");

        jLabel2.setText("Contraseña :");

        jTPasword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPaswordKeyPressed(evt);
            }
        });

        jBLogin.setBackground(new java.awt.Color(153, 255, 255));
        jBLogin.setForeground(new java.awt.Color(62, 64, 149));
        jBLogin.setText("INGRESAR");
        jBLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoginActionPerformed(evt);
            }
        });

        jLabel3.setText("LOGIN ");

        jBLogin1.setBackground(new java.awt.Color(153, 255, 255));
        jBLogin1.setForeground(new java.awt.Color(62, 64, 149));
        jBLogin1.setText("NUEVO USUARIO");
        jBLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogin1ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bienvenido a la Red más Privada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jBLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTPasword, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(jTUsuarioNombre))))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTUsuarioNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTPasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLogin)
                    .addComponent(jBLogin1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogin1ActionPerformed
        // TODO add your handling code here:
        InsertarLocal local = InsertarLocal.getInstance();
        local.estado(1);
        this.setVisible(false);
        local.limpiar();
        local.setPapa(this);
    }//GEN-LAST:event_jBLogin1ActionPerformed

    private void jBLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoginActionPerformed
        // TODO add your handling code here:
        String usuName = jTUsuarioNombre.getText();
        String contra = jTPasword.getText();
        if (usuario != null) {

            try {
                Registry registry = LocateRegistry.getRegistry();
                TestRemote testRemote = (TestRemote) registry.lookup("Enrutador");
                usuario = new UsuarioLogueado(usuName, contra);

                if (usuario.getAmigoIp() == null) {

                    JOptionPane.showMessageDialog(null, "Nancy causa te weveaste de id o contra");
                    return;
                }

                String host = InetAddress.getLocalHost().getHostAddress();
                String host1 = InsertarLocal.getIp();
                if (!host.contains("127.0")) {
                    usuario.setAmigoIp(host);
                } else if (!host1.equals("0")) {
                    usuario.setAmigoIp(host1);
                }
                
                int random = (int) (Math.floor(Math.random() * 500));

                int porto = Registry.REGISTRY_PORT + 9000 + random;
                usuario.setAmigoPuerto("" + porto);
                ArrayList<Amigo> presentes = testRemote.ImHere(usuario);
                //Amigo.CambiarAmigos(presentes);
                if (presentes == null) {
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                    return;
                }
                System.err.println(usuario.getAmigoNombre());
                for (Amigo amiguito : presentes) {
                    System.out.println("soy el amiguito " + amiguito.getAmigoNombre() + " y estoy presente");

                }
                long a = System.nanoTime();
                Principal prin = new Principal();
                prin.setUsuariosConectados(presentes);
                a = System.nanoTime() - a;
                System.out.print("creacion del objeto " + a);
                prin.setUsuario(usuario);
                long b = System.nanoTime();

                prin.iniciarServer();
                prin.estado(1);
                a = System.nanoTime() - a;
                System.out.print("creacion del objeto " + a);
                this.setVisible(false);

            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jBLoginActionPerformed

    private void jTPaswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPaswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBLoginActionPerformed(null);
        }
    }//GEN-LAST:event_jTPaswordKeyPressed

    private void jTUsuarioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTUsuarioNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTUsuarioNombreActionPerformed
    private void centrarPantalla() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((int) (pantalla.width - ventana.width) / 2, (int) (pantalla.height - ventana.height) / 2);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        
        new NativeDiscovery().discover();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLogin;
    private javax.swing.JButton jBLogin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jTPasword;
    private javax.swing.JTextField jTUsuarioNombre;
    // End of variables declaration//GEN-END:variables

}
