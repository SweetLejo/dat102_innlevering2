package oppg2oving4;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class KlientMain {

	public static void main(String[] args) {

		Datakontakt kontakt = new Datakontakt(6);
		TekstGrensesnitt ui = new TekstGrensesnitt();
		
		for(int i = 0; i < 6; i++) {
			kontakt.leggTilMedlem(ui.lesMedlem());
		}
		
		ui.skrivHobbyListe(kontakt.getMedlem(2));
		ui.skrivHobbyListe(kontakt.getMedlem(5));
		ui.skrivHobbyListe(kontakt.getMedlem(2));
		
		kontakt.finnPartnerForAlle();
		
		ui.skrivParListe(kontakt);
	}	
}
