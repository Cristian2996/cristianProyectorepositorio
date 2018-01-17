package unach.trabajogithub.test;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogithub.dao.IRoles;
import unach.trabajogithub.entidades.Roles;
import unach.trabajogithub.impl.ImplRoles;

public class testRoles {

    public testRoles() {
    }
    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        IRoles rolesDao = new ImplRoles();
        Roles roles = new Roles(3,"Look",new Date(),new Date());
        try{
            filasAfectadas = rolesDao.insertar(roles);
            System.out.println("Roles ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);

        List<Roles> lista = new ArrayList<>();
        try {
            lista = rolesDao.obtener();
            for (Roles c:lista){
            System.out.println("Datos Roles");
            System.out.println("Identidad  :"+c.getId_roles());
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
