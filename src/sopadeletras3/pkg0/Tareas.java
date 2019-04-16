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
public class Tareas extends Thread{
    
    String [][] Characteres; 
    String palabra; 
    ArrayList<String>Caminos=new ArrayList<String>();
    
    public Tareas(String [][] Characteres,String palabra){
      this.Characteres=Characteres;
      this.palabra=palabra;
    }
   
    public void run(){
   
      BusquedaUniversal();
       
     }
    
   public void BusquedaUniversal(){
     String perro1="",perro2="",perro3="",perro4="",perro5="",perro6="",perro7="",perro8="";
     boolean detener=false;
       
      for(int i=1;i<this.Characteres.length-1;i++){
          for(int j=1;j<this.Characteres.length-1;j++){
              if(this.Characteres[i][j].equals(palabra.substring(0,1))){
                  perro1=BusquedaDerecha(i,j);
                  if(perro1!=null){
                     System.out.println(perro1);
                     Caminos.add(perro1.substring(0,perro1.length()-palabra.length()));
                     detener=true;
                     break;
                    }
                  perro2=BusquedaIzquierda(i,j);
                   if(perro2!=null){
                     System.out.println(perro2);  
                     Caminos.add(perro2.substring(0,perro2.length()-palabra.length()));
                     detener=true;
                     break;
                    }
                  perro3=BusquedaArriba(i,j);
                   if(perro3!=null){
                      System.out.println(perro3);
                      Caminos.add(perro3.substring(0,perro3.length()-palabra.length()));
                      detener=true;
                     break;
                    }
                  perro4=BusquedaAbajo(i,j);
                  if(perro4!=null){
                     System.out.println(perro4);
                     Caminos.add(perro4.substring(0,perro4.length()-palabra.length()));
                     detener=true;
                     break;
                    }
                  perro5=BusquedaDiagonalArribaIzquierda(i,j);
                  if(perro5!=null){
                     System.out.println(perro5); 
                     Caminos.add(perro5.substring(0,perro5.length()-palabra.length()));
                     detener=true;
                     break;
                    }
                  perro6=BusquedaDiagonalArribaDerecha(i,j);
                  if(perro6!=null){
                     System.out.println(perro6); 
                     Caminos.add(perro6.substring(0,perro6.length()-palabra.length()));
                     detener=true;
                     break;
                    }
                  perro7= BusquedaDiagonalAbajoIzquierda(i,j);
                  if(perro7!=null){
                     System.out.println(perro7); 
                     Caminos.add(perro7.substring(0,perro7.length()-palabra.length()));
                     detener=true;
                     break;
                    }
                  perro8=BusquedaDiagonalAbajoDerecha(i,j);
                  if(perro8!=null){
                     System.out.println(perro8); 
                     Caminos.add(perro8.substring(0,perro8.length()-palabra.length()));
                     detener=true;
                     break;
                    }
                }
            }
            if(detener==true){
               break; 
            }
        }            
    }
   
    public String BusquedaDerecha(int i,int j){
      int inicio=1,fin=2,pocicion=0;
      boolean BanderaDerecha=true;
      int ContDerecha=0;    
      String encontrado="";   
      String camino="";
      String posi=String.valueOf(i),posj=String.valueOf(j);
      camino=camino+posi+" "+posj+"\n";
     do{
         pocicion++;
         if(this.Characteres[i][j+pocicion].equals(palabra.substring(inicio,fin))){
             inicio++;
             fin++;
             ContDerecha++;    
             posi=String.valueOf(i);
             posj=String.valueOf(j+pocicion);
             camino=camino+posi+" "+posj+"\n";
             if(ContDerecha==palabra.length()-1){
                 BanderaDerecha=false;
                 return encontrado=camino+"\n"+palabra;
                 } 
            }
           else{
             BanderaDerecha=false; 
             encontrado=null;
             }
        }while(BanderaDerecha==true); 
    return encontrado;
    } 
    
    public String BusquedaIzquierda(int i,int j){
      int inicio=1,fin=2,pocicion=0;
      boolean BanderaIzquierda=true;
      int ContIzquierda=0;    
      String encontrado=" ";
      String camino="";
      String posi=String.valueOf(i),posj=String.valueOf(j);
      camino=camino+posi+" "+posj+"\n";
      do{
          pocicion++;
          if(this.Characteres[i][j-pocicion].equals(palabra.substring(inicio,fin))){
             inicio++;
             fin++;
             ContIzquierda++; 
             posi=String.valueOf(i);
             posj=String.valueOf(j-pocicion);
             camino=camino+posi+" "+posj+"\n";
               if(ContIzquierda==palabra.length()-1){
                  BanderaIzquierda=false;
                  return encontrado=camino+"\n"+palabra;
                }
            }
            else{
             BanderaIzquierda=false;
             encontrado=null;
            }
        }while(BanderaIzquierda==true); 
    return encontrado;
    }
    
    public String BusquedaArriba(int i,int j){
     int inicio=1,fin=2,pocicion=0;
     boolean Arriba=true;
     int ContArriba=0; 
     String encontrado="";
     String camino="";
     String posi=String.valueOf(i),posj=String.valueOf(j);
     camino=camino+posi+" "+posj+"\n";
     do{
         pocicion++;
          if(this.Characteres[i-pocicion][j].equals(palabra.substring(inicio,fin))){
              inicio++;
              fin++;
              ContArriba++;
              posi=String.valueOf(i-pocicion);
              posj=String.valueOf(j);
              camino=camino+posi+" "+posj+"\n";
              if(ContArriba==palabra.length()-1){
                 Arriba=false;
                 return encontrado=camino+"\n"+palabra;
                }               
            }
            else{
              Arriba=false;
              encontrado=null;
            }
        }while(Arriba==true); 
    return encontrado;
    }
    
    public String BusquedaAbajo(int i,int j){
     int inicio=1,fin=2,pocicion=0;
     boolean Abajo=true;
     int ContAbajo=0; 
     String encontrado="";
     String camino="";
     String posi=String.valueOf(i),posj=String.valueOf(j);
     camino=camino+posi+" "+posj+"\n";
     do{
         pocicion++;
         if(this.Characteres[i+pocicion][j].equals(palabra.substring(inicio,fin))){
             inicio++;
             fin++;
             ContAbajo++;
             posi=String.valueOf(i+pocicion);
             posj=String.valueOf(j);
             camino=camino+posi+" "+posj+"\n";
             if(ContAbajo==palabra.length()-1){
                 Abajo=false;
                 return encontrado=camino+"\n"+palabra; 
                }
            }
            else{
             Abajo=false;
             encontrado=null;
            }
        }while(Abajo==true); 
     return encontrado;
    }
    
    public String BusquedaDiagonalArribaIzquierda(int i,int j){
       int inicio=1,fin=2,pocicioni=0,pocicionj=0;
       boolean ArribaDiagonalI=true;
       int Cont=0;
       String encontrado=""; 
       String camino="";
       String posi=String.valueOf(i),posj=String.valueOf(j);
       camino=camino+posi+" "+posj+"\n";
       do{
         pocicioni++;
         pocicionj++;
         if(this.Characteres[i-pocicioni][j-pocicionj].equals(palabra.substring(inicio,fin))){
             inicio++;
             fin++;
             Cont++;
             posi=String.valueOf(i-pocicioni);
             posj=String.valueOf(j-pocicionj);
             camino=camino+posi+" "+posj+"\n";
             if(Cont==palabra.length()-1){
                 ArribaDiagonalI=false;
                 return encontrado=camino+"\n"+palabra; 
                }
            }
            else{
             ArribaDiagonalI=false;
             encontrado=null;
            }
        }while(ArribaDiagonalI==true); 
     return encontrado;
    }
    
    public String BusquedaDiagonalArribaDerecha(int i,int j){
       int inicio=1,fin=2,pocicioni=0,pocicionj=0;
       boolean ArribaDiagonalD=true;
       int Cont=0;
       String encontrado=""; 
       String camino="";
       String posi=String.valueOf(i),posj=String.valueOf(j);
       camino=camino+posi+" "+posj+"\n";
       do{
         pocicioni++;
         pocicionj++;
         if(this.Characteres[i-pocicioni][j+pocicionj].equals(palabra.substring(inicio,fin))){
             inicio++;
             fin++;
             Cont++;
             posi=String.valueOf(i-pocicioni);
             posj=String.valueOf(j+pocicionj);
             camino=camino+posi+" "+posj+"\n";
             if(Cont==palabra.length()-1){
                 ArribaDiagonalD=false;
                 return encontrado=camino+"\n"+palabra; 
                }
            }
            else{
             ArribaDiagonalD=false;
             encontrado=null;
            }
        }while(ArribaDiagonalD==true); 
    return encontrado;
    }
    
    public String BusquedaDiagonalAbajoIzquierda(int i,int j){
       int inicio=1,fin=2,pocicioni=0,pocicionj=0;
       boolean AbajoDiagonalI=true;
       int Cont=0;
       String encontrado=""; 
       String camino="";
       String posi=String.valueOf(i),posj=String.valueOf(j);
       camino=camino+posi+" "+posj+"\n";
       do{
         pocicioni++;
         pocicionj++;
         if(this.Characteres[i+pocicioni][j-pocicionj].equals(palabra.substring(inicio,fin))){
             inicio++;
             fin++;
             Cont++;
             posi=String.valueOf(i+pocicioni);
             posj=String.valueOf(j-pocicionj);
             camino=camino+posi+" "+posj+"\n";
             if(Cont==palabra.length()-1){
                 AbajoDiagonalI=false;
                 return encontrado=camino+"\n"+palabra; 
                }
            }
            else{
             AbajoDiagonalI=false;
             encontrado=null;
            }
        }while(AbajoDiagonalI==true); 
    return encontrado;
    }
    
    public String BusquedaDiagonalAbajoDerecha(int i,int j){
       int inicio=1,fin=2,pocicioni=0,pocicionj=0;
       boolean AbajoDiagonalD=true;
       int Cont=0;
       String encontrado=""; 
       String camino="";
       String posi=String.valueOf(i),posj=String.valueOf(j);
       camino=camino+posi+" "+posj+"\n";
       do{
         pocicioni++;
         pocicionj++;
         if(this.Characteres[i+pocicioni][j+pocicionj].equals(palabra.substring(inicio,fin))){
             inicio++;
             fin++;
             Cont++;
             posi=String.valueOf(i+pocicioni);
             posj=String.valueOf(j+pocicionj);
             camino=camino+posi+" "+posj+"\n";
             if(Cont==palabra.length()-1){
                 AbajoDiagonalD=false;
                 return encontrado=camino+"\n"+palabra; 
                }
            }
            else{
             AbajoDiagonalD=false;
             encontrado=null;
            }
        }while(AbajoDiagonalD==true); 
    return encontrado;
    }
    
    public ArrayList<String> GetRegresandoCaminos(){
     
     return this.Caminos; 
    }
   
  
  

   
    
  }
