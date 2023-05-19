/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.modeloTabla;

import controller.ed.cola.ColaI;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Reclamo;

/**
 *
 * @author Peluche
 */
public class ModeloTablaAcciones extends AbstractTableModel{
    private ColaI cola = new ColaI(20);

    public ColaI getCola() {
        return cola;
    }

    public void setCola(ColaI cola) {
        this.cola = cola;
    }
    
    @Override
    public int getRowCount() {
       return cola.size();
    }

    @Override
    public int getColumnCount() {
       return 1;
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        
        String s = null;
        
        try {
            s = cola.get(i).toString();
        } catch (EmptyException ex) {
            Logger.getLogger(ModeloTablaAcciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(ModeloTablaAcciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch(i1){
            case 0: return (s != null) ? s : "No definido";
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Acción";
            default: return null;
        }
    }
}
