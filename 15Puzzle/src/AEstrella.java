
import java.util.*;

public class AEstrella extends Busqueda
{

    public AEstrella()
    {
    }

    public static LinkedList Resolver(Problema p)
    {
        HashMap a = new HashMap();
        HashMap g = new HashMap();

       
        TreeSet abierta = new TreeSet();
        NodoA problema_inicial = new NodoA(p, 0.0D, p.Manhattan(), new String("Nodo Inicial"));
       
        abierta.add(problema_inicial);
        a.put(p, problema_inicial);
        while(abierta.size() != 0) 
        {
            NodoA n = (NodoA)abierta.first();
            
            abierta.remove(n);
            if(n.problema().EsObjetivo())
            {
                LinkedList solucion = new LinkedList();
                Nodo nodo;
                for(Problema padre = n.problema(); !padre.equals(p); nodo.cambiarCoste(nodo.coste() - ((NodoA)a.get(padre)).g()))
                {
                    nodo = new Nodo(padre, ((NodoA)a.get(padre)).g(), ((NodoA)a.get(padre)).accion());
                    solucion.addFirst(nodo);
                    padre = ((NodoA)a.get(padre)).problema();
                }

               
                return solucion;
            }
            LinkedList Siguientes_n = n.problema().Siguientes();
            g.put(n.problema(), Siguientes_n);
            for(ListIterator i = Siguientes_n.listIterator(); i.hasNext();)
            {
                Nodo c = (Nodo)i.next();
                NodoA nuevo_nodo = null;
                boolean nodo_visitado = a.containsKey(c.problema());
                if(nodo_visitado)
                    nuevo_nodo = new NodoA(n.problema(), c.coste() + ((NodoA)a.get(n.problema())).g(), ((NodoA)a.get(n.problema())).m(), c.accion());
                else
                    nuevo_nodo = new NodoA(n.problema(), c.coste() + ((NodoA)a.get(n.problema())).g(), c.problema().Manhattan(), c.accion());
                if(abierta.contains(nuevo_nodo))
                {
                    rectificar(nuevo_nodo, n.problema(), c.problema(), c.coste(), a, abierta);
                } else
                if(nodo_visitado)
                {
                    if(rectificar(nuevo_nodo, n.problema(), c.problema(), c.coste(), a, abierta))
                        rectificarlista((LinkedList)g.get(c.problema()), nuevo_nodo, a, g, abierta);
                } else
                {
                    a.put(c.problema(), nuevo_nodo);
                    nuevo_nodo = new NodoA(c.problema(), c.coste() + ((NodoA)a.get(n.problema())).g(), c.problema().Manhattan(), c.accion());
                    abierta.add(nuevo_nodo);
                }
            }

        }

        return null;
    }

    private static boolean rectificar(NodoA n, Problema p, Problema hijo, double coste_ph, HashMap a, TreeSet abierta)
    {
        double m = ((NodoA)a.get(hijo)).m();
        double g_nuevo = ((NodoA)a.get(p)).g() + coste_ph;
        double g_actual = ((NodoA)a.get(hijo)).g();
        if(g_actual > g_nuevo)
        {
            NodoA actualizado = new NodoA(p, g_nuevo, m, n.accion());
            a.put(hijo, actualizado);
       
            if(abierta.contains(n))
            {
                abierta.remove(n);
                NodoA nuevo_nodo = new NodoA(hijo, ((NodoA)a.get(hijo)).g(), ((NodoA)a.get(hijo)).m(), n.accion());
                abierta.add(nuevo_nodo);
            }
            return true;
        } else
        {
            return false;
        }
    }

    private static void rectificarlista(LinkedList l, NodoA p, HashMap a, HashMap g, TreeSet abierta)
    {
        if(l != null)
        {
            for(ListIterator it = l.listIterator(); it.hasNext();)
            {
                Nodo n = (Nodo)it.next();
                NodoA nuevo_nodo = new NodoA(n.problema(), p.g() + n.coste(), n.problema().Manhattan(), n.accion());
                if(rectificar(nuevo_nodo, p.problema(), n.problema(), n.coste(), a, abierta))
                    rectificarlista((LinkedList)g.get(n.problema()), nuevo_nodo, a, g, abierta);
            }

        }
    }

   
}
