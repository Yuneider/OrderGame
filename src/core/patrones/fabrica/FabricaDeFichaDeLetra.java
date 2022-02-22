package core.patrones.fabrica;

import static core.api.IJuego.ALTO;
import static java.lang.Math.floor;
import static java.lang.Math.random;
import static logica.fichas.FichaDeLetra.N_LETRAS;
import static logica.fichas.FichaDeLetra.letras;

import java.awt.Point;

import core.api.IFicha;
import java.io.Serializable;
import logica.fichas.FichaDeLetra;

public class FabricaDeFichaDeLetra implements IFabricaDeFichas, Serializable {
	@Override
	public IFicha crearFicha(Point posicion) {
		int letra_i   = (int) floor(random() * N_LETRAS);		
		return new FichaDeLetra(new Point(posicion.x, posicion.y + ALTO), letras[letra_i]);
	}
}
