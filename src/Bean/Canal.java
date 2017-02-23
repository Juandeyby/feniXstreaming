/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Local.Conexion.SelectApp;
import Ruteador.Bean.UsuarioConneccion;
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
public class Canal {

    private int idCanal;
    private String CanalNombre;
    private boolean activo;
    private ArrayList<Amigo> usuarios;
    private ArrayList<Archivo> archivos;
    
    private SelectApp conexion = new SelectApp();
    private Connection conn = conexion.connect();

    public Canal() {
    }

    public Canal(int id) {
        int idCanal = id;

    }

    public void getDatosCanal() {
        String sql = "SELECT\n"
                + "     amiguito.* , "
                + "     canales.*  "
                + "\n"
                + "FROM\n"
                + "		  `CanalAmigos`  canalitos "
                + "	INNER  JOIN `Amigo` amiguito on canalitos.`IdAmigo`= amiguito.`IdAmigo`\n"
                + "     INNER JOIN `Canal` canales ON canalitos.`IdCanal` = canales.`IdCanal`\n"
                + "WHERE\n"
                + "      canales.`idcanal` ='" + idCanal;

        try {
            
            Statement sent = conn.createStatement();
            System.out.println(sql);
            ResultSet rs = sent.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
                if (a == 0) {
                    setIdCanal(rs.getInt("IdCanal"));
                    setNombreRuteoCanal(rs.getString("CanalNombre"));
                    setActivo(rs.getBoolean("CanalEstadoActual"));
                }
                Amigo usuario = new Amigo();
                usuario.setAmigoCertificado(rs.getString("AmigoCertificado"));
                usuario.setAmigoIp(rs.getString("AmigoIp"));
                usuario.setAmigoLogueoName(rs.getString("AmigoLogueoName"));
                usuario.setAmigoNombre(rs.getString("AmigoNombre"));
                usuario.setAmigoPassword(rs.getString("AmigoPassword"));
                usuario.setAmigoPuerto(rs.getString("AmigoPuerto"));
                usuario.setAmigoSobreNombre(rs.getString("AmigoSobreNombre"));
                usuario.setIdAmigo(rs.getInt("IdAmigo"));
                usuarios.add(usuario);
                a++;
            }
            
        } catch (SQLException e) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, e);
        }
         String sql2 ="select * from archivo where idcanal =  "+ idCanal;
        try {
            
            Statement sent2 = conn.createStatement();
            System.out.println(sql);
            ResultSet rs2 = sent2.executeQuery(sql2);
            while (rs2.next()) {
                 Archivo ar= new Archivo();
                 ar.setArchivoNombre(rs2.getString("archivoNombre"));
                 ar.setIdAmigoDueño(rs2.getString("archivoNombre"));
                 ar.setIdArchivo(rs2.getString("archivoNombre"));
                 ar.setIdCanal(rs2.getString("archivoNombre"));
                 ar.setMrl(rs2.getString("archivoNombre"));
                 archivos.add(ar);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
