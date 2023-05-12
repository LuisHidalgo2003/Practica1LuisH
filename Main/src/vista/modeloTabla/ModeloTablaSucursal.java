/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.util.Utilidades;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;

/**
 *
 * @author peluche
 */
public class ModeloTablaSucursal extends AbstractTableModel {

    private Sucursal[] datos = new Sucursal[4];

    public Sucursal[] getDatos() {
        return datos;
    }

    public void setDatos(Sucursal[] datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public Object getValueAt(int i, int il) {
        Sucursal s = datos[i];
        switch (il) {
            case 0:
                return (s != null) ? s.getNombre() : "NO DEFINIDO";
            case 1:
                return (s != null) ? Utilidades.sumarVentas(s) : 0.0;
            case 2:
                return (s != null) ? Utilidades.mediaVentas(s) : 0.0;
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
        case 0: return "Sucursal";
        case 1: return "Venta Anual";
        case 2: return "Venta Promedio";
        default: return null;
    }
    }

 
}
