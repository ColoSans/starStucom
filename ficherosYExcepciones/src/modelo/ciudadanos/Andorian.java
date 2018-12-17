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
public class Andorian extends Ciudadano  {
    private String aenar;
/**
 * Constructor
 * @param aenar valor propio de la especie solo puede ser "aenar" o "noaenar"
 * @param nombre nombre del ser heredado de la clase madre
 * @throws MyException 
 */
    public Andorian (String aenar, String nombre)throws MyException {
        
        super(nombre);
        if(aenar.equalsIgnoreCase("aenar")){
            this.aenar = aenar;
        }else if(aenar.equalsIgnoreCase("noaenar")){
            this.aenar = aenar;
        }else{
            throw new MyException("< ERROR 004: Dato incorrecto >");
        }
        
    }
/**
 * Devuelve el valor aenar
 * @return 
 */
    public String getAenar() {
        return aenar;
    }
/**
 * Sirve para modifiacar el valor aenar, solo puede ser "aenar" o "noaenar"
 * @param aenar valor aenar
 * @throws MyException 
 */
    public void setAenar(String aenar) throws MyException{
        if(aenar.equalsIgnoreCase("aenar")){
            this.aenar = aenar;
        }else if(aenar.equalsIgnoreCase("noaenar")){
            this.aenar = aenar;
        }else{
            throw new MyException("< ERROR 004: Dato incorrecto >");
        }
    }
    /**
     * Devuelve el string indicado
     * @return 
     */
    public String toString() {
        return "andorian-"+ super.toString()+"-"+aenar; 
    }
}
