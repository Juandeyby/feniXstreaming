/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Local.Conexion.SelectApp;
import Ruteador.Bean.UsuarioConneccion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Canal implements Serializable{

    private int idCanal;
    private String CanalNombre;
    private boolean activo;
    private ArrayList<Amigo> usuarios;
    


    public Canal() {
    }

    public Canal(int id) {
        int idCanal = id;

    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public String getNombreRuteoCanal() {
        return CanalNombre;
    }

    public void setNombreRuteoCanal(String NombreRuteoCanal) {
        this.CanalNombre = NombreRuteoCanal;
    }

    public ArrayList<Amigo> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Amigo> usuarios) {
        this.usuarios = usuarios;
    }

    public void LlenarUsuarios() {

    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Canal{" + "CanalNombre=" + CanalNombre + '}';
    }

}
