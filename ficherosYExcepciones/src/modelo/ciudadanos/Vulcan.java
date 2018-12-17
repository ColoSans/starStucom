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
    /**
     * Constructor
     * @param meditacion valor propio del ser el valor tiene que ser del 0 al 10
     * @param nombre valor nombre heredado de la clase madre
     * @throws MyException 
     */
    public Vulcan(int meditacion, String nombre) throws MyException {
        super(nombre);
        if(meditacion>10 || meditacion < 0){
            throw new MyException("< ERROR 011: Nivel de meditación incorrecto >");
        }else{
            this.meditacion = meditacion;
        }
        
    }
/**
 * devuelve la meditación del ser
 * @return 
 */
    public int getMeditacion() {
        return meditacion;
    }
/**
 * modifica el valor meditacion
 * @param meditacion valor propio del ser el valor tiene que ser del 0 al 10
 * @throws MyException 
 */
    public void setMeditacion(int meditacion) throws MyException {
         if(meditacion>10 || meditacion < 0){
            throw new MyException("< ERROR 011: Nivel de meditación incorrecto >");
        }else{
            this.meditacion = meditacion;
        }
    }
    
    /**
     * Devuelve el string indicado
     * @return 
     */
       @Override
    public String toString() {
        return "vulcan-"+ super.toString()+"-"+meditacion; 
    }
}
