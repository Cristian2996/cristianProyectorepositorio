package unach.trabajogithub.dao;

import java.util.ArrayList;
import unach.trabajogithub.entidades.*;
import java.util.*;

public interface INiveles {
public int insertar (Niveles niveles) throws Exception;
    public Niveles obtener(int id_niveles) throws Exception;
    public ArrayList<Niveles> obtener () throws Exception;       
}
