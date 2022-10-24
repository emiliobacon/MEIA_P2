/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Escritorio
 */
public class write_bitacora_backup {
    
    public static void run(String mod) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_bitacora_backup.txt"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_bitacora_backup.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\bitacora_backup.txt")
               
                
        );
        
        myWriter.close();
        
    }
    
       
        
    public static void run(String mod, String fecha, String creator ) throws IOException {
  
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_bitacora_backup.txt");
        myWriter.write
        (
                """
                nombre_simbolico: desc_bitacora_backup
                fecha_creacion: """ + fecha
                +"\nusuario_creacion: " + creator
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\bitacora_backup.txt")
               
                
        );
        
        myWriter.close();
        
    }
}
