package Ruteador.Servidor;


import Bean.Amigo;
import Bean.UsuarioLogueado;
import Peer2Peer.Point.TestRemoteP2P;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
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
public class ServerPeticionesEnrutamiento implements TestRemote {
   private ArrayList<Amigo> amigosPresentes = new ArrayList<Amigo>();  
   
   /***
    * @see  lanza un nuevo  un hilo para poder identificar los usuarios presentes 
    * @throws  RemoteException   ,  En realidad el flujo normal usa esta exepcion si alguien lo corrige seria genial 
    */
   public ServerPeticionesEnrutamiento(){
        new Thread(){
            public void run (){
                while (true){
                    ArrayList<Amigo > quienesEstan = new ArrayList<Amigo>();
                    for (Amigo amiguito : amigosPresentes){
                      
                        try {
                            Registry registry = LocateRegistry.getRegistry(amiguito.getAmigoIp(), Integer.parseInt(amiguito.getAmigoPuerto()));
                            String nombreServer = "rmi://" + amiguito.getAmigoIp() + ":" + amiguito.getAmigoPuerto() + "/server";
                             
                            TestRemoteP2P testRemote = (TestRemoteP2P) registry.lookup(nombreServer);
                            quienesEstan.add(amiguito);
                        } catch (RemoteException | NotBoundException ex) {
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
    public dota sayHello(String name) throws RemoteException {
        return new dota();
    
    }

    @Override
    public ArrayList<Amigo> ImHere(Amigo usu) throws RemoteException {
        amigosPresentes.add(usu);
        return amigosPresentes;
    }
        @Override
    public ArrayList<Amigo> ImNotHere(Amigo usu) throws RemoteException {
        amigosPresentes.remove(usu);
        return amigosPresentes;
    }


    @Override
    public ArrayList<Amigo> WhoIsThere() throws RemoteException {
        return amigosPresentes;
    }

    @Override
    public ArrayList<Amigo> Login(String user, String password) throws RemoteException {
        UsuarioLogueado usuario = new UsuarioLogueado(user, password);
            if (usuario==null){
            return null;
            }
                ArrayList<Amigo> presentes = ImHere(usuario);
               
        return presentes;
    }

        
   
}
