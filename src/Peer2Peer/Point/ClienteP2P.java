package Peer2Peer.Point;

/*

En este planteo lo que hacemos es reproducir a todos los amigos  sin importar si ellos quieren o no  el strean


 */
import Bean.UsuarioLogueado;
import GUI.Chat.Chat;
import GUI.Chat.Mensaje;
import GUI.Principal.Principal;
import Peer2Peer.Bean.Video;
import Peer2Peer.Bean.VideoStreaming;
import Ruteador.Servidor.ConectServerEnruteador;
import Ruteador.Servidor.TestRemote;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import de.root1.simon.annotation.SimonRemote;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;
import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
@SimonRemote(value = {InterfazCLienteP2p.class}) 

public class ClienteP2P extends Thread  implements InterfazCLienteP2p{

    private Video videito;
    private Principal papa;
    private static ClienteP2P instance;
    private ArrayList<UsuarioLogueado> usuariosConectados = new ArrayList<UsuarioLogueado>();
    private Map<UsuarioLogueado, VideoStreaming> videos = new HashMap<>();
    private Map<Integer, Chat> chatsLocales   = new HashMap<>();
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
           TestRemote testRemote = ConectServerEnruteador.getInstanceOfServerEnruteador();
            ArrayList<UsuarioLogueado> presente = testRemote.WhoIsThere();
           if (papa.getUsuariosConectados().size()> presente.size())
           { papa.setUsuariosConectados(presente);
            papa.getServerPeticiones().DepurarChat();}
            papa.setUsuariosConectados(presente);
  }

    public Video getVideito() {
        return videito;
    }

    public void setVideito(Video videito) {
        this.videito = videito;
    }

    public ArrayList<UsuarioLogueado> getUsuariosConectados() {
        return usuariosConectados;
    }

    public void setUsuariosConectados(ArrayList<UsuarioLogueado> usuariosConectados) {
        this.usuariosConectados = usuariosConectados;
    }

    public Map<UsuarioLogueado, VideoStreaming> getVideos() {
        return videos;
    }

    public void setVideos(Map<UsuarioLogueado, VideoStreaming> videos) {
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

    @Override
    public void EscribirMensaje(Mensaje men, int i) {
        chatsLocales.get(i).getMensajes().add(men);
    }
    
}
