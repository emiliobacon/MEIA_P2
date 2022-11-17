
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
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\MEIA\\arbol_binario.txt"));
        BufferedReader reader3 = new BufferedReader(new FileReader("C:\\MEIA\\arbol_binario.txt"));
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        String line1 = "";
        
        while ((line = reader2.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String puntero_izquierdo = split[0];
                String puntero_derecho = split[1];
                String artista = split[2];
                String codigo = split[3];
                String cancion = split[4];
                String ruta = split[5];
                String usuario = split[6];
                String fecha = split[7];
                String estatus = split[8];
                
                
                String nuevo = artista + "|" + codigo + "|" + cancion + "|" + ruta + "|" + usuario + "|" + fecha + "|" + estatus + "|" + puntero_izquierdo + "|" + puntero_derecho; 
                            
                str.add(nuevo);
                                        
        }
        reader2.close();
        
        Collections.sort(str);
        
        
        FileWriter writer = new FileWriter("C:\\MEIA\\arbol_binario.txt");
        
        for (String s: str)
        {
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
        
        str.clear();
        
        while((line1 = reader3.readLine()) != null)
        {
            String[] split = line1.split("\\|");
              String puntero_izquierdo = split[0];
                String puntero_derecho = split[1];
                String artista = split[2];
                String codigo = split[3];
                String cancion = split[4];
                String ruta = split[5];
                String usuario = split[6];
                String fecha = split[7];
                String estatus = split[8];
                
                String nuevo = fecha + "|" + estatus+ "|" + puntero_izquierdo + "|" + puntero_derecho + "|" + artista + "|" + codigo + "|" + cancion + "|" + ruta + "|" + usuario  ; 
                            
                str.add(nuevo);
        }
        reader3.close();
        
        FileWriter writer2 = new FileWriter("C:\\MEIA\\arbol_binario.txt");
        
        for (String s: str)
        {
            writer2.write(s);
            writer2.write("\r\n");
        }
        writer2.close();
        
        str.clear();

    }
    
    public static void sortSong() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\arbol_binario.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\MEIA\\arbol_binario.txt"));
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        String line2 = "";
        
        while ((line = reader.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String puntero_izquierdo = split[0];
                String puntero_derecho = split[1];
                String artista = split[2];
                String codigo = split[3];
                String cancion = split[4];
                String ruta = split[5];
                String usuario = split[6];
                String fecha = split[7];
                String estatus = split[8];
                
                
                String nuevo = cancion + "|" + puntero_izquierdo + "|" + puntero_derecho + "|" + artista + "|" + codigo  + "|" + ruta + "|" + usuario + "|" + fecha + "|" + estatus; 
                            
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
        
        while((line2 = reader2.readLine()) != null)
        {
            String[] split = line2.split("\\|");
                String cancion = split[0];    
                String puntero_izquierdo = split[1];
                String puntero_derecho = split[2];
                String artista = split[3];
                String codigo = split[4];
                String ruta = split[5];
                String usuario = split[6];
                String fecha = split[7];
                String estatus = split[8];
                
                String nuevo = puntero_izquierdo + "|" + puntero_derecho + "|" + artista + "|" + codigo + "|" + cancion + "|" + ruta + "|" + usuario+ "|" + fecha + "|" + estatus; 
                            
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
        
        str.clear();

    }
    
}
