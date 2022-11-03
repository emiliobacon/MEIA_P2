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
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author megan
 */
public class ArchivoSecuencialIndizado {
    public void insercion(String usuario, String lista, String codigo) throws IOException{
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy 'at' hh/mm");
        String fecha_transaccion = ft.format(date); 
        int max_reo= 3;
                  
        int numeroBloque= comprobacionArchivos();
        if (numeroBloque ==0) {
            
            //bloques
            FileWriter escribirBloque = new FileWriter("C:/MEIA/Bloque1.txt",true);
            BufferedWriter bw1 = new BufferedWriter(escribirBloque);
            bw1.write(usuario + "|"+ lista + "|"+ codigo + "|"+ usuario + "|"+ fecha_transaccion+ "|"+ '1'+System.getProperty("line.separator") );
            bw1.close();
            escribirBloque.close();
            
            //Descriptor
            FileWriter Escribir2 = new FileWriter("C:/MEIA/desc_Bl1.txt",false);
            BufferedWriter bw = new BufferedWriter(Escribir2);
            bw.write("Nombre: Desc_Bloque1"+System.getProperty("line.separator"));
            bw.write("Usuario_creación: "+usuario+System.getProperty("line.separator"));
            bw.write("FechaCreacion: "+fecha_transaccion+System.getProperty("line.separator"));
            bw.write("#TotalRegistros:1"+System.getProperty("line.separator"));
            bw.write("#Registros activos:1"+System.getProperty("line.separator"));
            bw.write("#Registros Inactivos:0"+System.getProperty("line.separator")); 
            bw.write("MaxRegistros:"+max_reo+System.getProperty("line.separator"));
            bw.close();
            Escribir2.close();
            
             //indice
            FileWriter EscribirIndice = new FileWriter("C:/MEIA/Indice.txt",true);
            BufferedWriter bw2 = new BufferedWriter(EscribirIndice);
            bw2.write("1|1.1|"+usuario+"|"+lista+"|"+codigo+"|0|1"+System.getProperty("line.separator"));
            bw2.close();
            EscribirIndice.close();

            //Descriptor
            FileWriter EscribirDescIndice = new FileWriter("C:/MEIA/desc_Indice.txt",false);
            BufferedWriter bw3 = new BufferedWriter(EscribirDescIndice);
            bw3.write("Nombre: Des_Indice"+System.getProperty("line.separator"));
            bw3.write("Creador:"+usuario +System.getProperty("line.separator"));
            bw3.write("FechaCreacion:"+fecha_transaccion+System.getProperty("line.separator"));
            bw3.write("RegInicial:1"+System.getProperty("line.separator"));
            bw3.write("NoBloques:1"+System.getProperty("line.separator"));
            bw3.write("MaxReorganizar:"+max_reo+System.getProperty("line.separator"));
            
            bw3.close();
            EscribirDescIndice.close();
           
        }
        else{
            int NumeroBloqueAEscribir= VerificarDescriptorBloque(numeroBloque);
            if (VerificarMaxRegistros(NumeroBloqueAEscribir)==0) {
                //bloque
                FileWriter Escribir = new FileWriter("C:/MEIA/Bloque"+(NumeroBloqueAEscribir)+".txt",true);
                BufferedWriter bw1 = new BufferedWriter(Escribir);
                bw1.write(usuario + "|"+ lista + "|"+ codigo + "|"+ usuario + "|"+ fecha_transaccion+ "|"+ '1' +System.getProperty("line.separator"));
                bw1.close();
                Escribir.close();
                
                //Descriptor
                FileWriter Escribir2 = new FileWriter("C:/MEIA/desc_Bl"+(NumeroBloqueAEscribir)+".txt",false);
                BufferedWriter bw = new BufferedWriter(Escribir2);
                bw.write("Nombre: desc_Bl"+(NumeroBloqueAEscribir)+System.getProperty("line.separator"));
                bw.write("Usuario_creación: "+usuario+System.getProperty("line.separator"));
                bw.write("FechaCreacion: "+fecha_transaccion+System.getProperty("line.separator"));
                bw.write("#TotalRegistros:1"+System.getProperty("line.separator"));
                bw.write("#Registros activos:1"+System.getProperty("line.separator"));
                bw.write("#Registros Inactivos:0"+System.getProperty("line.separator")); 
                bw.write("MaxRegistros:"+max_reo+System.getProperty("line.separator"));
                bw.close();
                Escribir2.close();
                
                //indice
                FileWriter EscribirIndice = new FileWriter("C:/MEIA/Indice.txt",true);
                BufferedWriter bw2 = new BufferedWriter(EscribirIndice);
                bw2.write((VerificarCantRegistrosIndice(NumeroBloqueAEscribir)+1)+"|"+(NumeroBloqueAEscribir)+"."+VerificarSiguiente(NumeroBloqueAEscribir)+"|"
                +usuario+"|"+lista+"|"+codigo+"|0|1"+System.getProperty("line.separator"));
                bw2.close();
                EscribirIndice.close();
                String inicial =OrganizarIndice();
                
                //desc
                FileWriter EscribirDescIndice = new FileWriter("C:/MEIA/desc_IndiceDs.txt",false);
                BufferedWriter bw4 = new BufferedWriter(EscribirDescIndice);
                bw4.write("Nombre: Des_Indice"+System.getProperty("line.separator"));
                bw4.write("Usuario_creación: "+VerificarCreadorIndice() +System.getProperty("line.separator"));
                bw4.write("FechaCreacion:"+VerificarFechaIndice()+System.getProperty("line.separator"));
                bw4.write("RegInicial:"+inicial+System.getProperty("line.separator"));
                bw4.write("NoBloques:"+VerificarBloques()+System.getProperty("line.separator"));
                bw4.write("MaxReorganizar:"+max_reo+System.getProperty("line.separator"));
                bw4.close();
                EscribirDescIndice.close();
                File ArchivoNuevo1=new File("C:/MEIA/desc_IndiceDs.txt");
                File ArchivoViej1o=new File("C:/MEIA/desc_Indice.txt");
                ArchivoViej1o.delete();
                boolean bool2 = ArchivoNuevo1.renameTo(ArchivoViej1o);
  
            }
            else{
                //resto de bloques
                FileWriter Escribir = new FileWriter("C:/MEIA/Bloque"+NumeroBloqueAEscribir+".txt",true);
                BufferedWriter bw=new BufferedWriter(Escribir);
                bw.write(usuario + "|"+ lista + "|"+ codigo + "|"+ usuario + "|"+ fecha_transaccion+ "|"+ '1' +System.getProperty("line.separator"));
                bw.close();
                Escribir.close();
                
                //Descriptor
                FileWriter Escribir2 = new FileWriter("C:/MEIA/desc_Bl"+(NumeroBloqueAEscribir)+"p.txt",false);
                BufferedWriter bw1 = new BufferedWriter(Escribir2);
                bw1.write("Nombre: desc_Bl"+(NumeroBloqueAEscribir)+System.getProperty("line.separator"));
                bw1.write("Usuario_creación: "+VerificarCreador(NumeroBloqueAEscribir)+System.getProperty("line.separator"));
                bw1.write("FechaCreacion:"+VerificarFecha(NumeroBloqueAEscribir)+System.getProperty("line.separator"));
                bw1.write("#TotalRegistros:"+(VerificarTotRegistros(NumeroBloqueAEscribir)+1)+System.getProperty("line.separator"));
                bw1.write("#Registros activos:"+((VerificarRegActivos(NumeroBloqueAEscribir))+1)+System.getProperty("line.separator"));
                bw1.write("#Registros Inactivos:"+VerificarRegInactivos(NumeroBloqueAEscribir)+System.getProperty("line.separator")); 
                bw1.write("MaxRegistros:"+VerificarMaxRegistros(NumeroBloqueAEscribir)+System.getProperty("line.separator"));
                bw1.close();
                Escribir2.close();
                
                File ArchivoNuevo=new File("C:/MEIA/desc_Bl"+NumeroBloqueAEscribir+"p.txt");
                File ArchivoViejo=new File("C:/MEIA/desc_Bl"+NumeroBloqueAEscribir+".txt");
                ArchivoViejo.delete();
                boolean bool = ArchivoNuevo.renameTo(ArchivoViejo);
                
                //indice
                FileWriter EscribirIndice = new FileWriter("C:/MEIA/Indice.txt",true);
                BufferedWriter bw2 = new BufferedWriter(EscribirIndice);
                bw2.write((VerificarCantRegistrosIndice(NumeroBloqueAEscribir)+1)+"|"+(NumeroBloqueAEscribir)+"."+VerificarSiguiente(NumeroBloqueAEscribir)+"|"
                +usuario+"|"+lista+"|"+codigo+"|0|1"+System.getProperty("line.separator"));
                bw2.close();
                EscribirIndice.close();
                String inicial =OrganizarIndice();
                
                //desc
                FileWriter EscribirDescIndice = new FileWriter("C:/MEIA/desc_IndiceDs.txt",false);
                BufferedWriter bw4 = new BufferedWriter(EscribirDescIndice);
                bw4.write("Nombre: Des_Indice"+System.getProperty("line.separator"));
                bw4.write("Usuario_creación: "+VerificarCreadorIndice() +System.getProperty("line.separator"));
                bw4.write("FechaCreacion:"+VerificarFechaIndice()+System.getProperty("line.separator"));
                bw4.write("RegInicial:"+inicial+System.getProperty("line.separator"));
                bw4.write("NoBloques:"+VerificarBloques()+System.getProperty("line.separator"));
                bw4.write("MaxReorganizar:"+max_reo+System.getProperty("line.separator"));
                bw4.close();
                EscribirDescIndice.close();
                File ArchivoNuevo1=new File("C:/MEIA/desc_IndiceDs.txt");
                File ArchivoViej1o=new File("C:/MEIA/desc_Indice.txt");
                ArchivoViej1o.delete();
                boolean bool2 = ArchivoNuevo1.renameTo(ArchivoViej1o);
            }
        }
    }
    
    public int comprobacionArchivos(){
           int noBloque = 0;
           File folder = new File("C:/MEIA");
           File[] listOfFiles = folder.listFiles();

            if(listOfFiles.length >0){
                for(int i = 0; i < listOfFiles.length;i++){
                    if(listOfFiles[i].getName().contains("Bloque")){
                        noBloque++;
                    }
                }
           }
           return noBloque;
    }
    
    public int VerificarDescriptorBloque(int BloqueAVerificar) throws IOException{
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Bl"+BloqueAVerificar+".txt"));
        String numeroReg="";
        String numeroMax="";
        String linea=Archivo.readLine();
        
        while(linea!=null){
            if (linea.split(":")[0].equals("#TotalRegistros")) {
                numeroReg=linea.split(":")[1];
            }
            else if (linea.split(":")[0].equals("MaxRegistros")){
                numeroMax=linea.split(":")[1];
            }
            linea=Archivo.readLine();
        }
        Archivo.close();
        if (numeroReg.equals(numeroMax)) {
            //CrearNuevoBloque               
                return BloqueAVerificar+1;
        }
        return BloqueAVerificar;
    }
    public int VerificarMaxRegistros(int NumeroBloque) throws IOException{
        String numeroReg="";
        File Bitacora = new File("C:/MEIA/desc_Bl"+NumeroBloque+".txt");
        if (Bitacora.exists()) {
            BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Bl"+NumeroBloque+".txt"));
            String linea = Archivo.readLine();
            while(linea!=null){
                if (linea.split(":")[0].equals("MaxRegistros")) {
                 numeroReg=linea.split(":")[1];
                }
                linea=Archivo.readLine();
            }
            Archivo.close();            
            return Integer.parseInt(numeroReg);
        } 
        return 0;
    }
    public int VerificarCantRegistrosIndice(int NumBloque) throws FileNotFoundException, IOException{
        int numeroReg=0;
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/Indice.txt"));
        String linea=Archivo.readLine();
        while(linea!=null)   {
            numeroReg++;
            linea=Archivo.readLine();
        }
        Archivo.close();
        return (numeroReg);  
    }
    public int VerificarSiguiente(int NumBloque) throws FileNotFoundException, IOException{
        FileWriter Escribir2 = null;
        int numeroReg=0;
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/Bloque"+NumBloque+".txt"));
        String linea=Archivo.readLine();

        while(linea!=null)   {
            numeroReg++;                    
            linea=Archivo.readLine();
        }
        Archivo.close();
        return (numeroReg);     
    }
    public String OrganizarIndice() throws FileNotFoundException, IOException{
        String indiceInicial="";
           //arreglar indice
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/Indice.txt"));
        String linea=Archivo.readLine();
        List<String> elementosArchivo = new ArrayList<String>();
        while(linea!=null){
            String[] campos=linea.split("\\|");
            String llave=campos[2]+"|"+campos[3]+"|"+campos[4]+"&"+campos[0];
            elementosArchivo.add(llave);
            linea=Archivo.readLine();
        }
        Archivo.close();
        Collections.sort(elementosArchivo);
        int tamano = elementosArchivo.size();
        String [] nuevaList=new String[tamano];
        for (int i = 0; i < elementosArchivo.size(); i++) {
           try{
               String actual=elementosArchivo.get(i).split("\\&")[1];
               String siguiente= elementosArchivo.get(i+1).split("\\&")[1];
               nuevaList[i]=(actual+"|"+siguiente);
           }catch(IndexOutOfBoundsException ex){
               nuevaList[i]=(elementosArchivo.get(i).split("\\&")[1]+"|-");
           }
        }
        
        BufferedReader Archivo2 = new BufferedReader(new FileReader("C:/MEIA/Indice.txt"));
        linea=Archivo2.readLine();
        elementosArchivo.removeAll(elementosArchivo);
        List<String> escribirLista= new ArrayList<String>();

        while(linea!=null){
            elementosArchivo.add(linea);
            linea=Archivo2.readLine();
        }
        indiceInicial=nuevaList[0].split("\\|")[0];
        for (int j = 0; j < elementosArchivo.size(); j++) {
            String[] atributos=elementosArchivo.get(j).split("\\|");
                for (int k = 0; k < nuevaList.length; k++) {
                    String nodo = nuevaList[k].split("\\|")[0];
                    String siguiente = nuevaList[k].split("\\|")[1];
                    if (nodo.equals(atributos[0])) {
                        escribirLista.add(atributos[0]+"|"+atributos[1]+"|"+atributos[2]+"|"+atributos[3]+"|"+
                        atributos[4]+"|"+siguiente+"|"+atributos[6]);
                        break;
                    }
                }                    
        }
        Archivo2.close();
        BufferedWriter ArchivoNuevo = new BufferedWriter(new FileWriter("C:/MEIA/Indice.txt"));
        for (int i = 0; i < escribirLista.size(); i++) {
            ArchivoNuevo.write(escribirLista.get(i)+System.getProperty("line.separator"));
        }
        ArchivoNuevo.close();
        return indiceInicial;
    }
    public String VerificarCreadorIndice() throws FileNotFoundException, IOException{
        String numeroReg="";
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Indice.txt"));
        String linea = Archivo.readLine();
        while(linea!=null){
            if (linea.split(":")[0].equals("Usuario_creación")) {
                numeroReg=linea.split(":")[1];
            }
            linea=Archivo.readLine();
        }
        Archivo.close();
        return (numeroReg);
    }
    public String VerificarFechaIndice() throws IOException{
        String numeroReg="";
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Indice.txt"));
        String linea = Archivo.readLine();
        while(linea!=null){
            if (linea.split(":")[0].equals("FechaCreacion")) {
             numeroReg=linea.split(":")[1];
            }
            linea=Archivo.readLine();
        }
        Archivo.close();
        return (numeroReg);
    }
    public String VerificarBloques(){
        int NoBloque=0;
        NoBloque = 0;
        File folder = new File("C:/MEIA");
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles.length >0){
            for(int i = 0; i < listOfFiles.length;i++){
                if(listOfFiles[i].getName().contains("Bloque")){
                    NoBloque++;
                }
            }
        }
        return Integer.toString(NoBloque);
    }
    
    public String VerificarCreador(int NumeroBloque) throws IOException{
        String numeroReg="";
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Bl"+NumeroBloque+".txt"));
        String linea = Archivo.readLine();
        while(linea!=null){
            if (linea.split(":")[0].equals("Usuario_creación")) {
             numeroReg=linea.split(":")[1];
            }
            linea=Archivo.readLine();
        }
        Archivo.close();
        return numeroReg;
    }
    public String VerificarFecha (int NumeroBloque) throws IOException{
        String numeroReg="";
        
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Bl"+NumeroBloque+".txt"));
        String linea = Archivo.readLine();
        while(linea!=null){
            if (linea.split(":")[0].equals("FechaCreacion")) {
                numeroReg=linea.split(":")[1];
            }
            linea=Archivo.readLine();
        }
        Archivo.close();
        return numeroReg;
    }
    public int VerificarRegActivos(int NumeroBloque) throws IOException{
        String numeroReg="";
        
            BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Bl"+NumeroBloque+".txt"));
            String linea = Archivo.readLine();
            while(linea!=null){
                if (linea.split(":")[0].equals("#Registros activos")) {
                 numeroReg=linea.split(":")[1];
                }
                linea=Archivo.readLine();
            }
            Archivo.close();
        return Integer.parseInt(numeroReg);
    }    
    public int VerificarRegInactivos(int NumeroBloque) throws IOException{
        String numeroReg="";
        
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Bl"+NumeroBloque+".txt"));
        String linea = Archivo.readLine();
        while(linea!=null){
            if (linea.split(":")[0].equals("#Registros Inactivos")) {
             numeroReg=linea.split(":")[1];
            }
            linea=Archivo.readLine();
        }
        Archivo.close(); 
        return Integer.parseInt(numeroReg);
    }
    public int VerificarTotRegistros(int NumeroBloque) throws FileNotFoundException, IOException{
        String numeroReg="";
        
        BufferedReader Archivo = new BufferedReader(new FileReader("C:/MEIA/desc_Bl"+NumeroBloque+".txt"));
        String linea = Archivo.readLine();
        while(linea!=null){
            if (linea.split(":")[0].equals("#TotalRegistros")) {
             numeroReg=linea.split(":")[1];
            }
            linea=Archivo.readLine();
        }
        Archivo.close();
        return Integer.parseInt(numeroReg);
    }
}
