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
public class AmigoLocal extends  Amigo{
     private String ruta ="";
     private String EstadoActual  ;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getEstadoActual() {
        return EstadoActual;
    }

    public void setEstadoActual(String EstadoActual) {
        this.EstadoActual = EstadoActual;
    }
     
}
