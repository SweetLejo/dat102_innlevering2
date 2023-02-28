package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.adt.MengdeADTTest;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

import org.junit.jupiter.api.Test;

public class TabellMendgeTest extends MengdeADTTest{

	@Override
	public MengdeADT<String> init() {
		return new TabellMengde<>();
	}
}
