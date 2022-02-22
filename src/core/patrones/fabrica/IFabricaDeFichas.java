package core.patrones.fabrica;
import java.awt.Point;
import core.api.IFicha;
import java.io.Serializable;

public interface IFabricaDeFichas extends Serializable{
	IFicha crearFicha(Point posicion);
}
