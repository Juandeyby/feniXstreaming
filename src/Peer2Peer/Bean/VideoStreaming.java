/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peer2Peer.Bean;

import Bean.Amigo;
import javax.swing.JOptionPane;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author USUARIO
 */
public class VideoStreaming extends Thread{
    private Video videito ;
    private Amigo receptor;
     private  MediaPlayerFactory mediaPlayerFactory;
    private  EmbeddedMediaPlayer localMediaPlayer;
    public VideoStreaming(Video videito1,Amigo receptor1){
        videito = videito1;
        receptor=receptor1;
        reproducir();
   
   }
    public void run(){
        
    
    }
  public void reproducir(){
        String mrl = videito.getMrlLocal();
        if(mrl.length() > 0) {

                String host = receptor.getAmigoIp();
                int port = Integer.parseInt(receptor.getAmigoPuerto());

                String[] localOptions = {formatRtpStream(host, port), ":no-sout-rtp-sap", ":no-sout-standard-sap", ":sout-all", ":sout-keep",};
 mediaPlayerFactory = new MediaPlayerFactory();
        localMediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
                localMediaPlayer.playMedia(mrl, localOptions);
           
        }
        else {
            JOptionPane.showMessageDialog(null, "You must specify source media, e.g. v4l2:///dev/video0 on Linux or dshow:// on Windows.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
  
  
  }   
  private static String formatRtpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#transcode{vcodec=h264,vb=500,width=480,height=360,acodec=mp3,ab=128,channels=2,samplerate=44100}:duplicate{dst=display,dst=rtp{dst=");
        sb.append(serverAddress);
        sb.append(",port=");
        sb.append(serverPort);
        sb.append(",mux=ts}}");
        return sb.toString();
    } 
}
