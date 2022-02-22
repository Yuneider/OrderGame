/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import core.patrones.estado.Inicial;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import logica.controladores.ControladorPersistencia;

/**
 *
 * @author yunei
 */
public class Main {
   
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        Juego juego = new Juego();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ControladorPersistencia persistencia = new ControladorPersistencia();
        juego.setNombre(JOptionPane.showInputDialog(null, "Ingrese su nombre"));
        jf.getContentPane().add(juego);
        juego.setEstado(new Inicial(juego,persistencia));
    }
    
}
