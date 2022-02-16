package core.api;

public interface IJugador extends IIniciador,IDetenedor,IDibujable{
	void capturarFichas();
	void ordenarFichas();
}
