package no.hvl.dat102.mengde;


import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.*;
import static org.junit.Assert.*;

import org.junit.*;

import java.util.Iterator;

public class KjedetTest extends MengdeADTtest{

    @Override
    public MengdeADT<String> init() {
        return new KjedetMengde<>();
    }
}
