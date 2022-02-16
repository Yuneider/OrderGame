package core.patrones.mediador;

import java.awt.*;

public abstract class AColega {
	protected Point posicion;
	protected Color color;	
	protected AMediador juego;
	public AColega(AMediador juego) {		
		this.juego = juego;
	}
	public void actualizar() {
		juego.actualizar();
	}
}
