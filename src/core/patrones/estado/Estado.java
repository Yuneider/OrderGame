package core.patrones.estado;
import core.api.IJuego;
public abstract class Estado {
	protected IJuego juego;	
	public Estado(IJuego juego) {		
		this.juego = juego;
	}
	public abstract void manejar();
}
