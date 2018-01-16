package unach.trabajogithub.entidades;

import java.sql.Date;

public class Usuarios {
private int id_usuario;    
private Roles roles;
private String nombre;
private String email;
private String password;
private Date creado;
private Date actualizado;

    public Usuarios() {
    }

    public Usuarios(int id_usuario, Roles roles, String nombre, String email, String password, Date creado, Date actualizado) {
        this.id_usuario = id_usuario;
        this.roles = roles;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.creado = creado;
        this.actualizado = actualizado;
    }

    public Date getActualizado() {
        return actualizado;
    }

    public void setActualizado(Date actualizado) {
        this.actualizado = actualizado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

}
