/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planetas;

import exceptions.MyException;
import modelo.ciudadanos.Ciudadano;

/**
 *
 * @author marcc
 */
public class Kronos extends Planeta{
    private int nHabitantes;
/**
 * constructor
 * @param nHabitantes
 * @param nombre 
 */
    public Kronos(int nHabitantes, String nombre) {
        super(nombre);
        this.nHabitantes = 30;
    }
/**
 * Devuelve el valor nHabitantes
 * @return 
 */
    public int getnHabitantes() {
        return nHabitantes;
    }
/**
 * modifica el valor nHabitantes
 * @param nHabitantes 
 */
    public void setnHabitantes(int nHabitantes) {
        this.nHabitantes = nHabitantes;
    }
    /**
     * comprueba que el planeta tenga como maximo 30 habitantes
     * @param c objeto ciudadanos
     * @throws MyException 
     */
    public void comprobarCiudadano(Ciudadano c) throws MyException {
        if(getHabitantes().size()==nHabitantes){
             throw new MyException("< ERROR 005: No se puede registrar ese ser en ese planeta >");
        }
    }
}
