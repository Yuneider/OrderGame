package core.patrones.mediador;

import javax.swing.JPanel;

public abstract class AMediador extends JPanel{
	private static final long serialVersionUID = 1L;
	public void actualizar() {
		repaint();		
	}
}
