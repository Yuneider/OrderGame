package core.api;

import java.io.Serializable;

public interface IJugador extends IIniciador,IDetenedor,IDibujable,Serializable{
	void capturarFichas();
	void ordenarFichas();
}
