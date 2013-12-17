/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author inf109793
 */
public class Game{
    
    public void listujPliki(){
        File dir = new File(".");
        for (File child : dir.listFiles()){
            String nazwa = child.getName();
            if (nazwa.endsWith(".bbb")){
                nazwa.replace(".bbb", "");
                System.out.println(child.getName());
            }            
        }
    }
    
   public void zapisz(State stan){
       ObjectOutputStream oos;
       try {
           oos = new ObjectOutputStream(new FileOutputStream(stan.nick + ".bbb"));
           oos.writeObject(stan);
       } catch (IOException ex) {
           Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
       }              
   }
   
   public State wczytaj(String nick) throws ClassNotFoundException{
       ObjectInputStream ois;
       try {
           ois = new ObjectInputStream(new FileInputStream(nick + ".bbb"));
           return (State) ois.readObject();
       } catch (IOException ex) {
           Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
}
