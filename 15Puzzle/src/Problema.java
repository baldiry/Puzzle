

import java.util.HashMap;
import java.util.LinkedList;

public class Problema
{

    public Problema()
    {
        id_prob = -1;
    }

    public int identificador()
    {
        if(id_prob == -1)
            if(probhm.containsKey(this))
            {
                id_prob = ((Integer)probhm.get(this)).intValue();
            } else
            {
                instancias++;
                id_prob = instancias;
                probhm.put(this, Integer.valueOf(id_prob));
            }
        return id_prob;
    }

    public String nombre()
    {
        return nombre;
    }

    public LinkedList Siguientes()
    {
        return null;
    }

    public boolean EsObjetivo()
    {
        return false;
    }

    public double Manhattan()
    {
        return 0.0D;
    }

    public int Profundidad()
    {
        return profundidad;
    }

  

    protected int profundidad;
    protected static String nombre;
    private static int instancias = 0;
    private int id_prob;
    private static HashMap probhm = new HashMap();

}
