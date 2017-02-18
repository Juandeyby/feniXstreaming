package Ruteador.Bean;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class UsuarioConneccion implements  Serializable{
     private String ip = "" ;
     private int puerto =5656;

    public UsuarioConneccion() {
    }

    public UsuarioConneccion(String ip1 , int puerto1) {
        ip=ip1;
        puerto=puerto1;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
     
}
