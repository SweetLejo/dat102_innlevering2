package oppg2oving4;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
	private static int SDK = 10;
	private Medlem[] medlemTab;
	private int antall;
	
	public Datakontakt() {
		this.medlemTab = new Medlem[SDK];
		this.antall = 0;
	}
	
	public Datakontakt(int antall) {
		this.medlemTab = new Medlem[antall];
		this.antall = 0;
	}
	
	public void leggTilMedlem(Medlem person) {
		if(antall == medlemTab.length) 
			medlemTab = utvidTabell(medlemTab);
		
		medlemTab[antall] = person;
		antall++;
	}
		
	private static Medlem[] utvidTabell(Medlem[] tab) {
		Medlem[] ny = new Medlem[tab.length * 2];
		for(int i = 0; i < tab.length; i++) 
			ny[i] = tab[i];
		
		return ny;
	}
	
	public int finnMedlemsIndex(String medlemsnavn) {
		for(int i = 0; i < antall; i++) {
			if(medlemsnavn.equals(medlemTab[i].getNavn())) {
				return i;
			}
		}
		return -1;
	}
	
	public int finnPartnerFor(String medlemsNavn) {
		int medlemsIndex = finnMedlemsIndex(medlemsNavn);
		if(medlemsIndex == -1) 
			return -1;
	
		for(int i = 0; i < antall; i++) {
			if(medlemTab[i].passerTil(medlemTab[medlemsIndex])
					&& medlemTab[i].getStatusIndex() == -1) {
				medlemTab[i].setStatusIndex(medlemsIndex);
				medlemTab[medlemsIndex].setStatusIndex(i);
				return i;
			}
		}
		
		return -1;
	}
	
	public void finnPartnerForAlle() {
		for(int i = 0; i < antall; i++) {
			boolean harPartner = medlemTab[i].getStatusIndex() != -1;
			
			for(int j = 0; j < i && !harPartner; j++) {
				if(medlemTab[j].passerTil(medlemTab[i])
						&& medlemTab[j].getStatusIndex() == -1) {
					medlemTab[j].setStatusIndex(i);
					medlemTab[i].setStatusIndex(i);
					harPartner = true;
				}
			}
		}
	}
	
	public void tilbakestillStatusIndex(String medlemsNavn) {
		int medlemsIndex = finnMedlemsIndex(medlemsNavn);
		if(medlemsIndex == -1)
			return;
		
		int partnerIndex = medlemTab[medlemsIndex].getStatusIndex();
		if(partnerIndex == -1)
			return;
		
		medlemTab[medlemsIndex].setStatusIndex(-1);
		medlemTab[partnerIndex].setStatusIndex(-1);
	}
	
	public int antall() {
		return this.antall;
	}
	
	public Medlem getMedlem(int index) {
		return medlemTab[index];
	}
}
