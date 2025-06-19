import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class01ReadEmpleados {
    public static void main(String[] args) {
        //1) REGISTRAR LA CLASE DE NUESTRO DRIVE JDBC DE MYSQL
        try{
            //este se decarga de google el myspaice es para mysql
            Class.forName("com.mysql.cj.jdbc.Driver"); //programamos una excepcion, 
            //2) NECESITAMOS UNA CADENA DE CONEXION
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            //3)Crear una conexion mediante DRIVERMANAGER 
            Connection cn = DriverManager.getConnection(connectionString,"root","root");
            //4)   CONSULTA SOBRE BBDD
            String sql = "select * from EMP";
            //5)UNA VEZ QUE TENGAMOS LA CONSULTA QUE QUIERO CREAMOS EL TIPO DE STATEMENT DEPENDIENDO DE LA CONSULTA
            // si tiene parametros o si es simple, en este caso es simple y se utiliza Statemen java.sql
            Statement st = cn.createStatement();
            //6)DEPENDDE QUE CONSULTA ES :SELECT, DELETE, UBDATE
            //en este caso es SELECT, necesitamos un ResultSet Y EL METODO executeQuery()
            ResultSet rs = st.executeQuery(sql);
            //7) RECORREMOS LOS REGISTROS MEDIANTE UN BUCLE WHILE
            while (rs.next()) {
                //ya tenemos los datos
            //AHORA RECUPERAMOS EL PRIMER APELLIDO y puede ser por posicion o nombre 
            String apellido = rs.getString("APELLIDO");
            System.out.println("Apellido: " + apellido);
            }
        //8) LIBERAMOS LOS RECURSOS
        rs.close();
        cn.close();
        }catch (ClassNotFoundException e){
            System.out.println("Class" + e);
        }catch (SQLException ex){
            System.out.println("Sql: " + ex);
        }
    }   
}
