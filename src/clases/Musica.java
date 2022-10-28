package clases;
import java.awt.Desktop;
import java.awt.Desktop.Action; 
import java.io.File;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import java.nio.file.Path;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Musica 
{
  
   public static Path getInputPath(String s) 
   {
       
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
}
