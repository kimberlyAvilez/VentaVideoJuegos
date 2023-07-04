
package pruebaconectbd;

import java.sql.*;

/**
 *
 * @author Luis, Kimberly, Deimon
 */
public class Cliente {
    private int Cedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Correo;
    private String Direccion;
    
    accesobd base;

    public Cliente(accesobd base) {
        this.base = base;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    public void InsertarCliente() throws SQLException {
        String cadena = "INSERT INTO cliente VALUES('" + getCedula()+ "',"
                + "'" + getNombre()+ "',"
                + "'" + getApellido()+ "',"
                + "'" + getTelefono()+ "',"
                + "'" + getDireccion()+ "',"
                + "'" + getCorreo()+ "');";
        base.actualizaBD(cadena);
      //  base.cerrarBD();

    }    
    public void ActualizarCliente(){
        try{
        String Cadena = "UPDATE cliente SET "+
                "'nombre='"+getNombre()+
                "', apellido='"+getApellido()+
                "',telefono='"+getTelefono()+
                "',direccion='"+getDireccion()+
                "', correo='"+getCorreo()+
                "' WHERE cedula = "+getCedula();
        base.actualizaBD(Cadena);
    //   System.out.println(Cadena);
        }catch(SQLException e){}        
    } 
    public ResultSet Consultar_Cliente_Cedula() throws SQLException{
        return base.consultaBD("select * from cliente where cedula="+getCedula());
    }    
    public void EliminarCliente() throws SQLException{
        String cadena = "DELETE FROM cliente WHERE cedula ="+getCedula();
        base.actualizaBD(cadena);
    }
}
