package Ruteador.Servidor;


import Bean.Amigo;
import Bean.UsuarioLogueado;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
public class ServerPeticionesEnrutamiento implements TestRemote {
   private ArrayList<Amigo> amigosPresentes = new ArrayList<Amigo>();  
    @Override
    public dota sayHello(String name) throws RemoteException {
        return new dota();
    
    }

    @Override
    public ArrayList<Amigo> ImHere(Amigo usu) throws RemoteException {
        amigosPresentes.add(usu);
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
