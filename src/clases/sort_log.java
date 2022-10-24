package clases;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class sort_log 
{
    public static void reorganizar() throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\MEIA\\bitacora_usuario.txt"));
        
        ArrayList<String> str = new ArrayList<>();
        String line = "";
        
        while ((line = reader.readLine()) != null)
        {
            
                String[] split = line.split("\\|");
                String prueba = split[9];
                
                if (prueba.equals("1")) 
                {
                    str.add(line);
                }                        
        }
        reader.close();
        
        Collections.sort(str);
        
        FileWriter writer = new FileWriter("C:\\MEIA\\bitacora_usuario.txt");
        for (String s: str)
        {
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();
        
        
        
        
        
    }
}
