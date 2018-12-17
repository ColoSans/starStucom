/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.planetas;
import exceptions.MyException;
import java.util.ArrayList;
import modelo.ciudadanos.Ciudadano;

/**
 *
 * @author marcc
 */
public class Vulcano extends Planeta{
    private ArrayList<String> noBienvenido = new ArrayList<>();
    /**
     * Constructor
     * @param nombre nombre del planeta
     */
    public Vulcano(String nombre) {
        super(nombre);
        this.noBienvenido.add("Klingon");
        this.noBienvenido.add("Andorian");
    }
/**
 * Devuelve los seres que no se pueden registrar al planeta
 * @return 
 */
    public ArrayList<String> getNoBienvenido() {
        return noBienvenido;
    }
/**
 * modifica el arraylist de los seres que no pueden habitar en el planeta(no lo utilizo pero lo tengo creado por si acaso)
 * @param noBienvenido 
 */
    public void setNoBienvenido(ArrayList<String> noBienvenido) {
        this.noBienvenido = noBienvenido;
    }
    /**
     * metodo que comprueba que un ciudadano pueda registrarse al planeta
     * @param c objeto ciudadano
     * @throws MyException 
     */
    @Override
    public void comprobarCiudadano(Ciudadano c) throws MyException {
        if(c.getClass().getSimpleName().equalsIgnoreCase("Klingon") || c.getClass().getSimpleName().equalsIgnoreCase("Andorian")){
             throw new MyException("< ERROR 005: No se puede registrar ese ser en ese planeta >");
        }
        
    }
    
    
}
