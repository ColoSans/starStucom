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
public class Vulcan extends Ciudadano{
    private int meditacion;
    public Vulcan(int meditacion, String nombre) throws MyException {
        super(nombre);
        if(meditacion>10 || meditacion < 0){
            throw new MyException("< ERROR 011: Nivel de meditación incorrecto >");
        }else{
            this.meditacion = meditacion;
        }
        
    }

    public int getMeditacion() {
        return meditacion;
    }

    public void setMeditacion(int meditacion) throws MyException {
         if(meditacion>10 || meditacion < 0){
            throw new MyException("< ERROR 011: Nivel de meditación incorrecto >");
        }else{
            this.meditacion = meditacion;
        }
    }
    
       @Override
    public String toString() {
        return "vulcan-"+ super.toString()+"-"+meditacion; 
    }
}
