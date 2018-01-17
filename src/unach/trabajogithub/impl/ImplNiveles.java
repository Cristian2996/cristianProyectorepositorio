package unach.trabajogithub.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import unach.trabajogithub.dao.INiveles;
import unach.trabajogithub.entidades.Niveles;
import unach.trabajohithub.accesodatos.Conexion;
import unach.trabajohithub.accesodatos.Parametro;
import java.util.*;
import java.sql.*;

public class ImplNiveles implements INiveles {
@Override
    public int insertar(Niveles niveles) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Niveles (id_niveles, nombre, creado, actualizado) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, niveles.getId_niveles()));
        lstP.add(new Parametro(2, niveles.getNombre()));
        if (niveles.getCreado() instanceof java.util.Date) {
            lstP.add(new Parametro(3, new java.sql.Date(((java.util.Date) niveles.getCreado()).getTime())));
        } else {
            lstP.add(new Parametro(3, niveles.getCreado()));
        }
        if (niveles.getActualizado() instanceof java.util.Date) {
            lstP.add(new Parametro(4, new java.sql.Date(((java.util.Date) niveles.getActualizado()).getTime())));
        } else {
            lstP.add(new Parametro(4, niveles.getActualizado()));
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
    public Niveles obtener(int id_niveles) throws Exception {
        Niveles niv = null;
        String csql = "Select id_niveles, nombre, creado, actualizado From Niveles Where id_niveles=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_niveles));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                niv=new Niveles();
                niv.setId_niveles(rst.getInt(1));
                niv.setNombre(rst.getString(2));
                niv.setCreado(rst.getDate(3));
                niv.setActualizado(rst.getDate(4));
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return niv;
    }

    @Override
    public ArrayList<Niveles> obtener() throws Exception {
      ArrayList<Niveles> nive = new ArrayList<>();
        String csql="select id_niveles, nombre, creado, actualizado from Niveles";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Niveles niv=null;
            while(rst.next()){
                niv=new Niveles();
                niv.setId_niveles(rst.getInt(1));
                niv.setNombre(rst.getString(2));
                niv.setCreado(rst.getDate(3));
                niv.setActualizado(rst.getDate(4));
                nive.add(niv);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nive;  
    }    
}
