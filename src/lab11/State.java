/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import java.io.Serializable;

/**
 *
 * @author inf109793
 */
public class State implements Serializable {
    String nick;
    int wynik;  
    
    public State(String nick){
        this.nick = nick;
    }
    
    public void voidDodajWynik(int nowyWynik){
        if(nowyWynik > this.wynik)
            this.wynik = nowyWynik;        
    }
}
