/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author emilio
 */
public class contrasena {
     public static String verificar (String Password)
    {
        if (Password.length()< 6)
        {
           return "Debe ser mayor a 6 caracteres.";
        }  
        else
        {
            int Puntuacion = 0;  
            int Mayuscula = 0; 
            int Minuscula = 0;
            int Numeros = 0;
            int Simbolos = 0;
           
           //Puntuación= (Número de la segunda línea) * (largo de contraseña ingresada)
           Puntuacion += 3*Password.length();
           
           //Encontrar las mayúsculas, minúsculas, símbolos y números
            for (int i = 0; i < Password.length(); i++) {
                char ch = Password.charAt(i);
                
                if (ch>= 'A' && ch <='Z') {
                    Mayuscula++;
                }
                else if (ch>='a' && ch<='z') {
                    Minuscula++;
                }
                else if (ch == '/' || ch == '¿' || ch == '%' || ch == '$' || ch == '#' ) {
                    Simbolos++;
                }
                else {
                    Numeros++;
                }
            }
            
            //Puntuación= Puntuación + [(Número de la tercer línea)*(total de Mayúsculas ingresadas)]
            if (Mayuscula != 0) {
                
                Puntuacion += 2*Mayuscula;
            }
            
            
            //Puntuación= Puntuación+ [(total de letras ingresadas)+ (Número de la cuarta línea)
            if (Mayuscula != 0 || Minuscula != 0) {
                
                Puntuacion += Mayuscula + Minuscula + 1;
            }
            
            //Puntuación= Puntuación+ [(total de números ingresados)+ (Número de la quinta línea)
            if (Numeros != 0) {
                Puntuacion += Numeros + 2;
            }
            
            //Puntuación= Puntuación + (total de símbolos ingresados) *[(largo de cadena) + (Número de la sexta línea) [/¿?%$#]
            if (Simbolos != 0) {
                
                Puntuacion += Simbolos * (Password.length() + 4);
            }         
            
            //Si hay sólo letras: Puntuación – (Número de la séptima línea)
            if (Numeros == 0 && Simbolos == 0) {
                
                Puntuacion -= 6;
            }
            
            //Si hay sólo números: Puntuación – (Número de la octava línea)
            
            if (Mayuscula == 0 && Minuscula == 0 && Simbolos == 0) {
                
                Puntuacion -= 3;
            }
            
            //Imprimir comentario sobre seguridad de contraseña
            
            if (Puntuacion >= 0 && Puntuacion <= 25) {
                
                return "Contraseña Insegura";
            }
            else if (Puntuacion >= 26 && Puntuacion <= 35) {
                
                return "Contraseña poco Segura";
            }
            else if (Puntuacion >= 36 && Puntuacion <= 50) {
                
                return "Contraseña Segura...";
            }
            else if (Puntuacion >= 51) {
                
                return "Contraseña muy Segura...";
            }
            
        }
        
        return "error";
    }

    
}
