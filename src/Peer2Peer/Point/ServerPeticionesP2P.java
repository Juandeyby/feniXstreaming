package Peer2Peer.Point;

import Ruteador.Servidor.*;
import Bean.Amigo;
import Bean.UsuarioLogueado;
import Peer2Peer.Bean.Video;
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
import javax.swing.JOptionPane;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class ServerPeticionesP2P implements TestRemoteP2P {

    private ArrayList<Video> videos = new ArrayList<Video>();
    private Video VidoeoUnico;
    private ArrayList<EmbeddedMediaPlayer> video = new ArrayList<>();

    @Override
    public dota sayHello(String name) throws RemoteException {
        return new dota();
    }

    @Override
    public ArrayList<Video> tellMeUrVideos() {

        return videos;
    }

    @Override
    public Video OECTmDimeTuVideo() {

        return VidoeoUnico;

    }

    public Video getVidoeoUnico() {
        return VidoeoUnico;
    }

    public void setVidoeoUnico(Video VidoeoUnico) {
        this.VidoeoUnico = VidoeoUnico;
    }

    @Override
    public String TransmitemeTuVideo(String host, int port) throws RemoteException {
        String mrl = VidoeoUnico.getMrlLocal();

        String[] localOptions = {formatRtpStream(host, port), ":no-sout-rtp-sap", ":no-sout-standard-sap", ":sout-all", ":sout-keep",};
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        EmbeddedMediaPlayer localMediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();

        localMediaPlayer.playMedia(mrl, localOptions);

        return mrl;
    }

    private static String formatRtpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#transcode{vcodec=h264,vb=500,width=480,height=360,acodec=mp3,ab=128,channels=2,samplerate=44100}");
        sb.append(serverAddress);
        sb.append(",port=");
        sb.append(serverPort);
        sb.append(",mux=ts}}");
        return sb.toString();
    }

}
