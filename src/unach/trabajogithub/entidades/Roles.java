package unach.trabajogithub.entidades;

import java.sql.Date;

public class Roles {
 private int id_roles;
 private String nombre;
 private Date creado;
 private Date actualizado;

    public Roles() {
    }

    public Roles(int id_roles, String nombre, Date creado, Date actualizado) {
        this.id_roles = id_roles;
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

    public int getId_roles() {
        return id_roles;
    }

    public void setId_roles(int id_roles) {
        this.id_roles = id_roles;
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
