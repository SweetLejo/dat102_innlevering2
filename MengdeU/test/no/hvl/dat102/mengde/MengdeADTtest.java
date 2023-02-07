package no.hvl.dat102.mengde;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.*;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;
public abstract class MengdeADTtest {

    private MengdeADT<String> m1;
    private MengdeADT<String> m2;
    private MengdeADT<String> m3;
    public abstract MengdeADT<String> init();

    @Before
    public void setup(){
        m1 = init();
        m2 = init();
        m3 = init();

        String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Foerde","Olsen", "Ole", "buss", "rute", "Bergen" };
        for(String word : ord){
            m1.leggTil(word);
            m2.leggTil(word);
        }
    }
    @Test
    public void testleggTill(){
        assertEquals(m1, m2);

        //test adding duplicate
        m1.leggTil("Hans");
        assertEquals(m1, m2);

        //test adding a new element
        m1.leggTil("hello");
        assertNotEquals(m1, m2);
    }

    @Test
    public void leggTilAlle(){
        //test if it works when they are the same
        m1.leggTilAlle(m2);
        assertEquals(m1, m2);
        m2.leggTil("hello");
        m2.leggTil("what");
        m1.leggTilAlle(m2);
        assertEquals(m1, m2);
    }

    @Test
    public void testfjernTilfeldig(){
        m1.fjernTilfeldig();
        assertNotEquals(m1,m2);
    }

    @Test
    public void testFjern(){
        m1.fjern("hello");
        assertEquals(m1, m2);
        m1.fjern("God");
        assertNotEquals(m1, m2);
        assertEquals("Hans", m1.fjern("Hans"));
    }

    @Test
    public void testUnion(){
        for(String i : m1){
            m3.leggTil(i);
        }
        assertEquals(m3, m1.union(m2));
        m1.leggTil("hello");
        m1.leggTil("what");
        assertNotEquals(m3, m1.union(m2));
        m3.leggTil("hello");
        m3.leggTil("what");
        assertEquals(m3, m2.union(m1));
        assertEquals(m1, m1.union(m1));
    }

    @Test
    public void testinneholder(){
        assertFalse(m1.inneholder("hello"));
        assertTrue(m1.inneholder("God"));
    }
    @Test
    public void testequals(){
        assertTrue(m1.equals(m2));
        assertFalse(m1.equals(m3));
        m3.leggTil("hello");
        assertFalse(m3.equals(m1));
    }

    @Test
    public void testerTom(){
        assertTrue(m3.erTom());
        assertFalse(m1.erTom());
    }

    @Test
    public void testantall(){
        assertEquals(0, m3.antall());
        assertEquals(11, m1.antall());
    }

    @Test
    public void testsnitt(){
        assertEquals(m1, m1.snitt(m2));
        m3.leggTil("hello");
        assertEquals(m1.differens(m2), m2.snitt(m3));
    }

    @Test
    public void testdifferens(){
        assertEquals(m3, m1.differens(m2));
        assertNotEquals(m1, m1.differens(m2));

        m3.leggTil("God");
        m3.leggTil("dag");
        m3.leggTil("Hans");

        m2.fjern("God");
        m2.fjern("dag");
        m2.fjern("Hans");

        assertNotEquals(m3, m1.differens(m3));
        assertEquals(m2, m1.differens(m3));

    }

    @Test
    public void testUndermengde(){
        assertTrue(m1.undermengde(m3));
        assertTrue(m1.undermengde(m2));
        m3.leggTil("hello");
        assertFalse(m1.undermengde(m3));
    }

}
