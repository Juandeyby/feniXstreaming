/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Utilitarios.Encriptacion;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class test {
    public static void main(String []args) throws Exception{
        try {
            System.out.println(Encriptacion.Desencriptar("qjJvXU2PNnl21YzV3+ZGJaCyKEJ+czTT1mvaMH7R+deq0C/tOqlbRaW+XPChdEWfsicQwZOVkCqcm9SFuUGZb9/9R26+w4Ox8w76Vo0E+NWrT10SdBVBudnQKF+1FE16"));
        } catch (UnknownHostException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
