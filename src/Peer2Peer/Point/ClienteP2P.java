package Peer2Peer.Point;

/*

En este planteo lo que hacemos es reproducir a todos los amigos  sin importar si ellos quieren o no  el strean


 */
import Bean.Amigo;
import GUI.Principal.Principal;
import Peer2Peer.Bean.Video;
import Peer2Peer.Bean.VideoStreaming;
import Ruteador.Servidor.*;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;
import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteP2P extends Thread {

    private Video videito;
    private Principal papa;
    private static ClienteP2P instance;
    private ArrayList<Amigo> usuariosConectados = new ArrayList<Amigo>();
    private Map<Amigo, VideoStreaming> videos = new HashMap<>();

    public static ClienteP2P getInstance() {
        if (instance == null) {
            instance = new ClienteP2P();
        }
        return instance;
    }

    private ClienteP2P() {

    }

    public ClienteP2P(Principal papa1) {
        papa = papa1;

    }

    public void run() {
        try {
            while (true) {
                sleep(1000);
            
                    iniciarEscuchaServer();
              
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteP2P.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws UnknownHostException, LookupFailedException, EstablishConnectionFailed  {
     Lookup nameLookup = Simon.createNameLookup("190.168.0.160", 22222);
        TestRemote testRemote = (TestRemote) nameLookup.lookup("Enrutador");
        nameLookup.release(testRemote);

        System.out.println("se llama al server del cliente y esta corriendo");
    }

    public void iniciarEscuchaServer() {
  
        try {
           
            Lookup nameLookup = Simon.createNameLookup("192.168.0.160", 22222);
            TestRemote testRemote = (TestRemote) nameLookup.lookup("Enrutador");
            
            ArrayList<Amigo> presente = testRemote.WhoIsThere();
                                    nameLookup.release(testRemote);

            papa.setUsuariosConectados(presente);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteP2P.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LookupFailedException ex) {
            Logger.getLogger(ClienteP2P.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EstablishConnectionFailed ex) {
            Logger.getLogger(ClienteP2P.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public Video getVideito() {
        return videito;
    }

    public void setVideito(Video videito) {
        this.videito = videito;
    }

    public ArrayList<Amigo> getUsuariosConectados() {
        return usuariosConectados;
    }

    public void setUsuariosConectados(ArrayList<Amigo> usuariosConectados) {
        this.usuariosConectados = usuariosConectados;
    }

    public Map<Amigo, VideoStreaming> getVideos() {
        return videos;
    }

    public void setVideos(Map<Amigo, VideoStreaming> videos) {
        this.videos = videos;
    }

    public Principal getPapa() {
        return papa;
    }

    public void setPapa(Principal papa) {
        this.papa = papa;
    }

    public void ReiniciarStreaming() {

    }
}
