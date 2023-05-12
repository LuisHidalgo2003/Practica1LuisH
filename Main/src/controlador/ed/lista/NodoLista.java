/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.lista;

/**
 *
 * @author peluche
 */
public class NodoLista<E> {
        private E info;
    private NodoLista sig;

    public NodoLista(E info, NodoLista sig) {
        this.info = info;
        this.sig = sig;
    }

    public NodoLista() {
        info = null;
        sig = null;
    }
    

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public NodoLista getSig() {
        return sig;
    }

    public void setSig(NodoLista sig) {
        this.sig = sig;
    }
}
