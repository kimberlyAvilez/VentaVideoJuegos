
package pruebaconectbd;

import java.sql.*;

/**
 *
 * @author Luis, Kimberly, Deimon
 */
public class Venta {
    private int Id_Venta;
    private int Cliente_CL;
    private Date fecha;
    private Double Total;
    
    accesobd base;

    public Venta(accesobd base) {
        this.base = base;
    }

    public int getId_Venta() {
        return Id_Venta;
    }

    public void setId_Venta(int Id_Venta) {
        this.Id_Venta = Id_Venta;
    }

    public int getCliente_CL() {
        return Cliente_CL;
    }

    public void setCliente_CL(int Cliente_CL) {
        this.Cliente_CL = Cliente_CL;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }
    
    public int IncrementoVenta() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = base.consultaBD("SELECT max(ID_venta) num FROM venta;");
        if (rs.next()) {
            inc = rs.getInt(1)+1;
        } else {
            inc = 1;
        }
        return inc;
    }
    
    public void InsertarVenta() throws SQLException {
        String cadena = "INSERT INTO venta VALUES('" + getId_Venta()+ "',"
                + "'" + getCliente_CL()+ "',"
                + "'" + getFecha()+ "',"
                + getTotal()+");";
        base.actualizaBD(cadena);
      //  base.cerrarBD();

    }
    
    public void ActualizarJuego(){
        try{
        String Cadena = "UPDATE juego SET "
                + "cedula='"+getCliente_CL()+
                "',fecha_venta='"+getFecha()+
                "', total='"+getTotal()+
                "' WHERE id_venta = "+getId_Venta();
        base.actualizaBD(Cadena);
    //   System.out.println(Cadena);
        }catch(SQLException e){}
        
    }    
    
    public ResultSet Consultar_Venta_ID() throws SQLException{
        return base.consultaBD("select * from venta where id_venta="+getId_Venta());
    }
    
    public void EliminarVenta() throws SQLException{
        String cadena = "DELETE FROM venta WHERE id_venta ="+getId_Venta();
        base.actualizaBD(cadena);
    }
}
