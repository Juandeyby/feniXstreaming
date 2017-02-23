/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import Local.Conexion.SelectApp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class Generico {
    
    static SelectApp conexion = new SelectApp();
    static Connection conn = conexion.connect();
    
    public static void LLenarTabla(JTable JTabla, String[] cabecera, String sql) {
            
            try (Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {
                ArrayList<ArrayList<String>> arr = new ArrayList<>();
                int i = 0;

                while (rs.next()) {
                    arr.add(new ArrayList<String>());
                    for (int a = 0; a < cabecera.length; a++) {
                        arr.get(i).add(rs.getString(a + 1));

                    }
                    i++;
                }
                if (i == 0) {
                    return;
                }
                String[][] data = new String[arr.size()][arr.get(0).size()];
                for (int j = 0; j < arr.size(); j++) {
                    for (int j1 = 0; j1 < arr.get(0).size(); j1++) {
                        data[j][j1] = arr.get(j).get(j1);
                    }
                }
                MiModel model = new MiModel(data, cabecera);

                JTabla.setModel(model);

                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getString("AmigoLogueoName") + "\t"
                            + rs.getString("AmigoPassword"));
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    public static ArrayList<String> consultaCon(String nomTabla, String atrBuscar, String where) throws SQLException {
        ArrayList<String> desu = new ArrayList<String>();
        try{
            Statement sent2 = conn.createStatement();
            String sql_cons = "select * from " + nomTabla + " " + where;
            System.out.println(sql_cons);
            ResultSet rs2 = sent2.executeQuery(sql_cons);

            while (rs2.next()) {
                desu.add(rs2.getString(atrBuscar));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return desu;
    }

    public static int GetNewId(String tabla ,String  dato) {

        try {
            String sql = "SELECT "+dato+" \n"
                    + "FROM " + tabla + " \n"
                    + "WHERE " + dato + " = (\n"
                    + "    SELECT max(" + dato + ") FROM "+tabla+"\n"
                    + "    )";
            int retorno = 0;
            Statement sent = conn.createStatement();
            
            System.out.println(sql);
            ResultSet rs = sent.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
                retorno = rs.getInt(1);
            }
            retorno++;
            conn.close();
            return retorno ;
        } catch (SQLException ex) {
            Logger.getLogger(Generico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1 ;
    }

}
