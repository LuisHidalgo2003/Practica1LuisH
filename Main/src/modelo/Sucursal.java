/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author peluche
 */
public class Sucursal {

    private Integer id;
    private String nombre;
    private Venta[] venta;

    public Venta[] getVentas() {
        return venta;
    }

    public void setVentas(Venta[] ventas) {
        this.venta = ventas;
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

    @Override
    public String toString() {
        return nombre;
    }

}
