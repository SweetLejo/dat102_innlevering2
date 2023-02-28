package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		bak--;
		T resultat = liste[bak];
		liste[bak] = null;
		
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		for(int i = 0; i < bak; i++) {
			liste[i] = liste[i + 1];
		}
		bak--;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = liste[bak - 1];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		boolean lagtTil = false;
		if(bak == 0) {
			liste[0] = element;
			lagtTil = true;
		}

		for(int i = bak; i > 0 && !lagtTil; i--) {
			if(liste[i - 1].compareTo(element) < 0) {
				liste[i] = element;
				lagtTil = true;
			} else {
				liste[i] = liste[i - 1];
			}
		}
		
		if(!lagtTil) {
			liste[0] = element;
		}
	
		bak++;
		if(bak == liste.length) 
			utvid();
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int elementIndex = finn(element);
		while(elementIndex != IKKE_FUNNET) {
			for(int i = elementIndex; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
			bak--;
			elementIndex = finn(element);
		}
		
		return element;

	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		while(i < bak && resultat == IKKE_FUNNET) {
			if(el.equals(liste[i])) {
				resultat = i;
			}
			i++;
		}
		
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
