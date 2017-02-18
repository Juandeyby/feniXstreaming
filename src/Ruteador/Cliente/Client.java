package Ruteador.Cliente;

import Ruteador.Servidor.TestRemote;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        TestRemote testRemote = (TestRemote) registry.lookup("Test");
        System.out.println(testRemote.sayHello("JavaMexico"));
    }
}