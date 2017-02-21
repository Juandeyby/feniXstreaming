/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peer2Peer.Point;

import Ruteador.Servidor.ServerPeticionesEnrutamiento;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author USUARIO
 */
public class ServerP2P {
    public ServerP2P (String name) throws RemoteException, AlreadyBoundException{
         Remote stub = UnicastRemoteObject.exportObject(new ServerPeticionesEnrutamiento(), 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        registry.bind(name, stub);
        System.out.println("se llama al server del cliente y esta corriendo");
    
    }
}
