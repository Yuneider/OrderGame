package core.patrones.estado;

import core.api.IJuego;

public class Final extends Estado {
	public Final(IJuego juego) {
		super(juego);
		juego.reportar();		
	}
	@Override
	public void manejar() {		
		juego.setEstado(new Inicial(juego));			
	}
}
