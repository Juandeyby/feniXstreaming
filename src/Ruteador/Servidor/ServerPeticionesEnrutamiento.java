package Ruteador.Servidor;


import Bean.Amigo;
import Bean.UsuarioLogueado;
import Peer2Peer.Point.TestRemoteP2P;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import Simon.ServerInterface;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import de.root1.simon.annotation.SimonRemote;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
@SimonRemote(value = {TestRemote.class}) 

public class ServerPeticionesEnrutamiento implements TestRemote {
   private ArrayList<Amigo> amigosPresentes = new ArrayList<Amigo>();  
   
   /***
    * @see  lanza un nuevo  un hilo para poder identificar los usuarios presentes 
    * @throws  RemoteException   ,  En realidad el flujo normal usa esta exepcion si alguien lo corrige seria genial 
    */
   public ServerPeticionesEnrutamiento() {
        new Thread(){
            public void run (){
                while (true){
                    ArrayList<Amigo > quienesEstan = new ArrayList<Amigo>();
                    for (Amigo amiguito : amigosPresentes){
                    
                        try {
                            String nombreServer = "rmi://" + amiguito.getAmigoIp() + ":" + amiguito.getAmigoPuerto() + "/server";
                            Lookup nameLookup = Simon.createNameLookup(amiguito.getAmigoIp(),Integer.parseInt( amiguito.getAmigoPuerto()));
                            
                            
                            TestRemoteP2P testRemote = (TestRemoteP2P)nameLookup.lookup(nombreServer);
                            quienesEstan.add(amiguito);
                        } catch (UnknownHostException ex) {
                            Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (LookupFailedException ex) {
                            Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (EstablishConnectionFailed ex) {
                            Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        
                            
                
                
                }
                    amigosPresentes= quienesEstan;
                    try {
                        sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (Amigo  amiguito :amigosPresentes){
                        System.out.println("hola soy el amigo "+amiguito.getAmigoLogueoName()+" y estoy vivito y coleando ");
                    
                    }
                }
                
            
            
            }
        
        
        }.start();
    
    
    
    }
    public dota sayHello(String name)  {
        return new dota();
    
    }

    @Override
    public ArrayList<Amigo> ImHere(Amigo usu)  {
        amigosPresentes.add(usu);
        return amigosPresentes;
    }
        @Override
    public ArrayList<Amigo> ImNotHere(Amigo usu){
        amigosPresentes.remove(usu);
        return amigosPresentes;
    }


    @Override
    public ArrayList<Amigo> WhoIsThere()  {
        return amigosPresentes;
    }

    @Override
    public ArrayList<Amigo> Login(String user, String password){
        UsuarioLogueado usuario = new UsuarioLogueado(user, password);
            if (usuario==null){
            return null;
            }
                ArrayList<Amigo> presentes = ImHere(usuario);
               
        return presentes;
    }

        
   
}
