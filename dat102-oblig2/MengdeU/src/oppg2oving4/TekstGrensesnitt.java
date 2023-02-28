package oppg2oving4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class TekstGrensesnitt {
	private static final String LISTE_FORMAT = "%-25s%-50s%n";
	
	private Scanner input;
	
	public TekstGrensesnitt() {
		input = new Scanner(System.in);
	}
	
	public void close() {
		input.close();
	}
	
	public Medlem lesMedlem() { 
		System.out.println("--NYTT MEDLEM--");
		
		System.out.println("Skriv medlemsnavn:");
		String navn = input.nextLine();
		Medlem medlem = new Medlem(navn.trim());
		
		System.out.println("Skriv hobbyer: 	('q' hvis ferdig)");		
		String hobby = input.nextLine();
		while(!hobby.equals("q")) {
			medlem.getHobbyer().leggTil(new Hobby(hobby.trim()));
			hobby = input.nextLine();
		}
		
		return medlem;
	}  
	 
	public void skrivHobbyListe(Medlem medlem) {  
	    System.out.println("Alle hobbyene til " + medlem.getNavn() + ": " 
	    		+ medlem.getHobbyer().toString()); 
	} 
	
	public void skrivParListe (Datakontakt arkiv){ 
		System.out.format(LISTE_FORMAT, "PARNAVN", "HOBBYER");
		
		int antall = arkiv.antall();
		
		for(int i = 0; i < antall; i++) {
			int parIndex = arkiv.getMedlem(i).getStatusIndex();
			if(parIndex > i) {
				System.out.format(LISTE_FORMAT, 
						arkiv.getMedlem(i) + " og " 
								+ arkiv.getMedlem(parIndex).getNavn(),
						arkiv.getMedlem(i).getHobbyer());
			}
		}
	} 
	
}
