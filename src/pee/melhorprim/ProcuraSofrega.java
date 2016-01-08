package pee.melhorprim;

import pee.mecproc.No;
import pee.modprob.Estado;
import pee.modprob.ProblemaHeur;

public class ProcuraSofrega<e extends Estado> extends ProcuraMelhorPrim<e, ProblemaHeur<e>> {

	@Override
	public double f(No<e> no) {
		return problema.heuristica(no.getEstado());
	}
}
