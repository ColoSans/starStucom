/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ciudadanos;
/**
 *
 * @author marcc
 */
public class Ciudadano {
    
    private String nombre;
    /**
     * Constructor
     * @param nombre nombre del ser
     */
    public Ciudadano(String nombre){
        this.nombre=nombre;
    }
/**
 * devuelve el nombre del ser
 * @return 
 */
    public String getNombre() {
        return nombre;
    }
/**
 * sirve para modificar el nombre del ser
 * @param nombre nombre
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve la variable indicada, en este caso, en cada clase, hago un override para adaptar el toString a cada especie
     * @return 
     */
    @Override
    public String toString() {
        return nombre; 
    }
}
