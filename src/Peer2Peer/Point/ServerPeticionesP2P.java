package Peer2Peer.Point;


import Ruteador.Servidor.*;
import Bean.Amigo;
import Bean.UsuarioLogueado;
import Bean.Video;
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
public class ServerPeticionesP2P implements TestRemoteP2P {
   private ArrayList<Video> videos = new ArrayList<Video>();  

    @Override
    public dota sayHello(String name) throws RemoteException {
        return new dota();
    }

    @Override
    public ArrayList<Video> tellMeUrVideos() {

        return videos;
    }

    @Override
    public ArrayList<Video> OECTmDimeTuVideo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
        
   
}
