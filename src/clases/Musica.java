package clases;
import java.awt.Desktop;
import java.awt.Desktop.Action; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import ventanas.Ventana_Administrador;

public class Musica 
{    

    public static Path CargarMusica(String usuario) throws IOException 
   {
        int num_reg_bitacora = 0; 
        int num_reg_canciones = 0;
        int codigoCancion = 1;
        
        num_reg_bitacora = descriptor.numRegistros("C:\\MEIA\\canciones.txt");
        num_reg_canciones = descriptor.numRegistros("C:\\MEIA\\bitacora_canciones.txt");

        if (num_reg_bitacora == 0 && num_reg_canciones == 0) 
        {
            codigoCancion = 1;
        } else 
        {
            codigoCancion = num_reg_bitacora + num_reg_canciones + 1;
        }
       String s = null;
       
        JFileChooser jd= s == null ? new JFileChooser() : new JFileChooser(s);
        jd.setDialogTitle("Elija música para cargar...");
        
        //solo lee .mp3 
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "MP3", "mp3");
        
        jd.setFileFilter(filter);
        
        int returnVal= jd.showOpenDialog(null);
        
        if (returnVal != JFileChooser.APPROVE_OPTION) return null;
        
        
        String ruta = (jd.getSelectedFile().toString());
        
        File song = new File(ruta);
        String SongName = song.getName();
        
        Insertar(NombreCompleto(SongName), Artista(SongName), ruta, usuario, codigoCancion);
        
        //mover el archivo a la carpeta MEIA
        Mover(ruta, SongName);
       
        codigoCancion++;
        
        return jd.getSelectedFile().toPath();   
    }  
   
   public static void Mover(String ruta, String name)
   {
        File file = new File( ruta);
         
        // renaming the file and moving it to a new location
        if(file.renameTo
           (new File("C:\\MEIA\\Musica\\" + name )))
        {
            // if file copied successfully then delete the original file
            file.delete();    
        }
        else
        {
            System.out.println("Failed to move the file");
        }
   }
   
   public static String Artista(String nombreCompleto)
   {

        String[] split = nombreCompleto.split("-");
        String prueba = split[1];
        
        String[] split2 = prueba.split(".mp3");
        String artista = split2[0];
       
       return artista;       
   }
   
   public static String NombreCompleto(String nombre)
   {
       String[] split = nombre.split("-");
       String prueba = split[0];
       
       return prueba;
   }
   
   public static void Insertar(String cancion, String artista, String ruta, String usuario,  int codigo)
   {
        try
        {    
            File file =new File("C:\\MEIA\\bitacora_canciones.txt");    
            //if file doesnt exists, then create it    
            if(!file.exists())
            {    
                file.createNewFile();          
            }    

            //true = append file    
                FileWriter fileWritter = new FileWriter(file,true);        
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                bufferWritter.write
                (
                    codigo + "|" + cancion + "|" + artista + "|" + ruta + "|" + usuario + "|" + descriptor.modDate() + "|" + "1\n" 
                );
                bufferWritter.close();
                fileWritter.close();
        }
        catch(Exception e)
        {    
            e.printStackTrace();    
        } 
   }
   
       public static void reorganizar() throws FileNotFoundException, IOException
    {
        //si hay mas de 3 playlists 
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\bitacora_canciones.txt"));
        BufferedReader reader3 = new BufferedReader(new FileReader("C:\\MEIA\\bitacora_canciones.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\MEIA\\canciones.txt"));
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
            
            FileWriter writer = new FileWriter("C:\\MEIA\\canciones.txt");
            for (String s: str)
            {
                writer.write(s);
                writer.write("\r\n");
            }
            writer.close();

            try
            {
                FileWriter fw = new FileWriter("C:\\MEIA\\bitacora_canciones.txt", false);
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
