package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class bitacoraBackUp {
    
    public static void add_log_backup(String usuario, String fecha, String ruta)
    {
        
        try
        {    
              

            File file =new File("C:\\MEIA\\bitacora_backup.txt");    

            //if file doesnt exists, then create it    
            if(!file.exists()){    
                file.createNewFile();    
                    
            }    

            //true = append file    
                FileWriter fileWritter = new FileWriter(file,true);        
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                bufferWritter.write
                (
                        "ruta_absoluta: " + ruta
                        +" | usuario: " + usuario
                        +" | fecha_transaccion: " + fecha +"\n"
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
