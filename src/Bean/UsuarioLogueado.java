/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Local.Conexion.Mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sun.security.util.Password;

/**
 *
 * @author USUARIO
 */
public class UsuarioLogueado {

    private ArrayList<Canal> canales = new ArrayList<Canal>();
    private Amigo usuario;
    public static Connection cn = Mysql.getConection();
    public UsuarioLogueado(){
    
    
    }
    public UsuarioLogueado(String usuarioNombre, String password) {
        String sql = "select * from  datosnodoactual  where "
                + " amigologueoname =  '"+ usuarioNombre + "' and amigopassword = '"
                + password +"'";
        try {
            Statement sent;

            sent = cn.createStatement();
            System.out.println(sql);
            ResultSet rs = sent.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
                if (a == 0) {
                    usuario = new Amigo();
                    usuario.setAmigoCertificado(rs.getString("AmigoCertificado"));
                    usuario.setAmigoIp(rs.getString("AmigoIp"));
                    usuario.setAmigoLogueoName(rs.getString("AmigoLogueoName"));
                    usuario.setAmigoNombre(rs.getString("AmigoNombre"));
                    usuario.setAmigoPassword(rs.getString("AmigoPassword"));
                    usuario.setAmigoPuerto(rs.getString("AmigoPuerto"));
                    usuario.setAmigoSobreNombre(rs.getString("AmigoSobreNombre"));
                    usuario.setIdAmigo(rs.getInt("IdAmigo"));

                }

//                Canal ca= new Canal();
//                ca.setIdCanal(rs.getInt("IdCanal"));
//                ca.setNombreRuteoCanal(rs.getString("CanalNombre"));
//                ca.setActivo(rs.getBoolean("CanalEstadoActual"));
//                canales.add(ca);
//a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Canal> getCanales() {
        return canales;
    }

    public void setCanales(ArrayList<Canal> canales) {
        this.canales = canales;
    }

    public Amigo getUsuario() {
        return usuario;
    }

    public void setUsuario(Amigo usuario) {
        this.usuario = usuario;
    }

}
