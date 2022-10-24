/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author megan
 */
public class desciptor_usuario {
    
    String nombre_simbolico;
    Date fecha_creacion;
    String usuario_creacion;
    Date fecha_modificacion;
    String usuario_modificacion;
    int no_registros;
    int registros_activos;
    int registros_inactivos;
    int max_reorganizacion;

    public desciptor_usuario(String nombre_simbolico, Date fecha_creacion, String usuario_creacion, Date fecha_modificacion, String usuario_modificacion, int no_registros, int registros_activos, int registros_inactivos, int max_reorganizacion) {
        this.nombre_simbolico = nombre_simbolico;
        this.fecha_creacion = fecha_creacion;
        this.usuario_creacion = usuario_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.no_registros = no_registros;
        this.registros_activos = registros_activos;
        this.registros_inactivos = registros_inactivos;
        this.max_reorganizacion = max_reorganizacion;
    }

    @Override
    public String toString() {
        try {
            return "nombre_simbolico=" +  nombre_simbolico + "\n" + ", fecha_creacion=" + fecha_creacion +"\n" + ", usuario_creacion=" + usuario_creacion + "\n" +", fecha_modificacion=" + descriptor.modDate() +"\n" + ", usuario_modificacion=" + descriptor.modUser() +"\n" + ", no_registros=" + descriptor.numRegistros("C:\\MEIA\\usuario.txt") +"\n" + ", registros_activos=" + descriptor.numRegistrosActivos("C:\\MEIA\\usuario.txt") +"\n" + ", registros_inactivos=" + descriptor.numRegistrosInactivos("C:\\MEIA\\usuario.txt") +"\n" + ", max_reorganizacion=" + max_reorganizacion + '}';
        } catch (IOException ex) {
            Logger.getLogger(desciptor_usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    
    
    
    
        
}
