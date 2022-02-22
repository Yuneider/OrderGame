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
            result[i] = "Score: " + games.get(i).getTablero().getPuntaje();
        }
        return result;
    }

    public void showGames() {
        JOptionPane.showMessageDialog(null, new JList(getString()), "Games", 1);
    }

}
