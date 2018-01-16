package unach.trabajogithub.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogithub.dao.INiveles;
import unach.trabajogithub.entidades.Niveles;
import unach.trabajogithub.impl.ImplNiveles;

public class testNiveles {

    public testNiveles() {
    }
    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        INiveles nivelesDao = new ImplNiveles();
        Niveles niveles = new Niveles(3,"Look",new Date(),new Date());
        try{
            filasAfectadas = nivelesDao.insertar(niveles);
            System.out.println("Nivel ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);

        List<Niveles> lista = new ArrayList<>();
        try {
            lista = nivelesDao.obtener();
            for (Niveles c:lista){
            System.out.println("Datos Etiqueta");
            System.out.println("Identidad  :"+c.getId_niveles());
            System.out.println("Nombre :"+c.getNombre());
            System.out.println("Creado :"+c.getCreado());
            System.out.println("Actualizado :"+c.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}
