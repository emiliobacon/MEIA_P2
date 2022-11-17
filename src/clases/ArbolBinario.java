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
public class ArbolBinario {
    nodoArbolBinario root;

    public ArbolBinario() {
        this.root = null;
    }
    public ArbolBinario(nodoArbolBinario first) {
        this.root = first;
    }
    
    public void insertarEnArbol(nodoArbolBinario newNode)
    {
        if (root == null) 
        {
            root = newNode;    
        }
        else
        {
            insertarEnArbol(root, newNode);       
        }
    }
    private void insertarEnArbol(nodoArbolBinario  root, nodoArbolBinario nuevo)
    {
        if ((nuevo.compareTo(root)) < 0)
        {
            if ( root.izquierdo == null) 
            {
                root.izquierdo = nuevo;      
            }
            else
            {
                insertarEnArbol( root.izquierdo, nuevo);    
            }
        }
        else if((nuevo.compareTo( root))==0){
            //si el valor es repetido no hará nada
        }
        else
        {
            if ( root.derecho == null) 
            {
                root.derecho = nuevo;      
            }
            else
            {
                insertarEnArbol( root.derecho, nuevo);    
            }
        }
    }
    
    public nodoArbolBinario Buscar(nodoArbolBinario itemBuscado)
    {
        if (root != null) {
            return Buscar(itemBuscado, root);
        }
        else return null;
    }
    private nodoArbolBinario Buscar(nodoArbolBinario item, nodoArbolBinario  root)
    {
        if (root != null) {
            if (item.compareTo(root)==0) {
                return root;
            }
            else if ((item.compareTo(root)) < 0)
            {
                return Buscar(item, root.izquierdo);
            }
            else
            {
                return Buscar(item, root.derecho);
            }
        }
        else
        {
            return null;
        }
    }
    
    
}
