

public class Nodo
{

    public Nodo(Problema p, double c, String a)
    {
        pro = p;
        costo = c;
        acc = a;
    }

    public Problema problema()
    {
        return pro;
    }

    public double coste()
    {
        return costo;
    }

    public double cambiarCoste(double d)
    {
        costo = d;
        return costo;
    }

    public String accion()
    {
        return acc;
    }

    @Override
    public String toString()
    {
        return (new StringBuilder()).append(acc).append("\n").toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Nodo)
            return ((Nodo)o).problema().equals(pro);
        if(o instanceof NodoA)
            return ((NodoA)o).problema().equals(pro);
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        return pro.hashCode();
    }

    private Problema pro;
    private double costo;
    private String acc;
}
