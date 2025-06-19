
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class03BuscadorPlantillaFuncion {
    public static void main(String[] args) {   
        Scanner teclado = new Scanner(System.in);
        System.out.println("Que funcion desea: ");
        String filtroFuncion= teclado.nextLine();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString,"root","root");
            String sql = "SELECT APELLIDO,FUNCION,SALARIO FROM PLANTILLA WHERE FUNCION='"+ filtroFuncion+"'";
            System.out.println(sql); //chivato de la consulta que quiero mostrar
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String apellido = rs.getString("Apellido");
                String funcion = rs.getString("funcion");
                String salario = rs.getString("salario");
                System.out.println("Apellido: "+ apellido + " - Funcion:" + funcion + " el Salario es: " + salario);
            }
            rs.close();
            cn.close();
        }catch (Exception e){
            System.out.println(e);

        }
        teclado.close();
    }
    
}
