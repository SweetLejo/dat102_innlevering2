package no.hvl.dat102.klient;

import no.hvl.dat102.kjedet.DobbelKjedetOrdnetListe;

public class NyKlient {

	public static void main(String[] args) {
		DobbelKjedetOrdnetListe<Integer> liste = new DobbelKjedetOrdnetListe<>(1, 1000);
		
		liste.leggTil(264);
		liste.leggTil(4);
		liste.leggTil(321);
		liste.leggTil(902);
		liste.leggTil(432);
		
		System.out.println(liste.fjern(321));
		
		liste.visListe();
	}
}
