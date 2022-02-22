package core.patrones.estado;

import core.api.IJuego;
import java.io.Serializable;
import logica.controladores.ControladorPersistencia;

public class Jugando extends Estado implements Serializable{
	public Jugando(IJuego juego,ControladorPersistencia persistencia) {
		super(juego,persistencia);
		juego.getLanzador().iniciar();	
		juego.getJugador().iniciar();
	}
	@Override
	public void manejar() {		
		if(juego.gameOver()) {
			new Final(juego,persistencia).manejar();
		}else {
			juego.setEstado(new Pausado(juego,persistencia));
		}		
	}
}
