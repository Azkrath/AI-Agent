package pee.prof;

import pee.mecproc.MecanismoProcura;
import pee.mecproc.Solucao;
import pee.mecproc.memorias.MemoriaLIFO;
import pee.mecproc.memorias.MemoriaProcura;
import pee.modprob.Estado;
import pee.modprob.Problema;

public class ProcuraProf<e extends Estado> extends MecanismoProcura<e, Problema<e>> {

	@Override
	public MemoriaProcura<e> iniciarMemoria() {
		return new MemoriaLIFO<e>();
	}
	
	public Solucao<e> procurar(Problema<e> problema) {
		return super.procurar(problema, Double.MAX_VALUE);
	}
}
