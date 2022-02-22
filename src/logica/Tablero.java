package logica;

import static core.api.IJuego.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
import core.api.*;
import core.patrones.mediador.*;

public class Tablero extends AColega implements ITablero, IDibujable {

    public final static int PUNTAJE_X_COLUMNA = 10;
    Stack<IFicha> pilas[];
    int puntaje;

    public Tablero(AMediador juego) {
        super(juego);
        posicion = new Point(ORIGEN.x, Y_TALERO);
        this.pilas = new Stack[N_COLUMNAS];
        iniciar();
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    @Override
    public void recibirFicha(IFicha f_i) {
        int columna = f_i.getPosicion().x / ANCHO;
        if (pilas[columna].size() < N_FILAS) {
            pilas[columna].push(f_i);
            verificarColumnas();
        }
    }

    @Override
    public void recogerFichas() {
        List<IFicha> fichas = ((IJuego) juego).getLanzador().getFichas();
        List<IFicha> removidas = new ArrayList<IFicha>();
        for (IFicha f_i : fichas) {
            if (f_i.getPosicion().y > posicion.y - ALTO) {
                removidas.add(f_i);
                recibirFicha(f_i);
            }
        }
        fichas.removeAll(removidas);
    }

    @Override
    public void verificarTrios() {
        verificarColumnas();
    }

    private void verificarColumnas() {
        List<IFicha> removidas = new ArrayList<IFicha>();
        for (Stack<IFicha> p_i : pilas) {
            for (int i = 0; i < p_i.size(); i++) {
                if (p_i.size() - i >= 3) {
                    if (p_i.get(i).esIgual(p_i.get(i + 1)) && p_i.get(i + 1).esIgual(p_i.get(i + 2))) {
                        removidas.add(p_i.get(i));
                        removidas.add(p_i.get(i + 1));
                        removidas.add(p_i.get(i + 2));
                        break;
                    }
                }
            }
            if (!removidas.isEmpty()) {
                p_i.removeAll(removidas);
                removidas = new ArrayList<IFicha>();
                puntaje += PUNTAJE_X_COLUMNA;
                actualizar();
            }
        }
    }

    @Override
    public boolean reportarGameOver() {
        for (Stack p_i : pilas) {
            if (p_i.size() == N_FILAS) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void reportarScore() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "Score: " + puntaje);
                iniciar();
            }
        });
    }

    @Override
    public void dibujar(Graphics pintor) {
        recogerFichas();
        for (Stack p_i : pilas) {
            for (int i = 0; i < p_i.size(); i++) {
                IFicha f_i = (IFicha) p_i.get(i);
                f_i.getPosicion().y = posicion.y + (N_FILAS - i) * ALTO;
                f_i.dibujar(pintor);
            }
        }
    }

    @Override
    public void iniciar() {
        puntaje = 0;
        for (int i = 0; i < N_COLUMNAS; i++) {
            pilas[i] = new Stack<IFicha>();
        }
    }
    
}
