package oppg3oving5;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.kjedet.KjedetStabel;

public class Main implements Parentessjekker {

	public static void main(String[] args) {
		
		String a = ")(=??=)(}][";
		String b = "{a/([])}";
		
		Parentessjekker sjekker = new Main();
		
		System.out.println(sjekker.erBalansert(a) + " " + sjekker.erBalansert(b));;
		
	}
	
	@Override
	public boolean erVenstreparentes(char p) {
		return p == '(' || p == '[' || p == '{';
	}

	@Override
	public boolean erHogreparentes(char p) {
		return p == ')' || p == ']' || p == '}';
	}

	@Override
	public boolean erParentes(char p) {
		return erVenstreparentes(p) || erHogreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		return (venstre == '(' && hogre == ')')
				|| (venstre == '[' && hogre == ']')
				|| (venstre == '{' && hogre == '}'); 
	}

	@Override
	public boolean erBalansert(String s) {
		StabelADT<Character> stabel = new KjedetStabel<>();
		
		for(char c : s.toCharArray()) {
			if(erVenstreparentes(c)) {
				stabel.push(c);
			}
			if(erHogreparentes(c)) {
				if(stabel.erTom() || !erPar(stabel.pop(), c)) {
					return false;
				}
			}
		}
			
		return true;
	}

}
