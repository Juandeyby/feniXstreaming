package Peer2Peer.Point;

import Ruteador.Servidor.*;
import Bean.Amigo;
import GUI.Chat.Chat;
import GUI.Chat.Mensaje;
import Peer2Peer.Bean.Video;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;

import java.util.ArrayList;
public interface TestRemoteP2P  {
    dota sayHello(String name) ;
    ArrayList<Video>  tellMeUrVideos();  
   Video  OECTmDimeTuVideo()  ;  
   String  TransmitemeTuVideo(String host, int puerto); 
   //Agregar Amigos
   String verificaAmistad(String certificadoOtro) ;
   void EscribirMensaje(int a , Mensaje men );
      void EscribirMensajeHost(int a , Mensaje men );

   ArrayList<Chat> TellMeYourChats();
}