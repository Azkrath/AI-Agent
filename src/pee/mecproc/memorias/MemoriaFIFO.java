package pee.mecproc.memorias;

import java.util.LinkedList;

import pee.mecproc.No;
import pee.modprob.Estado;

public class MemoriaFIFO<e extends Estado> extends MemoriaProcura<e> {
	
	public MemoriaFIFO() {
		super(new LinkedList<No<e>>());
	}
}
