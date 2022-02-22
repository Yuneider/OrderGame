package core.patrones.estado;
import core.api.IJuego;
import java.io.Serializable;
import logica.controladores.ControladorPersistencia;
public abstract class Estado implements Serializable{
	protected IJuego juego;
        transient protected ControladorPersistencia persistencia;
        
	public Estado(IJuego juego,ControladorPersistencia persistencia) {		
		this.juego = juego;
                this.persistencia = persistencia;
	}
	public abstract void manejar();
}
