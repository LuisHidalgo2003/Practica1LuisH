/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.exception.SpaceException;
import model.EnumMes;
import model.Reclamo;
import model.Sucursal;
import model.Venta;

/**
 *
 * @author Peluche
 */
public class SucursalController {

    private ListaEnlazada<Sucursal> lista;
    private Sucursal sucursal;
    private Venta venta;
    private ListaEnlazada<Reclamo> listaReclamos;

    
    public SucursalController() {
        lista =  new ListaEnlazada<>();
        listaReclamos = new ListaEnlazada<>();
    }
    
    public SucursalController(String nombre){
        getSucursal().setNombre(nombre);  
    }

    public ListaEnlazada<Reclamo> getListaReclamos() {
        return listaReclamos;
    }

    public void setListaReclamos(ListaEnlazada<Reclamo> listaReclamos) {
        this.listaReclamos = listaReclamos;
    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public ListaEnlazada<Sucursal> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Sucursal> lista) {
        this.lista = lista;
    }
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public void guardarReclamo(Reclamo reclamo){
        this.listaReclamos.insertar(reclamo);
    }

    public boolean registrar() throws SpaceException {

        //sucursal.setVentas(new Venta[EnumMes.values().length]);
        for (int i = 0; i < EnumMes.values().length; i++) {
            Venta venta = new Venta();
            venta.setId(i + 1);
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
            //sucursal.getVentas()[i] = venta;
            sucursal.getListaVentas().insertar(venta);
        }

        lista.insertar(sucursal);
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws SpaceException, EmptyException, PositionException{

        if (this.sucursal != null) {
            if (posVenta <= this.sucursal.getListaVentas().size()) {
                //sucursal.getVentas()[posVenta].setValor(valor);
                sucursal.getListaVentas().get(posVenta).setValor(valor);
            }else{
                throw new SpaceException();
            }
        } else {
            throw new NullPointerException("Debe seleccionar una sucursal");
        }
        return true;
    }

}
