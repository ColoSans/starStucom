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
    private boolean aenar;

    public Andorian (String aenar, String nombre)throws MyException {
        
        super(nombre);
        if(aenar.equalsIgnoreCase("aenar")){
            this.aenar = true;
        }else if(aenar.equalsIgnoreCase("noaenar")){
            this.aenar = false;
        }else{
            throw new MyException("< ERROR 004: Dato incorrecto >");
        }
        
    }

    public boolean isAenar() {
        return aenar;
    }

    public void setAenar(String aenar) throws MyException{
        if(aenar.equalsIgnoreCase("aenar")){
            this.aenar = true;
        }else if(aenar.equalsIgnoreCase("noaenar")){
            this.aenar = false;
        }else{
            throw new MyException("< ERROR 004: Dato incorrecto >");
        }
    }
    
}
