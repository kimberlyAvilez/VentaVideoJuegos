package pruebaconectbd;

/**
 *
 * @author Luis, Kimberly, Deimon
 */
import java.sql.*;

public class Juego {

    private int id;
    private int casaD;
    private String titulo;
    private String genero;
    private float precio;
    private int stock;
    public accesobd base;

    // Constructor vacío
    public Juego(accesobd base) {
        this.base = base;
    }

    // Getters y Setters (métodos generados automáticamente)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCasaD() {
        return casaD;
    }

    public void setCasaD(int casaD) {
        this.casaD = casaD;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int IncrementoJuego() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = base.consultaBD("SELECT max(ID_juego) num FROM juego;");
        if (rs.next()) {
            inc = rs.getInt(1)+1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void InsertarJuego() throws SQLException {
        String cadena = "INSERT INTO juego VALUES('" + getId() + "',"
                + "'" + getCasaD()+ "',"
                + "'" + getTitulo() + "',"
                + "'" + getGenero() + "',"
                + getPrecio() + ","
                + getStock() + ");";
        base.actualizaBD(cadena);
      //  base.cerrarBD();

    }
    
    public void ActualizarJuego(){
        try{
        String Cadena = "UPDATE juego SET id_casadesarrolladora='"+getCasaD()+"',titulo='"+getTitulo()+"', genero='"+getGenero()+"',precio='"+getPrecio()+"', stock='"+getStock()+"' WHERE id_juego = "+getId();
        base.actualizaBD(Cadena);
    //   System.out.println(Cadena);
        }catch(SQLException e){}
        
    }    
    
    public ResultSet Consultar_Juego_ID() throws SQLException{
        return base.consultaBD("select * from juego where id_juego="+getId());
    }
    
    public void EliminarJuego() throws SQLException{
        String cadena = "DELETE FROM juego WHERE id_juego ="+getId();
        base.actualizaBD(cadena);
    }
    
    public ResultSet consultaTabla(String sql) throws SQLException {      
        return base.consultaBD(sql);
    }
    
    public ResultSet Consultar_VideoJuego() throws SQLException{
        return base.consultaBD("SELECT * FROM JUEGO");
    }

    public ResultSet Consultar_VideoJuegos_Nombre(String nombre) throws SQLException{
        return base.consultaBD("select * from juego where titulo = '"+nombre+"'");
    }
}
