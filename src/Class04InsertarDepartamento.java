import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Class04InsertarDepartamento {
       public static void main(String[] args) {
         Scanner teclado = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");
            //SI QUEREMOS ADMINISTRAR EL COMMIT pero depende de la base de datos 
            cn.setAutoCommit(false);//opcional si lo quiero administar yo  
            System.out.println("Id departamento");
            String id = teclado.nextLine();
            System.out.println("Nombre Departamento");
            String nombre = teclado.nextLine();
            System.out.println("Localidad");
            String loc = teclado.nextLine();
            //insert into DEPT values(50,'TEST', 'LOC TEST')
            String sql = "insert into DEPT values (" + id + ", '" + nombre+ "','" + loc + "')";
            Statement st = cn.createStatement();
            int registros = st.executeUpdate(sql);
            System.out.println("Registros insertados: " + registros);
            //Al ser una bbdd transaccional por ejeplo mysql / oracle debemos indicar que los cambios son permannetes
            //hay dos pormas:
            //1) PERMANENTE: commit
            //2) DESHACER CAMBIOS: rollback
            cn.commit(); //este pone que ya lo tiene y no hay que ponerlo por eso esta comentado
            //Cerramos la conexíon
            cn.close();

        }catch(Exception e){
            System.out.println("Excepcíon" + e );
        }
        teclado.close();
    }
}
