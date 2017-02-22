package Ruteador.Servidor;

import Bean.Amigo;
import Ruteador.Bean.dota;
import Ruteador.Bean.UsuarioConneccion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface TestRemote extends Remote {
    dota sayHello(String name) throws RemoteException;
    ArrayList<Amigo> ImHere(Amigo  usu) throws RemoteException;
    ArrayList<Amigo> ImNotHere(Amigo  usu) throws RemoteException;
    ArrayList<Amigo> WhoIsThere() throws RemoteException;
    ArrayList<Amigo> Login(String user, String password) throws RemoteException;
}