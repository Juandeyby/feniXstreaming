/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peer2Peer.Bean;

import Bean.Amigo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Video  implements Serializable{
    private String Descripcion ="descripcion";
    private Amigo usuarioDueño ;
    private int porto=5555;
    private String mrlLocal;
    private int  latencia = 0 ;
    public Video(Amigo dueño, String mrl){
        usuarioDueño = dueño;
        mrlLocal=mrl;
    }
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Amigo getUsuarioDueño() {
        return usuarioDueño;
    }

    public void setUsuarioDueño(Amigo usuarioDueño) {
        this.usuarioDueño = usuarioDueño;
    }

 

    public int getPorto() {
        return porto;
    }

    public void setPorto(int porto) {
        this.porto = porto;
    }

    public String getMrlLocal() {
        return mrlLocal;
    }

    public void setMrlLocal(String mrlLocal) {
        this.mrlLocal = mrlLocal;
    }

    public int getLatencia() {
        return latencia;
    }

    public void setLatencia(int latencia) {
        this.latencia = latencia;
    }

    @Override
    public String toString() {
return Descripcion + "  transmision a " + latencia ;    }
    
}
