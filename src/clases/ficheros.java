/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author megan
 */
public class ficheros {

    /**
     * Método para crear nuevos carpetas si es que no existen.
     *
     * @param rutaCompleta
     * @throws IOException
     */
    public void crearNuevoDirectorio(String rutaCompleta) throws IOException {
        Path path = Paths.get(rutaCompleta);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
            System.out.println("New Directory created !   " + rutaCompleta);
        } else {

            System.out.println("Directory already exists");
        }
    }

    /**
     * Copiar un directorio y todo su contenido de forma recursiva
     *
     * @param origen
     * @param destino
     */
    public void copiarDirectorio(String origen, String destino) throws IOException {
        crearNuevoDirectorio(destino);
        File directorio = new File(origen);
        File f;
        if (directorio.isDirectory()) {
            crearNuevoDirectorio(destino);
            String[] files = directorio.list();
            if (files.length > 0) {
                for (String archivo : files) {
                    f = new File(origen + File.separator + archivo);
                    if (f.isDirectory()) {
                        crearNuevoDirectorio(destino + File.separator + archivo + File.separator);
                        copiarDirectorio(origen + File.separator + archivo + File.separator, destino + File.separator + archivo + File.separator);
                    } else { //Es un archivo
                        copiarArchivo(origen + File.separator + archivo, destino + File.separator + archivo);
                    }
                }
            }
        }
    }

    /**
     * Copia el archivo origen en el destino
     *
     * @param sOrigen
     * @param sDestino
     */
    private void copiarArchivo(String sOrigen, String sDestino) {
        try {
            File origen = new File(sOrigen);
            File destino = new File(sDestino);
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearFicheroNoDesc(String ruta) throws IOException {
        try {

            File New_File = new File(ruta);

            if (New_File.createNewFile()) {
                System.out.println("Correcto");
            } else {
                System.out.println("ya existe");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void crearFicheroDescUsuario(String ruta) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            writer.println("nombre_simbolico: desc_usuario");
            writer.println("fecha_creacion: ");
            writer.println("usuario_creacion: ");
            writer.println("fecha_modificacion:");
            writer.println("usuario_modificacion:");
            writer.println("#_registros:");
            writer.println("registros_activos:");
            writer.println("registros_inactivos:");
            writer.println("max_reorganizacion: 3");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void crearFicheroDescBitacoraUsuario(String ruta) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            writer.println("nombre_simbolico: desc_bitacora_usuario");
            writer.println("fecha_creacion: ");
            writer.println("usuario_creacion: ");
            writer.println("fecha_modificacion:");
            writer.println("usuario_modificacion:");
            writer.println("#_registros:");
            writer.println("registros_activos:");
            writer.println("registros_inactivos:");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
