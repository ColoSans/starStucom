package ficherosyexcepciones;

import exceptions.MyException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ciudadanos.*;
import modelo.planetas.*;
import persistencia.*;
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
        // cargar los datos de los fichero (leer)(FALTA)
        persistencia();
        
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
                                    listaPorEspecie(linea);
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

    /**
     * Compruebo si un numero es int
     * @param dato dato para comprobar si es int
     * @return 
     */
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
/**
 * Modifica el valor especifico de un ciudadano según su nombre
 * @param linea linea que introduce el usuario
 */
    public static void modificar(String linea) {

        try {

            String[] arrayLinea = linea.split(" ");
            String nombreHabitante = arrayLinea[1];
            String dato = arrayLinea[2];
            if (isInteger(dato)) {
                if (comprobarNombre(nombreHabitante)) {
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
/**
 * Borra un ciudadano
 * @param linea linea que introduce el usuario
 */
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
/**
 * Muestro los habiantes ordenados por planetas y por especies
 */
    public static void listarHabitantes() {
        System.out.println("< POPULATION BY PLANET >");
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
/**
 * Creo planetas
 */
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
/**
 * Metodo en el que según la especie que se introduzca, se añade a su arraylist correspondiente.
 * Aquí invoco los metodos de añadir a ficheros
 * @param linea linea que introduce el usuario
 * @throws MyException 
 */
    public static void tryCiudadano(String linea) throws MyException {
        String[] arrayLinea = linea.split(" ");
        // si comprobarNombre - Lanzas excepcion, ya existe
        if (!comprobarNombre(arrayLinea[3])) {

            switch (arrayLinea[1]) {
                case "vulcan":
                    if (comprobarPlaneta(arrayLinea[2])) {
                        if(isInteger(arrayLinea[4])){
                            int meditacion = Integer.parseInt(arrayLinea[4]);
                            Vulcan v = new Vulcan(meditacion, arrayLinea[3]);
                            Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                            traerPlaneta.comprobarCiudadano(v);
                            traerPlaneta.getHabitantes().add(v);
                            guardarHabitante(v, linea);// Guardar en fichero
                        
                        System.out.println("< OK: Ser censado correctamente en el planeta >");
                        }else{
                            System.out.println("< ERROR 004: Dato incorrecto >");
                        }
                        
                    }
                    break;
                case "nibirian":
                    if (comprobarPlaneta(arrayLinea[2])) {
                        Nibirian n = new Nibirian(arrayLinea[4], arrayLinea[3]);
                        //FALTA COMPROBAR QUE LOS VEGETARIANOS SOLO VIVAN EN NIBIRU
                        Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                        traerPlaneta.comprobarCiudadano(n);
                        guardarHabitante(n, linea);// Guardar en fichero
                        traerPlaneta.getHabitantes().add(n);
                        
                        System.out.println("< OK: Ser censado correctamente en el planeta >");

                    }
                    break;
                case "andorian":
                    if (comprobarPlaneta(arrayLinea[2])) {
                        Andorian a = new Andorian(arrayLinea[4], arrayLinea[3]);
                        Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                        traerPlaneta.comprobarCiudadano(a);
                        guardarHabitante(a, linea);// Guardar en fichero
                        traerPlaneta.getHabitantes().add(a);
                        
                        System.out.println("< OK: Ser censado correctamente en el planeta >");
                    }
                    break;
                case "human":
                    if (comprobarPlaneta(arrayLinea[2])) {
                        if(isInteger(arrayLinea[4])){
                            Human h = new Human(Integer.parseInt(arrayLinea[4]), arrayLinea[3]);
                        Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                        traerPlaneta.comprobarCiudadano(h);
                        guardarHabitante(h, linea);// Guardar en fichero
                        traerPlaneta.getHabitantes().add(h);
                        
                        System.out.println("< OK: Ser censado correctamente en el planeta >");
                        }else{
                            System.out.println("< ERROR 004: Dato incorrecto >");
                        }
                        
                    }
                    break;
                case "klingon":
                    if (comprobarPlaneta(arrayLinea[2])) {
                        if(isInteger(arrayLinea[4])){
                        Klingon k = new Klingon(Integer.parseInt(arrayLinea[4]), arrayLinea[3]);
                        Planeta traerPlaneta = traerPlaneta(arrayLinea[2]);
                        traerPlaneta.comprobarCiudadano(k);
                        guardarHabitante(k, linea);// Guardar en fichero
                        traerPlaneta.getHabitantes().add(k);
                        
                        System.out.println("< OK: Ser censado correctamente en el planeta >");
                        }else{
                            System.out.println("< ERROR 004: Dato incorrecto >");
                        }
                        
                       
                    }
                    break;
                default:
                    throw new MyException("< ERROR 002: Especie incorrecta >");
            }
        } else {
            throw new MyException("< ERROR 006: Ya existe un ser censado con ese nombre >");
        }

    }
/**
 * Recojo el planeta que introduce el usuario
 * @param planeta
 * @return devuelve el planeta
 * @throws MyException 
 */
    public static Planeta traerPlaneta(String planeta) throws MyException {
        for (int i = 0; i < planetas.size(); i++) {
            if (planeta.equals(planetas.get(i).getNombre())) {
                return planetas.get(i);
            }
        }
        return null;
    }
/**
 * Comprueba que exista el planeta
 * @param planeta nombre del planeta
 * @return comprueba si el planeta existe
 * @throws MyException 
 */
    public static boolean comprobarPlaneta(String planeta) throws MyException {
        for (int i = 0; i < planetas.size(); i++) {
            if (planeta.equals(planetas.get(i).getNombre())) {
                return true;
            }
        }
        throw new MyException("< ERROR 003: Planeta incorrecto >");
    }
/**
 * Compruebo que exista el nombre en los arraylist
 * @param nombre nombre del ciudadano
 * @return comprueba si el nombre ya está registrado
 * @throws MyException 
 */
    public static boolean comprobarNombre(String nombre) throws MyException {
        for (Planeta planetas : planetas) {
            for (Ciudadano habitante : planetas.getHabitantes()) {
                if (habitante.getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Metodo en el que compruebo que la especie exista
     * @param especie especia
     * @return  comprueba si la especie existe
     */
    public static boolean comprobarEspecies(String especie) {
        String[] especiesAceptadas = {"Human", "Andorian", "Vulcan", "Nibirian", "Klingon"};
        for (String especieAceptada : especiesAceptadas) {
            if (especieAceptada.equalsIgnoreCase(especie)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metodo en el que listo los ciudadanos dependiendo de la especie
     * @param linea linea que introduce el usuario
     * @throws MyException 
     */
    public static void listaPorEspecie(String linea) throws MyException {

        String[] arrayLinea = linea.split(" ");
        String especie = arrayLinea[1];
        if (comprobarEspecies(especie)) {

            System.out.println("< POPULATION BY RACE >");

            for (Planeta planeta : planetas) {
                for (Ciudadano ciudadanos : planeta.getHabitantes()) {
                    if (ciudadanos.getClass().getSimpleName().equalsIgnoreCase(especie)) {

                        System.out.println(ciudadanos.toString()+"-"+planeta.getNombre());

                    }
                }
            }

        } else {

            throw new MyException("< ERROR 002: Especie incorrecta >");

        }

    }
    /**
     * Metodo en el que paso el ciudadano y el nombre del archivo segun el planeta
     * @param c objeto ciudadano
     * @param linea linea que introduce el usuario
     */
    public static void guardarHabitante(Ciudadano c, String linea){
         String[] arrayLinea = linea.split(" ");
        switch(arrayLinea[2]){
            case "vulcano":
                String archivo;
                Persistencia.escribirEnArchivo(c, archivo="Vulcano.txt");
                break;
            case "nibiru":
                Persistencia.escribirEnArchivo(c, archivo="Nibiru.txt");
                break;
            case "kronos":
                Persistencia.escribirEnArchivo(c, archivo="Kronos.txt");
                break;
            case "andoria":
                Persistencia.escribirEnArchivo(c, archivo="Andoria.txt");
                break;
        }
    }
    /**
     * Metodo donde creo los ficheros y cargo todos sus datos en arraylists segun el planeta
     */
    public static void persistencia() {
        
            File archivoAndoria = Persistencia.comprobarExistencia("Andoria");
            File archivoKronos = Persistencia.comprobarExistencia("Kronos");
            File archivoNibiru = Persistencia.comprobarExistencia("Nibiru");
            File archivoVulcano = Persistencia.comprobarExistencia("Vulcano");
            
        try {
            ArrayList<Ciudadano> andoria = Persistencia.leerLineaALinea(archivoAndoria);
            planetas.get(2).setHabitantes(andoria);
            ArrayList<Ciudadano> kronos = Persistencia.leerLineaALinea(archivoKronos);
            planetas.get(1).setHabitantes(kronos);
            ArrayList<Ciudadano> nibiru = Persistencia.leerLineaALinea(archivoNibiru);
            planetas.get(0).setHabitantes(nibiru);
            ArrayList<Ciudadano> vulcano = Persistencia.leerLineaALinea(archivoVulcano);
            planetas.get(3).setHabitantes(vulcano);
        } catch (MyException ex) {
            Logger.getLogger(FicherosYExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    /**
     * Metodo en el que añado los datos de los arraylists en los que he metido la información de los ficheros a los arraylists de cada planeta
     * @param planeta
     * @param habitantes 
     */
    public static void meterEnPlaneta(Planeta planeta,  ArrayList<String> habitantes){
        if(habitantes.size()==0){
            if(planeta.equals(habitantes)){
                
            }
        }else{
            
        }
    }
    
//    public static void addHabitantes(ArrayList<String> habitantes) throws MyException {
//        for (String cadena : habitantes) {
//            cadena = "c-" + cadena;
//            String operacion = cadena.replace('-',' ');
//            tryCiudadano(operacion);
//        }
//    }
    
    
    
    // Método que le pases una Especie y un nombre de planeta
    // y aÑADE  una linea al fichero nombreplaneta.txt con los datos de la especie
}

