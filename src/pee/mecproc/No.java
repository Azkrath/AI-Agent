package pee.mecproc;

import pee.modprob.Estado;
import pee.modprob.Operador;

public class No<e extends Estado> {
	private e estado;
	private Operador<e> operador;
	private No<e> antecessor = null;
	private Integer profundidade = 0;
	private double custo = 0;
	
	public No<e> getAntecessor() {
		return antecessor;
	}
	
	public e getEstado() {
		return estado;
	}
	
	public Operador<e> getOperador() {
		return operador;
	}
	
	public No(e estado) {
		this.estado = estado;
	}
	
	public No(e estado, Operador<e> operador, No<e> no) {
		this(estado);
		this.operador = operador;
		antecessor = no;
		if(no != null)
			profundidade = no.getProfundidade() + 1;
		else
			profundidade = 0;
		if(no != null)
			custo = no.getCusto() + operador.custo(no.getEstado(), estado);
		else
			custo = 0;
			
	}

	public double getCusto() {
		return custo;
	}

	public int getProfundidade() {
		return profundidade;
	}

}
