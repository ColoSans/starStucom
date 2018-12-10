/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*dsadsa*/
package ficherosyexcepciones;

import exceptions.MyException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ciudadanos.*;
import modelo.planetas.*;

/**
 *
 * @author marcc
 */
public class FicherosYExcepciones {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Planeta> planetas = new ArrayList<>();
//    public static ArrayList<Ciudadano> ciudadanos = new ArrayList<>();

    public static void main(String[] args) {
        crearPlanetas();
        // cargar los datos de los fichero (leer)
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            boolean salir = false;
            do {
                try {
                    linea = br.readLine().toLowerCase();

                    String[] arrayLinea = linea.split(" ");

                    if (arrayLinea.length > 0) {

                        switch (arrayLinea[0]) {
                            case "x":

                                if (arrayLinea.length == 1) {
                                    salir = true;
                                } else {
                                    throw new MyException("< ERROR 001: N.º de argumentos inválido >");
                                }
                                break;
                            case "c":
                                if (arrayLinea.length == 5) {

                                    tryCiudadano(linea);

                                } else {
                                    throw new MyException("< ERROR 001: N.º de argumentos inválido >");
                                }
                                break;
                            case "b":
                                if (arrayLinea.length == 2) {
                                    borrarCiudadano(linea);
                                } else {
                                    throw new MyException("< ERROR 001: N.º de argumentos inválido >");
                                }
                                break;
                            case "m":
                                if (arrayLinea.length == 3) {
                                    modificar(linea);
                                } else {
                                    throw new MyException("< ERROR 001: N.º de argumentos inválido >");
                                }
                                break;
                            case "p":
                                if (arrayLinea.length == 2) {

                                } else {
                                    throw new MyException("< ERROR 001: N.º de argumentos inválido >");
                                }
                                break;
                            case "l":
                                if (arrayLinea.length == 1) {
                                    listarHabitantes();
                                } else {
                                    throw new MyException("< ERROR 001: N.º de argumentos inválido >");
                                }
                                break;
                        };
                    } else {
                        System.out.println("Valor incorrecto");
                    }
                } catch (MyException ex) {
                    System.out.println(ex.getMessage());
                }
            } while (!salir);

        } catch (IOException ex) {
            Logger.getLogger(FicherosYExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isInteger(String dato) {
        try {

            Integer.parseInt(dato);

        } catch (NumberFormatException e) {

            return false;

        } catch (NullPointerException e) {

            return false;

        }

        return true;
    }

    public static void modificar(String linea) {

        try {

            String[] arrayLinea = linea.split(" ");
            String nombreHabitante = arrayLinea[1];
            String dato = arrayLinea[2];
            if (isInteger(dato)) {
                if (!comprobarNombre(nombreHabitante)) {
                    for (Planeta planeta : planetas) {
                        for (Ciudadano ciudadanos : planeta.getHabitantes()) {
                            if (ciudadanos.getNombre().equalsIgnoreCase(nombreHabitante)) {
                                switch (ciudadanos.getClass().getSimpleName().toLowerCase()) {

                                    case "human":
                                        Human humano = (Human) ciudadanos;
                                        humano.setEdad(Integer.parseInt(dato));
                                        System.out.println("< OK: Ser modificado correctamente >");
                                        break;
                                    case "vulcan":
                                        Vulcan vulcan = (Vulcan) ciudadanos;
                                        vulcan.setMeditacion(Integer.parseInt(dato));
                                        System.out.println("< OK: Ser modificado correctamente >");
                                        break;
                                    case "klingon":
                                        Klingon klingon = (Klingon) ciudadanos;
                                        klingon.setFuerza(Integer.parseInt(dato));
                                        System.out.println("< OK: Ser modificado correctamente >");
                                        break;
                                    default:
                                        throw new MyException("< ERROR 008: El ser no permite ser modificado >");
                                }
                            }
                        }
                    }

                } else {

                    throw new MyException("< ERROR 007: No existe ningún ser con ese nombre >");

                }
            } else {

                throw new MyException("< ERROR 004: Dato incorrecto >");

            }
        } catch (MyException ex) {

            System.out.println(ex.getMessage());

        }

    }

    public static void borrarCiudadano(String linea) {

        try {

            String[] arrayLinea = linea.split(" ");
            String nombreHabitante = arrayLinea[1];

            for (int i = 0; i < planetas.size(); i++) {
                ArrayList<Ciudadano> habitantes = planetas.get(i).getHabitantes();
                for (int a = 0; a < habitantes.size(); a++) {
                    if (habitantes.get(a).getNombre().equalsIgnoreCase(nombreHabitante)) {
                        habitantes.remove(a);
                        System.out.println("<OK: Ser borrado correctamente >");
                    }
                }
            }
            //Elimina al habitante pero cuando acaba de recorrer el bucle saca por pantalla la excepcion
            throw new MyException("< ERROR 007: No existe ningún ser con ese nombre >");
        } catch (MyException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public static void listarHabitantes() {
        System.out.println("< POPULATION BY PLANET");
        Comparator<Ciudadano> comparadorNombre = Comparator.comparing(Ciudadano -> Ciudadano.getClass().getSimpleName());
        comparadorNombre = comparadorNombre.thenComparing(Comparator.comparing(Ciudadano -> Ciudadano.getNombre()));

        for (Planeta planeta : planetas) {
            System.out.println("< " + planeta.getNombre() + " >");
            Collections.sort(planeta.getHabitantes(), comparadorNombre);
            for (Ciudadano ciudadano : planeta.getHabitantes()) {
                System.out.println(ciudadano);
            }

        }

    }

    public static void crearPlanetas() {
        Planeta vulcano = new Vulcano("vulcano");
        Planeta andoria = new Andoria("andoria");
        Planeta kronos = new Kronos(0, "kronos");
        Planeta nibiru = new Planeta("nibiru");
        planetas.add(nibiru);
        planetas.add(kronos);
        planetas.add(andoria);
        planetas.add(vulcano);
    }

    public static void tryCiudadano(String linea) throws MyException {
        String[] arrayLinea = linea.split(" ");

        switch (arrayLinea[1]) {
            case "vulcan":
                int meditacion = Integer.parseInt(arrayLinea[4]);
                if (comprobarPlaneta(arrayLinea[2]) && comprobarNombre(arrayLinea[3])) {
                    Vulcan v = new Vulcan(meditacion, arrayLinea[3]);
                    Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                    traerPlaneta.comprobarCiudadano(v);
                    traerPlaneta.getHabitantes().add(v);
                    // Guardar en fichero
                    System.out.println("< OK: Ser censado correctamente en el planeta >");
                }
                break;
            case "nibirian":
                if (comprobarPlaneta(arrayLinea[2]) && comprobarNombre(arrayLinea[3])) {
                    Nibirian n = new Nibirian(arrayLinea[4], arrayLinea[3]);
                    //FALTA COMPROBAR QUE LOS VEGETARIANOS SOLO VIVAN EN NIBIRU
                    Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                    traerPlaneta.comprobarCiudadano(n);
                    // Guardar en fichero
                    traerPlaneta.getHabitantes().add(n);
                    System.out.println("< OK: Ser censado correctamente en el planeta >");

                }
                break;
            case "andorian":
                if (comprobarPlaneta(arrayLinea[2]) && comprobarNombre(arrayLinea[3])) {
                    Andorian a = new Andorian(arrayLinea[4], arrayLinea[3]);
                    Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                    traerPlaneta.comprobarCiudadano(a);
                    // Guardar en fichero
                    traerPlaneta.getHabitantes().add(a);
                    System.out.println("< OK: Ser censado correctamente en el planeta >");
                }
                break;
            case "human":
                if (comprobarPlaneta(arrayLinea[2]) && comprobarNombre(arrayLinea[3])) {
                    Human h = new Human(Integer.parseInt(arrayLinea[4]), arrayLinea[3]);
                    Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                    traerPlaneta.comprobarCiudadano(h);
                    // Guardar en fichero
                    traerPlaneta.getHabitantes().add(h);
                    System.out.println("< OK: Ser censado correctamente en el planeta >");
                }
                break;
            case "klingon":
                if (comprobarPlaneta(arrayLinea[2]) && comprobarNombre(arrayLinea[3])) {
                    Klingon k = new Klingon(Integer.parseInt(arrayLinea[4]), arrayLinea[3]);
                    Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                    traerPlaneta.comprobarCiudadano(k);
                    // Guardar en fichero
                    traerPlaneta.getHabitantes().add(k);
                    System.out.println("< OK: Ser censado correctamente en el planeta >");
                }
                break;
            default:
                throw new MyException("< ERROR 002: Especie incorrecta >");
        }
    }

    public static Planeta traerPlaneta(String planeta) throws MyException {
        for (int i = 0; i < planetas.size(); i++) {
            if (planeta.equals(planetas.get(i).getNombre())) {
                return planetas.get(i);
            }
        }
        return null;
    }

    public static boolean comprobarPlaneta(String planeta) throws MyException {
        for (int i = 0; i < planetas.size(); i++) {
            if (planeta.equals(planetas.get(i).getNombre())) {
                return true;
            }
        }
        throw new MyException("< ERROR 003: Planeta incorrecto >");
    }

    public static boolean comprobarNombre(String nombre) throws MyException {
        for (Planeta planetas : planetas) {
            for (Ciudadano habitante : planetas.getHabitantes()) {
                if (habitante.getNombre().equals(nombre)) {
                    throw new MyException("< ERROR 006: Ya existe un ser censado con ese nombre >");
                }
            }
        }
        return true;
    }

    // Método que le pases una Especie y un nombre de planeta
    // y aÑADE  una linea al fichero nombreplaneta.txt con los datos de la especie
}
