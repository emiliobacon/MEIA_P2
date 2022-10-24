package clases;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class reorganizar 
{
    public static void reorganizar(String Data) throws IOException
    {
        FileWriter fw = null; 
        BufferedWriter bw = null; 
        PrintWriter pw = null;
        
        try
        {
            fw = new FileWriter("C:\\MEIA\\bitacora_usuario.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw); 
            
            pw.println(Data);   
            pw.flush();
                               
        }
        finally 
        {
            try
            {
                pw.close();
                bw.close();
                fw.close();
                
            }
            catch (IOException io)
            {
                
            }
        }
            
        
    }
}
