package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class canciones_playlist {
    
    public static String Concatenar(String Usuario, String Playlist, String Cancion) throws IOException
    {   
        String concatenado = "";
        
        concatenado = Usuario + "|" + Playlist + "|" + Codigo_Cancion(Cancion) + "|" + Usuario + "|" + descriptor.modDate() + "|" + "1\n";
        return concatenado;
    
    }
    
    private static String Codigo_Cancion(String Cancion) throws IOException
    {
        String codigo = "";
        
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\canciones.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\MEIA\\bitacora_canciones.txt"));
        
        String line = "";
        String line2 = "";
        

            while ((line = reader.readLine()) != null)
            {
                String[] split = line.split("\\|");
                String prueba = split[1];
                prueba += "-" + split[2];
                
                if (prueba.equals(Cancion)) 
                {
                    codigo = split[0];
                    return codigo;
                }                               
            }
            reader.close();
            
            while ((line2 = reader2.readLine()) != null)
            {
                String[] split = line2.split("\\|");
                String prueba = split[1];
                prueba += "-" + split[2];
                
                if (prueba.equals(Cancion)) 
                  {
                      codigo = split[0];
                      return codigo;
                  }                        
            }
            reader2.close();

        String no = "no encontrado";
        return no;
    }
    
}
