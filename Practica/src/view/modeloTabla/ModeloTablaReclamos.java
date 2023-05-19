/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.modeloTabla;

import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Reclamo;
import model.Sucursal;

/**
 *
 * @author Peluche
 */
public class ModeloTablaReclamos extends AbstractTableModel{

    private ListaEnlazada<Reclamo> lista =  new ListaEnlazada<>();

    public ListaEnlazada<Reclamo> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Reclamo> lista) {
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
        Reclamo r = null;
        try {
            r = lista.get(i);
        } catch (EmptyException ex) {
            Logger.getLogger(ModeloTablaReclamos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PositionException ex) {
            Logger.getLogger(ModeloTablaReclamos.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(i1){
            case 0: return (r != null) ? r.getHora(): "No definido";
            case 1: return (r != null) ? r.getNombre() : "No definido";
            case 2: return (r != null) ? r.getComentario() : "No definido";
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Hora";
            case 1: return "Nombre";
            case 2: return "Comentario";
            default: return null;
        }
    }
    
}
