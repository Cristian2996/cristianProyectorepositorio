package unach.trabajogithub.dao;

import java.util.ArrayList;
import unach.trabajogithub.entidades.Publicaciones;

public interface IPublicaciones {
    public int insertar (Publicaciones publicaciones) throws Exception;
    public Publicaciones obtener(int id_publicaciones) throws Exception;
    public ArrayList<Publicaciones> obtener () throws Exception;
}
