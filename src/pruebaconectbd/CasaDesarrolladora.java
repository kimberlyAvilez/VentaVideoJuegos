package pruebaconectbd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis, Kimberly, Deimon
 */
public class CasaDesarrolladora {

    private int id;
    private String nombre;
    private String pais;
    private String telefono;
    accesobd base;

    // Constructor vacío
    public CasaDesarrolladora(accesobd base) {
        this.base = base;
    }

    // Getters y Setters (métodos generados automáticamente)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Otros métodos de la clase CasaDesarrolladora
    public int IncrementoCasa() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = base.consultaBD("SELECT max(ID_casadesarrolladora) num FROM casa_desarrolladora;");
        if (rs.next()) {
            inc = rs.getInt(1) + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void InsertarCasaDesarrolladora() throws SQLException {
        String cadena = "INSERT INTO casa_desarrolladora VALUES("
                + "'" + getId() + "',"
                + "'" + getNombre() + "',"
                + "'" + getPais() + "',"
                + "'" + getTelefono() + "')";
        base.actualizaBD(cadena);
    }

    public void ActualizarCasaDesarrolladora() throws SQLException {
        String cadena = "update Casa_desarrolladora set nombre='"+getNombre()+"', pais='"+getPais()+"', telefono='"+getTelefono()+"' where id_casadesarrolladora=" + getId();
        base.actualizaBD(cadena);

    }
    
    public ResultSet Consultar_Casa() throws SQLException {
        return base.consultaBD("Select * from casa_desarrolladora");
    }

    public ResultSet Consultar_Casa_Nombre(String nombre) throws SQLException {
        return base.consultaBD("Select * from casa_desarrolladora where nombre = '" + nombre + "'");
    }

    public void EliminarCasaDesarrolladora() {
        // Lógica para eliminar una casa desarrolladora de la base de datos
    }

    // Otros métodos relacionados a la clase CasaDesarrolladora
}
