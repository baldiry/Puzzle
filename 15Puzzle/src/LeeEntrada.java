
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moloa
 */
public class LeeEntrada {
    
   public int[] a = new int[16];
   public int[] b = new int[16];
   
     int numFilaA=0;
         int numFilaB=0;
   
    public void lee(){
        
         String texto;
         int c = 0;
         int cc=0;
         int p=0;
         
       
         
         int conta=0;
         int conta0=0;
         
      File archivo = null;
      FileReader fr = null;
      BufferedReader sr = null;
 
      try {
       
         archivo = new File ("puzzle.txt");
         fr = new FileReader (archivo);
         sr = new BufferedReader(fr);
 
         String [] temp = new String[4];
       
                texto = sr.readLine();
                
                while (texto != null)
                {
                    
           
                    if(p>=4){
                      conta++;
                    int t = c + 4;
                    int k=0;
                   
                     temp=texto.split(" ");
                    for (; c < t ; c++)
                    {
                        if(Integer.parseInt(temp[k])==0){
                            numFilaB=conta;
                        }
                        
                        b[c] = Integer.parseInt(temp[k]);
                            k++;
                    
                    }
                        }
                        
                   
                    
                    else{
                        int t = cc + 4;
                    int k=0;
                    conta0++;
                    temp=texto.split(" ");
                    for (; cc < t ; cc++)
                    {
                         if(Integer.parseInt(temp[k])==0){
                            numFilaA=conta0;
                        }
                        a[cc] = Integer.parseInt(temp[k]);
                            k++;
                    }
                    //System.out.println(p);
                   
                    }
                            
                    texto = sr.readLine();
                        p++;
                      
                          
                   
                }
                sr.close();
      }
      catch(Exception e){
          
      }
       
}
    
    
    
    
    public static void main(String []a){
  
        
     
        
        
    }
}
