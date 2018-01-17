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
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IEtiquetaspublicaciones etiquetaspublicacionesDao = new ImplEtiquetaspublicaciones();
        IEtiquetas etiquetasDao = new ImplEtiquetas();
        Etiquetas etiquetas = etiquetasDao.obtener(1);
        IPublicaciones publicacionesDao = new ImplPublicaciones();
        Publicaciones publicaciones = publicacionesDao.obtener(1);
        Etiquetaspublicaciones etiquetaspublicaciones = new Etiquetaspublicaciones(etiquetas,publicaciones,new Date(),new Date());
        
        try{
            filasAfectadas = etiquetaspublicacionesDao.insertar(etiquetaspublicaciones);
            System.out.println("Ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
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
