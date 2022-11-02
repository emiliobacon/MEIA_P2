package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class descriptor_listas_canciones {
    
    public static void descriptorBitacora(String usuario) throws IOException
    {   
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_bitacora_listas_canciones.txt"));
        
        if (reader.readLine() == null) {
            FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_bitacora_listas_canciones.txt");
            myWriter.write
            (
                     "nombre_simbolico: desc_bitacora_listas_canciones"
                    +"\nfecha_creacion: " + descriptor.modDate() 
                    +"\nusuario_creacion: " + usuario
                    +"\nfecha_modificacion: " + descriptor.modDate()
                    + "\nusuario_modificacion: " + usuario
                    + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\bitacora_listas_canciones.txt")
                    + "\nregistros_activos: " + descriptor.numRegistros("C:\\MEIA\\bitacora_listas_canciones.txt")
                    + "\nregistros_inactivos: 0"       
            );

            myWriter.close();     
            
        }
        else
        {
           descriptorBitacoraModificado(usuario); 
        }
        
    
    }
  
  public static void descriptorBitacoraModificado(String mod) throws IOException {
         
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_bitacora_listas_canciones.txt"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_bitacora_listas_canciones.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\bitacora_listas_canciones.txt")
                + "\nregistros_activos: " + descriptor.numRegistros("C:\\MEIA\\bitacora_listas_canciones.txt")
                + "\nregistros_inactivos: 0" 
        );
        
        myWriter.close();
    
    }
  
  public static void descriptorListas(String usuario) throws IOException
    {   
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_listas_canciones.txt"));
        
        if (reader.readLine() == null) {
            FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_listas_canciones.txt");
            myWriter.write
            (
                     "nombre_simbolico: desc_listas_canciones"
                    +"\nfecha_creacion: " + descriptor.modDate() 
                    +"\nusuario_creacion: " + usuario
                    +"\nfecha_modificacion: " + descriptor.modDate()
                    + "\nusuario_modificacion: " + usuario
                    + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\listas_canciones.txt")
                    + "\nregistros_activos: " + descriptor.numRegistros("C:\\MEIA\\listas_canciones.txt")
                    + "\nregistros_inactivos: 0"       
            );

            myWriter.close();     
            
        }
        else
        {
           descriptorListasModificado(usuario); 
        }
        
    
    }
  
  public static void descriptorListasModificado(String mod) throws IOException {
         
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_listas_canciones.txt"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_listas_canciones.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\listas_canciones.txt")
                + "\nregistros_activos: " + descriptor.numRegistros("C:\\MEIA\\listas_canciones.txt")
                + "\nregistros_inactivos: 0" 
        );
        
        myWriter.close();
    
    }
        
}
    

