package unach.trabajogithub.dao;

import java.util.ArrayList;
import unach.trabajogithub.entidades.*;

public interface INiveles {
public int insertar (Niveles niveles) throws Exception;
    public Niveles obtener(String id_niveles) throws Exception;
    public ArrayList<Niveles> obtener () throws Exception;       
}
