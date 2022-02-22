/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import core.persistencia.Persistencia;
import logica.Consola;
import logica.Score;
import presentacion.Juego;

/**
 *
 * @author yunei
 */
public class ControladorPersistencia {
    
    private final String consoleFile="consolData.txt";
    private final String scoreFile="scoreData.txt";
    private Consola console;
    private Score score;
    private Persistencia persistence;
    
    public ControladorPersistencia(){
        persistence=new Persistencia(consoleFile);
        persistence.setObject(new Consola());
        if(!persistence.getObject().equals(null))
            console=(Consola)persistence.getObject();
        
        persistence=new Persistencia(scoreFile);
        persistence.setObject(new Score(10));
        if(!persistence.getObject().equals(null))
            score=(Score)persistence.getObject();

    }
    
    public void insertGame(Juego game){
        console.insertGame(game);
        persistence.setFileName(consoleFile);
        persistence.setObject(console);
        persistence.writteObject();
    }
    
    public void insertScore(int score){
        this.score.insertScore(score);
        persistence.setFileName(scoreFile);
        persistence.setObject(this.score);
        persistence.writteObject();
    }
    
    public void showScore(){
        persistence.setObject(this.score);
        score=(Score)persistence.getObject();
        score.showScore();
    }
    
    public void showSavedGames(){
        persistence.setObject(this.console);
        console=(Consola)persistence.getObject();
        console.showGames();
    }
    
}
