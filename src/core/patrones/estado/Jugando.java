package core.patrones.estado;

import core.api.IJuego;

public class Jugando extends Estado {
	public Jugando(IJuego juego) {
		super(juego);
		juego.getLanzador().iniciar();	
		juego.getJugador().iniciar();
	}
	@Override
	public void manejar() {		
		if(juego.gameOver()) {
			new Final(juego).manejar();
		}else {
			juego.setEstado(new Pausado(juego));
		}		
	}
}
