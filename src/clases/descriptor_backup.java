/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author megan
 */
public class descriptor_backup {
    String nombre_simbolico;
    Date fecha_creacion;
    String usuario_creacion;
    Date fecha_modificacion;
    String usuario_modificacion;
    int no_registros;

    public descriptor_backup(String nombre_simbolico, Date fecha_creacion, String usuario_creacion, Date fecha_modificacion, String usuario_modificacion, int no_registros) {
        this.nombre_simbolico = nombre_simbolico;
        this.fecha_creacion = fecha_creacion;
        this.usuario_creacion = usuario_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.no_registros = no_registros;
    }

    @Override
    public String toString() {
        try {
            return "nombre_simbolico=" +  nombre_simbolico + "\n" + ", fecha_creacion=" + fecha_creacion +"\n" + ", usuario_creacion=" + usuario_creacion + "\n" +", fecha_modificacion=" + descriptor.modDate() +"\n" + ", usuario_modificacion=" + descriptor.modUser() +"\n" + ", no_registros=" + descriptor.numRegistros("C:\\MEIA\\bitacora_usuario.txt") +"\n" + ", registros_activos=" + descriptor.numRegistrosActivos("C:\\MEIA\\bitacora_usuario.txt") +"\n" + ", registros_inactivos=" + descriptor.numRegistrosInactivos("C:\\MEIA\\bitacora_usuario.txt");
        } catch (IOException ex) {
            Logger.getLogger(desciptor_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
