package pee.modprob;


public interface Operador<e extends Estado> {
	e aplicar(e estado);
	double custo(e estado, e estadoSuc);
}
