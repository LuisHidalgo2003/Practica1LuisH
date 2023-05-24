/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.SucursalController;
import controller.ed.cola.Cola;
import controller.ed.cola.ColaI;
import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.ed.pila.exception.TopeException;
import controller.util.Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EnumMes;
import model.Sucursal;
import model.Venta;
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
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(dateFormat.format(new Date()));
//        vs.setListaVentas(new ListaEnlazada<>());
//
//        for (int i = 0; i < 12; i++) {
//            Venta venta = new Venta();
//            venta.setId(i + 1);
//            venta.setMes(EnumMes.values()[i]);
//            if (i == 4 || i == 10) {
//                venta.setValor(2.0);
//            } else {
//                venta.setValor(0.0);
//            }
//            vs.getListaVentas().insertar(venta);
//        }
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(vs, VentaSucursal.class);
//        try {
//            PrintWriter escritor = new PrintWriter(new File("a.json"));
//            escritor.write(json);
//            escritor.flush();
//            escritor.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            try {
//                Reader lector = Files.newBufferedReader(Paths.get("a.json"));
//                Gson gson = new Gson();
//                vs = (gson.fromJson(lector, VentaSucursal.class));
//            } catch (IOException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            vs.getListaVentas().imprimir();
//        } catch (EmptyException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
