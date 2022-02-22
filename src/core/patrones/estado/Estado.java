package core.patrones.estado;
import core.api.IJuego;
import logica.controladores.ControladorPersistencia;
public abstract class Estado {
	protected IJuego juego;
        protected ControladorPersistencia persistencia;
	public Estado(IJuego juego,ControladorPersistencia persistencia) {		
		this.juego = juego;
                this.persistencia = persistencia;
	}
	public abstract void manejar();
}
