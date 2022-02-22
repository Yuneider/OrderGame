package core.patrones.estado;

import core.api.IJuego;
import java.io.Serializable;
import logica.controladores.ControladorPersistencia;

public class Final extends Estado implements Serializable{
	public Final(IJuego juego,ControladorPersistencia persistencia) {
		super(juego,persistencia);
		juego.reportar();		
	}
	@Override
	public void manejar() {
            persistencia.insertScore(juego.getTablero().getPuntaje());
            juego.setEstado(new Inicial(juego,persistencia));			
	}
}
