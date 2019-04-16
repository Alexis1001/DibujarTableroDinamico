/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras3.pkg0;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class TamanoMatriz {
    ArrayList<String> palabras=new ArrayList<String>();
    String palabrax="";
   public TamanoMatriz(){
     this.palabras=palabras;
    
     } 
    
    public void SetRecibePalabras(ArrayList<String> palabras){
      this.palabras=palabras;
     }
   
    public int GetTamano(){
       int mayor=0;
       int aux=0;
        
        for(int i=0;i<palabras.size();i++){
            mayor=palabras.get(i).length();
            if(mayor>aux){
               aux=mayor;             
            }
        }
       return aux;
    } 
    
    public String GetObtenerPalabras(){
       
       for(int i=0;i<palabras.size();i++){
           palabrax=palabrax+(i+1)+" "+palabras.get(i)+" "+"\n";
           System.out.println("palabra "+(i+1)+" "+palabras.get(i));
        }
      return palabrax; 
    } 
    
    
}
