
package pruebaconectbd;

import java.sql.*;
/**
 *
 * @author Luis, Kimberly, Deimon
 */
public class Juego_Distribuidora {

    private int Id_Juego_Distr;
    private int Id_Juego;
    private int Id_Distribuidor;
    private Date publicacion;

    accesobd base;

    public Juego_Distribuidora(accesobd base) {
        this.base = base;
    }

    public int getId_Juego_Distr() {
        return Id_Juego_Distr;
    }

    public void setId_Juego_Distr(int Id_Juego_Distr) {
        this.Id_Juego_Distr = Id_Juego_Distr;
    }

    public int getId_Juego() {
        return Id_Juego;
    }

    public void setId_Juego(int Id_Juego) {
        this.Id_Juego = Id_Juego;
    }

    public int getId_Distribuidor() {
        return Id_Distribuidor;
    }

    public void setId_Distribuidor(int Id_Distribuidor) {
        this.Id_Distribuidor = Id_Distribuidor;
    }

    public Date getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Date publicacion) {
        this.publicacion = publicacion;
    }

    public int Incrementojuegodistribuidor() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = base.consultaBD("SELECT max(ID_juegodistribuidora) num FROM juego_distribuidora;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void InsertarDistribuidora() throws SQLException {
        String cadena = "INSERT INTO juego_distribuidora VALUES("
                + "'" + getId_Juego_Distr() + "',"
                + "'" + getId_Juego() + "',"
                + "'" + getId_Distribuidor() + "',"
                + "'" + getPublicacion() + "')";
        base.actualizaBD(cadena);
    }

    public ResultSet Consultar_Juego_Distribuidor() throws SQLException {
        return base.consultaBD("select * from juego_distribuidora where id_juego=" + getId_Juego() + " and id_distribuidora=" + getId_Distribuidor());
    }

    @Override
    public String toString() {
        return "Juego_Distribuidora{" + "Id_Juego_Distr=" + Id_Juego_Distr + ", Id_Juego=" + Id_Juego + ", Id_Distribuidor=" + Id_Distribuidor + ", publicacion=" + publicacion + '}';
    }

    public void ActualizarJuegoDistribuidor() throws SQLException {
        String cadena = "update juego_distribuidora set id_juego='" + getId_Juego() + "', juego_distribuidora='" + getId_Distribuidor() + "', publicacion='" + getPublicacion() + "' where id_juegodistribuidora=" + getId_Juego_Distr();
        base.actualizaBD(cadena);
    }
    
    public void eliminarJuegoDistribuidor() throws SQLException{
        base.actualizaBD("delete from juego_distribuidora where id_juegodistribuidora="+getId_Juego_Distr());
    }

}
