package no.hvl.dat102.mengde;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class TabellTest extends MengdeADTtest{


    @Override
    public MengdeADT<String> init() {
        return new TabellMengde<>();
    }
}
