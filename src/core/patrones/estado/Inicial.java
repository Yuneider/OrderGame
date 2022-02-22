package core.patrones.estado;

import static core.api.IJuego.TAM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import core.api.IJuego;
import core.patrones.comando.ComandoDeJugandoPausado;
import core.patrones.fabrica.*;
import core.patrones.mediador.AMediador;
import java.io.Serializable;
import logica.*;
import logica.controladores.ControladorPersistencia;
import presentacion.Juego;

public class Inicial extends Estado implements Serializable{
	public Inicial(IJuego juego,ControladorPersistencia persistencia) {
		super(juego,persistencia);		
		armar();		
	}
	private void armar() {
		juego.setJugador(new Jugador((AMediador)juego));
		juego.setLanzador(new Lanzador((AMediador)juego,Math.round(Math. random()*1) == 0?new FabricaDeFichaDeColor():new FabricaDeFichaDeLetra()));
		juego.setTablero(new Tablero((AMediador)juego));
		Container jp = (JPanel)juego,jf= (JPanel)juego;
                
		while(!((jf=jf.getParent()) instanceof JFrame));
                ((JFrame)jf).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                //Center frame
                //((JFrame)jf).setLocationRelativeTo(null);
		((JFrame)jf).setResizable(false);		
		((JFrame)jf).setSize(TAM.width,TAM.height);				
		((JFrame)jf).setVisible(true);
		((JFrame)jf).setFocusable(true);
		if (jp.getComponentCount() == 0) {
                        final Button bScore = new Button("Ver score");
			bScore.setFocusable(false);
			bScore.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
                                    persistencia.showScore();
			}});
                        bScore.setBounds(35, 5, 70, 25);
                        bScore.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        bScore.setFont(new Font("Helvetica",Font.BOLD,13));
                        bScore.setBackground(Color.WHITE);
                        jp.add(bScore);
                        
                        final Button bJugar = new Button("Jugar");
			bJugar.setFocusable(false);
			bJugar.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				bJugar.setLabel(bJugar.getLabel(). equals("Jugar")?"Pausar":"Jugar");
				new ComandoDeJugandoPausado((Estado) juego.getEstado()).ejecutar();
			}});
                        bJugar.setBounds(110, 5, 55, 25);
                        bJugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        bJugar.setFont(new Font("Helvetica",Font.BOLD,13));
                        bJugar.setBackground(Color.WHITE);
                        jp.add(bJugar);
                        
                        final Button bGuardar = new Button("Guardar");
			bGuardar.setFocusable(false);
			bGuardar.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				persistencia.saveGame((Juego)juego);
			}});
                        bGuardar.setBounds(400, 5, 55, 25);
                        bGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        bGuardar.setFont(new Font("Helvetica",Font.BOLD,13));
                        bGuardar.setBackground(Color.WHITE);
                        jp.add(bGuardar);
                        
                        final Button bguardar = new Button("ver juegos");
			bguardar.setFocusable(false);
			bguardar.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				persistencia.showSavedGames();
			}});
                        bguardar.setBounds(450, 5, 55, 25);
                        bguardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        bguardar.setFont(new Font("Helvetica",Font.BOLD,13));
                        bguardar.setBackground(Color.WHITE);
                        jp.add(bguardar);
		} else {
			((Button)jp.getComponents()[1]). setLabel("Jugar");
			((Button)jp.getComponents()[1]). setFocusable(false);
		}
	}
	@Override
	public void manejar() {	
		juego.setEstado(new Jugando(juego,persistencia));
	}
}
