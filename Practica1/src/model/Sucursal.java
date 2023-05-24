/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ed.listaEnlazada.ListaEnlazada;

/**
 *
 * @author Peluche
 */
public class Sucursal {

    private Integer id;
    private String nombre;
    //private Venta ventas [];
    private ListaEnlazada<Venta> listaVentas;

    public Sucursal() {
        this.listaVentas = new ListaEnlazada<>();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public Venta[] getVentas() {
//        return ventas;
//    }
//
//    public void setVentas(Venta[] ventas) {
//        this.ventas = ventas;
//    }

    public ListaEnlazada<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ListaEnlazada<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}
