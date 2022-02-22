package presentacion;

import java.awt.Graphics;

import core.api.IJuego;
import core.api.IJugador;
import core.api.ILanzador;
import core.api.ITablero;
import core.patrones.estado.Estado;
import core.patrones.mediador.AMediador;

public class Juego extends AMediador implements IJuego{

    private static final long serialVersionUID = 1L;
    public IJugador jugador;
    public ILanzador lanzador;
    public ITablero talero;
    Estado estado;
    
    @Override
    public ILanzador getLanzador() {
        return lanzador;
    }

    @Override
    public ITablero getTablero() {
        return talero;
    }

    @Override
    public IJugador getJugador() {
        return jugador;
    }

    @Override
    public void setLanzador(ILanzador lanzador) {
        this.lanzador = lanzador;
    }

    @Override
    public void setJugador(IJugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void setTablero(ITablero talero) {
        this.talero = talero;
    }

    @Override
    public void setEstado(Object estado) {
        this.estado = (Estado) estado;
    }

    @Override
    public Object getEstado() {
        return estado;
    }

    @Override
    public void paint(Graphics pintor) {
        super.paint(pintor);
        talero.dibujar(pintor);
        lanzador.dibujar(pintor);
        jugador.dibujar(pintor);
    }

    @Override
    public boolean gameOver() {
        return talero != null ? talero.reportarGameOver() : false;
    }

    @Override
    public void reportar() {
        talero.reportarScore();
    }
  
}
