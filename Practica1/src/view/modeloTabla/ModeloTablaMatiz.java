/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.modeloTabla;

import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.util.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.EnumMes;
import model.Sucursal;

/**
 *
 * @author Peluche
 */
public class ModeloTablaMatiz extends AbstractTableModel{
    
    private ListaEnlazada<Sucursal> listaSucursales = new ListaEnlazada<>();

    public ListaEnlazada<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(ListaEnlazada<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }
    
    @Override
    public int getRowCount() {
       return EnumMes.values().length + 1;
    }

    @Override
    public int getColumnCount() {
       return 2 + listaSucursales.size();
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        EnumMes m = null;
        if (i < EnumMes.values().length) {
            m = EnumMes.values()[i];
            if (i1 == 0) {
                return m;
            }else if (i1 == (getColumnCount()-1)) {
                try {
                    return Utilities.promediarMeses(listaSucursales, i);
                } catch (EmptyException ex) {
                    Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PositionException ex) {
                    Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(i1 <= listaSucursales.size()){
                try {
                    return listaSucursales.get(i1-1).getListaVentas().get(i).getValor();
                } catch (EmptyException ex) {
                    Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PositionException ex) {
                    Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if (i1 != 0 && i1 <= listaSucursales.size()){
            try {
                return Utilities.sumarVentas(listaSucursales.get(i1-1));
            } catch (EmptyException ex) {
                Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PositionException ex) {
                Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ">>Ventas anuales<<";
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Mes";
        }else if(column == (getColumnCount()-1)){
            return "PromedioMes";
        }else if(column <= listaSucursales.size()){
            try {
                return listaSucursales.get(column-1).getNombre();
            } catch (EmptyException ex) {
                Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PositionException ex) {
                Logger.getLogger(ModeloTablaMatiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return "a";
    }
    
}
