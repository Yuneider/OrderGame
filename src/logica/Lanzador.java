package logica;

import static core.api.IJuego.*;
import static java.lang.Math.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import core.api.*;
import core.patrones.estado.Estado;
import core.patrones.fabrica.IFabricaDeFichas;
import core.patrones.mediador.*;
import java.io.Serializable;

public class Lanzador extends AColega implements Runnable,IIniciador,IDetenedor,ILanzador,IDibujable,Serializable {
	List<IFicha> fichas = new ArrayList<IFicha>();	
    Thread lanzamientos;    
    IFabricaDeFichas fabrica;
    int conteo=0,xFinal=0,paso =0;
	public Lanzador(AMediador juego,IFabricaDeFichas fabrica) {
		super(juego);	
		posicion = new Point(ORIGEN.x + ((N_COLUMNAS / 2) * ANCHO), Y_LANZADOR);
		color = new Color(100, 100, 200);
		this.fabrica = fabrica;
	}	
	private void moverseAPosicionfinal() {		
		xFinal = (int) floor(random() * N_COLUMNAS) * ANCHO + ORIGEN.x;
		paso   = (posicion.x - xFinal) > 0 ?-ANCHO:ANCHO;
	}
	@Override
	public void lanzar() {		
		if(conteo++>LANZAMIENTO) {
		   moverseAPosicionfinal();		   
		   fichas.add(fabrica.crearFicha(posicion));
		   conteo=0;
		}else if(posicion.x!=xFinal) {
		   posicion.x +=paso;
		}		
	}
	@Override
	public void dibujar(Graphics pintor) {
		pintor.setColor(color);
		pintor.fillRect(posicion.x, posicion.y,ANCHO, ALTO);
		for (IFicha f_i : fichas) {
			 f_i.moverse(null);
			 f_i.dibujar(pintor);
		}
	}
	private boolean seHanDetenidoLosLanzamientos() {
		return lanzamientos==null||((IJuego)juego).gameOver();
	}
	@Override
	public void run() {	
		while (!seHanDetenidoLosLanzamientos()) {
			   lanzar();				
			   actualizar();
			   long t=System.currentTimeMillis();
			   while(System.currentTimeMillis()-t<TIEMPO_DE_LANAAMIENTO&&lanzamientos!=null);
		}		
		if(((IJuego)juego).gameOver()) {		  
		   detener();
		   ((Estado)((IJuego)juego).getEstado()).manejar();
		}
	}
	public List<IFicha> getFichas() {
		return fichas;
	}
	@Override
	public void iniciar() {
		(lanzamientos = new Thread(this)).start();				
	}	
	@Override
	public void detener() {		
		lanzamientos.interrupt();
		lanzamientos=null;
	}
}
