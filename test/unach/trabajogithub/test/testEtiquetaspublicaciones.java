package unach.trabajogithub.test;

import java.util.Date;
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
    public void testGeneral() {
        IEtiquetaspublicaciones etiquetaspublicacionesDao = new ImplEtiquetaspublicaciones();
        //TEST INSERTAR
        int filas = 0;
        Etiquetas etiq=new Etiquetas(12, "Lopez", new Date(), new Date());
        Roles nRol = new Roles(52, "MArlon", new Date(), new Date());
        Usuarios user = new Usuarios(62,nRol,"Marcelo" , "Lora", "Abril", new Date(), new Date());
        Niveles nuevoNivel=new Niveles(32, "jhon", new Date(), new Date());
        Publicaciones pulblicar=new Publicaciones(43, user, nuevoNivel, "123532", "ljsr", "Enero", 35, 7, new Date(), new Date());
        Etiquetaspublicaciones nEtiqPublic=new Etiquetaspublicaciones(etiq, pulblicar, new Date(), new Date());
        try {
            filas = etiquetaspublicacionesDao.insertar(nEtiqPublic);
            System.out.println("filas Insertadas:" + filas);
        } catch (Exception e) {
        }
        assertEquals(filas > 0, true);
        
             //              LISTADO DE PEdido
        List<Etiquetaspublicaciones> lista = new ArrayList<>();
        try {
            lista = etiquetaspublicacionesDao.obtener();
            for (Etiquetaspublicaciones c:lista){
                System.out.println("---Datos etiqueta_publicacion---");
                System.out.println("Etiqueta :"+c.getEtiquetas().getId_etiqueta());
                System.out.println("Publicacion :"+c.getPublicaciones().getId_publicaciones());
                System.out.println("Fecha creado :"+c.getCreado());
                System.out.println("Fecha actualizado :"+c.getActualizado());
                
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}
