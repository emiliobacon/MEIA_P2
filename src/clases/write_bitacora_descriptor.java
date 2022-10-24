package clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class write_bitacora_descriptor {
    
    public static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_bitacora_usuario.txt"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_bitacora_usuario.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + descriptor.modUser()
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\bitacora_usuario.txt")
                + "\nregistros_activos: " + descriptor.numRegistrosActivos("C:\\MEIA\\bitacora_usuario.txt")
                + "\nregistros_inactivos: " + descriptor.numRegistrosInactivos("C:\\MEIA\\bitacora_usuario.txt")
                
        );
        
        myWriter.close();
        
    }
    
    public static void run(String mod) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\desc_bitacora_usuario.txt"));
        ArrayList<String> str = new ArrayList<>();
        String line = "";
         
        for (int i = 0; i < 3; i++) 
        {
            line = reader.readLine();
            str.add(line); 
        }
        
        FileWriter myWriter = new FileWriter("C:\\MEIA\\desc_bitacora_usuario.txt");
        myWriter.write
        (
                 str.get(0)
                +"\n"+str.get(1)
                +"\n"+str.get(2)
                +"\nfecha_modificacion: " + descriptor.modDate()
                + "\nusuario_modificacion: " + mod
                + "\n#_registros: " + descriptor.numRegistros("C:\\MEIA\\bitacora_usuario.txt")
                + "\nregistros_activos: " + descriptor.numRegistrosActivos("C:\\MEIA\\bitacora_usuario.txt")
                + "\nregistros_inactivos: " + descriptor.numRegistrosInactivos("C:\\MEIA\\bitacora_usuario.txt")
                
        );
        
        myWriter.close();
        
    }
}
