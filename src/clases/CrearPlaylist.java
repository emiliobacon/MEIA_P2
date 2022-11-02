package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CrearPlaylist {
    
    public static void CrearPlaylist (String nombrePlaylist, String usuario) throws IOException
    {
         File file =new File("C:\\MEIA\\bitacora_listas_canciones.txt");    
            if(!file.exists())
            {    
                file.createNewFile();          
            }    
            //true = append file    
                FileWriter fileWritter = new FileWriter(file,true);        
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                bufferWritter.write
                (
                    usuario + "|" + nombrePlaylist + "|" + usuario + "|" + descriptor.modDate() + "|" + "1\n" 
                );
                bufferWritter.close();
                fileWritter.close();
    }
    

    public static void reorganizar() throws FileNotFoundException, IOException
    {
        //si hay mas de 3 playlists 
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\bitacora_listas_canciones.txt"));
        BufferedReader reader3 = new BufferedReader(new FileReader("C:\\MEIA\\bitacora_listas_canciones.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\MEIA\\listas_canciones.txt"));
        String line = "";
        String line2 = "";
         ArrayList<String> str = new ArrayList<>();
        
        int contador = 0; 
        
        while(reader3.readLine() != null)
        {
            contador++;
        }
        
        if (contador == 3)
        {
            while ((line = reader.readLine()) != null)
            {
                        str.add(line);                         
            }
            reader.close();
            
            while ((line2 = reader2.readLine()) != null)
            {
                        str.add(line2);                       
            }
            reader2.close();
            
            Collections.sort(str);
            
            FileWriter writer = new FileWriter("C:\\MEIA\\listas_canciones.txt");
            for (String s: str)
            {
                writer.write(s);
                writer.write("\r\n");
            }
            writer.close();

            try
            {
                FileWriter fw = new FileWriter("C:\\MEIA\\bitacora_listas_canciones.txt", false);
                PrintWriter pw = new PrintWriter(fw, false);
                pw.flush();
                pw.close();
                fw.close();
            }
            catch(Exception exception)
            {
                
            }

        }
            
    }
        
        
        
        
        
        
        
        
        
    }
    
   
    

