package respuzzle.modprob;

import pee.modprob.ProblemaHeur;
import puzzle.Puzzle;

public class ProblemaPuzzle extends ProblemaHeur<EstadoPuzzle> {
	private EstadoPuzzle estadoFinal;

	public ProblemaPuzzle(Puzzle puzzleInicial, Puzzle puzzleFinal, OperadorMoverPosVazia[] operador) {
		super(operador, new EstadoPuzzle(puzzleInicial));
		this.estadoFinal = new EstadoPuzzle(puzzleFinal);
	}

	@Override
	public Boolean objetivo(EstadoPuzzle puzzle) {
		return puzzle.equals(estadoFinal);
	}
	
	public double heuristica(EstadoPuzzle estado) {
		return estado.getPuzzle().distManhattan(estadoFinal.getPuzzle());
		//return estado.getPuzzle().numPecasForaLugar(estadoFinal.getPuzzle());
	}

}
