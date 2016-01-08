package pee.melhorprim;

import pee.mecproc.No;
import pee.modprob.Estado;
import pee.modprob.ProblemaHeur;

public class ProcuraAA<e extends Estado> extends ProcuraMelhorPrim<e,ProblemaHeur<e>> {

	@Override
	public double f(No<e> no) {
		return no.getCusto() + problema.heuristica(no.getEstado());
	}

}
