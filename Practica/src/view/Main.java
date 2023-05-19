/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SucursalController;
import controller.ed.cola.Cola;
import controller.ed.cola.ColaI;
import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.ed.pila.exception.TopeException;
import controller.util.Utilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sucursal;

/**
 *
 * @author Peluche
 */
public class Main {

    public static void main(String[] args) {

//        ListaEnlazada<Sucursal> lista = new ListaEnlazada<>();
//        try {
//            Sucursal s1 = new Sucursal();
//            s1.setId(lista.size() + 1);
//            s1.setNombre("Alyce");
//            lista.insertar(s1);
//            lista.imprimir();
//            s1 = new Sucursal();
//            s1.setId(lista.size() + 1);
//            s1.setNombre("Marylin");
//            lista.insertar(s1);
//
//            lista.imprimir();
// 
//        } catch (EmptyException ex) {
//            System.out.println(ex.getMessage());
//        
//        }
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
// 
//        String hora = dateFormat.format(new Date());
// 
//        System.out.println(hora);
        //Utilities.eliminarAntiguos(new ListaEnlazada<>());
//        ColaI cola = new ColaI(20);
//
//        try {
//            for (int i = 0; i < 25; i++) {
//                if (cola.isFull()) {
//                    cola.dequeue();
//                }
//                cola.queue(i);
//            }
//            for (int i = 0; i < cola.getTope(); i++) {
//                System.out.println(cola.dequeue());
//            }
//        } catch (EmptyException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TopeException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (PositionException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(new Date()));
    }
}
