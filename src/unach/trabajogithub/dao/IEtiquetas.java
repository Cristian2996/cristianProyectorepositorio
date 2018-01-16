package unach.trabajogithub.dao;
import java.util.ArrayList;
import unach.trabajogithub.entidades.Etiquetas;

public interface IEtiquetas {
   public int insertar (Etiquetas etiquetas) throws Exception;
    public Etiquetas obtener(String id_etiqueta) throws Exception;
    public ArrayList<Etiquetas> obtener () throws Exception;    
}
