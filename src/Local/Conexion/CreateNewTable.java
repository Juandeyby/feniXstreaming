package Local.Conexion;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class CreateNewTable {
 
    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:feniXtreaming.db";
        
        // SQL statement for creating a new table
        String sql_1 = "CREATE TABLE IF NOT EXISTS amigo (\n"
                + "	IdAmigo INTEGER PRIMARY KEY,\n"
                + "	AmigoIP char(20) DEFAULT NULL,\n"
                + "	AmigoPuerto char(20) DEFAULT NULL,\n"
                + "	AmigoCertificado text,\n"
                + "	AmigoNombre char(20) DEFAULT NULL,\n"
                + "	AmigoSobreNombre char(20) DEFAULT NULL,\n"
                + "	AmigoLogueoName varchar(20) NOT NULL,\n"
                + "	AmigoPassword varchar(20) NOT NULL,\n"
                + "	AmigoPrendido tinyint(1) NOT NULL DEFAULT '0',\n"
                + "	AmigoCondicion int(11) NOT NULL DEFAULT '0'\n"
                + ");";
        
        String sql_2 = "CREATE TABLE IF NOT EXISTS datosnodoactual (\n"
                + "	IdAmigo int(11) PRIMARY KEY,\n"
                + "	AmigoIP char(20) DEFAULT NULL,\n"
                + "	AmigoPuerto char(20) DEFAULT NULL,\n"
                + "	AmigoCertificado text,\n"
                + "	AmigoNombre char(20) DEFAULT NULL,\n"
                + "	AmigoSobreNombre char(20) DEFAULT NULL,\n"
                + "	AmigoLogueoName varchar(20) NOT NULL,\n"
                + "	AmigoPassword varchar(20) NOT NULL,\n"
                + "	AmigoEstadoActual tinyint(1) NOT NULL DEFAULT '0',\n"
                + "	Ruta varchar(50) NOT NULL DEFAULT './compartido'\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            if(stmt.execute(sql_1))
                System.out.println("Sexo1");
            if(stmt.execute(sql_2))
                System.out.println("Sexo2");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }
 
}