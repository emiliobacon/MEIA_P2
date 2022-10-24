package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class descriptor 
{
    
    
    
    public static String modUser() throws FileNotFoundException, IOException
    {
        String modUser = "";
        int count = 1; 
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\usuario.txt"));
        String line = "";
        
       
        while ((line = reader.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String prueba = split[0];
                
                
                modUser = prueba;           
        }
        reader.close();
        
        return modUser; 
    }
    
    public static String modDate ()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String modDate = now.toString();
        return modDate;
        
    }
    
    public static int numRegistros (String Ruta) throws FileNotFoundException, IOException
    {
            int numRegistros = 0;
            
            BufferedReader reader = new BufferedReader(new FileReader(Ruta));

            ArrayList<String> str = new ArrayList<>();
            String line = "";

            while ((line = reader.readLine()) != null)
            {
                numRegistros ++;
            }
            reader.close();
            
            return numRegistros;
    }
    
    public static int numRegistrosActivos (String Ruta) throws FileNotFoundException, IOException
    {
        int regActivos = 0;
        
        BufferedReader reader = new BufferedReader(new FileReader(Ruta));
        
        String line = "";
        
        while ((line = reader.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String prueba = split[9];
                
                if (prueba.equals("1")) 
                {
                    regActivos ++;
                } 
              
        }
        reader.close();
        
        return regActivos;
    }
    
    public static int numRegistrosInactivos (String Ruta) throws FileNotFoundException, IOException
    {
        int regInactivos = 0; 
        
        BufferedReader reader = new BufferedReader(new FileReader(Ruta));
        String line = "";
        
        while ((line = reader.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String prueba = split[9];
                
                if (prueba.equals("0")) 
                {
                    regInactivos ++;
                } 
              
        }
        reader.close();
        
        return regInactivos;
    }
}
