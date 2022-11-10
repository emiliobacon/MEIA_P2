
package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class sortBinarySearchTree {
    
    public static void sortArtist() throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\canciones.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\MEIA\\arbol_binario.txt"));
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        
        while ((line = reader.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String campo_0 = split[0];
                String campo_1 = split[1];
                String campo_2 = split[2];
                String campo_3 = split[3];
                String campo_4 = split[4];
                String campo_5 = split[5];
                String campo_6 = split[6];
                
                String nuevo = campo_2 + "|" + campo_0 + "|" + campo_1 + "|" + campo_3 + "|" + campo_4 + "|" + campo_5 + "|" + campo_6; 
                            
                str.add(nuevo);
                                        
        }
        reader.close();
        
        Collections.sort(str);
        
        
        FileWriter writer = new FileWriter("C:\\MEIA\\arbol_binario.txt");
        
        for (String s: str)
        {
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
        
        str.clear();
        
        
    }
    
    public static void sortSong() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\canciones.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\MEIA\\arbol_binario.txt"));
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        
        while ((line = reader.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String campo_0 = split[0];
                String campo_1 = split[1];
                String campo_2 = split[2];
                String campo_3 = split[3];
                String campo_4 = split[4];
                String campo_5 = split[5];
                String campo_6 = split[6];
                
                String nuevo = campo_1 + "|" + campo_0 + "|" + campo_2 + "|" + campo_3 + "|" + campo_4 + "|" + campo_5 + "|" + campo_6; 
                            
                str.add(nuevo);
                                        
        }
        reader.close();
        
        Collections.sort(str);
        
        
        FileWriter writer = new FileWriter("C:\\MEIA\\arbol_binario.txt");
        
        for (String s: str)
        {
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
        
        str.clear();
        
        while((line = reader2.readLine()) != null)
        {
            String[] split = line.split("\\|");
                String campo_0 = split[0];
                String campo_1 = split[1];
                String campo_2 = split[2];
                String campo_3 = split[3];
                String campo_4 = split[4];
                String campo_5 = split[5];
                String campo_6 = split[6];
                
                String nuevo = campo_2 + "|" + campo_1 + "|" + campo_0 + "|" + campo_3 + "|" + campo_4 + "|" + campo_5 + "|" + campo_6; 
                            
                str.add(nuevo);
        }
        reader2.close();
        
        FileWriter writer2 = new FileWriter("C:\\MEIA\\arbol_binario.txt");
        
        for (String s: str)
        {
            writer2.write(s);
            writer2.write("\r\n");
        }
        writer2.close();
    }
    
}
