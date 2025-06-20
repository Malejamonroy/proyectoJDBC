import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class07AccionesDepartamentos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");

            //SSELECT DEPT_NO,DNOMBRE FROM DEPT;;
            String sql = "select DEPT_NO,DNOMBRE from DEPT";
            System.out.println(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("DEPT_NO");
                String nom = rs.getString("DNOMBRE");
                System.out.println(id + " " + nom);
            }
            
            System.out.println("------------Menú------------");
            System.out.println("1) Insertar departamento: ");
            System.out.println("2) Modificar departamento: ");
            System.out.println("3) Eliminar departamento: ");
            System.out.println("4) Salir. ");
            System.out.println("----------------------------");
            String dato = teclado.nextLine();
            
            if (Integer.parseInt(dato)==1){
                //pregunta de Insertar
                System.out.println("Id Departamento: ");
                String noDep = teclado.nextLine();
                System.out.println("Nombre Departamento: ");
                String nomDep = teclado.nextLine();
                System.out.println("Localidad");
                String locDep = teclado.nextLine(); 
                //insert into DEPT values(54,'fds','GEtafe')
                String sqlInsert = "insert into DEPT values(" + noDep + ", '" + nomDep + "','" + locDep + "')"; 
                int registros = st.executeUpdate(sqlInsert);
                System.out.println("Reguistros insertados: " + registros);

            }else if(Integer.parseInt(dato)==2){
                System.out.println("Id Departamento: ");
                String noDep = teclado.nextLine();
                System.out.println("Nombre Departamento: ");
                String nomDep = teclado.nextLine();
                System.out.println("Localidad");
                String locDep = teclado.nextLine(); 
                //ubdate into DEPT values(54,'fds','GEtafe')
                String sqlInsert = "ubdate into DEPT values(" + noDep + ", '" + nomDep + "','" + locDep + "')"; 
                int registros = st.executeUpdate(sqlInsert);
                System.out.println("Reguistros insertados: " + registros);


            }else if()
            
            //Eliminar Departamento

        } catch (Exception e) {
            System.out.println("Exepción" + e);
        }
    }
    
}
