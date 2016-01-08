package pee.mecproc;

import pee.mecproc.memorias.MemoriaProcura;
import pee.modprob.Estado;
import pee.modprob.Operador;
import pee.modprob.Problema;

public abstract class MecanismoProcura<e extends Estado, p extends Problema<e>> {
	private MemoriaProcura<e> memoriaProcura;
	protected p problema;
	protected double profundidadeMax;
	
	public MecanismoProcura() {
		memoriaProcura = iniciarMemoria();
	}
	
	public abstract MemoriaProcura<e> iniciarMemoria();

	public Solucao<e> procurar(p problema, double profundidadeMax) {
		this.problema = problema;
		memoriaProcura.limpar();
		e estadoInicial = problema.getEstadoInicial();
		No<e> noInicial = new No<e>(estadoInicial);
		memoriaProcura.inserir(noInicial);
		
		while(!memoriaProcura.fronteiraVazia()) {
			No<e> no = memoriaProcura.remover();
			e estado = no.getEstado();
			Boolean resultado = problema.objetivo(estado);
			
			if(resultado) {
				return gerarSolucao(no);
		} else if(no.getProfundidade() < profundidadeMax) {
				expandir(no);
			}
		}
		
		return null;
	}

	private Solucao<e> gerarSolucao(No<e> no) {
		Solucao<e> solucao = new Solucao<e>();
		No<e> noTemp = new No<e>(no.getEstado(),no.getOperador(), no.getAntecessor());
		solucao.juntarInicio(noTemp);
		while(no.getAntecessor() != null) {
			noTemp = new No<e>(no.getAntecessor().getEstado(), no.getAntecessor().getOperador(), no.getAntecessor().getAntecessor());
			solucao.juntarInicio(noTemp);
			no = noTemp;
		}
		solucao.setNosProcessados(memoriaProcura.getNosProcessados());
		solucao.setTamanhoFront(memoriaProcura.getTamanhoFront());
		return solucao;
	}

	private void expandir(No<e> no) {
		for(Operador<e> op : problema.getOperadores()) {
			e estadoSuc =  op.aplicar(no.getEstado());
			if(estadoSuc != null) {
				memoriaProcura.inserir(new No<e>(estadoSuc, op, no));
			}
		}
	}
}
