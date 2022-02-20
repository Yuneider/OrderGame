/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author yunei
 */
public class Score implements Serializable{
    
    private int[] score;
    
    public Score(int size){
        score = new int[size];
        for(int i=0;i<size;i++){
            score[i]=0;
        }
    }
    
    public void insertScore(int score){
        for(int i=0;i<this.score.length;i++){
            if(score > this.score[i]){
                if(i==9)
                    this.score[i]=i;
                else{
                    int aux = this.score[i];
                    this.score[i] = score;
                    for(int j=i+1;j<this.score.length;j++){
                        int x = this.score[j];
                        this.score[j] = aux;
                        aux = x;
                    }
                    score=0;
                }    
            }
        }
    }
    
    public String[] getString(){
        String[] arr = new String[score.length];
        for(int i=0;i<score.length;i++){
            arr[i]=String.valueOf(score[i]);
        }
        return arr;
    }
    
    public void showSocore(){
        JOptionPane.showMessageDialog(null, new JList(getString()));
    }
    
}
