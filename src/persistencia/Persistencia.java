/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuneider
 */
public class Persistencia {
    
    private ObjectOutputStream os;
    private ObjectInputStream is;
    private Object object;
    
    public Persistencia(String fileName){
        try {
            os = new ObjectOutputStream(new FileOutputStream(fileName));
            is = new ObjectInputStream(new FileInputStream(fileName));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setObject(Object object){
        this.object=object;
    }
    
    public Object getObject(){
        readObject();
        return object;
    }
    
    public void writteObject(){
        try {
            os.writeObject(this.object);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void readObject(){
        try {
            object = (Object) is.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
