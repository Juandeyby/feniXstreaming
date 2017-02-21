/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peer2Peer.Bean;

import Bean.Amigo;

/**
 *
 * @author USUARIO
 */
public class Video {
    private String Descripcion ;
    private Amigo usuarioDueño ;
    private int porto=5555;
    private String mrlLocal;
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

    @Override
    public String toString() {
        return "Video{" + "Descripcion=" + Descripcion + ", usuarioDue\u00f1o=" + usuarioDueño + ", porto=" + porto + ", mrlLocal=" + mrlLocal + '}';
    }
    
}
