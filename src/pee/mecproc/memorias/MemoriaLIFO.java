package pee.mecproc.memorias;

import java.util.Collections;
import java.util.LinkedList;

import pee.mecproc.No;
import pee.modprob.Estado;

public class MemoriaLIFO<e extends Estado> extends MemoriaProcura<e> {
	
	public MemoriaLIFO() {
		super(Collections.asLifoQueue(new LinkedList<No<e>>()));
	}
}
