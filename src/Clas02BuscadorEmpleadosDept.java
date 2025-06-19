import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Clas02BuscadorEmpleadosDept {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca numero de departamento");
        String idDepartamento = teclado.nextLine();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString,"root","root");
            String sql = "select APELLIDO, OFICIO from EMP where DEPT_NO=" + idDepartamento;
            System.out.println(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String apellido = rs.getString("APELLIDO");
                String oficio = rs.getString("OFICIO");
                System.out.println(apellido + " - " + oficio);
            }
            rs.close();
            cn.close();
        }catch(Exception e){
            System.out.println("error gordo: " + e);
        }
        teclado.close();
    }
    
}
