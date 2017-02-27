/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruteador.Servidor;

import Bean.UsuarioLogueado;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class ConectServerEnruteador {
     public static TestRemote getInstanceOfServerEnruteador(){
         try {
             Lookup nameLookup = Simon.createNameLookup("192.168.0.100", 22222);
             TestRemote testRemote = (TestRemote) nameLookup.lookup("Enrutador");
             return  testRemote;
         } catch (LookupFailedException ex) {
             Logger.getLogger(ConectServerEnruteador.class.getName()).log(Level.SEVERE, null, ex);
         } catch (EstablishConnectionFailed ex) {
             Logger.getLogger(ConectServerEnruteador.class.getName()).log(Level.SEVERE, null, ex);
         } catch (UnknownHostException ex) {
             Logger.getLogger(ConectServerEnruteador.class.getName()).log(Level.SEVERE, null, ex);
         }
     return null;
     }
     public static void main(String args[]){
     
     TestRemote test =getInstanceOfServerEnruteador();
     UsuarioLogueado de =test.ItsMe(new UsuarioLogueado("pa", "pa"));
     }
}
