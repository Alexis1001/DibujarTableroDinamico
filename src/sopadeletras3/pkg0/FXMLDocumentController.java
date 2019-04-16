/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras3.pkg0;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author PC
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private ImageView ImagenPrincipal;
    @FXML private AnchorPane Pagina1;
    @FXML private TextField IngresarPalabra;
    @FXML private AnchorPane Pagina2;
    @FXML private StackPane StackPane;
    @FXML private TextArea TextArea;
    
    ArrayList<String>palabras=new ArrayList<String>();  
    String palabra="";
    int contadorPalabras=0;
    TamanoMatriz tamanio;
    int tam=0;
    TextField [][] MatrizDeletras ;//Matriz de objetos Textfield;
    TextField textField; //objeto textfield
    String [][] MatrizCaracteres; //contenedor de los caracteres de la matriz del textfield
    LlenarMatriz llenar;// objeto de la clase llenar matriz
    String [][] Characteres;//formamos la sopa de letras 
    String [][] auxiliar;// matriz que no servira para pintar las palabras encontradas;
    ArrayList<ArrayList<String>>Caminos=new ArrayList<ArrayList<String>>();
    Tareas hilo[];
    
    @FXML void Ingresar(ActionEvent event) {
       palabra=IngresarPalabra.getText();
       if(palabra.length()>0){
          contadorPalabras++; 
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Palabra");
          alert.setHeaderText(null);
          alert.setContentText("Ingresado Correctamente "+contadorPalabras);
          alert.showAndWait();
          palabras.add(palabra);
          IngresarPalabra.setText("");
        }    
    }
    
    @FXML void Listo(ActionEvent event) {
        Pagina1.setVisible(false);
        Pagina2.setVisible(true);
        
        tamanio.SetRecibePalabras(palabras);
        tam=tamanio.GetTamano();
        TextArea.setText(tamanio.GetObtenerPalabras());// aqui imprimo las palabras
        TextArea.setEditable(false);
        
        MatrizDeletras= new TextField[tam+2][tam+2];
        MatrizCaracteres=new String[tam+2][tam+2];
        auxiliar=new String[tam+2][tam+2];
        GridPane gridPane = new GridPane();
        for(int i = 1; i<this.MatrizDeletras.length-1;i++){
            for(int j = 1; j<this.MatrizDeletras.length-1; j++){
                textField = new TextField();
                textField.setStyle("-fx-pref-width: 3em;");
                MatrizDeletras[i][j]=textField;
                gridPane.add(MatrizDeletras[i][j], j, i); 
                gridPane.setVgap(1); 
                gridPane.setHgap(1); 
            }
        }     
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);
        StackPane.getChildren().add(gridPane); 
        
     }
    
    @FXML
    void LlenarMatrizRandom(ActionEvent event) {
        this.StackPane.getChildren().clear();
        for(int i=1;i<this.MatrizDeletras.length-1;i++){
            for(int j=1;j<this.MatrizDeletras.length-1;j++){
                String l=MatrizDeletras[i][j].getText();
                this.MatrizCaracteres[i][j]=l;
                }
        }
        llenar=new LlenarMatriz(this.MatrizCaracteres);
        Characteres=llenar.GetMatrizCaracteres();
        GridPane gridPane = new GridPane();
        for(int i=0; i<this.Characteres.length;i++){
            for(int j=0;j<this.Characteres.length; j++){
                textField = new TextField(this.Characteres[i][j]);
                textField.setStyle("-fx-pref-width:4em;");
             // textField.setStyle("-fx-background-color:red");
             // textField.setStyle("-fx-text-inner-color: blue");
            //  textField.setStyle("-fx-pref-width:4em;-fx-background-color:red;"); good
                textField.setEditable(false);
                gridPane.add(textField, j, i); 
                gridPane.setVgap(1); 
                gridPane.setHgap(1); 
            }
        }     
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        StackPane.getChildren().add(gridPane);  
    }
    
    @FXML void LanzarHilos(ActionEvent event) {
        hilo=new Tareas[palabras.size()];
        
        for(int i=0;i<hilo.length;i++){
            hilo[i]=new Tareas(Characteres,palabras.get(i));
        }
        for(int i=0;i<hilo.length;i++){
          hilo[i].start();
        }        
    }
    
    @FXML void VerSolucion(ActionEvent event) {
     int cont=0;
     String pocicionesaux="";  
     String pos[];
     String Pociciones="";
     String pocicionfinal="";
     ArrayList<String> listaP=new ArrayList<String>();
     int conty=0; 
     int pocicioni=0;
     int pocicionj=0;
     String auxi="",auxj="";
     
       for(int i=0;i<hilo.length;i++){
          Caminos.add(hilo[i].GetRegresandoCaminos());
        }  
       
        for(int i=0;i<hilo.length;i++){
            pocicionesaux=Caminos.get(i).get(0);
            for(int j=0;j<pocicionesaux.length();j++){
                if(Character.toString(pocicionesaux.charAt(j)).equals("\n")){
                   cont++;
                }
            }
            pos=pocicionesaux.split("\n");
            for(int k=0;k<cont-1;k++){
                Pociciones=pos[k];
                listaP.add(Pociciones);
            }  
         cont=0;   
        }  
        
       
        for(int h=0;h<listaP.size();h++){
             pocicionfinal=listaP.get(h);
            for(int l=0;l<pocicionfinal.length();l++){
                conty++;
                if(pocicionfinal.charAt(l)==' '){
                   auxi=pocicionfinal.substring(0,conty-1);
                   pocicioni=Integer.parseInt(auxi);
                   auxj=pocicionfinal.substring(conty,pocicionfinal.length()); 
                   pocicionj=Integer.parseInt(auxj);
                   this.auxiliar[pocicioni][pocicionj]="*";
                   break;
                }
            }
            conty=0;
        }
        
        PintarMatriz pintar=new PintarMatriz(this.Characteres,this.auxiliar);
        this.StackPane.getChildren().clear();
        GridPane gridpane=new GridPane();
        gridpane=pintar.GetPintarMatriz();
        this.StackPane.getChildren().add(gridpane);
        
     }
     
    
    
    @Override public void initialize(URL url, ResourceBundle rb) {
            
        tamanio=new TamanoMatriz();
      
     }    
    
}
