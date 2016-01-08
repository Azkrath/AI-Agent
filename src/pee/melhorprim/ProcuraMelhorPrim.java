package pee.melhorprim;

import java.util.Comparator;

import pee.mecproc.MecanismoProcura;
import pee.mecproc.No;
import pee.mecproc.memorias.MemoriaPrioridade;
import pee.mecproc.memorias.MemoriaProcura;
import pee.modprob.Estado;
import pee.modprob.Problema;

public abstract class ProcuraMelhorPrim<e extends Estado, p extends Problema<e>> extends MecanismoProcura<e, p> implements Comparator<No<e>> {

	public abstract double f(No<e> no);
	
	@Override
	public int compare(No<e> o1, No<e> o2) {
		return Double.compare(f(o1), f(o2));
	}
	
	public MemoriaProcura<e> iniciarMemoria() {
		return new MemoriaPrioridade<e>(this);
	}

}
