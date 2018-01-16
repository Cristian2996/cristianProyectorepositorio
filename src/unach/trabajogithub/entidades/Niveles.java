package unach.trabajogithub.entidades;

import java.sql.Date;

public class Niveles {
private int id_niveles;
private String nombre;
private Date creado;
private Date actualizado;

    public Niveles() {
    }

    public Niveles(int id_niveles, String nombre, Date creado, Date actualizado) {
        this.id_niveles = id_niveles;
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

    public int getId_niveles() {
        return id_niveles;
    }

    public void setId_niveles(int id_niveles) {
        this.id_niveles = id_niveles;
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
