import java.util.LinkedList;

public class Puzzle 
extends Problema 
{
	private int[][] puzzle;
	static private int[][]objetivo;
	private int fi;
	private int co;
	
	public Puzzle(int[][] matriz, int[][] obj){
		
		puzzle = matriz;
		objetivo = obj;
		profundidad=0;

		for (int i=0; i < matriz.length; ++i){
			for (int j=0; j < matriz[i].length; ++j){
				if (matriz[i][j]==0){
					fi = i;
					co = j;
				}
			}
		}
	}
	
	private Puzzle (int[][] matriz, int p, int f, int c){
		puzzle = matriz;
		profundidad = p;
		fi = f;
		co = c;
	}

	
        @Override
	public LinkedList<Nodo> Siguientes(){
		LinkedList<Nodo> sig = new LinkedList<Nodo>();
		
		if((fi+1)<puzzle.length){
			int[][] copia = new int[puzzle.length][puzzle[0].length];
			
			for (int i=0; i < puzzle.length; ++i)
				for (int j=0; j < puzzle[i].length; ++j)
					copia[i][j]=puzzle[i][j];
			
			copia[fi][co] = copia[fi+1][co];
			copia[fi+1][co] = 0;
			Puzzle t = new Puzzle(copia,profundidad+1,fi+1,co);
			sig.add(new Nodo(t,1, ("Mueve "+ copia[fi][co] +" hacia arriba")));
		}
		
		if((co+1)<puzzle[0].length){
			int[][] copia = new int[puzzle.length][puzzle[0].length];
			
			for (int i=0; i < puzzle.length; ++i)
				for (int j=0; j < puzzle[i].length; ++j)
					copia[i][j]=puzzle[i][j];
			
			copia[fi][co] = copia[fi][co+1];
			copia[fi][co+1] = 0;
			Puzzle t = new Puzzle(copia,profundidad+1,fi,co+1);
			sig.add(new Nodo(t,1, ("Mueve " + copia[fi][co] + " hacia izquierda")));
		}
		
		if((fi-1)>=0){
			int[][] copia = new int[puzzle.length][puzzle[0].length];
			
			for (int i=0; i < puzzle.length; ++i)
				for (int j=0; j < puzzle[i].length; ++j)
					copia[i][j]=puzzle[i][j];
			
			copia[fi][co] = copia[fi-1][co];
			copia[fi-1][co] = 0;
			Puzzle t = new Puzzle(copia,profundidad+1,fi-1,co);
			sig.add(new Nodo(t,1, ("Mueve " + copia[fi][co] + " hacia abajo")));
		}
		
		if((co-1)>=0){
			int[][] copia = new int[puzzle.length][puzzle[0].length];
			
			for (int i=0; i < puzzle.length; ++i)
				for (int j=0; j < puzzle[i].length; ++j)
					copia[i][j]=puzzle[i][j];
			
			copia[fi][co] = copia[fi][co-1];
			copia[fi][co-1] = 0;
			Puzzle t = new Puzzle(copia,profundidad+1,fi,co-1);
			sig.add(new Nodo(t,1, ("Mueve " + copia[fi][co] + " hacia derecha")));
		}
		
		return sig;
	}
        
        @Override
        public boolean EsObjetivo(){
		if (objetivo.length!=puzzle.length) return false;
		for (int i=0; i < objetivo.length; ++i)
			for (int j=0; j < objetivo[i].length; ++j)
				if (objetivo[i][j]!=puzzle[i][j]) return false;
		return true;
	}

        @Override
	public double Manhattan(){
		// Algoritmo que calcula la suma de las distancias manhattan
		// hasta la solucion
		double suma=0;
			
		for (int i=0; i < puzzle.length; ++i){
			for (int j=0; j < puzzle[i].length; ++j){
				if(objetivo[i][j]!=puzzle[i][j]){
					//Buscamos la posición correcta para la ficha en puzzle[i][j]
					int i2=0, j2=0;
					while(i2<objetivo.length && (objetivo[i2][j2]!=puzzle[i][j])){
						j2++;
						if (j2 >= objetivo[i2].length) {
			                               i2++;
			                               j2=0;
                        			}  
					}
					//En [i2][j2] estó la posición correcta
					suma+=Math.abs(i2-i)+Math.abs(j2-j);
				}
			}
		}
		
		return suma;
	}
	
        @Override
	public int hashCode(){
		int suma = 0, num;
		for (int i=0; i < puzzle.length; ++i){
			num = 0;
			for (int j=0; j < puzzle[i].length; ++j)
				num += puzzle[i][j] * Math.pow(10,puzzle[i].length-(j+1));
			suma+=num*(i+1);
		}
		
		return suma;
	}
	
        @Override
	public boolean equals( Object c ){
		if ( c instanceof Puzzle ){
			Puzzle n = (Puzzle)c;
			if (n.puzzle.length!=puzzle.length) return false;
			for (int i=0; i < puzzle.length; ++i)
				for (int j=0; j < puzzle[i].length; ++j)
					if (n.puzzle[i][j]!=puzzle[i][j]) return false;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		long inicio, fin;
		LinkedList<Nodo> sol;
		
         LeeEntrada po = new LeeEntrada();
         //lecura del fichero
         po.lee();
         
         ValidaEntrada va= new ValidaEntrada();
        
            int [] ax=po.a;
            int [] bx=po.b;
         
         if( va.esValida(po.a, po.b)){
                
		int[][] inicial = new int[4][4];
		int[][] objetiv = new int[4][4];
		
                
		inicial[0][0] = ax[0];
		inicial[0][1] = ax[1];
		inicial[0][2] = ax[2];
		inicial[0][3] = ax[3];
		
		inicial[1][0] = ax[4];
		inicial[1][1] = ax[5];
		inicial[1][2] = ax[6];
		inicial[1][3] = ax[7];
		
		inicial[2][0] = ax[8];
		inicial[2][1] = ax[9];
		inicial[2][2] = ax[10];
		inicial[2][3] = ax[11];
			
		inicial[3][0] = ax[12];
		inicial[3][1] = ax[13];
		inicial[3][2] = ax[14];
		inicial[3][3] = ax[15];

		
		objetiv[0][0] = bx[0];
		objetiv[0][1] = bx[1];
		objetiv[0][2] = bx[2];
		objetiv[0][3] = bx[3];
		
		objetiv[1][0] = bx[4];
		objetiv[1][1] = bx[5];
		objetiv[1][2] = bx[6];
		objetiv[1][3] = bx[7];
		
		objetiv[2][0] = bx[8];
		objetiv[2][1] = bx[9];
		objetiv[2][2] = bx[10];
		objetiv[2][3] = bx[11];
		
		objetiv[3][0] = bx[12];
		objetiv[3][1] = bx[13];
		objetiv[3][2] = bx[14];
		objetiv[3][3] = bx[15];
		
		
		Puzzle a = new Puzzle(inicial,objetiv);
		System.out.println("Resolviendo...");
		System.out.println("--------------------------------------------");		
		inicio = System.currentTimeMillis();
		sol = AEstrella.Resolver(a);
		fin = System.currentTimeMillis();
		System.out.println("La solución es la siguiente: \n"+sol);
                System.out.println("Se ha llevado: "+sol.size()+" pasos");
		System.out.println("Tardo: "+ ((fin-inicio)/1000.0) +" segundos en ser resuelto");
		
        }else{
    System.out.println("No tiene solucion");
}

  }
}
