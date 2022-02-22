/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import java.awt.event.*;
import logica.controladores.ControladorPersistencia;
import core.patrones.estado.Inicial;

/**
 *
 * @author User
 */
public class Inicio extends JFrame{
    
    private JPanel fondo;
    private JLabel menu, lNombre;
    private JButton jugar, salir, score;
    private ImageIcon ifondo;
    private JTextField tNombre;
    
    
    public Inicio(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setSize(562,551);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ifondo = new ImageIcon("images/menu.png");
        
        fondo = new JPanel();
        fondo.setLayout(null);
        this.add(fondo);
        
        menu = new JLabel();
        menu.setLayout(null);
        menu.setSize(550,520);
        menu.setIcon(new ImageIcon(ifondo.getImage().getScaledInstance(550, 520, Image.SCALE_AREA_AVERAGING)));
        fondo.add(menu);
        
        tNombre = new JTextField("Ingrese Nombre");
        tNombre.setBounds(196, 220, 150, 32);
        menu.add(tNombre);
                
        jugar = new JButton("Jugar");
        jugar.setBounds(229, 300, 88, 42);
        jugar.setFocusable(false);
        jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));
        jugar.setBackground(Color.BLUE);
        jugar.setForeground(Color.WHITE);
        jugar.addActionListener(new ActionListener() {				
        public void actionPerformed(ActionEvent e) {
            JFrame jf = new JFrame();
            Juego juego = new Juego();
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ControladorPersistencia persistencia = new ControladorPersistencia();            
            juego.setNombre(tNombre.getText());
            jf.getContentPane().add(juego);
            juego.setEstado(new Inicial(juego,persistencia));
            Ventana(false);
	}});
        menu.add(jugar);
        
        salir = new JButton("Salir");
        salir.setBounds(229, 370, 88, 42);
        salir.setFocusable(false);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.MAGENTA));
        salir.setBackground(Color.BLUE);
        salir.setForeground(Color.WHITE);
        salir.addActionListener(new ActionListener() {				
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
	}});
        menu.add(salir);
        
        this.setVisible(true);
        
    }
    
    public void Ventana(boolean V){
        this.setVisible(V);
    }
    
    public static void main(String[] args) {
        Inicio show = new Inicio();
        
    }
}


