package pee.larg;

import pee.mecproc.MecanismoProcura;
import pee.mecproc.memorias.MemoriaFIFO;
import pee.mecproc.memorias.MemoriaProcura;
import pee.modprob.Estado;
import pee.modprob.Problema;

public class ProcuraLarg<e extends Estado> extends MecanismoProcura<e, Problema<e>> {

	@Override
	public MemoriaProcura<e> iniciarMemoria() {
		return new MemoriaFIFO<e>();
	}


}
