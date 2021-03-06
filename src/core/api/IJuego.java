package core.api;

import java.awt.Dimension;
import java.awt.Point;

public interface IJuego{
	public static Dimension TAM  = new Dimension(226,250);
	public static Point ORIGEN = new Point(0,50);
		
	public static int ANCHO = 30;
	public static int ALTO  = 10;
	public static int PASO  = ALTO/2;
	public static int Y_LANZADOR = ORIGEN.y;
	public static int Y_JUGADOR  = Y_LANZADOR+ 7*ALTO;
	public static int Y_TALERO   = Y_JUGADOR + 3*ALTO;
	public static int CAPACIDAD_DEL_JUGADOR = 3;
	
	public static int N_COLUMNAS = 7;
	public static int N_FILAS    = N_COLUMNAS - 2;
	
	public static int ANCHO_JUEGO = ANCHO*N_COLUMNAS;
	
	public static int TIEMPO_DE_LANAAMIENTO = 300;
	public static int LANZAMINETO_RAPIDO = 3;
	public static int LANZAMINETO_MEDIO = 4;
	public static int LANZAMINETO_LENTO = 5;
	public static int LANZAMIENTO = LANZAMINETO_LENTO;
	
	ILanzador getLanzador();
	IJugador  getJugador();
	ITablero  getTablero();
	void  setLanzador(ILanzador l);
	void  setJugador(IJugador j);
	void  setTablero(ITablero t);
	void  setEstado(Object obj);
	Object  getEstado();
	boolean gameOver();	
	void reportar();
}
