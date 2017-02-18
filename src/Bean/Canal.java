/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import static Bean.UsuarioLogueado.cn;
import Ruteador.Bean.UsuarioConneccion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
            Statement sent;

            sent = cn.createStatement();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
         String sql2 ="select * from archivo where idcanal =  "+ idCanal;
        try {
            Statement sent;

            sent = cn.createStatement();
            System.out.println(sql);
            ResultSet rs = sent.executeQuery(sql2);
            while (rs.next()) {
                 Archivo ar= new Archivo();
                 ar.setArchivoNombre(rs.getString("archivoNombre"));
                 ar.setIdAmigoDueño(rs.getString("archivoNombre"));
                 ar.setIdArchivo(rs.getString("archivoNombre"));
                 ar.setIdCanal(rs.getString("archivoNombre"));
                 ar.setMrl(rs.getString("archivoNombre"));
                 archivos.add(ar);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
