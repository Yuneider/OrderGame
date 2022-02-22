/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import presentacion.Juego;

/**
 *
 * @author yunei
 */
public class Consola implements Serializable{
    
    private ArrayList<Juego> games;
    
    public Consola(){
        games=new ArrayList();
    }
    
    public void insertGame(Juego game){
        games.add(game);
    }
    
}
