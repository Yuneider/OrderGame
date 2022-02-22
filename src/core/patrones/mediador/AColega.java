package core.patrones.mediador;

import java.awt.*;
import java.io.Serializable;

public abstract class AColega implements Serializable{
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
