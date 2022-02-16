package core.api;

import java.awt.Point;

import core.patrones.componente.IComponente;

public interface IFicha extends IMovible,IDibujable,IComponente{
	boolean esIgual(IFicha ficha);
	Point getPosicion();
}
