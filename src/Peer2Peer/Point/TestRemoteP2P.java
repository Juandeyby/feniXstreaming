package Peer2Peer.Point;

import Ruteador.Servidor.*;
import Bean.Amigo;
import Peer2Peer.Bean.Video;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface TestRemoteP2P extends Remote {
    dota sayHello(String name) throws RemoteException;
    ArrayList<Video>  tellMeUrVideos() throws RemoteException;  
   Video  OECTmDimeTuVideo()  throws RemoteException;  
   String  TransmitemeTuVideo(String host, int puerto)  throws RemoteException; 
   //Agregar Amigos
   String verificaAmistad(String certificadoOtro) throws RemoteException;
}