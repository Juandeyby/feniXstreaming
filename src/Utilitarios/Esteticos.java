/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author USUARIO
 */
public class Esteticos {
    /***
     * 
     * @param frame la ventana en la cual estas trabajando  y quieres cambiarle el icono 
      * @param imagen la etiqueta a la cual le quieres poner  la imagen logica 
     */
     public static  void ponerImagenIcono(JFrame frame , JLabel imagen){
     
         ImageIcon iconLogo = new ImageIcon("logo.png");
        // In init() method write this code
        imagen.setIcon(iconLogo);
        frame.setResizable(false);
        Image icono = Toolkit.getDefaultToolkit().getImage("minilogo.png");
        frame.setIconImage(icono);
     
     }
}
