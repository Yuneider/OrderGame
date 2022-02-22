package core.api;

import java.io.Serializable;
import java.util.List;

public interface ILanzador extends IIniciador,IDetenedor,IDibujable,Serializable{
	void lanzar();	
	List<IFicha> getFichas();
}
