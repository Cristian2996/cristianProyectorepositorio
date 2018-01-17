package unach.trabajogithub.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import unach.trabajogithub.dao.IEtiquetas;
import unach.trabajogithub.entidades.Etiquetas;
import unach.trabajohithub.accesodatos.Conexion;
import unach.trabajohithub.accesodatos.Parametro;
import java.sql.*;

public class ImplEtiquetas implements IEtiquetas {
   @Override
    public int insertar(Etiquetas etiquetas) throws Exception {
        int numFilas = 0;
        String sqlC = "INSERT INTO Etiquetas (id_etiqueta, nombre, creado, actualizado) VALUES (?,?,?,?)";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, etiquetas.getId_etiqueta()));
        lisParametros.add(new Parametro(2, etiquetas.getNombre()));
        if (etiquetas.getCreado() instanceof java.util.Date) {
            lisParametros.add(new Parametro(3, new java.sql.Date(((java.util.Date) etiquetas.getCreado()).getTime())));
        } else {
            lisParametros.add(new Parametro(3, etiquetas.getCreado()));
        }
        if (etiquetas.getCreado() instanceof java.util.Date) {
            lisParametros.add(new Parametro(4, new java.sql.Date(((java.util.Date) etiquetas.getActualizado()).getTime())));
        } else {
            lisParametros.add(new Parametro(4, etiquetas.getActualizado()));
        }
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilas = con.ejecutarComando(sqlC, lisParametros);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilas;
    }

     @Override
    public Etiquetas obtener(int id_etiqueta) throws Exception {
        Etiquetas elEtiqueta = null;
        String sqlC = "SELECT id_etiqueta, nombre, creado, actualizado FROM Etiquetas Where id_etiqueta=?";
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, id_etiqueta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, lisParametros);
            while (rst.next()) {
                elEtiqueta = new Etiquetas();
                elEtiqueta.setId_etiqueta(rst.getInt(1));
                elEtiqueta.setNombre(rst.getString(2));
                elEtiqueta.setCreado(rst.getDate(3));
                elEtiqueta.setActualizado(rst.getDate(4));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return elEtiqueta;
    }

    @Override
    public ArrayList<Etiquetas> obtener() throws Exception {
        ArrayList<Etiquetas> listEtiqueta = new ArrayList<>();
        Etiquetas nEtiqueta = null;
        String sqlC = "Select id_etiqueta, nombre, creado, actualizado from Etiquetas";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sqlC, null);
            while (rst.next()) {
                nEtiqueta = new Etiquetas();
                nEtiqueta.setId_etiqueta(rst.getInt(1));
                nEtiqueta.setNombre(rst.getString(2));
                nEtiqueta.setCreado(rst.getDate(3));
                nEtiqueta.setActualizado(rst.getDate(4));
                listEtiqueta.add(nEtiqueta);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return listEtiqueta;
    }

}
