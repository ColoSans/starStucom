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
public class Human extends Ciudadano{
    private int edad;
/**
 * Constructor
 * @param edad valor propio del ser el valor solo puede ser entre 0 y 130
 * @param nombre nombre del ser heredado de la clase madre
 * @throws MyException 
 */
    public Human(int edad, String nombre) throws MyException {
        
        super(nombre);
        if(edad<0 || edad>130){
            throw new MyException("< ERROR 010: Edad incorrecta >");
        }else{
            this.edad = edad;
        }
        
    }
/**
 * devuelve la edad del ser
 * @return 
 */
    public int getEdad() {
        return edad;
    }
/**
 * Modifica el valor edad. el valor solo puede ser entre 0 y 130
 * @param edad el valor solo puede ser entre 0 y 130
 * @throws MyException 
 */
    public void setEdad(int edad) throws MyException {
        if(edad<0 || edad>130){
            throw new MyException("< ERROR 010: Edad incorrecta >");
        }else{
            this.edad = edad;
        }
    }
    /**
     * Devuelve el string indicado
     * @return 
     */
    public String toString() {
        return "human-"+ super.toString()+"-"+edad; 
    }
}
