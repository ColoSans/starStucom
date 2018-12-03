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
    private static ArrayList<Ciudadano> ciudadanos = new ArrayList<>();
//    public static ArrayList<Ciudadano> ciudadanos = new ArrayList<>();

    public static void main(String[] args) {
        crearPlanetas();
        // cargar los datos de los fichero (leer)
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            boolean salir = false;
            do {
                linea = br.readLine().toLowerCase();

                String[] arrayLinea = linea.split(" ");

                if (arrayLinea.length > 0) {

                    switch (arrayLinea[0]) {
                        case "x":
                            if (arrayLinea.length == 1) {
                                salir = true;
                            } else {
                                System.out.println("Numero de argumentos invalido");
                            }
                            break;
                        case "c":
                            if (arrayLinea.length == 5) {
                                tryCiudadano(linea);
                            }else{
                                System.out.println("Numero de argumentos invalido");
                            }
                            break;
                        case "b":
                            if (arrayLinea.length == 2) {
                                
                            }else{
                                System.out.println("Numero de argumentos invalido");
                            }
                            break;
                        case "m":
                            if (arrayLinea.length == 3) {
                                
                            } else {
                                System.out.println("Numero de argumentos invalido");
                            }
                            break;
                        case "p":
                            if (arrayLinea.length == 2) {
                                
                            } else {
                                System.out.println("Numero de argumentos invalido");
                            }
                            break;
                        case "l":
                            if (arrayLinea.length == 1) {
                                
                            } else {
                                System.out.println("Numero de argumentos invalido");
                            }
                            break;
                    };
                } else {
                    System.out.println("Valor incorrecto");
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

    public static void tryCiudadano(String linea) {
        String[] arrayLinea = linea.split(" ");
        switch(arrayLinea[1]){
            case "vulcan":
                for(int i=0;i<planetas.size();i++){
                    if(arrayLinea[2].equals(planetas.get(i).getNombre())){
                        if(arrayLinea[3].equals(ciudadanos.get(i).getNombre())){
                            
                        }else{
                            System.out.println("< ERROR 006: Ya existe un ser censado con ese nombre >");
                        }
                    }else{
                        System.out.println("< ERROR 003: Planeta incorrecto >");
                    }
                }
                break;
            case "nibirian":
                break;
            case "andorian":
                break;
            case "human":
                break;
            case "klingon":
                break;
            
        }
        
    }
    
    
//        public static boolean planetaxplaneta(String[] arrayLinea){
//        for(int i=0;i<planetas.size();i++){
//            if(arrayLinea[2].equals(planetas.get(i).getNombre())){
//                if(arrayLinea[3].equals(ciudadanos.get(i).getNombre())){
//                    return true;
//                }else{
//                    System.out.println("< ERROR 006: Ya existe un ser censado con ese nombre >");
//                    return false;
//                }
//                }else{
//                    System.out.println("< ERROR 003: Planeta incorrecto >");
//                    return false;
//                }
//                    
//            }
//        return false;
//    }
}
