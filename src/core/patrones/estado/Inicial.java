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

public class Inicial extends Estado implements Serializable {

    public Inicial(IJuego juego, ControladorPersistencia persistencia) {
        super(juego, persistencia);
        armar();
    }

    private void armar() {
        if(juego.getJugador() == null)
            juego.setJugador(new Jugador((AMediador) juego));

        if(juego.getLanzador() == null)
            juego.setLanzador(new Lanzador((AMediador) juego, Math.round(Math.random() * 1) == 0 ? new FabricaDeFichaDeColor() : new FabricaDeFichaDeLetra()));

        if(juego.getTablero() == null)
            juego.setTablero(new Tablero((AMediador) juego));
                
        Container jp = (JPanel) juego, jf = (JPanel) juego;
        jp.setLayout(null);
        while (!((jf = jf.getParent()) instanceof JFrame));
        ((JFrame) jf).setResizable(false);
        ((JFrame) jf).setBackground(Color.DARK_GRAY);
        ((JFrame) jf).setSize(TAM.width, TAM.height);
        ((JFrame) jf).setVisible(true);
        ((JFrame) jf).setFocusable(true);
        if (jp.getComponentCount() == 0) {
            final Button bJugar = new Button("Jugar");
            final Button bScore = new Button("Mejores scores");
            final Button bGuardar = new Button("Guardar");
            final Button bJuegos = new Button("Juegos guardados");
            jp.add(bJugar);
            jp.add(bScore);
            jp.add(bGuardar);
            jp.add(bJuegos);
        }    
        
            ((Button) jp.getComponents()[0]).setLabel("Jugar");
            ((Button) jp.getComponents()[0]).setFocusable(false);
            ((Button) jp.getComponents()[0]).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ((Button) jp.getComponents()[0]).setLabel(((Button) jp.getComponents()[0]).getLabel().equals("Jugar") ? "Pausar" : "Jugar");
                    new ComandoDeJugandoPausado((Estado) juego.getEstado()).ejecutar();
                }
            });
            ((Button) jp.getComponents()[0]).setBounds(240, 5, 70, 25);
            ((Button) jp.getComponents()[0]).setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((Button) jp.getComponents()[0]).setFont(new Font("Helvetica", Font.BOLD, 13));
            ((Button) jp.getComponents()[0]).setBackground(Color.lightGray);
            

            ((Button) jp.getComponents()[1]).setLabel("Mejores scores");
            ((Button) jp.getComponents()[1]).setFocusable(false);
            ((Button) jp.getComponents()[1]).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    persistencia.showScore();
                }
            });
            ((Button) jp.getComponents()[1]).setBounds(15, 5, 110, 25);
            ((Button) jp.getComponents()[1]).setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((Button) jp.getComponents()[1]).setFont(new Font("Helvetica", Font.BOLD, 13));
            ((Button) jp.getComponents()[1]).setBackground(Color.WHITE);
            

            ((Button) jp.getComponents()[2]).setLabel("Guardar");
            ((Button) jp.getComponents()[2]).setFocusable(false);
            ((Button) jp.getComponents()[2]).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    persistencia.saveGame((Juego) juego);
                }
            });
            ((Button) jp.getComponents()[2]).setBounds(130, 5, 70, 25);
            ((Button) jp.getComponents()[2]).setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((Button) jp.getComponents()[2]).setFont(new Font("Helvetica", Font.BOLD, 13));
            ((Button) jp.getComponents()[2]).setBackground(Color.WHITE);
            

            ((Button) jp.getComponents()[3]).setLabel("Juegos guardados");
            ((Button) jp.getComponents()[3]).setFocusable(false);
            ((Button) jp.getComponents()[3]).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JFrame j = new JFrame();
                    Juego juegoaux = persistencia.showSavedGames();
                    j.getContentPane().add(juegoaux);
                    juego=juegoaux;
                    ControladorPersistencia persistencia = new ControladorPersistencia();
                    juego.setEstado(new Inicial(juego,persistencia));
                    new ComandoDeJugandoPausado((Estado) juego.getEstado()).ejecutar();
                }
            });
            ((Button) jp.getComponents()[3]).setBounds(350, 5, 150, 25);
            ((Button) jp.getComponents()[3]).setCursor(new Cursor(Cursor.HAND_CURSOR));
            ((Button) jp.getComponents()[3]).setFont(new Font("Helvetica", Font.BOLD, 13));
            ((Button) jp.getComponents()[3]).setBackground(Color.WHITE);
        
    }

    @Override
    public void manejar() {
        juego.setEstado(new Jugando(juego, persistencia));
    }
}
