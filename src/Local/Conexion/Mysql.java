/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Local.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo EPIS
 */
public class Mysql {

    /*private static String db="polleria1";
     private static String user="tefa2";
     private static String passw="tefa";
     private static String url="jdbc:mysql://192.168.1.47:3306/"+db;
     private static Connection c;*/
            private static String db = "fenixdatabase";
    private static String user = "root";
    private static String passw = "";
    private static String url = "jdbc:mysql://localhost/" + db;
    private static Connection c;

    public static Connection getConection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, user, passw);
            System.out.println("LERO LERO");
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return c;
    }

    public static Connection getConection(String schema) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url1 = "jdbc:mysql://localhost/" + schema;

            c = DriverManager.getConnection(url1, user, passw);
            System.out.println("LERO LERO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
        return c;
    }

    public static void main(String[] args) {
        getConection();
    }
}
