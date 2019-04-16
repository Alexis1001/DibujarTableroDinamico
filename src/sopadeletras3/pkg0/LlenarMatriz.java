/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras3.pkg0;

import java.util.Random;

/**
 *
 * @author PC
 */
public class LlenarMatriz {
   
   
    String MatrizCaracteres[][];
    String abecedario;
    int numero;
   LlenarMatriz(String MatrizCaracteres[][]){
      this.MatrizCaracteres=MatrizCaracteres;
      this.abecedario="";
      this.numero=0;
   }
   
  public String[][] GetMatrizCaracteres(){
    Random numeros=new Random();
    abecedario="abcdefghijklmnñopqrstuvwxyz";
    this.MatrizCaracteres[0][0]="*";
    this.MatrizCaracteres[0][this.MatrizCaracteres.length-1]="*";
     
        for(int i=1;i<this.MatrizCaracteres.length-1;i++){
           this.MatrizCaracteres[0][i]=String.valueOf(i);
        }
        for(int i=1;i<this.MatrizCaracteres.length-1;i++){
           this.MatrizCaracteres[i][0]=String.valueOf(i);
        }
        for(int i=0;i<this.MatrizCaracteres.length;i++){
           this.MatrizCaracteres[this.MatrizCaracteres.length-1][i]="*";
        }
        for(int i=0;i<this.MatrizCaracteres.length;i++){
            this.MatrizCaracteres[i][this.MatrizCaracteres.length-1]="*";
        }
        for(int i=0;i<this.MatrizCaracteres.length;i++){
            for(int j=0;j<this.MatrizCaracteres.length;j++){
                if(this.MatrizCaracteres[i][j].equals("")){
                   numero=numeros.nextInt(25);
                   this.MatrizCaracteres[i][j]=abecedario.substring(numero,numero+1);
                } 
            }
        }
     return this.MatrizCaracteres; 
    }
       
        
 }
