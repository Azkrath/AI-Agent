package respuzzle.modprob;

import pee.modprob.Estado;
import puzzle.Puzzle;

public class EstadoPuzzle extends Estado {
	private Puzzle puzzle;
	
	public EstadoPuzzle(Puzzle puzzleInicial) {
		puzzle = puzzleInicial;
	}
	
	@Override
	public int hashCode() {
		return puzzle.hashCode();
	}
	
	public Puzzle getPuzzle() {
		return puzzle;
	}
	
	@Override
	public String toString() {
		return puzzle.toString();
	}
}
