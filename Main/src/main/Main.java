/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.VacioException;
import modelo.Sucursal;

/**
 *
 * @author peluche
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ListaEnlazada<Sucursal> lista = new ListaEnlazada<>();
        try {
            Sucursal s1 = new Sucursal();
            s1.setId(lista.size() + 1);
            s1.setNombre("Alyce");
            lista.insertar(s1);
            lista.imprimir();
            s1 = new Sucursal();
            s1.setId(lista.size() + 1);
            s1.setNombre("Marylin");
            lista.insertar(s1);

            lista.imprimir();
 
        } catch (VacioException ex) {
            System.out.println(ex.getMessage());
        
        }
    }
    
}
