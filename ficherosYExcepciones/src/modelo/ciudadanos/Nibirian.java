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
public class Nibirian extends Ciudadano {
    
    private boolean alimento;
    /**
     * Constructor
     * @param alimento alimento puede ser true o false
     * @param nombre  nombre que viene de la clase padre
     */
    public Nibirian(String alimento, String nombre) throws MyException {
        super(nombre);
         if(alimento.equalsIgnoreCase("vegetarian")){
             this.alimento = false;
         }else if(alimento.equalsIgnoreCase("novegetarian")){
             this.alimento = true;
         }else{
             throw new MyException("< ERROR 004: Dato incorrecto >");
         }
        
    }
/**
 * devuelve el valor de alimento
 * @return 
 */
    public boolean isAlimento() {
        return alimento;
    }
/**
 * modifica el valor de alimento
 * @param alimento 
 */
    public void setAlimento(String alimento) throws MyException {
        if(alimento.equalsIgnoreCase("vegetarian")){
             this.alimento = false;
         }else if(alimento.equalsIgnoreCase("novegetarian")){
             this.alimento = true;
         }else{
            throw new MyException("< ERROR 004: Dato incorrecto >");
         }
    }
    
}
