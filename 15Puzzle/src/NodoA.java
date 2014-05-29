

public class NodoA
    implements Comparable
{

    public NodoA(Problema p, double c, double m, String a)
    {
        problem = p;
        costo = c;
        Manhattan = m;
        accion = a;
    }

    public Problema problema()
    {
        return problem;
    }

    public double g()
    {
        return costo;
    }

    public void g(double d)
    {
        costo = d;
    }

    public double m()
    {
        return Manhattan;
    }

    public String accion()
    {
        return accion;
    }

    @Override
    public int hashCode()
    {
        return problem.hashCode();
    }

    @Override
    public int compareTo(Object o)
    {
        if(o instanceof NodoA)
        {
            NodoA n = (NodoA)o;
            if(n.problema().equals(problem))
                return 0;
            return n.g() + n.m() >= g() + m() ? -1 : 1;
        } else
        {
            return -2;
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof NodoA)
        {
            NodoA n = (NodoA)o;
            return n.problema().equals(problem);
        } else
        {
            return false;
        }
    }

    private Problema problem;
    private double costo;
    private double Manhattan;
    private String accion;
}
