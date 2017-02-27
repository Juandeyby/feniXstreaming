package Ruteador.Servidor;


import Bean.Amigo;
import Bean.InterfazSesion;
import Bean.Sesion;
import Bean.UsuarioLogueado;
import Peer2Peer.Point.TestRemoteP2P;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import Simon.ServerInterface;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import de.root1.simon.SimonUnreferenced;
import de.root1.simon.annotation.SimonRemote;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;
import java.io.Serializable;
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
public class ServerPeticionesEnrutamiento implements TestRemote ,SimonUnreferenced,Serializable {
   private ArrayList<UsuarioLogueado> amigosPresentes = new ArrayList<UsuarioLogueado>();  
   private ArrayList<Sesion> sesions= new ArrayList<>();
   /***
    * @see  lanza un nuevo  un hilo para poder identificar los usuarios presentes 
    * @throws  RemoteException   ,  En realidad el flujo normal usa esta exepcion si alguien lo corrige seria genial 
    */
   public ServerPeticionesEnrutamiento() {
        new Thread(){
            public void run (){
                    while (true){
                          try {
                            sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                        }/*
                        ArrayList<UsuarioLogueado > quienesEstan = new ArrayList<UsuarioLogueado>();
                        for (UsuarioLogueado amiguito : amigosPresentes){


                                String nombreServer = "rmi://" + amiguito.getAmigoIp() + ":" + amiguito.getAmigoPuerto() + "/server";
                                Lookup nameLookup = null;
                            try {
                                nameLookup = Simon.createNameLookup(amiguito.getAmigoIp(),Integer.parseInt( amiguito.getAmigoPuerto()));
                            } catch (UnknownHostException ex) {
                                Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                  TestRemoteP2P testRemote = null;
                            try {
                                testRemote = (TestRemoteP2P)nameLookup.lookup(nombreServer);
                            } catch (LookupFailedException ex) {
                                Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (EstablishConnectionFailed ex) {
                                Logger.getLogger(ServerPeticionesEnrutamiento.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            if(testRemote!=null)
                                quienesEstan.add(amiguito);






                    }
                        amigosPresentes= quienesEstan;
                    */
                    System.out.println("asdasdads ");
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
    public ArrayList<UsuarioLogueado> ImHere(UsuarioLogueado usu)  {
      
        amigosPresentes.add(usu);
        
        return amigosPresentes;
    }
        @Override
    public ArrayList<UsuarioLogueado> ImNotHere(UsuarioLogueado usu){
        amigosPresentes.remove(usu);
        return amigosPresentes;
    }


    @Override
    public ArrayList<UsuarioLogueado> WhoIsThere()  {
        return amigosPresentes;
    }

    @Override
    public ArrayList<UsuarioLogueado> Login(String user, String password){
        UsuarioLogueado usuario = new UsuarioLogueado(user, password);
            if (usuario==null){
            return null;
            }
                ArrayList<UsuarioLogueado> presentes = ImHere(usuario);
               
        return presentes;
    }

    @Override
    public void unreferenced() {
        System.err.println("por q se fue ");
        
    }

    @Override
    public UsuarioLogueado ItsMe(UsuarioLogueado us) {
        return new UsuarioLogueado();

    }

    @Override
    public void SalirSesion(Sesion aThis) {
       amigosPresentes.remove(aThis.getUsu());
        sesions.remove(aThis);
    }

    @Override
    public InterfazSesion logueame(UsuarioLogueado us) {
        
        Sesion se = new Sesion();
       se.setUsu(us);
        se.setServer(this);
        
        return se ;
    }

        
   
}
