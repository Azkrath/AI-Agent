package pee.modprob;


public abstract class Problema<e extends Estado> {
		private Operador<e>[] operador;
		private e estadoInicial;
		
		protected Problema(Operador<e>[] operador, e estadoInicial) {
			this.operador = operador;
			this.estadoInicial = estadoInicial;
		}
		
		public e getEstadoInicial() {
			return estadoInicial;
		}

		public Operador<e>[] getOperadores() {
			return operador;
		}
		
		public abstract Boolean objetivo(e estado);
}
