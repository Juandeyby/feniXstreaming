package Ruteador.Servidor;


import Simon.ServerInterfaceImpl;
import java.io.IOException;
import java.net.UnknownHostException;

import de.root1.simon.Registry;
import de.root1.simon.Simon;import de.root1.simon.SimonUnreferenced;
import de.root1.simon.exceptions.NameBindingException;
import java.net.Inet4Address;
import java.net.InetAddress;

public class Server extends Thread implements  SimonUnreferenced{
    
   
    public static void main(String[] args) throws NameBindingException, IOException  {
      
        System.out.println("se llama al server y esta ");
        
        
           ServerPeticionesEnrutamiento serverImpl = new ServerPeticionesEnrutamiento();

        // create the server's registry ...
        Registry registry = Simon.createRegistry(InetAddress.getLocalHost(),22222);
        registry.start();
        // ... where we can bind the serverobject to
        registry.bind("Enrutador", serverImpl);

        
    }

    @Override
    public void unreferenced() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}