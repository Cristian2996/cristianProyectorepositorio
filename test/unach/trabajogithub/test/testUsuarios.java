package unach.trabajogithub.test;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import unach.trabajogithub.dao.*;
import unach.trabajogithub.entidades.*;
import unach.trabajogithub.impl.*;

public class testUsuarios {

    public testUsuarios() {
    }

    @Test
    public void pruebageneral() throws Exception {
        //              INSERTAR
        int filasAfectadas = 0;
        IUsuarios usuariosDao = new ImplUsuarios();
        IRoles rolesDao = new ImplRoles();
        Roles roles = rolesDao.obtener(51);
        Usuarios usuarios = new Usuarios(1215,roles, "Carlos", "carlosmorales@gmail.com", "1224566777",new Date(),new Date());
        try {
            filasAfectadas = usuariosDao.insertar(usuarios);
            System.out.println("Usuario ingresado!!!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filasAfectadas > 0, true);
        //              LISTADO DE PEDIDO
        List<Usuarios> lista = new ArrayList<>();
        try {
            lista = usuariosDao.obtener();
            for (Usuarios c : lista) {
                System.out.println("---Datos usuarios---");
                System.out.println("Identificacion :" + c.getId_usuario());
                System.out.println("Codigo  :" + c.getRoles().getId_roles());
                System.out.println("Nombre  :" + c.getNombre());
                System.out.println("Email :" + c.getEmail());
                System.out.println("Password :" + c.getPassword());
                System.out.println("Creacion :" + c.getCreado());
                System.out.println("Actualizacion :" + c.getActualizado());

            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size() > 0);
    }
}
