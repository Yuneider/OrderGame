/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import javax.swing.JList;
import javax.swing.JOptionPane;
import logica.Score;
import persistencia.Persistencia;

/**
 *
 * @author yunei
 */
public class ControladorScore {
    
    private final String fileName="data.bin";
    private Score score;
    private Persistencia persistence;
    
    public ControladorScore(){
        persistence=new Persistencia(fileName);
        persistence.setObject(new Score(10));
        score=(Score)persistence.getObject();
    }
    
    public void insert(int score){
        this.score.insertScore(score);
        persistence.setObject(this.score);
        persistence.writteObject();
    }
    
    public void showScore(){
        persistence.getObject();
        JOptionPane.showMessageDialog(null, new JList(score.getString()));
    }
    
}
