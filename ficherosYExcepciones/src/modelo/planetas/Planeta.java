/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planetas;
import exceptions.MyException;
import modelo.ciudadanos.Ciudadano;
import java.util.ArrayList;

/**
 *
 * @author marcc
 */
public class Planeta {
    private String nombre;
    private ArrayList<Ciudadano> habitantes = new ArrayList<>();
    
    /**
     * Constructor clase planeta
     * @param nombre nombre de los planetas
     */
    public Planeta(String nombre){
            this.nombre = nombre;
    }
    /**
     * Devuelve el valor de nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modifica el valor de la variable nombre
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void comprobarCiudadano(Ciudadano c) throws MyException {
        
    }
    public ArrayList<Ciudadano> getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(ArrayList<Ciudadano> habitantes) {
        this.habitantes = habitantes;
    }
    
}
