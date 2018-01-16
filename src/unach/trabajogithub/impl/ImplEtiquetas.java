package unach.trabajogithub.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import unach.trabajogithub.dao.IEtiquetas;
import unach.trabajogithub.entidades.Etiquetas;
import unach.trabajohithub.accesodatos.Conexion;
import unach.trabajohithub.accesodatos.Parametro;

public class ImplEtiquetas implements IEtiquetas {
    @Override
    public int insertar(Etiquetas etiquetas) throws Exception {
 int nFilas = 0;
        String csql = "Insert into Etiquetas (id_etiqueta, nombre, creado, actualizado) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, etiquetas.getId_etiqueta()));
        lstP.add(new Parametro(2, etiquetas.getNombre()));
         if (etiquetas.getCreado() instanceof java.util.Date) {
            lstP.add(new Parametro(3, new java.sql.Date(((java.util.Date) etiquetas.getCreado()).getTime())));
        } else {
            lstP.add(new Parametro(3, etiquetas.getCreado()));
        }
        if (etiquetas.getActualizado() instanceof java.util.Date) {
            lstP.add(new Parametro(4, new java.sql.Date(((java.util.Date) etiquetas.getActualizado()).getTime())));
        } else {
            lstP.add(new Parametro(4, etiquetas.getActualizado()));
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
    public Etiquetas obtener(String id_etiqueta) throws Exception {
        Etiquetas eti = null;
        String csql = "Select id_etiqueta, nombre, creado, actualizado From Etiquetas Where id_etiqueta=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_etiqueta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                eti=new Etiquetas();
                eti.setId_etiqueta(rst.getInt(1));
                eti.setNombre(rst.getString(2));
                eti.setCreado(rst.getDate(3));
                eti.setActualizado(rst.getDate(4));
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return eti;
    }

    @Override
    public ArrayList<Etiquetas> obtener() throws Exception {
         ArrayList<Etiquetas> etiq = new ArrayList<>();
        String csql="select id_etiqueta, nombre, creado, actualizado from Etiquetas";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Etiquetas eti=null;
            while(rst.next()){
                eti=new Etiquetas();
                eti.setId_etiqueta(rst.getInt(1));
                eti.setNombre(rst.getString(2));
                eti.setCreado(rst.getDate(3));
                eti.setActualizado(rst.getDate(4));
                etiq.add(eti);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return etiq;
    }    
}
