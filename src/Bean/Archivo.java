/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author USUARIO
 */
public class Archivo {
   private String IdArchivo;
   private String IdAmigoDueño;
   private String IdCanal;
   private String ArchivoNombre;
 private String mrl ;
    public String getIdArchivo() {
        return IdArchivo;
    }

    public void setIdArchivo(String IdArchivo) {
        this.IdArchivo = IdArchivo;
    }

    public String getIdAmigoDueño() {
        return IdAmigoDueño;
    }

    public void setIdAmigoDueño(String IdAmigoDueño) {
        this.IdAmigoDueño = IdAmigoDueño;
    }

    public String getIdCanal() {
        return IdCanal;
    }

    public void setIdCanal(String IdCanal) {
        this.IdCanal = IdCanal;
    }

    public String getArchivoNombre() {
        return ArchivoNombre;
    }

    public void setArchivoNombre(String ArchivoNombre) {
        this.ArchivoNombre = ArchivoNombre;
    }

    public String getMrl() {
        return mrl;
    }

    public void setMrl(String mrl) {
        this.mrl = mrl;
    }
   
} 
