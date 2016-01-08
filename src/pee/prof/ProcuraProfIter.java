package pee.prof;

import pee.mecproc.Solucao;
import pee.modprob.Estado;
import pee.modprob.Problema;

public class ProcuraProfIter<e extends Estado> extends ProcuraProf<e> {
	Solucao<e> solucao;
	
	@Override
	public Solucao<e> procurar(Problema<e> problema) {
		return procurar(problema, Double.MAX_VALUE, 1);
	}
	
	public Solucao<e> procurar(Problema<e> problema, double profMax, double incProf) {
		for(double profMaxIter = incProf; profMaxIter <= profMax; profMaxIter += incProf) {
			solucao = super.procurar(problema, profMaxIter);
			if(solucao != null)
				return solucao;
		}
		return null;
	}
}
