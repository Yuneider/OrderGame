/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import core.persistencia.Persistencia;
import javax.swing.JOptionPane;
import logica.Consola;
import logica.Score;
import presentacion.Juego;

/**
 *
 * @author yunei
 */
public class ControladorPersistencia {

    private final String consoleFile = "consoleData.json";
    private final String scoreFile = "scoreData.txt";
    private Consola console;
    private Score score;
    private Persistencia persistence;

    public ControladorPersistencia() {
        persistence = new Persistencia(consoleFile);
        persistence.setObject(new Consola());
        console = (Consola) persistence.getObject();

        persistence = new Persistencia(scoreFile);
        persistence.setObject(new Score(10));
        score = (Score) persistence.getObject();

    }
    
    public void saveGame(Juego game) {
        console.insertGame(game);
        persistence.setFileName(consoleFile);
        persistence.setObject(console);
        persistence.writteObject();
        JOptionPane.showMessageDialog(null, "Saved");
    }

    public void insertScore(int score) {
        this.score.insertScore(score);
        persistence.setFileName(scoreFile);
        persistence.setObject(this.score);
        persistence.writteObject();
        JOptionPane.showMessageDialog(null, "Inserted");
    }

    public void showScore() {
        persistence.setFileName(scoreFile);
        persistence.setObject(this.score);
        score = (Score) persistence.getObject();
        score.showScore();
    }

    public Juego showSavedGames() {
        persistence.setFileName(consoleFile);
        persistence.setObject(this.console);
        console = (Consola) persistence.getObject();
        return console.getGame(console.showGames());
    }

}
