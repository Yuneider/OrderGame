package core.patrones.estado;

import core.api.IJuego;
import java.io.Serializable;
import logica.controladores.ControladorPersistencia;

public class Pausado extends Estado implements Serializable{
	public Pausado(IJuego juego,ControladorPersistencia persistencia) {
		super(juego,persistencia);
		juego.getLanzador().detener();
		juego.getJugador().detener();
	}
	@Override
	public void manejar() {	
		if(juego.gameOver()) {
		   new Final(juego,persistencia).manejar();
		}else {
		   juego.setEstado(new Jugando(juego,persistencia));
		}
	}
}
