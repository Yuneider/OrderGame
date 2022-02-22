/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import core.persistencia.Persistencia;
import logica.Consola;
import presentacion.Juego;

/**
 *
 * @author yunei
 */
public class ControladorPersistencia {
    
    private final String fileName="data.bin";
    private Consola console;
    private Persistencia persistence;
    
    public ControladorPersistencia(){
        persistence=new Persistencia(fileName);
        persistence.setObject(new Consola());
        console=(Consola)persistence.getObject();
    }
    
    public void insert(Juego game){
        console.insertGame(game);
        persistence.setObject(console);
        persistence.writteObject();
    }
    
    public void showScore(){
        persistence.getObject();
    }
    
    public void showSavedGames(){
        persistence.getObject();
    }
    
}
