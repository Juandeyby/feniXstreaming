package Ruteador.Servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Server {
   
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote stub = UnicastRemoteObject.exportObject(new ServerPeticionesEnrutamiento(), 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind("Enrutador", stub);
        System.out.println("se llama al server y esta ");
    }
}