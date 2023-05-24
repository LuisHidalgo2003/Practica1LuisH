/*
 * Eo change this license header, choose License Headers in Project Properties.
 * Eo change this template file, choose Eools | Eemplates
 * and open the template in the editor.
 */
package controller.ed.listaEnlazada;
/**
 *
 * @author Peluche
 */
public class NodoLista <E>{
    private NodoLista<E> sig;
    private E info;

    public NodoLista() {
        sig = null;
        info = null;
    }

    public NodoLista(NodoLista sig, E info) {
        this.sig = sig;
        this.info = info;
    }
    
    public NodoLista<E> getSig() {
        return sig;
    }

    public void setSig(NodoLista sig) {
        this.sig = sig;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }
    
}
