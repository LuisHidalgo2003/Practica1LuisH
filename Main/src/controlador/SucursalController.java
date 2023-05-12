/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.ed.lista.ListaEnlazada;
import controlador.exception.SpaceException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author peluche
 */
public class SucursalController {
    private ListaEnlazada<Sucursal> lista ;
    private Sucursal sucursal;
    private Venta venta;

    
    public SucursalController() {
        lista =  new ListaEnlazada<>();
        
    }
    
    public SucursalController(String nombre){
        getSucursal().setNombre(nombre);  
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

    public boolean registrar() throws SpaceException {

        sucursal.setVentas(new Venta[EnumMes.values().length]);
        for (int i = 0; i < EnumMes.values().length; i++) {
            Venta venta = new Venta();
            venta.setId(i + 1);
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
            sucursal.getVentas()[i] = venta;
        }

          lista.insertar(sucursal);
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws SpaceException{

        if (this.sucursal != null) {
            if (posVenta <= this.sucursal.getVentas().length-1) {
                sucursal.getVentas()[posVenta].setValor(valor);
            }else{
                throw new SpaceException();
            }
        } else {
            throw new NullPointerException("Debe seleccionar una sucursal");
        }
        return true;
    }
}
