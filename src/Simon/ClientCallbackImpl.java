/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simon;

/**
 *
 * @author USUARIO
 */
import de.root1.simon.annotation.SimonRemote;
import Simon.ClientCallbackInterface;

// mark this class as a remote class and export all methods known in ClientCallbackInterface
@SimonRemote(value = {ClientCallbackInterface.class})
public class ClientCallbackImpl implements ClientCallbackInterface {

   private static final long serialVersionUID = 1L;

   @Override 
   public void callback(String text) {

      System.out.println("This message was received from the server: "+text);

   }
} 