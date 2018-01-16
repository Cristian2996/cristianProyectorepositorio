package unach.trabajogithub.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import unach.trabajogithub.dao.*;
import unach.trabajogithub.entidades.*;
import unach.trabajohithub.accesodatos.Conexion;
import unach.trabajohithub.accesodatos.Parametro;

public class ImplPublicaciones implements IPublicaciones {

    @Override
    public int insertar(Publicaciones publicaciones) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Publicaciones (id_publicaciones, id_usuario, id_niveles, titulo, contenido, publicado,vistas, votos, creado, actualizado) Values (?,?,?,?,?,?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, publicaciones.getId_publicaciones()));
        lstP.add(new Parametro(2, publicaciones.getUsuarios().getId_usuario()));
        lstP.add(new Parametro(3, publicaciones.getNiveles().getId_niveles()));
        lstP.add(new Parametro(4, publicaciones.getTitulo()));
        lstP.add(new Parametro(5, publicaciones.getContenido()));
        lstP.add(new Parametro(6, publicaciones.getPublicado()));
        lstP.add(new Parametro(7, publicaciones.getVistas()));
        lstP.add(new Parametro(8, publicaciones.getVotos()));
       if (publicaciones.getCreado() instanceof java.util.Date) {
            lstP.add(new Parametro(9, new java.sql.Date(((java.util.Date) publicaciones.getCreado()).getTime())));
        } else {
            lstP.add(new Parametro(9, publicaciones.getCreado()));
        }
        if (publicaciones.getActualizado() instanceof java.util.Date) {
            lstP.add(new Parametro(10, new java.sql.Date(((java.util.Date) publicaciones.getActualizado()).getTime())));
        } else {
            lstP.add(new Parametro(10, publicaciones.getActualizado()));
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
    public Publicaciones obtener(int id_publicaciones) throws Exception {
       Publicaciones publi = null;
        Usuarios usuarios=null;
        IUsuarios usuariosDao=new ImplUsuarios();
        Niveles niveles=null;
        INiveles nivelesDao=new ImplNiveles();
        String csql = "Select id_publicaiones, id_usuarios, id_niveles, titulo, contenido, publicado,vistas, votos, creado, actualizado  From Publicaciones Where id_publicaciones=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_publicaciones));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                usuarios = new Usuarios();
                usuarios =usuariosDao.obtener(rst.getInt(2));
                niveles = new Niveles();
                niveles=nivelesDao.obtener(rst.getString(3));
                publi=new Publicaciones();
                publi.setId_publicaciones(rst.getInt(1));
                publi.setUsuarios(usuarios);
                publi.setNiveles(niveles);
                publi.setTitulo(rst.getString(4));
                publi.setContenido(rst.getString(5));
                publi.setPublicado(rst.getString(6));
                publi.setVistas(rst.getInt(7));
                publi.setVotos(rst.getInt(8));
                publi.setCreado(rst.getDate(9));
                publi.setActualizado(rst.getDate(10));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return publi;
    }

    @Override
    public ArrayList<Publicaciones> obtener() throws Exception {
        ArrayList<Publicaciones> publica = new ArrayList<>();
        Usuarios usuarios=null;
        IUsuarios usuariosDao=new ImplUsuarios();
        Niveles niveles=null;
        INiveles nivelesDao=new ImplNiveles();
        String csql="select id_publicaiones, id_usuarios, id_niveles, titulo, contenido, publicado,vistas, votos, creado, actualizado from Publicaciones";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Publicaciones publi=null;
            while(rst.next()){
                usuarios = new Usuarios();
                usuarios = usuariosDao.obtener(rst.getInt(2));
                niveles = new Niveles();
                niveles = nivelesDao.obtener(rst.getString(3));
                publi=new Publicaciones();
                publi.setId_publicaciones(rst.getInt(1));
                publi.setUsuarios(usuarios);
                publi.setNiveles(niveles);
                publi.setTitulo(rst.getString(4));
                publi.setContenido(rst.getString(5));
                publi.setPublicado(rst.getString(6));
                publi.setVistas(rst.getInt(7));
                publi.setVotos(rst.getInt(8));
                publi.setCreado(rst.getDate(9));
                publi.setActualizado(rst.getDate(10));
                publica.add(publi);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return publica;
    }
    }
    
