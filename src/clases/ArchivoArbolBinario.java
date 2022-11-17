/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author megan
 */
public class ArchivoArbolBinario {

    private static int RegistroInicial = -1;

    private static ArbolBinario construirArbol(List<nodoArbolBinario> contenidoArchivo) {
        ArbolBinario arbol = new ArbolBinario();
        for (nodoArbolBinario item : contenidoArchivo) {
            arbol.insertarEnArbol(item);
        }
        return arbol;
    }

    public static void EscribirDescriptor(String NombreArchivo, String TipoOrg, String UsuarioCreador, String FechaCreacion, String FechaModificacion,
            int RegistroInicial, int TotRegistros, int RegistrosActivos, int RegistrosInactivos) {
        try {
            FileWriter Escribir = new FileWriter("C:/MEIA/desc_" + NombreArchivo + ".txt", false);
            BufferedWriter bw = new BufferedWriter(Escribir);

            String content = ObtenerContenidoDescriptor(NombreArchivo, TipoOrg, UsuarioCreador, FechaCreacion, FechaModificacion, RegistroInicial,
                    TotRegistros, RegistrosActivos, RegistrosInactivos);

            //Escribir en descriptor
            bw.write(content);
            bw.close();
            Escribir.close();

        } catch (IOException ex) {

        }
    }

    private static String ObtenerContenidoDescriptor(String NombreArchivo, String TipoOrg, String UsuarioCreador, String FechaCreacion, String FechaModificacion,
            int RegistroInicial, int TotRegistros, int RegistrosActivos, int RegistrosInactivos) {
        String regArchivo = "Archivo:" + NombreArchivo + System.getProperty("line.separator");
        String regOrganizacion = "Organizacion:" + TipoOrg + System.getProperty("line.separator");
        String regUsuario = "Usuario:" + UsuarioCreador + System.getProperty("line.separator");
        String regFechaCreacion = "Fecha_Creacion:" + FechaCreacion + System.getProperty("line.separator");
        String regFechaMod = "Fecha_Modificacion:" + FechaModificacion + System.getProperty("line.separator");
        String regTotalReg = "Total_Registros:" + Integer.toString(TotRegistros) + System.getProperty("line.separator");
        String regRegistros_Activos = "Registros_Activos:" + Integer.toString(RegistrosActivos) + System.getProperty("line.separator");
        String regRegistros_Inactivos = "Registros_Inactivos:" + Integer.toString(RegistrosInactivos) + System.getProperty("line.separator");
        
        String regInicial = "Registro_Inicial:" + Integer.toString(RegistroInicial) + System.getProperty("line.separator");

        return regArchivo + regOrganizacion + regUsuario + regFechaCreacion + regFechaMod + regInicial
                + regTotalReg + regRegistros_Activos + regRegistros_Inactivos ;
    }

    public static void EscribirEnArchivo(String NombreArchivo, String strContenido) throws IOException {
        String pathMaster = "C:/MEIA/" + NombreArchivo + ".txt";
        String pathDescMaster = "C:/MEIA/desc_" + NombreArchivo + ".txt";

        String[] split = strContenido.split("\\|");
        Boolean Activo = "1".equals(split[split.length - 1]);

        //Agregar contenido al achivo
        try {
            FileWriter Escribir = new FileWriter(pathMaster, true);
            BufferedWriter bw = new BufferedWriter(Escribir);

            bw.write(strContenido + System.getProperty("line.separator"));

            bw.close();
            Escribir.close();

            //Asignar indice correcto a cada atributo en el archivo
            ReordenarElementos(NombreArchivo);

        } catch (IOException ex) {

        }

        //Actualizar descriptor
        File Archivo = new File(pathDescMaster);

        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy 'at' hh:mm");
        String FechaActual = ft.format(date);

        String Organizacion = "Arbol Binario";
        String Usuario = IdentificarCreadorArchivo(pathDescMaster);
        String Fecha_Creacion = IdentificarFechaCreacion(pathDescMaster);
        int Total_Registros = IdentificarTotRegistros(pathDescMaster);
        int Registros_Activos = IdentificarRegActivos(pathDescMaster);
        int Registros_Inactivos = IdentificarRegInactivos(pathDescMaster);;
        

        if (Archivo.exists()) {

            if (Activo) {
                Total_Registros++;
                Registros_Activos++;
            } else {
                Total_Registros++;
                Registros_Inactivos++;
            }
        }

        EscribirDescriptor(NombreArchivo, Organizacion, Usuario, Fecha_Creacion, FechaActual, RegistroInicial,
                Total_Registros, Registros_Activos, Registros_Inactivos);

    }

    private static void ReordenarElementos(String NombreArchivo) {
        String pathDescMaster = "C:/MEIA/desc_" + NombreArchivo + ".txt";

        String path = "C:/MEIA/" + NombreArchivo + ".txt";

        List<String> elementosArchivo = new ArrayList<String>();
        List<nodoArbolBinario> elementosActivos = new ArrayList<nodoArbolBinario>();
        List<String> nuevosElementos = new ArrayList<String>();
        String line;
        int posicion = 1;

        ArbolBinario arbol;
        try {
            //Anadir elementos del maestro a memoria

            File Master = new File(path);

            if (Master.exists()) {
                BufferedReader file = new BufferedReader(new FileReader(path));
                while ((line = file.readLine()) != null) {
                    String[] split = line.split("\\|");
                    if ("1".equals(split[split.length - 1])) //Si es un registro activo
                    {
                        elementosArchivo.add(line);
                        elementosActivos.add(new nodoArbolBinario(split[2], posicion)); //Anadir llave para insertarla en el arbol
                    } else {
                        elementosArchivo.add(line);
                    }

                    posicion++;
                }
                file.close();

                //Operaciones en arbol binario
                arbol = construirArbol(elementosActivos);
                RegistroInicial = arbol.root.posicion;

                //Cambiar atributos
                for (String item : elementosArchivo) {
                    String[] split = item.split("\\|");
                    nodoArbolBinario res = arbol.Buscar(new nodoArbolBinario(split[2], Integer.parseInt(split[3])));

                    String izquierdo = "-";
                    String derecho = "-";

                    if (res != null) {
                        if (res.izquierdo != null) {
                            izquierdo = Integer.toString(res.izquierdo.posicion);
                        }
                        if (res.derecho != null) {
                            derecho = Integer.toString(res.derecho.posicion);
                        }
                    }

                    String tmp = izquierdo + "|" + derecho + "|" + split[2] + "|" + split[3] + "|"
                            + split[4] + "|" + split[5] + "|" + split[6] + "|" + split[7] + "|" + split[8];

                    nuevosElementos.add(tmp);
                }
            }

            //Escribir elementos en archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            for (String item : nuevosElementos) {
                writer.write(item);
                writer.newLine();
            }

            writer.close();

            //Actualizar desscriptor 
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy 'at' hh:mm");
            String FechaActual = ft.format(date);

            String Organizacion = "Arbol Binario";
            String Usuario = IdentificarCreadorArchivo(pathDescMaster);
            String Fecha_Creacion = IdentificarFechaCreacion(pathDescMaster);
            int Total_Registros = IdentificarTotRegistros(pathDescMaster);
            int Registros_Activos = IdentificarRegActivos(pathDescMaster);
            int Registros_Inactivos = IdentificarRegInactivos(pathDescMaster);;
            

            EscribirDescriptor(NombreArchivo, Organizacion, Usuario, Fecha_Creacion, FechaActual, RegistroInicial,
                    Total_Registros, Registros_Activos, Registros_Inactivos);

        } catch (IOException ex) {

        } catch (Exception e) {
        }
    }

    private static String IdentificarValorEnDescriptor(String path, String llave) throws IOException {
        String Resultado = "";

        File Archivo = new File(path);
        FileReader LecturaArchivo = new FileReader(Archivo);
        BufferedReader LeerArchivo = new BufferedReader(LecturaArchivo);

        String Linea = LeerArchivo.readLine();
        String[] split;

        while (Linea != null) {
            split = Linea.split("\\:");

            if (llave.equals(split[0])) {
                int index = split[0].length() + 1;
                Linea = Linea.substring(index); //Obtener valor sin el nombre del campo
                Resultado = Linea;
                break;
            }
            Linea = LeerArchivo.readLine();
        }

        LecturaArchivo.close();
        LeerArchivo.close();

        return Resultado;
    }

    public static String IdentificarCreadorArchivo(String strPath) throws IOException {
        String creador = IdentificarValorEnDescriptor(strPath, "Usuario");

        if (creador.isEmpty()) {
            creador = "default";
        }

        return creador;
    }

    public static String IdentificarFechaCreacion(String strPath) throws IOException {
        String FechaCreacion = IdentificarValorEnDescriptor(strPath, "Fecha_Creacion");

        if (FechaCreacion.isEmpty()) {
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy 'at' hh:mm");
            FechaCreacion = ft.format(date);
        }

        return FechaCreacion;
    }

    public static int IdentificarTotRegistros(String strPath) throws IOException {
        int Registros = 0;

        String busqueda = IdentificarValorEnDescriptor(strPath, "Total_Registros");
        Registros = Integer.parseInt(busqueda);

        return Registros;
    }

    public static int IdentificarRegActivos(String strPath) throws IOException {
        int Registros = 0;

        String busqueda = IdentificarValorEnDescriptor(strPath, "Registros_Activos");
        Registros = Integer.parseInt(busqueda);

        return Registros;
    }

    public static int IdentificarRegInactivos(String strPath) throws IOException {
        int Registros = 0;

        String busqueda = IdentificarValorEnDescriptor(strPath, "Registros_Inactivos");
        Registros = Integer.parseInt(busqueda);

        return Registros;
    }

    public static int IdentificarRegInicial(String strPath) throws IOException {
        int Num = 0;

        String busqueda = IdentificarValorEnDescriptor(strPath, "Registro_Inicial");

        if (busqueda.isEmpty()) {
            Num = -1; //default
        } else {
            Num = Integer.parseInt(busqueda);
        }

        return Num;
    }
}
