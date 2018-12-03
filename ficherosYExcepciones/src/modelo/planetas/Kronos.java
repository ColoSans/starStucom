/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planetas;

/**
 *
 * @author marcc
 */
public class Kronos extends Planeta{
    private int nHabitantes;

    public Kronos(int nHabitantes, String nombre) {
        super(nombre);
        this.nHabitantes = nHabitantes;
        nHabitantes++;
    }

    public int getnHabitantes() {
        return nHabitantes;
    }

    public void setnHabitantes(int nHabitantes) {
        this.nHabitantes = nHabitantes;
    }
}
