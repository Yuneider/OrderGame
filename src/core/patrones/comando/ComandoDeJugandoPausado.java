package core.patrones.comando;
import core.patrones.estado.Estado;

public class ComandoDeJugandoPausado implements IComando{
	Estado estado;
	public ComandoDeJugandoPausado(Estado estado){		
		this.estado = estado;
	}
	@Override
	public void ejecutar() {
		estado.manejar();
	}
}
