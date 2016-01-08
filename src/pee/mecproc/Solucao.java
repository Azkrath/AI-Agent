package pee.mecproc;

import java.util.Iterator;
import java.util.LinkedList;

import pee.modprob.Estado;

public class Solucao<e extends Estado> implements Iterable<No<e>>{
	private LinkedList<No<e>> percurso = new LinkedList<No<e>>();
	private Integer nosProcessados;
	private Integer tamanhoFront;
	
	public void juntarInicio(No<e> no) {
		percurso.addFirst(no);
	}
	
	public LinkedList<No<e>> getPercurso() {
		return percurso;
	}

	@Override
	public Iterator<No<e>> iterator() {
		return percurso.iterator();
	}

	public void setNosProcessados(Integer nosProcessados) {
		this.nosProcessados = nosProcessados;
	}

	public void setTamanhoFront(Integer tamanhoFront) {
		this.tamanhoFront = tamanhoFront;
		
	}

	public Integer getNosProcessados() {
		return nosProcessados;
	}

	public Integer getTamanhoFront() {
		return tamanhoFront;
	}
	
	public Integer getCustoSoluc() {
		return percurso.size() - 1;
	}
}
