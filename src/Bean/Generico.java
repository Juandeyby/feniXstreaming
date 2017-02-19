/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Local.Conexion.Mysql;
import Utilitarios.MiModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class Generico {
    public static Connection cn = Mysql.getConection();

    public static void LLenarTabla(JTable JTabla, String[] cabecera, String sql) {
             try {
                    Statement sent;
            //if (id.length() != 0) {
           
                //System.out.println(sql_Cons);
            //}
            sent = cn.createStatement();
            ResultSet rs = sent.executeQuery(sql);
            ArrayList<ArrayList<String >> arr = new ArrayList<>();
            int i =0;
            
            while (rs.next()) {
                arr.add(new ArrayList<String >());
                 for(int a = 0 ; a < cabecera.length;a++ ){
                arr.get(i).add(rs.getString(a+1));
                 
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> consultaCon(String nomTabla, String atrBuscar, String where) throws SQLException {
        ArrayList<String> desu = new ArrayList<String>();
        Statement sent2 = cn.createStatement();
        String sql_cons = "select * from " + nomTabla + " " + where;
        System.out.println(sql_cons);
        ResultSet rs2 = sent2.executeQuery(sql_cons);

        while (rs2.next()) {
            desu.add(rs2.getString(atrBuscar));
        }
        return desu;
    }
    
    
}
