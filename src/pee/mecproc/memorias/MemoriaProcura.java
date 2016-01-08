package pee.mecproc.memorias;

import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;

import pee.mecproc.No;
import pee.modprob.Estado;

public class MemoriaProcura<e extends Estado> {
	protected Queue<No<e>> fronteira;
	protected Map<e, No<e>> explorados = new Hashtable<e, No<e>>();
	protected Integer nosProcessados = 0;
	protected Integer tamanhoFront = 0;
	
	public MemoriaProcura(Queue<No<e>> fronteira) {
		this.fronteira = fronteira;
	}

	public void limpar() {
		fronteira.clear();
		explorados.clear();
	}

	public void inserir(No<e> no) {
		nosProcessados += 1; //Complexidade Temporal
		if(explorados.get(no.getEstado()) == null ? true : explorados.get(no.getEstado()).getCusto() > no.getCusto()) {
			fronteira.add(no);
			if(fronteira.size() > tamanhoFront)
				tamanhoFront = fronteira.size(); //Complexidade Espacial
			explorados.put(no.getEstado(), no);
		}
	}

	public boolean fronteiraVazia() {
		return fronteira.isEmpty();
	}

	public No<e> remover() {
		return fronteira.poll();
	}

	public Integer getNosProcessados() {
		return nosProcessados;
	}

	public Integer getTamanhoFront() {
		return tamanhoFront;
	}
	
}
