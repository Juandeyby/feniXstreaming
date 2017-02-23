package Ruteador.Servidor;

import Bean.Amigo;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import de.root1.simon.annotation.SimonRemote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface TestRemote {
    dota sayHello(String name) ;
    ArrayList<Amigo> ImHere(Amigo  usu);
    ArrayList<Amigo> ImNotHere(Amigo  usu) ;
    ArrayList<Amigo> WhoIsThere() ;
    ArrayList<Amigo> Login(String user, String password);
}