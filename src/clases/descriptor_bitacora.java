/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author megan
 */
public class descriptor_bitacora {
    String nombre_simbolico;
    Date fecha_creacion;
    String usuario_creacion;
    Date fecha_modificacion;
    String usuario_modificacion;
    int no_registros;
    int registros_activos;
    int registros_inactivos;
    int max_reorganizacion;

    public descriptor_bitacora(String nombre_simbolico, Date fecha_creacion, String usuario_creacion, Date fecha_modificacion, String usuario_modificacion, int no_registros, int registros_activos, int registros_inactivos, int max_reorganizacion) {
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
    
    
}
