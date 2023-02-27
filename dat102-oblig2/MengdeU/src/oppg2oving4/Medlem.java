package oppg2oving4;

import java.util.Objects;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndex;
	
	public Medlem(String navn) {
		this.navn = navn;
		this.hobbyer = new KjedetMengde<>();
		this.statusIndex = -1;
	}
	
	public boolean passerTil(Medlem other) {
		return hobbyer.equals(other.getHobbyer())
				&& !navn.equals(other.getNavn());
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndex() {
		return statusIndex;
	}

	public void setStatusIndex(int statusIndex) {
		this.statusIndex = statusIndex;
	}

	@Override
	public int hashCode() {
		return Objects.hash(navn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medlem other = (Medlem) obj;
		return Objects.equals(navn, other.navn);
	}

	@Override
	public String toString() {
		return "Medlem [navn=" + navn + ", hobbyer=" + hobbyer + ", statusIndex=" + statusIndex + "]";
	}
	
	
}
