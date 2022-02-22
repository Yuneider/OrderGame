package core.patrones.componente;

import java.io.Serializable;

public interface IComponente extends Serializable{
	default void adicionar(IComponente componente) {};
	default IComponente remover() {return null;}
	default IComponente getHoja() {return null;}
}
