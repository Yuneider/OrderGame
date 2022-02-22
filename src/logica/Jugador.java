package logica;

import static core.api.IJuego.ALTO;
import static core.api.IJuego.ANCHO;
import static core.api.IJuego.ANCHO_JUEGO;
import static core.api.IJuego.CAPACIDAD_DEL_JUGADOR;
import static core.api.IJuego.N_COLUMNAS;
import static core.api.IJuego.ORIGEN;
import static core.api.IJuego.Y_JUGADOR;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.api.IDetenedor;
import core.api.IDibujable;
import core.api.IFicha;
import core.api.IJuego;
import core.api.IJugador;
import core.patrones.componente.IComponente;
import core.patrones.mediador.AColega;
import core.patrones.mediador.AMediador;

public class Jugador extends AColega implements IJugador, IDibujable, IDetenedor, IComponente {

    Stack<IFicha> fichas = new Stack<IFicha>();
    KeyAdapter enJuego;
    private String nombre;

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(AMediador juego) {
        super(juego);
        posicion = new Point(ORIGEN.x + ((N_COLUMNAS / 2) * ANCHO), Y_JUGADOR);
        color = new Color(10, 100, 200);
    }

    private void mover() {
        for (IFicha f_i : fichas) {
            f_i.getPosicion().x = posicion.x;
        }
    }

    private void moverADerecha() {
        posicion.x = posicion.x < (ORIGEN.x + ANCHO_JUEGO - ANCHO) ? posicion.x + ANCHO : ORIGEN.x;
        mover();
        actualizar();
    }

    private void moverAIzquierda() {
        posicion.x = posicion.x >= (ORIGEN.x + ANCHO) ? posicion.x - ANCHO : ORIGEN.x + ANCHO_JUEGO - ANCHO;
        mover();
        actualizar();
    }

    @Override
    public void dibujar(Graphics pintor) {
        capturarFichas();
        pintor.setColor(color);
        pintor.fillRect(posicion.x, posicion.y, ANCHO, ALTO);
        pintor.drawOval(posicion.x - 10, posicion.y, 5, 5);
        for (IFicha f_i : fichas) {
            f_i.dibujar(pintor);
        }
    }

    @Override
    public void capturarFichas() {
        List<IFicha> fichasLanzadas = ((IJuego) juego).getLanzador().getFichas();
        List<IFicha> fichasRemovidad = new ArrayList<IFicha>();
        synchronized (fichasLanzadas) {
            for (IFicha f_i : fichasLanzadas) {
                Point pos = f_i.getPosicion();
                int tam = ALTO * fichas.size();
                if (pos.x == posicion.x && (posicion.y - tam <= pos.y + ALTO && pos.y + tam <= posicion.y)) {
                    if (fichas.size() < CAPACIDAD_DEL_JUGADOR) {
                        f_i.moverse(new Point(posicion.x, posicion.y - (fichas.size() + 1) * ALTO));
                        synchronized (fichas) {
                            adicionar(f_i);
                        }
                        fichasRemovidad.add(f_i);
                    }
                }
            }
        }
        fichasLanzadas.removeAll(fichasRemovidad);
    }

    @Override
    public void ordenarFichas() {
        if (fichas.size() > 0) {
            IFicha ficha = (IFicha) remover();
            ((IJuego) juego).getTablero().recibirFicha(ficha);
        }
    }

    @Override
    public void iniciar() {
        Container jf = (JPanel) juego;
        while (!((jf = jf.getParent()) instanceof JFrame));
        jf.addKeyListener(enJuego = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'j':
                        moverAIzquierda();
                        break;
                    case 'l':
                        moverADerecha();
                        break;
                    case 'k':
                        ordenarFichas();
                        break;
                }
            }
        });
    }

    @Override
    public void detener() {
        Container jf = (JPanel) juego;
        while (!((jf = jf.getParent()) instanceof JFrame));
        jf.removeKeyListener(enJuego);
    }

    @Override
    public IComponente remover() {
        return fichas.pop();
    }

    @Override
    public void adicionar(IComponente componente) {
        fichas.push((IFicha) componente);
    }

    @Override
    public IComponente getHoja() {
        return fichas.peek();
    }
}
