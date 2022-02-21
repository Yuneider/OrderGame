/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Inicio extends JFrame{
    
    private JPanel fondo;
    private JButton jugar, salir, score;
    private ImageIcon ifondo;
    
    public Inicio(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setSize(562,551);
        setResizable(false);
        setLocationRelativeTo(null);
        
        fondo = new JPanel();
        fondo.setLayout(null);
        fondo.setBackground(Color.red);
        this.add(fondo);
                
        jugar = new JButton("Jugar");
        jugar.setBounds(232, 230, 85, 42);
        jugar.setFocusable(false);
        fondo.add(jugar);
        
        score = new JButton("Score");
        score.setBounds(232, 300, 85, 42);
        score.setFocusable(false);
        fondo.add(score);
        
        salir = new JButton("Salir");
        salir.setBounds(232, 370, 85, 42);
        salir.setFocusable(false);
        fondo.add(salir);
        
        this.setVisible(true);
        
    }
    
   
}


