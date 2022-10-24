package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.LineNumberReader;
import java.util.ArrayList;

public class write_usuario_descriptor {
    
  public static void run() throws IOException {
         
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_usuario.txt"));
        
        
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_usuario.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + descriptor.modUser()
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\usuario.txt")
                + "\nregistros_activos: " + descriptor.numRegistrosActivos("C:\\MEIA\\usuario.txt")
                + "\nregistros_inactivos: " + descriptor.numRegistrosInactivos("C:\\MEIA\\usuario.txt")
                + "\nmax_reorganizacion: 3"
        );
        
        myWriter.close();
        
        
        
      
      
    
  }
  
  public static void run(String mod) throws IOException {
         
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_usuario.txt"));
        
        
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_usuario.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\usuario.txt")
                + "\nregistros_activos: " + descriptor.numRegistrosActivos("C:\\MEIA\\usuario.txt")
                + "\nregistros_inactivos: " + descriptor.numRegistrosInactivos("C:\\MEIA\\usuario.txt")
                + "\nmax_reorganizacion: 3"
        );
        
        myWriter.close();
        
        
        
      
      
    
  }
}