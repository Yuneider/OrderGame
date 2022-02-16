package logica.fichas;

import static core.api.IJuego.PASO;
import java.awt.Point;
import core.api.IFicha;

public abstract class Ficha implements IFicha {
	protected Point posicion;	
	public Ficha(Point posicion) {		
		this.posicion = posicion;
	}
	public void moverse(Point posicion) {		
		if(posicion!=null) {
		   this.posicion =posicion;
		}else {
		   this.posicion.y+=PASO;
		}
	}
	public Point getPosicion() {
		return posicion;
	}
}
