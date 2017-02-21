package Peer2Peer.Server;

import Ruteador.Servidor.*;
import Bean.Amigo;
import Bean.Video;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface TestRemoteP2P extends Remote {
    dota sayHello(String name) throws RemoteException;
    ArrayList<Video>  tellMeUrVideos();  
}