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

                                } else {
                                    throw new MyException("< ERROR 001: N.º de argumentos inválido >");
                                }
                                break;
                            case "m":
                                if (arrayLinea.length == 3) {

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
