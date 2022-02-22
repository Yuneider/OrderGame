package core.api;

public interface ITablero extends IDibujable ,IIniciador{
	void recogerFichas();
	void recibirFicha(IFicha ficha);
	void verificarTrios();	
	boolean reportarGameOver();
	void reportarScore();
        int getPuntaje();
}
