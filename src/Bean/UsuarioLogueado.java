/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Local.Conexion.InsertApp;
import Ruteador.Servidor.ServerPeticionesEnrutamiento;
import Ruteador.Servidor.TestRemote;
import de.root1.simon.SimonUnreferenced;
import de.root1.simon.annotation.SimonRemote;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sun.security.util.Password;

/**
 *
 * @author USUARIO
 */
public class UsuarioLogueado extends Amigo implements  Serializable,SimonUnreferenced , Cloneable{
     private TestRemote server ;
    public UsuarioLogueado(){}
    public UsuarioLogueado(String usuarioNombre, String password) {
        String sql = "SELECT * FROM datosnodoactual WHERE "
                + " amigologueoname =  '"+ usuarioNombre + "' AND amigopassword = '"
                + password +"'";
        
        InsertApp command = new InsertApp();
        try (Connection conn = command.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
            if (rs.next()) {
                setAmigoCertificado(rs.getString("AmigoCertificado"));
                setAmigoIp(rs.getString("AmigoIp"));
                setAmigoLogueoName(rs.getString("AmigoLogueoName"));
                setAmigoNombre(rs.getString("AmigoNombre"));
                setAmigoPassword(rs.getString("AmigoPassword"));
                setAmigoPuerto(rs.getString("AmigoPuerto"));
                setAmigoSobreNombre(rs.getString("AmigoSobreNombre"));
                setIdAmigo(rs.getInt("IdAmigo"));
                System.out.println("Correcto");
            } else {
                System.out.println("Error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
//        try {
//            Statement sent;
//
//            sent = cn.createStatement();
//            System.out.println(sql);
//            ResultSet rs = sent.executeQuery(sql);
//            int a = 0;
//            while (rs.next()) {
//                if (a == 0) {
//                    setAmigoCertificado(rs.getString("AmigoCertificado"));
//                    setAmigoIp(rs.getString("AmigoIp"));
//                    setAmigoLogueoName(rs.getString("AmigoLogueoName"));
//                    setAmigoNombre(rs.getString("AmigoNombre"));
//                    setAmigoPassword(rs.getString("AmigoPassword"));
//                    setAmigoPuerto(rs.getString("AmigoPuerto"));
//                    setAmigoSobreNombre(rs.getString("AmigoSobreNombre"));
//                    setIdAmigo(rs.getInt("IdAmigo"));
//
//                }
//
////                Canal ca= new Canal();
////                ca.setIdCanal(rs.getInt("IdCanal"));
////                ca.setNombreRuteoCanal(rs.getString("CanalNombre"));
////                ca.setActivo(rs.getBoolean("CanalEstadoActual"));
////                canales.add(ca);
////a++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

 
    @Override
    public void unreferenced() {
        System.err.println("hey  you ");
         server.ImNotHere(this);

    }

    public TestRemote getServer() {
        return server;
    }

    public void setServer(ServerPeticionesEnrutamiento server) {
        this.server = server;
    }
  public Object clone(){
        UsuarioLogueado obj=null;
        try{
            obj=(UsuarioLogueado)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
  

}
