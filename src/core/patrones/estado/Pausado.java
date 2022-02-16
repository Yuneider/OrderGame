package core.patrones.estado;

import core.api.IJuego;

public class Pausado extends Estado {
	public Pausado(IJuego juego) {
		super(juego);
		juego.getLanzador().detener();
		juego.getJugador().detener();
	}
	@Override
	public void manejar() {	
		if(juego.gameOver()) {
		   new Final(juego).manejar();
		}else {
		   juego.setEstado(new Jugando(juego));
		}
	}
}
