package unach.trabajogithub.dao;

import java.util.ArrayList;
import unach.trabajogithub.entidades.*;

public interface IEtiquetaspublicaciones {
    public int insertar (Etiquetaspublicaciones etiquetaspublicacion) throws Exception;
    public Etiquetaspublicaciones obtener(int id_etiqueta,int id_publicaciones) throws Exception;
    public ArrayList<Etiquetaspublicaciones> obtener () throws Exception;
}
