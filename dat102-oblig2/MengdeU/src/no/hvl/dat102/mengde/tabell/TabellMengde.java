package no.hvl.dat102.mengde.tabell;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		// S�ker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		for (int i = 0; (i < antall && !funnet); i++) {
			if (tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall - 1];
				// tab[antall-1] = null;
				antall--;
				funnet = true;

			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}

	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hashcode-metoden da en del biblioterker brker hashcode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hashcode senere i faget.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object m2) {
		if (this == m2) {
			return true;
		}
		if (m2 == null) {
			return false;
		}
		if (getClass() != m2.getClass()) {
			return false;
		}	
		
		MengdeADT<T> ny = (TabellMengde<T>) m2;
		if (this.antall != ny.antall()) {
			return false;
		} 
		
		boolean likeMengder = true;
		for(T element : tab) {
			if(!ny.inneholder(element)) {
				likeMengder = false;
			}
		}
		
//		Hvis rekkefølge er vikitg
//		Iterator<T> teller = ny.iterator();
//		for(int i = 0; i < antall && likeMengder; i++) {
//			if(tab[i] != teller.next()) {
//				likeMengder = false;
//			}
//		}
			
		return likeMengder;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) { // Denne metoden erstattes med en mer effektiv, se KladdeoppgaveNr3
		TabellMengde<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.settInn(tab[i]);
		}
		
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			T element = teller.next();
			if(!this.inneholder(element)) {
				begge.settInn(element);
			}
		}
		
		return (MengdeADT<T>) begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		TabellMengde<T> snitt = new TabellMengde<T>();
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			T element = teller.next();
			if(this.inneholder(element)) {
				snitt.settInn(element);
			}
		}
		
		return (MengdeADT<T>) snitt;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		TabellMengde<T> differens = new TabellMengde<>();
		Iterator<T> teller = this.iterator();
		while (teller.hasNext()) {
			T element = teller.next();
			if(!m2.inneholder(element)) {
				differens.settInn(element);
			} 
		}
		
		return (MengdeADT<T>) differens;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		Iterator<T> teller = m2.iterator();
		while(teller.hasNext() && erUnderMengde) {
			if(!this.inneholder(teller.next())) {
				erUnderMengde = false;
			}
		}
		return erUnderMengde;
	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {// hjelpemetode
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	public String toString(){ 
		String resultat = ""; 
		for(int i = 0; i < antall; i++) {
			resultat += tab[i].toString() + "\t";  
		} 
		return resultat; 
	} 
	
}// class
