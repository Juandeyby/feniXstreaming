/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class test {
    public static void main(String []args){
    UsuarioLogueado usu=     new UsuarioLogueado("io0","io0");
    Amigo a = usu.getUsuario();
    ArrayList  <Canal>  canales= usu.getCanales();
        System.err.println("  nombre  "+ a.getAmigoNombre());
     for (Canal ca: canales){
         System.out.println(ca);
     
     }
    }
    
}
