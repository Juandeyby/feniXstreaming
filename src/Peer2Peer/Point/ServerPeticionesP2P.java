package Peer2Peer.Point;

import Ruteador.Servidor.*;
import Bean.Amigo;
import Bean.UsuarioLogueado;
import GUI.Principal.Principal;
import Local.Conexion.SelectApp;
import Peer2Peer.Bean.Video;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import de.root1.simon.annotation.SimonRemote;
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
@SimonRemote(value = {TestRemoteP2P.class}) 

public class ServerPeticionesP2P implements TestRemoteP2P {

    private ArrayList<Video> videos = new ArrayList<Video>();
    private Video VidoeoUnico;
    private ArrayList<HeadlessMediaPlayer> streaming = new ArrayList<>();
    

    @Override
    public dota sayHello(String name) {
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


    /***
     * @return mrl  :el mrl del punto del cual se podra recepcionar 
     * se usa en la clase canalGUI
     * @see trasmitira el video al host y puerto indicado , el metodo de transferencia sera rtp
     */
    public String TransmitemeTuVideo(String host, int port){
        String mrl = VidoeoUnico.getMrlLocal();

         String media = mrl;
        String options = formatRtpStream(host, port);


        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
        mediaPlayer.playMedia(media,
            options,
            ":no-sout-rtp-sap",
            ":no-sout-standard-sap",
            ":sout-all",
            ":sout-keep"
        );
        mrl = "rtp://@" +host+":"+port;
       streaming.add(mediaPlayer);

        return mrl;
    }
 /***
  * 
  * @param serverAddress  parametro de entrada es el host al cual queremos trasminitr
  * @param serverPort  puerto del host al qur se desea trasmiti
  * @return valor formateado para la transmisicon via rtp
  */
     private static String formatRtpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);

        sb.append(":sout=#transcode{vcodec=mp4v,vb=2048,scale=1,acodec=mpga,ab=128,channels=2,samplerate=44100}:rtp{dst=");
        sb.append(serverAddress);
        sb.append(",port=");
        sb.append(serverPort);
        sb.append(",mux=ts}");
        return sb.toString();
    }



    @Override
    public String verificaAmistad(String certificadoOtro)  {
        String condicion = null;
        Principal pri = new Principal();
        Amigo amigo = pri.getUsuario();
        try {
            String sql = "select AmigoCondicion from  amigo  where "
                    + " AmigoDeQueNodo = '" + amigo.getIdAmigo() + "' and AmigoCertificado = '"
                    + certificadoOtro + "'";

            SelectApp conexion = new SelectApp();
            Connection conn = conexion.connect();
            Statement sent = conn.createStatement();
            System.out.println(sql);
            ResultSet rs = sent.executeQuery(sql);
            if (rs.next()) {
                condicion = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerPeticionesP2P.class.getName()).log(Level.SEVERE, null, ex);
        }
        return condicion;
    }
    public void Cordinar( int tiempo ){
         
    
    }
}
