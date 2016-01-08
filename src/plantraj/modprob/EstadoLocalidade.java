package plantraj.modprob;

import pee.modprob.Estado;

public class EstadoLocalidade extends Estado {
	private String loc;
	
	public EstadoLocalidade(String locInicial) {
		loc = locInicial;
	}

	public int hashCode() {
		return loc.hashCode();
	}
	
	@Override
	public String toString() {
		return loc;
	}
}
