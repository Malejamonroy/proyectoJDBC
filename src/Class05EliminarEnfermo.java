import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class05EliminarEnfermo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); //para pintar los fuegos artifiiales 
        try {
            //la conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conneString = "jdbc:mysql://localhost:3306/hospital"; //cadena de conexion 
            Connection cn = DriverManager.getConnection(conneString, "root", "root"); //nueva Cadena de conexíon
            
            System.out.println("Inscripcion de Enfermo"); //Fuegos artificiales
            String inscripcion = teclado.nextLine();


                //DEsde B muestra los enfermos
            //POR SUPUESTO, PODEMOS REUTILIZAR EL Statement
            String sqlSelect = "select * from ENFERMO";
            //para ejecutar un select ResultSet 
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(sqlSelect);
            while (rs.next()) {
                String ins = rs.getString("INSCRIPCION");
                String ape = rs.getString("APELLIDO");
                System.out.println(ins + " - " + ape);                              
            }
            rs.close();
            //hasta B

            //consulta  //delete from ENFERMO where INSCRIPCION=1234 
            // desde A elimina enfermos
            String sql= "delete from ENFERMO where INSCRIPCION=" + inscripcion; //consulta simple
            int delete = st.executeUpdate(sql); //capturamos lo eliminado
            System.out.println("Enfermos eliminados: " + delete);
            //hasta A
           
            
            //CERRAMOS LA CONEXCION 
            cn.close();
        } catch (Exception e) {
            System.out.println("Exepcíon: " + e);
        }
        teclado.close();
    }
}
