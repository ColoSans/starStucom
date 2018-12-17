/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import exceptions.MyException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ciudadanos.Ciudadano;
import modelo.ciudadanos.Vulcan;

/**
 *
 * @author marcc
 */
public class Persistencia {
    // Para cada planeta
    // si existe el fichero -> lees linea a linea y vas creando los seres y añadiendolos a su arraylist
    // sino existe nada (queda el planeta con el arraylist vacío)
    
    
    // Escribir un ser en un planeta
    /**
     * Lee linea a linea el archivo que le pasas y añade las lineas en un arraylist
     * @param archivo archivo
     * @return
     * @throws MyException 
     */
    public static ArrayList<String> leerLineaALinea(File archivo) throws MyException {
        ArrayList<String> Ciudadanos = new ArrayList<>();
        try {
            if (archivo != null) {
                FileReader fileReader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linia;
                while ((linia = bufferedReader.readLine()) != null) {
                    
                    System.out.println(linia);
                    Ciudadanos.add(linia);
                }
                bufferedReader.close();
            }
        } catch (IOException ex) {

        }
        return Ciudadanos;
    }
    /**
     * Comprueba que que un fichero existe, si no, lo crea.
     * @param nombre nombre del fichero
     * @return 
     */
    public static File comprobarExistencia(String nombre) {
        try {
            String rutaFichero = nombre + ".txt";
            File archivo = new File(rutaFichero);
            if (archivo.exists()) {
                return archivo;
                
            } else {
                archivo.createNewFile();
            }
        } catch (Exception e) {

        }
        
        File archivo = new File(nombre);
        return archivo;
    }
    
    /**
     * Metodo que escribe en los ficheros
     * @param c objeto ciudadano
     * @param archivo nombre del archivo
     */
    public static void escribirEnArchivo(Ciudadano c, String archivo) {
        try {
        
            // supongamos que está en Vulcano
            // FileWriter para escribir en fichero si ponemos true, es para añadir una linea
            // Si no pones true, o pones false es para chafar contenido del fichero
            FileWriter fw = new FileWriter(new File(archivo), true);
            // BufferedWriter es para escribir linea a linea, más cómodo y óptimo 
            BufferedWriter bw = new BufferedWriter(fw);
            // escribimos los datos del extraterrestre
            bw.write(c.toString());
            // Salto de linea en el fichero
            bw.newLine();
            // cerramos canal de escritura sino puede haber error
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
