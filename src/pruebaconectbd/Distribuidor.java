
package pruebaconectbd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis, Kimberly, Deimon
 */
public class Distribuidor {

    private int id_distribuidor;
    private String nombre;
    private String pais;
    private String correo;

    accesobd base;

    public Distribuidor(accesobd base) {
        this.base = base;
    }

    public int getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(int id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int Incrementodistribuidor() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = base.consultaBD("SELECT max(ID_distribuidora) num FROM distribuidora;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }

        return inc;
    }
    public void InsertarDistribuidora() throws SQLException {
        String cadena = "INSERT INTO distribuidora VALUES("
                + "'" + getId_distribuidor() + "',"
                + "'" + getNombre() + "',"
                + "'" + getPais() + "',"
                + "'" + getCorreo() + "')";
        base.actualizaBD(cadena);
    }
    public void ActualizarDistribuidor() throws SQLException {
        String cadena = "update distribuidora set nombre ='" + getNombre() + "', pais='" + getPais() + "', correo='" + getCorreo() + "' where id_distribuidora = " + getId_distribuidor();
        base.actualizaBD(cadena);
    }
    public ResultSet Consultar_Distribuidor() throws SQLException {
        return base.consultaBD("Select * from distribuidora");
    }
    public ResultSet Consultar_Distribuidor_Nombre(String nombre) throws SQLException {
        return base.consultaBD("Select * from distribuidora where nombre = '" + nombre + "'");
    }

}
