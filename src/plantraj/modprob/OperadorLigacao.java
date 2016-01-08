package plantraj.modprob;

import pee.modprob.Operador;

public class OperadorLigacao implements Operador<EstadoLocalidade> {
	private EstadoLocalidade estadoOrigem;
	private EstadoLocalidade estadoDestino;
	private double custo;
	
	public OperadorLigacao(String locOrigem, String locDestino, double custo) {
		estadoOrigem = new EstadoLocalidade(locOrigem);
		estadoDestino = new EstadoLocalidade(locDestino);
		this.custo = custo;
	}
	
	public EstadoLocalidade aplicar(EstadoLocalidade estado) {
		if(estado.equals(estadoOrigem))
			return estadoDestino;
		return null;
	}

	@Override
	public double custo(EstadoLocalidade estado, EstadoLocalidade estadoSuc) {
		return custo;
	}

}
