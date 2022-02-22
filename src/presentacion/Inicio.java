/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author User
 */
public class Inicio extends JFrame{
    
    private JPanel fondo;
    private JLabel menu;
    private JButton jugar, salir, score;
    private ImageIcon ifondo;
    
    public Inicio(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setSize(562,551);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ifondo = new ImageIcon("images/menu.png");
        
        fondo = new JPanel();
        fondo.setLayout(null);
        this.add(fondo);
        
        menu = new JLabel("dfsraga");
        menu.setLayout(null);
        menu.setSize(550,520);
        menu.setIcon(new ImageIcon(ifondo.getImage().getScaledInstance(550, 520, Image.SCALE_AREA_AVERAGING)));
        fondo.add(menu);
                
        jugar = new JButton("Jugar");
        jugar.setBounds(232, 230, 85, 42);
        jugar.setFocusable(false);
        jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugar.setBorder(new EmptyBorder(10,10,10,10)); 
        menu.add(jugar);
        
        score = new JButton("Score");
        score.setBounds(232, 300, 85, 42);
        score.setFocusable(false);
        score.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menu.add(score);
        
        salir = new JButton("Salir");
        salir.setBounds(232, 370, 85, 42);
        salir.setFocusable(false);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        menu.add(salir);
        
        this.setVisible(true);
        
    }
    
//    public static void main (String [] args ) {
//	Inicio show = new Inicio();
//    }
}


