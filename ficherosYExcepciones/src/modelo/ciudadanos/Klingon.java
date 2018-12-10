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

    public Klingon(int fuerza, String nombre) throws MyException {
        
        super(nombre);
        if(fuerza<50 || fuerza>350){
            this.fuerza = fuerza;
        }else{
            throw new MyException("< ERROR 012: Valor de fuerza incorrecto >");
        }
        
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) throws MyException {
        if(fuerza<50 || fuerza>350){
            this.fuerza = fuerza;
        }else{
            throw new MyException("< ERROR 012: Valor de fuerza incorrecto >");
        }
    }
    public String toString() {
        return "klingon-"+ super.toString()+"-"+fuerza; 
    }
}
