/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modeloTabla;

import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.util.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Sucursal;

/**
 *
 * @author Peluche
 */
public class ModeloTablaSucursal extends AbstractTableModel{

    private ListaEnlazada<Sucursal> lista =  new ListaEnlazada<>();

    public ListaEnlazada<Sucursal> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Sucursal> lista) {
        this.lista = lista;
    }
    @Override
    public int getRowCount() {
       return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }
    @Override
    public Object getValueAt(int i, int i1) {
        Sucursal s = null;
        try {
            s = lista.get(i);
        } catch (EmptyException ex) {
            Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(i1){
            case 0: return (s != null) ? s.getNombre() : "No definido";
            case 1: {
                try {
                    return (s != null) ? Utilities.sumarVentas(s) : 0.0;
                } catch (EmptyException ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PositionException ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 2: {
                try {
                    return (s != null) ? Utilities.mediaVentas(s) : 0.0;
                } catch (EmptyException ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PositionException ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            default: return null;
        }
    }
//    private Sucursal [] datos = new Sucursal[4];
//
//    public Sucursal[] getDatos() {
//        return datos;
//    }
//
//    public void setDatos(Sucursal[] datos) {
//        this.datos = datos;
//    }
//    
//    @Override
//    public int getRowCount() {
//       return datos.length;
//    }
//
//    @Override
//    public int getColumnCount() {
//       return 3;
//    }
//
//    @Override
//    public Object getValueAt(int i, int i1) {
//        Sucursal s = datos[i];
//        switch(i1){
//            case 0: return (s != null) ? s.getNombre() : "No definido";
//            case 1: return (s != null) ? Utilities.sumarVentas(s) : 0.0;
//            case 2: return (s != null) ? Utilities.mediaVentas(s) : 0.0;
//            default: return null;
//        }
//    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Sucursal";
            case 1: return "Venta Anual";
            case 2: return "Venta Promedio";
            default: return null;
        }
    }
    
    
    
}
