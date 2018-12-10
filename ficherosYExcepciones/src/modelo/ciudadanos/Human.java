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

    public Human(int edad, String nombre) throws MyException {
        
        super(nombre);
        if(edad<0 || edad>130){
            throw new MyException("< ERROR 010: Edad incorrecta >");
        }else{
            this.edad = edad;
        }
        
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws MyException {
        if(edad<0 || edad>130){
            throw new MyException("< ERROR 010: Edad incorrecta >");
        }else{
            this.edad = edad;
        }
    }
    public String toString() {
        return "human-"+ super.toString()+"-"+edad; 
    }
}
