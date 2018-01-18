package unach.trabajogithub.dao;

import java.util.ArrayList;
import unach.trabajogithub.entidades.Roles;
import java.util.*;

public interface IRoles {
public int insertar (Roles roles) throws Exception;
    public Roles obtener(int id_roles) throws Exception;
    public ArrayList<Roles> obtener () throws Exception;       
}
