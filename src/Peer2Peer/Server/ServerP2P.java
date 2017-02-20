package Peer2Peer.Server;

import Bean.Amigo;
import Peer2Peer.Bean.VideoStreaming;
import Ruteador.Servidor.*;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServerP2P extends Thread{
  
    private static ServerP2P  instance ;
    private  ArrayList <Amigo>  usuarios = new ArrayList<Amigo>();
    private  Map<Amigo,VideoStreaming> videos= new HashMap<>();
    public static ServerP2P getInstance(){
     if (instance==null)instance= new ServerP2P();
        return instance;
    }
    private ServerP2P (){
        try {
            main(null);
        } catch (RemoteException ex) {
            Logger.getLogger(ServerP2P.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(ServerP2P.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run() {
        try {
            sleep(10000);
            try {
                iniciarEscuchaServer();
            } catch (NotBoundException ex) {
                Logger.getLogger(ServerP2P.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerP2P.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote stub = UnicastRemoteObject.exportObject(new ServerPeticionesEnrutamiento(), 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("ServerPropio", stub);
        System.out.println("se llama al server del cliente y esta corriendo");
    }
    public void iniciarEscuchaServer() throws NotBoundException{
        try {
            Registry registry = LocateRegistry.getRegistry();
            TestRemote testRemote = (TestRemote) registry.lookup("Enrutador");
             ArrayList <Amigo> presente =testRemote.WhoIsThere();
             if (presente.size()>usuarios.size()){
                 for(int i = usuarios.size(); i < presente.size();i++){
                    VideoStreaming stream = new VideoStreaming();
                    stream.run();
                    videos.put(presente.get(i),stream);}
             }
        } catch (RemoteException ex) {
            Logger.getLogger(ServerP2P.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}