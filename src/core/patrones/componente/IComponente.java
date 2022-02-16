package core.patrones.componente;

public interface IComponente {
	default void adicionar(IComponente componente) {};
	default IComponente remover() {return null;}
	default IComponente getHoja() {return null;}
}
