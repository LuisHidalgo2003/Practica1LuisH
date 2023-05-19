/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.SucursalController;
import controller.ed.cola.ColaI;
import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.ed.pila.exception.TopeException;
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
import model.Reclamo;
import model.Sucursal;
import model.Venta;
import view.modeloTabla.SucursalControllerJSON;

/**
 *
 * @author Peluche
 */
public class Utilities {

    public static void imprimir(Object[] objs) {
        System.out.println("Lista de " + objs.getClass().getSimpleName());
        for (Object o : objs) {
            System.out.println(o.toString());
        }
    }

    public static Double sumarVentas(Sucursal s) throws EmptyException, PositionException {
        if (!s.getListaVentas().isEmpty()) {
            Double ventas = 0.0;
            for (int i = 0; i < s.getListaVentas().size(); i++) {
                ventas += s.getListaVentas().get(i).getValor();
            }
            return ventas;
        }

//        if (s.getVentas() != null) {
//            Double ventas = 0.0;
//            for (Venta v : s.getVentas()) {
//                ventas += v.getValor();
//            }
//            return ventas;
//        }
        return 0.0;
    }

    public static Double mediaVentas(Sucursal s) throws EmptyException, PositionException {
        Double suma = sumarVentas(s);
        if (suma == 0) {
            return suma;
        } else {
            return suma / (s.getListaVentas().size());
        }
    }

    public static Double promediarMeses(ListaEnlazada<Sucursal> lista, int fila) throws EmptyException, PositionException {
        Double promedio = 0.0;

        for (int i = 0; i < lista.size(); i++) {
            promedio += lista.get(i).getListaVentas().get(fila).getValor();
        }

        promedio /= lista.size();

        return promedio;
    }

    public static String mayorVentas(ListaEnlazada<Sucursal> lista) throws EmptyException, PositionException {
        String cadena = "";
        Double mayor = 0.0;

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).getListaVentas().size(); j++) {
                if (lista.get(i).getListaVentas().get(j).getValor() > mayor) {
                    mayor = lista.get(i).getListaVentas().get(j).getValor();
                    cadena = lista.get(i).getNombre() + " / " + lista.get(i).getListaVentas().get(j).getMes().toString();
                }
            }
        }
        return cadena;
    }

    public static String menorVentas(ListaEnlazada<Sucursal> lista) throws EmptyException, PositionException {
        String cadena = "";
        Double menor = Double.MAX_VALUE;

        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.get(i).getListaVentas().size(); j++) {
                if (lista.get(i).getListaVentas().get(j).getValor() < menor) {
                    menor = lista.get(i).getListaVentas().get(j).getValor();
                    cadena = lista.get(i).getNombre() + " / " + lista.get(i).getListaVentas().get(j).getMes().toString();
                }
            }
        }
        return cadena;
    }

    public static ListaEnlazada<Reclamo> eliminarAntiguos(ListaEnlazada<Reclamo> lista) throws EmptyException, PositionException {
        ListaEnlazada<Reclamo> listaAux = lista;

        for (int i = 0; i < lista.size(); i++) {
            Reclamo reclamoAux = lista.get(i);

            String horaActual = horaActual();

            char horaActualArray[] = horaActual.toCharArray();
            char horaIngresoArray[] = reclamoAux.getHora().toCharArray();

            LocalTime horaInicio = LocalTime.of(Integer.parseInt(horaIngresoArray[0] + "" + horaIngresoArray[1]), Integer.parseInt(horaIngresoArray[3] + "" + horaIngresoArray[4]));
            LocalTime horaFin = LocalTime.of(Integer.parseInt(horaActualArray[0] + "" + horaActualArray[1]), Integer.parseInt(horaActualArray[3] + "" + horaActualArray[4]));

            long minutosTranscurridos = ChronoUnit.MINUTES.between(horaInicio, horaFin);

            if (minutosTranscurridos >= 60) {
                listaAux.delete(i);
            }
        }

        return listaAux;
    }

    public static String horaActual() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(new Date());
    }

    public static String fechaActual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }

    public static ColaI registrarAccion(ColaI cola, String accion) {
        if (cola.isFull()) {
            try {
                cola.dequeue();
            } catch (EmptyException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PositionException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        accion += " - " + fechaActual();

        try {
            cola.queue(accion);
        } catch (TopeException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cola;
    }

    public static String[] colaToArray(ColaI cola) throws EmptyException, PositionException {
        String lista[] = new String[20];
        ColaI colaAux = cola;

        for (int i = 0; i < cola.size(); i++) {
            lista[i] = colaAux.dequeue().toString();
        }
        return lista;
    }
    
    public static Boolean guardar(SucursalController sc) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        SucursalControllerJSON mapeo = new SucursalControllerJSON(sc);
        String json = gson.toJson(mapeo);
        try {
            PrintWriter escritor = new PrintWriter(new File("sucursales.json"));
            escritor.write(json);
            escritor.flush();
            escritor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
    
    public static SucursalController cargarJson() throws FileNotFoundException, IOException {
        SucursalControllerJSON mapeo = new SucursalControllerJSON();
        Reader lector = Files.newBufferedReader(Paths.get("sucursales.json"));
        Gson gson = new Gson();
        mapeo = (gson.fromJson(lector, SucursalControllerJSON.class));
        return mapeo.getSc();
    }
}
