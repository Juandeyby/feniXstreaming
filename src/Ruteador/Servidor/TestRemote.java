package Ruteador.Servidor;

import Bean.InterfazSesion;
import Bean.Sesion;
import Bean.UsuarioLogueado;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import de.root1.simon.annotation.SimonRemote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface TestRemote {
    dota sayHello(String name) ;
    ArrayList<UsuarioLogueado> ImHere(UsuarioLogueado  usu);
    ArrayList<UsuarioLogueado> ImNotHere(UsuarioLogueado  usu) ;
    ArrayList<UsuarioLogueado> WhoIsThere() ;
    ArrayList<UsuarioLogueado> Login(String user, String password);
    UsuarioLogueado ItsMe(UsuarioLogueado us);
    InterfazSesion logueame(UsuarioLogueado us);
    void SalirSesion(Sesion aThis);
}