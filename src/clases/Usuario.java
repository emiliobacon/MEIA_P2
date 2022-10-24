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
public class Usuario {
    
    String Usuario;
    String Nombre;
    String Apellido;
    String Password;
    int Rol;
    Date fecha_nacimiento;
    String correo_alterno;
    int Telefono;
    String Path_fotografia;
    int Estatus;

    public Usuario(String Usuario, String Nombre, String Apellido, String Password, int Rol, Date fecha_nacimiento, String correo_alterno, int Telefono, String Path_fotografia, int Estatus) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Password = Password;
        this.Rol = Rol;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo_alterno = correo_alterno;
        this.Telefono = Telefono;
        this.Path_fotografia = Path_fotografia;
        this.Estatus = Estatus;
    }

    @Override
    public String toString() {
        return "" + Usuario + "|" + Nombre + "|" + Apellido + "|" + Password + "|" + Rol + "|" + fecha_nacimiento + "|" + correo_alterno + "|" + Telefono + "|" + Path_fotografia + "|" + Estatus ;
    }
    

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

   

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo_alterno() {
        return correo_alterno;
    }

    public void setCorreo_alterno(String correo_alterno) {
        this.correo_alterno = correo_alterno;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getPath_fotografia() {
        return Path_fotografia;
    }

    public void setPath_fotografia(String Path_fotografia) {
        this.Path_fotografia = Path_fotografia;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    public int getEstatus() {
        return Estatus;
    }

    public void setEstatus(int Estatus) {
        this.Estatus = Estatus;
    }
}
