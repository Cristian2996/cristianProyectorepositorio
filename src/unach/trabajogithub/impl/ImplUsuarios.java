package unach.trabajogithub.impl;

import java.sql.ResultSet;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import unach.trabajogithub.dao.*;
import unach.trabajogithub.entidades.*;
import unach.trabajohithub.accesodatos.Conexion;
import unach.trabajohithub.accesodatos.Parametro;

public class ImplUsuarios implements IUsuarios {

    @Override
    public int insertar(Usuarios usuarios) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Usuarios (id_usuario, id_roles, nombre, email, password, creado, actualizado) Values (?,?,?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, usuarios.getId_usuario()));
        lstP.add(new Parametro(2, usuarios.getRoles().getId_roles()));
        lstP.add(new Parametro(3, usuarios.getNombre()));
        lstP.add(new Parametro(4, usuarios.getEmail()));
        lstP.add(new Parametro(5, usuarios.getPassword()));
        if (usuarios.getCreado() instanceof java.util.Date) {
            lstP.add(new Parametro(6, new java.sql.Date(((java.util.Date) usuarios.getCreado()).getTime())));
        } else {
            lstP.add(new Parametro(6, usuarios.getCreado()));
        }
        if (usuarios.getActualizado() instanceof java.util.Date) {
            lstP.add(new Parametro(7, new java.sql.Date(((java.util.Date) usuarios.getActualizado()).getTime())));
        } else {
            lstP.add(new Parametro(7, usuarios.getActualizado()));
        }
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public Usuarios obtener(int id_usuario) throws Exception {
        Usuarios usua = null;
        Roles role = null;
        IRoles rolesDao = new ImplRoles();
        String csql = "Select id_usuario, id_roles,nombre, email, password, creado, actualizado  From Usuarios Where id_usuario=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_usuario));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, null);
            while (rst.next()) {
                role = new Roles();
                role = rolesDao.obtener(rst.getInt(2));
                usua = new Usuarios();
                usua.setId_usuario(rst.getInt(1));
                usua.setRoles(role);
                usua.setNombre(rst.getString(3));
                usua.setEmail(rst.getString(4));
                usua.setPassword(rst.getString(5));
                usua.setCreado(rst.getDate(6));
                usua.setActualizado(rst.getDate(7));
            
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return usua;
    }

    @Override
    public ArrayList<Usuarios> obtener() throws Exception {
        ArrayList<Usuarios> usua = new ArrayList<>();
        Roles roles = null;
        IRoles rolesDao = new ImplRoles();
        String csql = "Select id_usuario, id_roles, nombre, email, password, creado, actualizado From Usuarios";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, null);
            Usuarios usu = null;
            while (rst.next()) {
                roles = new Roles();
                roles = rolesDao.obtener(rst.getInt(2));
                usu = new Usuarios();
                usu.setId_usuario(rst.getInt(1));
                usu.setRoles(roles);
                usu.setNombre(rst.getString(3));
                usu.setEmail(rst.getString(4));
                usu.setPassword(rst.getString(5));
                usu.setCreado(rst.getDate(6));
                usu.setActualizado(rst.getDate(7));
                usua.add(usu);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return usua;
    }

}
