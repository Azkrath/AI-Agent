package pee.modprob;

public abstract class ProblemaHeur<e extends Estado> extends Problema<e> {

	protected ProblemaHeur(Operador<e>[] operador, e estadoInicial) {
		super(operador, estadoInicial);
	}

	public abstract double heuristica(e estado);
}
