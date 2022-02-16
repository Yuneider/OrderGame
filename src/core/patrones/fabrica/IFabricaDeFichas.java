package core.patrones.fabrica;
import java.awt.Point;
import core.api.IFicha;

public interface IFabricaDeFichas {
	IFicha crearFicha(Point posicion);
}
