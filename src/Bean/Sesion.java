/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Ruteador.Servidor.TestRemote;
import de.root1.simon.SimonUnreferenced;
import de.root1.simon.annotation.SimonRemote;
import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
@SimonRemote(value = {InterfazSesion.class}) 
public class Sesion implements InterfazSesion,SimonUnreferenced , Serializable{
    private  TestRemote Server ;
    private  UsuarioLogueado usu;
    @Override
    public void unreferenced() {
        Server.SalirSesion(this);
    }

    public TestRemote getServer() {
        return Server;
    }

    public void setServer(TestRemote Server) {
        this.Server = Server;
    }

    public UsuarioLogueado getUsu() {
        return usu;
    }

    public void setUsu(UsuarioLogueado usu) {
        this.usu = usu;
    }
    
}
