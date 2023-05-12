/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.lista;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;

/**
 *
 * @author peluche
 */
public class ListaEnlazada <E>{
    
    private NodoLista<E> cabecera;
    private Integer size = 0;

    public NodoLista getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista cabecera) {
        this.cabecera = cabecera;
    }
    
    public boolean estaVacia() {
        return cabecera == null;
    }
    
    public boolean insertar(E info){
        NodoLista<E> nuevo = new NodoLista<>(info, null);
        if (estaVacia()) {
           
            this.cabecera = nuevo;
            this.size++;
        }else{
            NodoLista<E> aux = cabecera;
//            for (int i = 0; i < size()-1; i++) {
//                aux = aux.getSig();
//            }
            while (aux.getSig() !=null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
        return true;
      }
    
    public Integer size(){
 
        return size;
    }
    
    public void imprimir()throws VacioException{
        if (estaVacia()) {
            throw new VacioException();
        }else{
        NodoLista<E> aux = cabecera;
        System.out.println("----------Lista------------");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo());
                aux = aux.getSig();
            }
            System.out.println("----------Lista fin--------------");
        }
    }
    public void insertarPosicion(E info, Integer pos)throws PosicionException{
        if (estaVacia()) {
            insertar(info);
        }else if(pos >= 0 && pos< size()&& pos==0){
            insertarInicio(info);
        }
        else if(pos >= 0 && pos< size){
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < (pos -1); i++) {
                aux = aux.getSig();
            }
            NodoLista<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            size++;
        }else{
            throw  new PosicionException();
        }
    }
    public void insertarInicio(E info){
        if (estaVacia()) {
            insertar(info);
        }else{
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;
           
        }
    }
    public E get(Integer pos) throws VacioException, PosicionException {
        if (estaVacia()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos ; i++) {
                        aux = aux.getSig();
                    }
                    dato = aux.getInfo();
                }
            }else{
            throw new PosicionException();
            }
          return dato;  
        }
    
    }   
    public E delete(Integer pos) throws VacioException, PosicionException {
        if (estaVacia()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                    cabecera = cabecera.getSig();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos-1) ; i++) {
                        aux = aux.getSig();
                    }
                    if ((pos +1)== size()) {
                        NodoLista<E> aux1 = aux.getSig();
                       // dato = aux.getSig().getInfo();
                    }else{
                        dato =aux.getInfo();
                    }
                    dato = aux.getInfo();
                    NodoLista<E> proximo = aux.getSig();
                    aux.setSig(proximo.getSig());
                    size--;
                }
            }else{
                
            throw new PosicionException();
            }
          return dato;  
        }
        
    }
    public void deleteAll(){
        this.cabecera =null;
    }
}
