package core.patrones.mediador;

import java.io.Serializable;
import javax.swing.JPanel;

public abstract class AMediador extends JPanel implements Serializable{
	private static final long serialVersionUID = 1L;
	public void actualizar() {
		repaint();		
	}
}
