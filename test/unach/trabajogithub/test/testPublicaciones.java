package unach.trabajogithub.test;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogithub.dao.IPublicaciones;
import unach.trabajogithub.entidades.Niveles;
import unach.trabajogithub.entidades.Publicaciones;
import unach.trabajogithub.entidades.Roles;
import unach.trabajogithub.entidades.Usuarios;
import unach.trabajogithub.impl.ImplPublicaciones;

public class testPublicaciones {

    public testPublicaciones() {
    }
    @Test
    public void pruebageneral() throws Exception {
        //              INSERTAR
        int filasAfectadas = 0;
        IPublicaciones publicacionesDao = new ImplPublicaciones();
        Roles roles = new Roles(51,"Marlon",new Date(),new Date());
        Usuarios usuarios = new Usuarios(61,roles,"Danilo","merino1212@gmail.com","23456781a",new Date(),new Date());
        Niveles niveles = new Niveles(3,"Luis",new Date(),new Date());
        Publicaciones publicaciones = new Publicaciones(121,usuarios,niveles,"Los Planchados", "Proyecto de planchado", "Dia Lunes", 100, 200,new Date(),new Date());
        try {
            filasAfectadas = publicacionesDao.insertar(publicaciones);
            System.out.println("Publicacion ingresado!!!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filasAfectadas > 0, true);
        //              LISTADO DE PEDIDO
        List<Publicaciones> lista = new ArrayList<>();
        try {
            lista = publicacionesDao.obtener();
            for (Publicaciones c : lista) {
                System.out.println("---Datos Publicacion---");
                System.out.println("Codigo Publicacion :" + c.getId_publicaciones());
                System.out.println("Codigo Nivel :" + c.getNiveles().getId_niveles());
                System.out.println("Nombre Usuario :" + c.getUsuarios().getId_usuario());
                System.out.println("Titulo :" + c.getTitulo());
                System.out.println("Contenido :" + c.getContenido());
                System.out.println("Publicado :" + c.getPublicado());
                System.out.println("Vistas :" + c.getVistas());
                System.out.println("Votos :" + c.getVotos());
                System.out.println("Creacion :" + c.getCreado());
                System.out.println("Actualizacion :" + c.getActualizado());

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size() > 0);
    }
}
