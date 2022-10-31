package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class descriptor_canciones {
    public static void run1(String mod) throws IOException {
        
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_canciones.txt");
        myWriter.write
        (
                 "nombre_simbolico: desc_canciones"
                +"\nfecha_creacion: " + descriptor.modDate() 
                +"\nusuario_creacion: " + mod
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\canciones.txt")
                + "\nregistros_activos: " + descriptor.numRegistrosActivosCanciones("C:\\MEIA\\canciones.txt")
                + "\nregistros_inactivos: 0"       
        );
        
        myWriter.close();     
    
  }
  
  public static void run2(String mod) throws IOException {
         
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_canciones.txt"));
        
        
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_canciones.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\canciones.txt")
                + "\nregistros_activos: " + descriptor.numRegistrosActivosCanciones("C:\\MEIA\\canciones.txt")
                + "\nregistros_inactivos: 0" 
        );
        
        myWriter.close();
    
}
}
