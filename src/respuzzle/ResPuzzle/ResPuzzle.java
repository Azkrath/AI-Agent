package respuzzle.ResPuzzle;

import pee.larg.ProcuraLarg;
import pee.mecproc.No;
import pee.mecproc.Solucao;
import pee.melhorprim.ProcuraAA;
import pee.melhorprim.ProcuraCustoUnif;
import pee.melhorprim.ProcuraMelhorPrim;
import pee.melhorprim.ProcuraSofrega;
import pee.modprob.ProblemaHeur;
import pee.prof.ProcuraProf;
import pee.prof.ProcuraProfIter;
import puzzle.Puzzle;
import respuzzle.modprob.EstadoPuzzle;
import respuzzle.modprob.OperadorMoverPosVazia;
import respuzzle.modprob.ProblemaPuzzle;

public class ResPuzzle {
	
	public static void main(String[] args) {
		int[][] puzzleA = {{1,2,3},{8,4,5},{6,7,0}};
		int[][] puzzleB = {{8,4,5},{6,1,2},{3,7,0}};
		int[][] puzzleF = {{1,2,3},{4,5,6},{7,8,0}};
		Puzzle puzzleInicial = new Puzzle(puzzleB);
		Puzzle puzzleFinal   = new Puzzle(puzzleF);
		
		OperadorMoverPosVazia[] operador = definirOperadores();
		ProblemaPuzzle problema = definirProblema(puzzleInicial, puzzleFinal, operador);
		
		double profundidadeMax = 100;
		
		//ProcuraProf<EstadoPuzzle> mecProcura = new ProcuraProf<EstadoPuzzle>();
		//ProcuraProf<EstadoPuzzle> mecProcura = new ProcuraProfIter<EstadoPuzzle>();
		//ProcuraLarg<EstadoPuzzle> mecProcura = new ProcuraLarg<EstadoPuzzle>();
		ProcuraMelhorPrim<EstadoPuzzle, ProblemaHeur<EstadoPuzzle>>   mecProcura = new ProcuraAA<EstadoPuzzle>();
		//ProcuraMelhorPrim<EstadoPuzzle, ProblemaHeur<EstadoPuzzle>>   mecProcura = new ProcuraSofrega<EstadoPuzzle>();
		//ProcuraMelhorPrim<EstadoPuzzle, ProblemaHeur<EstadoPuzzle>>   mecProcura = new ProcuraCustoUnif<EstadoPuzzle>();
		
		Solucao<EstadoPuzzle> solucao = mecProcura.procurar(problema, profundidadeMax);
		//Solucao<EstadoPuzzle> solucao = mecProcura.procurar(problema);						//Utilizado na Procura em Profundidade
		
		mostrarTrajecto(solucao);
	}
	
	public static OperadorMoverPosVazia[] definirOperadores() {
		OperadorMoverPosVazia[] operador = {new OperadorMoverPosVazia(Puzzle.Movimento.CIMA), new OperadorMoverPosVazia(Puzzle.Movimento.BAIXO), new OperadorMoverPosVazia(Puzzle.Movimento.DIR), new OperadorMoverPosVazia(Puzzle.Movimento.ESQ)};
		return operador;
	}
	
	public static ProblemaPuzzle definirProblema(Puzzle puzzleInicial, Puzzle puzzleFinal, OperadorMoverPosVazia[] operador) {
		return new ProblemaPuzzle(puzzleInicial, puzzleFinal, operador);
	}
	
	public static void mostrarTrajecto(Solucao<EstadoPuzzle> solucao) {
		if(solucao != null) {
			System.out.print("------------");
			for(No<EstadoPuzzle> no : solucao) {
				System.out.printf("%s\n------------", no.getEstado());
			}
				System.out.println("----------------------------------");
				System.out.println("Nos Processados:" + solucao.getNosProcessados());
				System.out.println("Tamanho Max Fronteira: " + solucao.getTamanhoFront());
				System.out.println("Custo da Solução: " + solucao.getCustoSoluc());
				System.out.println("----------------------------------");
		} else
			System.out.println("Sem Solução!");
	}

}
