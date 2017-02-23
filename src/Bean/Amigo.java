/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

//import static Bean.UsuarioLogueado.cn;
import GUI.Principal.login;
import Local.Conexion.InsertApp;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Amigo implements Serializable {

    private int idAmigo;

    private String AmigoNombre;
    private String AmigoIp;
    private String AmigoPuerto;
    private String AmigoCertificado;
    private String AmigoSobreNombre;
    private String AmigoLogueoName;
    private String AmigoPassword;

    private boolean Activo;

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getAmigoNombre() {
        return AmigoNombre;
    }

    public void setAmigoNombre(String AmigoNombre) {
        this.AmigoNombre = AmigoNombre;
    }

    public String getAmigoIp() {
        return AmigoIp;
    }

    public void setAmigoIp(String AmigoIp) {
        this.AmigoIp = AmigoIp;
    }

    public String getAmigoPuerto() {
        return AmigoPuerto;
    }

    public void setAmigoPuerto(String AmigoPuerto) {
        this.AmigoPuerto = AmigoPuerto;
    }

    public String getAmigoCertificado() {
        return AmigoCertificado;
    }

    public void setAmigoCertificado(String AmigoCertificado) {
        this.AmigoCertificado = AmigoCertificado;
    }

    public String getAmigoSobreNombre() {
        return AmigoSobreNombre;
    }

    public void setAmigoSobreNombre(String AmigoSobreNombre) {
        this.AmigoSobreNombre = AmigoSobreNombre;
    }

    public String getAmigoLogueoName() {
        return AmigoLogueoName;
    }

    public void setAmigoLogueoName(String AmigoLogueoName) {
        this.AmigoLogueoName = AmigoLogueoName;
    }

    public String getAmigoPassword() {
        return AmigoPassword;
    }

    public void setAmigoPassword(String AmigoPassword) {
        this.AmigoPassword = AmigoPassword;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

//    public static void EstadoAmigosASinConexion() {
//        try {
//            String sql = "update Amigo set  amigoEstado = 0  ";
//
//            Statement sent = cn.createStatement();
//            sent.executeUpdate(sql);
//            System.out.println("guardado");
//        } catch (SQLException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    public static void CambiarAmigos(ArrayList<Amigo> presentes) {
//        try {
//            String sql = "update Amigo set  amigoEstadoActual = true where ";
//            for (Amigo amiguito : presentes) {
//                sql += " amigoCertificado = '" + amiguito.getAmigoCertificado() + "' or ";
//            }
//            sql = sql.substring(0, sql.length() - 3);
//            Statement sent = cn.createStatement();
//            sent.executeUpdate(sql);
//            System.out.println("guardado");
//        } catch (SQLException ex) {
//            Logger.getLogger(Amigo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.AmigoNombre);
        hash = 61 * hash + Objects.hashCode(this.AmigoIp);
        hash = 61 * hash + Objects.hashCode(this.AmigoLogueoName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Amigo other = (Amigo) obj;
        if (!Objects.equals(this.AmigoNombre, other.AmigoNombre)) {
            return false;
        }
        if (!Objects.equals(this.AmigoIp, other.AmigoIp)) {
            return false;
        }
        if (!Objects.equals(this.AmigoLogueoName, other.AmigoLogueoName)) {
            return false;
        }
        return true;
    }

    public void insertar() throws SQLException {
        //INSERT INTO `empresa`(`IdEmpresa`, `IdEmpresaGrupo`, `EmpRuc`, `EmpNom`, `EmpTel`, `EmpDir`, `EmpEstReg`)
        String sentIn = " INSERT INTO datosnodoactual(AmigoIP, AmigoPuerto, AmigoCertificado, AmigoNombre, AmigoSobreNombre, AmigoLogueoName, AmigoPassword) "
                + "VALUES (" + AmigoIp + "," + AmigoPuerto + "," + AmigoCertificado + "," + AmigoNombre + "," + AmigoSobreNombre + "," + AmigoLogueoName + "," + AmigoPassword + ")";
        System.out.println(sentIn);
        InsertApp command = new InsertApp();
        try (Connection conn = command.connect();
                PreparedStatement pstmt = conn.prepareStatement(sentIn)) {
            if (pstmt.executeUpdate() != 0) {
                System.out.println("guardado");
            } else {
                System.out.println("error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Amigo{" + "idAmigo=" + idAmigo + ", AmigoNombre="
                + AmigoNombre + ", AmigoIp=" + AmigoIp + ", AmigoPuerto="
                + AmigoPuerto + ", AmigoCertificado=" + AmigoCertificado
                + ", AmigoSobreNombre=" + AmigoSobreNombre +
                ", AmigoLogueoName=" + AmigoLogueoName + ", AmigoPassword="
                + AmigoPassword + ", Activo=" + Activo + '}';
    }

}
