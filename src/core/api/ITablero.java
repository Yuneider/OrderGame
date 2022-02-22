package core.api;

import java.io.Serializable;

public interface ITablero extends IDibujable ,IIniciador, Serializable{
	void recogerFichas();
	void recibirFicha(IFicha ficha);
	void verificarTrios();	
	boolean reportarGameOver();
	void reportarScore();
        int getPuntaje();
}
