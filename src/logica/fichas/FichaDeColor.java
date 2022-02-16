package logica.fichas;

import static core.api.IJuego.*;
import static java.lang.Math.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import core.api.IFicha;

public class FichaDeColor extends Ficha {
	public static int TOPE = 255;
	public static int N_COLORES = (int) ceil(N_COLUMNAS*1.3);
	public final static List<Color> COLORES = crearColores();

	static List<Color> crearColores() {
		List<Color> COLORES = new ArrayList<Color>();
		for (int i = 0; i < N_COLORES; i++) {
			int r = (int) floor(random() * TOPE);
			int g = (int) floor(random() * TOPE);
			int b = (int) floor(random() * TOPE);
			COLORES.add(new Color(r, g, b));
		}
		return COLORES;
	}
	protected Color color;

	public FichaDeColor(Point posicion, Color color) {
		super(posicion);
		this.color = color;
	}
	@Override
	public boolean esIgual(IFicha ficha) {
		return ((FichaDeColor)ficha).color.getRGB() == color.getRGB();
	}
	@Override
	public void dibujar(Graphics pintor) {
		pintor.setColor(color);
		pintor.fillRect(posicion.x, posicion.y, ANCHO, ALTO);
	}
}
