package plantraj.modprob;

import pee.modprob.Problema;

public class ProblemaTrajecto extends Problema<EstadoLocalidade> {
	private EstadoLocalidade estadoFinal;
	
	public ProblemaTrajecto(String locInicial, String locFinal, OperadorLigacao[] operadores) {
		super(operadores, new EstadoLocalidade(locInicial));
		estadoFinal = new EstadoLocalidade(locFinal);
	}

	@Override
	public Boolean objetivo(EstadoLocalidade estado) {
		return estado.equals(estadoFinal);
	}

}
