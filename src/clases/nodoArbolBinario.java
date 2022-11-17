/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author megan
 */
public class nodoArbolBinario implements Comparable<nodoArbolBinario>{
    int numeroRegistro;
    int posicion;
    String dato;
    
    nodoArbolBinario izquierdo;
    nodoArbolBinario derecho;
    
    //constructores de mi clase

    public nodoArbolBinario(String dato) {
        this.dato = dato;
    }

    public nodoArbolBinario(String dato,int posicion) {
        this.posicion = posicion;
        this.dato = dato;
    }

    @Override
    public int compareTo(nodoArbolBinario nodito) {
        String valor1 = dato+posicion;
        String valor2 = nodito.dato+nodito.posicion;
        
        return valor1.compareTo(valor2);
        
    }
}
