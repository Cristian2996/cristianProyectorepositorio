package unach.trabajogithub.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogithub.dao.*;
import unach.trabajogithub.entidades.*;
import unach.trabajogithub.impl.*;

public class testEtiquetaspublicaciones {

    public testEtiquetaspublicaciones() {
    }
 @Test
    public void pruebageneral() throws Exception {
        //              INSERTAR
        int filasAfectadas = 0;
        IEtiquetaspublicaciones etiquetaspublicacionesDao = new ImplEtiquetaspublicaciones();
        Etiquetas etiquetas = new Etiquetas(789,"Pablo",new Date(),new Date());
        Roles roles = new Roles(356,"Marco",new Date(),new Date());
        Usuarios usuarios = new Usuarios(333,roles,"Pedro","pedromorales@gmail.com","23456789s",new Date(), new Date());
        Roles roles = new Roles();
        Etiquetaspublicaciones etiquetaspublicaciones = new Etiquetaspublicaciones(etiquetas,publicaciones, new Date(), new Date());
        try {
            filasAfectadas = etiquetaspublicacionesDao.insertar(etiquetaspublicaciones);
            System.out.println("Etiqueta - Publicacion ingresado!!!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filasAfectadas > 0, true);
        //              LISTADO DE PEDIDO
        List<Etiquetaspublicaciones> lista = new ArrayList<>();
        try {
            lista = etiquetaspublicacionesDao.obtener();
            for (Etiquetaspublicaciones c : lista) {
                System.out.println("---Datos Publicacion---");
                System.out.println("Codigo Etiqueta :" + c.getEtiquetas().getId_etiqueta());
                System.out.println("Nombre Publicaciones :" + c.getPublicaciones().getId_publicaciones());
                System.out.println("Creacion :" + c.getCreado());
                System.out.println("Actualizacion :" + c.getActualizado());

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size() > 0);
    }    
}
