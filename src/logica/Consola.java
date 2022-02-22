/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import presentacion.Juego;

/**
 *
 * @author yunei
 */
public class Consola implements Serializable {

    private ArrayList<Juego> games;

    public Consola() {
        games = new ArrayList();
    }

    public void insertGame(Juego game) {
        games.add(game);
    }

    private String[] getString() {
        String[] result = new String[games.size()];
        for (int i = 0; i < games.size(); i++) {
            result[i] = "Nombre: "+games.get(i).getNombre()+" Score: " + games.get(i).getTablero().getPuntaje();
        }
        return result;
    }

    public String showGames() {
        return (String) JOptionPane.showInputDialog(null,"Selecciona un juego","Elegir",JOptionPane.QUESTION_MESSAGE,null,getString(),getString()[0]);
    }

    public Juego getGame(String info){
        String[] arr = info.split(" ");
        return findGame(arr[1],Integer.parseInt(arr[arr.length-1]));
    }
    
    private Juego findGame(String name,int score){
        for(Juego i:games){
            if(i.getNombre().equals(name) && i.getTablero().getPuntaje()==score)
                return i;
        }
        return null;
    }
    
}
