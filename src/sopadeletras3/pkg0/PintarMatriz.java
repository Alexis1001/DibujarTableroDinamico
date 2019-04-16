/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras3.pkg0;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author PC
 */
public class PintarMatriz {
    String [][] Characteres;
    String[][]auxiliar; 
    
    public PintarMatriz(String [][] Characteres,String[][]auxiliar){
     this.Characteres=Characteres;
     this.auxiliar=auxiliar;
       
    }
    
    public void VisualizarMatrizces(){
      for(int i=0; i<this.Characteres.length;i++){
          for(int j=0;j<this.Characteres.length; j++){
              System.out.print(this.Characteres[i][j]+" ");
             }
          System.out.println("  ");
        }
      
        System.out.println("aux perro xd");
        
        for(int i=0; i<this.Characteres.length;i++){
          for(int j=0;j<this.Characteres.length; j++){
              System.out.print(this.auxiliar[i][j]+" ");
              if(this.auxiliar[i][j]=="*"){
                  System.out.println("pintar ");
                 }
              if(this.auxiliar[i][j]==null){
                  System.out.println("no pintar");
                 }
             }
         System.out.println("  ");
        }
    
    }
    
    public GridPane GetPintarMatriz(){
     GridPane gridPane = new GridPane();
     TextField textField;
     
     for(int i=0; i<this.Characteres.length;i++){
         for(int j=0;j<this.Characteres.length; j++){
             
             if(this.auxiliar[i][j]=="*"){
                 textField = new TextField(this.Characteres[i][j]);
                 textField.setStyle("-fx-pref-width:4em;-fx-background-color:red;");
                 textField.setEditable(false);
                 gridPane.add(textField, j, i); 
                 gridPane.setVgap(10); 
                 gridPane.setHgap(10);
                 }
             if(this.auxiliar[i][j]==null){
                 textField = new TextField(this.Characteres[i][j]);
                 textField.setStyle("-fx-pref-width:4em;");
                 textField.setEditable(false);
                 gridPane.add(textField, j, i); 
                 gridPane.setVgap(1); 
                 gridPane.setHgap(1);
                }
            }
        }     
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
    
     return gridPane;
     }
    
    
}
