package no.hvl.dat102.mengde.kjedet;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.adt.MengdeADTTest;
import org.junit.jupiter.api.Test;

public class KjedetMengdeTest extends MengdeADTTest{

	@Override
	public MengdeADT<String> init() {
		return new KjedetMengde<>();
	}

}
