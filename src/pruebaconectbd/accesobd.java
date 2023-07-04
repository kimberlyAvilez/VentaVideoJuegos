package pruebaconectbd;
/**
 *
 * @author Luis, Kimberly, Deimon
 */
import java.sql.*;
public class accesobd { // Definir variables de instancias
    private static Connection conexion;
    private final String Host;//="com.mysql.jdbc.Driver"; 
    private final String User;//="root";
    private final String Password;//="luis123";
    private final String bd;//="jdbc:mysql://localhost:3306/Prueba";
    // Contructor 
    public accesobd(String Host, String User, String Password, String bd) {
        this.Host = Host;
        this.User = User;
        this.Password = Password;
        this.bd = bd;
    }
    // Metodos Getter
    public String getHost() {
        return Host;
    }
    public String getUser() {
        return User;
    }
    public String getPassword() {
        return Password;
    }
    public String getBd() {
        return bd;
    }

    public void conectaBD() {
        try {
            Driver driver = (Driver)
                  Class.forName("com.mysql.jdbc.Driver").newInstance();
            DriverManager.registerDriver(driver);
            String cadena = "jdbc:mysql://"+getHost()+"/"+getBd();
            conexion = DriverManager.getConnection(cadena,getUser(),getPassword());
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error " + e.toString());
        }
    }
    public void actualizaBD(String sql)throws SQLException {
        try {
            Statement stm = conexion.createStatement();
            stm.executeUpdate(sql);
            System.out.println("Transaccion exitosa!");
        } catch (SQLException e) {
            System.out.println("Error rollback"+e.toString());
        }
    }    
    public ResultSet consultaBD(String sql) throws SQLException {
        ResultSet cursor;
        Statement stm = conexion.createStatement();
        cursor = stm.executeQuery(sql);
        return cursor;
    }    
    public void cerrarBD() throws SQLException{
    conexion.close();
    }
}
