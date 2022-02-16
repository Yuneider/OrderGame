package core.api;

import java.util.List;

public interface ILanzador extends IIniciador,IDetenedor,IDibujable{
	void lanzar();	
	List<IFicha> getFichas();
}
