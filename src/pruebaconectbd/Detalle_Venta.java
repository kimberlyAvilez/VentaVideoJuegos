
package pruebaconectbd;

import java.sql.*;

/**
 *
 * @author Luis, Kimberly, Deimon
 */
public class Detalle_Venta {
    private int Id_VentaD;
    private int Id_Juego;
    private int Id_Venta;
    private int Cantidad;
    private Double Subtotal;
    
    accesobd base;

    public Detalle_Venta(accesobd base) {
        this.base = base;
    }

    public int getId_VentaD() {
        return Id_VentaD;
    }

    public void setId_VentaD(int Id_VentaD) {
        this.Id_VentaD = Id_VentaD;
    }

    public int getId_Juego() {
        return Id_Juego;
    }

    public void setId_Juego(int Id_Juego) {
        this.Id_Juego = Id_Juego;
    }

    public int getId_Venta() {
        return Id_Venta;
    }

    public void setId_Venta(int Id_Venta) {
        this.Id_Venta = Id_Venta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double Subtotal) {
        this.Subtotal = Subtotal;
    }
    
    public int IncrementoDetalle() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = base.consultaBD("SELECT max(ID_detVenta) num FROM detalle_venta;");
        if (rs.next()) {
            inc = rs.getInt(1)+1;
        } else {
            inc = 1;
        }
        return inc;
    }
    
    public void InsertarDetVenta() throws SQLException {
        String cadena = "INSERT INTO detalle_venta VALUES('" + getId_VentaD()+ "',"
                + "'" + getId_Juego()+ "',"
                + "'" + getId_Venta()+ "',"
                + "'" + getCantidad()+ "',"
                + getSubtotal() + ");";
        base.actualizaBD(cadena);

    }
    
    public void ActualizarDetVenta(){
        try{
        String Cadena = "UPDATE detalle_venta SET "
                + "id_juego='"+getId_Juego()+
                "',id_venta='"+getId_Venta()+
                "', cantidad='"+getCantidad() +
                "', subtotal="+getSubtotal()
                +" WHERE id_detventa = "+getId_VentaD();
        base.actualizaBD(Cadena);
    //   System.out.println(Cadena);
        }catch(SQLException e){}
        
    }    
    
    public ResultSet Consultar_DetVenta_ID() throws SQLException{
        return base.consultaBD("select * from detalle_venta where id_detventa="+getId_VentaD());
    }
    
    public void EliminarDetVenta() throws SQLException{
        String cadena = "DELETE FROM detalle_venta WHERE id_detventa ="+getId_VentaD();
        base.actualizaBD(cadena);
    }
    
    
}
