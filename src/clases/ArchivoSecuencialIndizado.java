/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author megan
 */
public class ArchivoSecuencialIndizado {
    public void insercion(String usuario, String lista, String codigo) throws IOException{
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy 'at' hh:mm");
        String fecha_transaccion = ft.format(date); 
                  
        int numeroBloque= comprobacionArchivos();
        if (numeroBloque ==0) {
            FileWriter Escribir = new FileWriter("C:/MEIA/Bloque1.txt",true);
            BufferedWriter bw1 = new BufferedWriter(Escribir);
            bw1.close();
            Escribir.close();
            
        }
        
    }
    
    public int comprobacionArchivos(){
       int noBloque = 0;
       File folder = new File("C:/MEIA");
       File[] listOfFiles = folder.listFiles();
       
        if(listOfFiles.length >0){
            for(int i = 0; i < listOfFiles.length;i++){
		if(listOfFiles[i].getName().contains("Bloque")){
                    noBloque++;
		}
	    }
       }
       
       return noBloque;
   }
}
