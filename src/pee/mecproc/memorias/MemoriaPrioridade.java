package pee.mecproc.memorias;

import java.util.Comparator;
import java.util.PriorityQueue;

import pee.mecproc.No;
import pee.modprob.Estado;

public class MemoriaPrioridade<e extends Estado> extends MemoriaProcura<e> {
	
	public MemoriaPrioridade(Comparator<No<e>> comparador) {
		super(new PriorityQueue<No<e>>(1,comparador));
	}

}
