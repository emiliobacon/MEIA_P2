/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_meia;

import clases.ficheros;
import java.io.IOException;
import ventanas.Ventana_login;


/**
 *
 * @author megan
 */
public class Proyecto1_MEIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        
        ficheros fichero = new ficheros();
        fichero.crearFicheroNoDesc("C:\\MEIA\\usuario.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\bitacora_usuario.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\bitacora_backup.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\desc_usuario.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\desc_bitacora_usuario.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\desc_bitacora_backup.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\canciones.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\bitacora_canciones.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\bitacora_listas_canciones.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\listas_canciones.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\desc_bitacora_listas_canciones.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\desc_bitacora_canciones.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\desc_canciones.txt");
        fichero.crearFicheroNoDesc("C:\\MEIA\\desc_listas_canciones.txt");

       Ventana_login menu = new Ventana_login();
       menu.setVisible(true); 
        
       
        
        
    }
    
}
