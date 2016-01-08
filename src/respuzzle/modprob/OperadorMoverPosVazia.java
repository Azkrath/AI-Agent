package respuzzle.modprob;

import pee.modprob.Operador;
import puzzle.Puzzle;

public class OperadorMoverPosVazia implements Operador<EstadoPuzzle> {
	private Puzzle.Movimento mov;
	
	public OperadorMoverPosVazia(Puzzle.Movimento mov) {
		this.mov = mov;
	}
	
	@Override
	public EstadoPuzzle aplicar(EstadoPuzzle estado) {
		Puzzle puzzle = estado.getPuzzle();
		Puzzle novoPuzzle = puzzle.movimentar(mov);
		if(novoPuzzle != null)
			return new EstadoPuzzle(novoPuzzle);
		else
			return null;
	}

	@Override
	public double custo(EstadoPuzzle estado, EstadoPuzzle estadoSuc) {
		//return estado.getPuzzle().distManhattan(estadoSuc.getPuzzle());
		//return estado.getPuzzle().numPecasForaLugar(estadoSuc.getPuzzle());
		return 1;
	}

}
