import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// necesitamos un programa para incrementar el salario de los empleados por oficio.Pedimos al usuario el OFICIO Y EL INCREMENTO SALARIAL para los empleado.
// Despues de incrementar, debemos mostrar un listado con Apellidos, oficio y salario de todos los empleados afectados por consulta

public class Class06IncrementoSalarialEmpleados {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            //la conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");
            
            System.out.println("Introduce el Oficio a modicficar: ");
            String oficio = teclado.nextLine();
            System.out.println("Introduce Incremento Salarial: ");
            String incremento = teclado.nextLine();
            oficio = oficio.toUpperCase(); //como oficio esta en mayusculas en la bbdd con esto convertimos en mayuscula 
            //vamos a modificar el salario del empleado que desean 
            //1)hacemos la consulta de modificar
            //UPDATE EMP SET SALARIO = SALARIO + 1 WHERE OFICIO = 'ANALISTA';
            String sql = "update EMP set SALARIO = SALARIO + " + incremento + " where OFICIO='" + oficio + "'";
            System.out.println(sql);
            //2)creamos nuestro Statement
            Statement st = cn.createStatement();
            
            //3)ejecutar la consulta
            //int modificados = st.executeUpdate(sql);
            
            //4)mostramos los empleados modificados
            
            //5) hacemos la consulta
            //select * from EMP where OFICIO='ANALISTA' 
            String sqlSelect = "select * from EMP where OFICIO='"+ oficio + "'";
            System.out.println(sqlSelect);
            //6) recuperamos el Resulset
            ResultSet rs = st.executeQuery(sqlSelect);
            //7)mostramos los datos
            while(rs.next()){
                //vamos a mostrar el apellido oficio y salario de los consultados
                String ape = rs.getString("APELLIDO");
                String ofi = rs.getString("OFICIO");
                String sal = rs.getString("SALARIO");
                //8) Dibujamos los datos
                System.out.println(ape+ " - " + ofi + " - " + sal);
            }
            //9) cerramos
            rs.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Excepcíon" + e);        
        }
        teclado.close();
    }
    
}
