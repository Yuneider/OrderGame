package core.api;

import java.awt.Point;

import core.patrones.componente.IComponente;
import java.io.Serializable;

public interface IFicha extends IMovible,IDibujable,IComponente,Serializable{
	boolean esIgual(IFicha ficha);
	Point getPosicion();
}
