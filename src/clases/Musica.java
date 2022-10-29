package clases;
import java.awt.Desktop;
import java.awt.Desktop.Action; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import java.nio.file.Path;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Musica 
{    
    public static Path CargarMusica(String usuario) 
   {
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
        
        Insertar(NombreCompleto(SongName), Artista(SongName), ruta, usuario, 1);
        
        //mover el archivo a la carpeta MEIA
        Mover(ruta, SongName);
       
        
        return jd.getSelectedFile().toPath();   
    }  
   
   public static void Mover(String ruta, String name)
   {
        File file = new File( ruta);
         
        // renaming the file and moving it to a new location
        if(file.renameTo
           (new File("C:\\MEIA\\" + name )))
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
            File file =new File("C:\\MEIA\\canciones.txt");    
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
   
   
}
