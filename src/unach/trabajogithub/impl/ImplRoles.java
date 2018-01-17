package unach.trabajogithub.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;
import unach.trabajogithub.dao.IRoles;
import unach.trabajogithub.entidades.Roles;
import unach.trabajohithub.accesodatos.Conexion;
import unach.trabajohithub.accesodatos.Parametro;

public class ImplRoles implements IRoles {
 @Override
    public int insertar(Roles roles) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Roles (id_roles, nombre, creado, actualizado) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, roles.getId_roles()));
        lstP.add(new Parametro(2, roles.getNombre()));
        if (roles.getCreado() instanceof java.util.Date) {
            lstP.add(new Parametro(3, new java.sql.Date(((java.util.Date) roles.getCreado()).getTime())));
        } else {
            lstP.add(new Parametro(3, roles.getCreado()));
        }
        if (roles.getActualizado() instanceof java.util.Date) {
            lstP.add(new Parametro(4, new java.sql.Date(((java.util.Date) roles.getActualizado()).getTime())));
        } else {
            lstP.add(new Parametro(4, roles.getActualizado()));
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
    public Roles obtener(String id_roles) throws Exception {
        Roles rol = null;
        String csql = "Select id_roles, nombre, creado, actualizado From Niveles Where id_roles=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_roles));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                rol=new Roles();
                rol.setId_roles(rst.getInt(1));
                rol.setNombre(rst.getString(2));
                rol.setCreado(rst.getDate(3));
                rol.setActualizado(rst.getDate(4));
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return rol;
    }

    @Override
    public ArrayList<Roles> obtener() throws Exception {
         ArrayList<Roles> role = new ArrayList<>();
        String csql="select id_roles, nombre, creado, actualizado from Roles";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Roles rol=null;
            while(rst.next()){
                rol=new Roles();
                rol.setId_roles(rst.getInt(1));
                rol.setNombre(rst.getString(2));
                rol.setCreado(rst.getDate(3));
                rol.setActualizado(rst.getDate(4));
                role.add(rol);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return role;
    }    
}
