/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moloa
 */
public class ValidaEntrada {
    
     public static int permutacion(int [] cuadro){
     int contador=0;
     
     for(int i=0; i< cuadro.length; i++){
         for(int k=i+1; k<cuadro.length; k++){
             if(cuadro[i]>cuadro[k]){
                 if(cuadro[k]!=0){
                 contador++;
                }
             }
        }
     }
          
    return contador;
     
 }
     
     public boolean esValida(int[] a,int [] b){
         
         LeeEntrada lee= new LeeEntrada();
         lee.lee();
         
         int ta=lee.numFilaA;
         int tb=lee.numFilaB;
         
         boolean valido=true;
         int ax= permutacion(a)+ta;
         int bx= permutacion(b)+tb;
         
         System.out.println(bx);
          if(  ((ax%2)==0 && (bx%2)==0) ){
                return valido;
            }
            if(  ((ax%2)==1 && (bx%2)==1) ){
                return valido;
            }
            
     else{
         return !valido;
     }
            
     }

    
}
