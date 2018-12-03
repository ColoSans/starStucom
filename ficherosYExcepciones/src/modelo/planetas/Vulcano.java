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
    
    public Vulcano(String nombre) {
        super(nombre);
        this.noBienvenido.add("Klingon");
        this.noBienvenido.add("Andorian");
    }

    public ArrayList<String> getNoBienvenido() {
        return noBienvenido;
    }

    public void setNoBienvenido(ArrayList<String> noBienvenido) {
        this.noBienvenido = noBienvenido;
    }
    
    public void comprobarCiudadano(Ciudadano c) throws MyException {
        if(c.getClass().getSimpleName().equalsIgnoreCase("Klingon") || c.getClass().getSimpleName().equalsIgnoreCase("Andorian")){
             throw new MyException("< ERROR 005: No se puede registrar ese ser en ese planeta >");
        }else{
            getHabitantes().add(c);
        }
        
    }
    
    
}
