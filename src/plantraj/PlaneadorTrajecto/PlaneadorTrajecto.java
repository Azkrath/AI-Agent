package plantraj.PlaneadorTrajecto;

import pee.mecproc.No;
import pee.mecproc.Solucao;
import pee.prof.ProcuraProf;
import plantraj.modprob.EstadoLocalidade;
import plantraj.modprob.OperadorLigacao;
import plantraj.modprob.ProblemaTrajecto;

public class PlaneadorTrajecto {
	
	public static void main(String[] args) {
		
		String locInicial = "Lisboa";
		String locFinal = "Porto";
		
		double profundidadeMax = 5;
		
		OperadorLigacao[] operador = definirOperadores();
		ProblemaTrajecto problema = definirProblema(locInicial, locFinal, operador);
		
		ProcuraProf<EstadoLocalidade> mecProcura = new ProcuraProf<EstadoLocalidade>();
		
		Solucao<EstadoLocalidade> solucao = mecProcura.procurar(problema, profundidadeMax);
		
		mostrarTrajecto(solucao);

	}
	
	public static OperadorLigacao[] definirOperadores() {
		OperadorLigacao[] operador = {new OperadorLigacao("Lisboa", "Santarem", 25), new OperadorLigacao("Lisboa", "Sintra", 5), new OperadorLigacao("Sintra", "TorresVedras", 12), 
			  new OperadorLigacao("TorresVedras", "Santarem", 10), new OperadorLigacao("Santarem", "Porto", 30), new OperadorLigacao("Sintra", "Terrugem", 5),
			  new OperadorLigacao("Terrugem", "TorresVedras", 15), new OperadorLigacao("TorresVedras", "Alenquer", 5), new OperadorLigacao("Alenquer", "Terrugem", 8),
			  new OperadorLigacao("Terrugem", "Porto", 15), new OperadorLigacao("Porto", "Alenquer", 2)};
		return operador;
	}
	
	public static ProblemaTrajecto definirProblema(String locInicial, String locFinal, OperadorLigacao[] operador) {
		return new ProblemaTrajecto(locInicial, locFinal, operador);
	}
	
	public static void mostrarTrajecto(Solucao<EstadoLocalidade> solucao) {
		for(No<EstadoLocalidade> no : solucao) {
			System.out.printf("%s", no.getEstado() + " -> ");
		}
	}
}
