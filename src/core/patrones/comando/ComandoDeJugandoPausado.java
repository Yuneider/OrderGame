package core.patrones.comando;
import core.patrones.estado.Estado;
import java.io.Serializable;

public class ComandoDeJugandoPausado implements IComando,Serializable{
	Estado estado;
	public ComandoDeJugandoPausado(Estado estado){		
		this.estado = estado;
	}
	@Override
	public void ejecutar() {
		estado.manejar();
	}
}
