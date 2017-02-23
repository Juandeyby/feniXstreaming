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

import de.root1.simon.Simon;
import Simon.ClientCallbackInterface;
import Simon.ServerInterface;
import de.root1.simon.annotation.SimonRemote;

// mark this class as a remote class and export all methods known in ServerInterface
@SimonRemote(value = {ServerInterface.class}) 
public class ServerInterfaceImpl implements ServerInterface {

   private static final long serialVersionUID = 1L;

   @Override 
   public void login(ClientCallbackInterface clientCallback) {

      clientCallback.callback("This is the callback. " +
         "Your address is "+
         Simon.getRemoteInetSocketAddress(clientCallback).getAddress()+
         " and your are connected from port "+
         Simon.getRemoteInetSocketAddress(clientCallback).getPort());
      System.out.println("el fresy se conecto");
   }
}