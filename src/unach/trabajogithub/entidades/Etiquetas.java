
package unach.trabajogithub.entidades;

import java.sql.Date;

public class Etiquetas {
    private int id_etiqueta;
    private String nombre;
    private Date creado;
    private Date actualizado;

    public Etiquetas() {
    }

    public Etiquetas(int id_etiqueta, String nombre, Date creado, Date actualizado) {
        this.id_etiqueta = id_etiqueta;
        this.nombre = nombre;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    public int getId_etiqueta() {
        return id_etiqueta;
    }

    public void setId_etiqueta(int id_etiqueta) {
        this.id_etiqueta = id_etiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }
    
}
