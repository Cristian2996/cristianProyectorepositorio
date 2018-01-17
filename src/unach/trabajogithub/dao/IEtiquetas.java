package unach.trabajogithub.dao;
import java.util.ArrayList;
import unach.trabajogithub.entidades.Etiquetas;
import java.util.*;

public interface IEtiquetas {
   public int insertar (Etiquetas etiquetas) throws Exception;
   public Etiquetas obtener(int id_etiqueta) throws Exception;
   public ArrayList<Etiquetas> obtener () throws Exception;   
    
}
