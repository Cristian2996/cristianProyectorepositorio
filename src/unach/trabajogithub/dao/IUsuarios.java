package unach.trabajogithub.dao;

import java.util.ArrayList;
import unach.trabajogithub.entidades.Usuarios;

public interface IUsuarios {
    public int insertar (Usuarios usuarios) throws Exception;
    public Usuarios obtener(int id_usuario) throws Exception;
    public ArrayList<Usuarios> obtener () throws Exception;    
}
