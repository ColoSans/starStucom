/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ciudadanos;

import exceptions.MyException;

/**
 *
 * @author marcc
 */
public class Klingon extends Ciudadano {
    private int fuerza;
/**
 * Constructor
 * @param fuerza valor propio del ser el valor solo puede ser entre 50 y 350
 * @param nombre nombre del ser heredado de la clase madre
 * @throws MyException 
 */
    public Klingon(int fuerza, String nombre) throws MyException {
        
        super(nombre);
        if(fuerza>50 || fuerza<350){
            this.fuerza = fuerza;
        }else{
            throw new MyException("< ERROR 012: Valor de fuerza incorrecto >");
        }
        
    }
/**
 * Devuelve la fuerza del ser
 * @return 
 */
    public int getFuerza() {
        return fuerza;
    }
/**
 * modifica la fuerza del ser
 * @param fuerza el valor solo puede ser entre 50 y 350
 * @throws MyException 
 */
    public void setFuerza(int fuerza) throws MyException {
        if(fuerza>50 || fuerza<350){
            this.fuerza = fuerza;
        }else{
            throw new MyException("< ERROR 012: Valor de fuerza incorrecto >");
        }
    }
    /**
     * Devuelve el string indicado
     * @return 
     */
    public String toString() {
        return "klingon-"+ super.toString()+"-"+fuerza; 
    }
}
