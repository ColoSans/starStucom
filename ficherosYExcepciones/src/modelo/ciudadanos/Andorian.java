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

    public String getAenar() {
        return aenar;
    }

    public void setAenar(String aenar) throws MyException{
        if(aenar.equalsIgnoreCase("aenar")){
            this.aenar = aenar;
        }else if(aenar.equalsIgnoreCase("noaenar")){
            this.aenar = aenar;
        }else{
            throw new MyException("< ERROR 004: Dato incorrecto >");
        }
    }
    
}
