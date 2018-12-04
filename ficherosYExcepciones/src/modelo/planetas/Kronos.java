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

    public Kronos(int nHabitantes, String nombre) {
        super(nombre);
        this.nHabitantes = 30;
    }

    public int getnHabitantes() {
        return nHabitantes;
    }

    public void setnHabitantes(int nHabitantes) {
        this.nHabitantes = nHabitantes;
    }
    public void comprobarCiudadano(Ciudadano c) throws MyException {
        if(getHabitantes().size()==nHabitantes){
             throw new MyException("< ERROR 005: No se puede registrar ese ser en ese planeta >");
        }
    }
}
