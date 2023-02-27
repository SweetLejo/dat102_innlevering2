package no.hvl.dat102.mengde.adt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class MengdeADTTest {
	
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private Integer a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8;
	
	protected abstract MengdeADT<Integer> init();
	
	@BeforeEach
	public void setup() {
		m1 = init();
		m2 = init();
		m1.leggTil(a);
		m1.leggTil(b);
		m1.leggTil(c);
		m1.leggTil(d);
		m1.leggTil(e);
		m2.leggTil(f);
		m2.leggTil(g);
		m2.leggTil(h);
		m2.leggTil(a);
		m2.leggTil(b);
	}
	
	@Test
	public void testInneholder() {
		assertTrue(m1.inneholder(a));
		assertTrue(m1.inneholder(e));
		assertTrue(m2.inneholder(b));
		assertFalse(m2.inneholder(c));
	}
	
	@Test
	public void testUnion() {		
		MengdeADT<Integer> m3 = m1.union(m2);
		assertTrue(m3.inneholder(a));
		assertTrue(m3.inneholder(b));
		assertTrue(m3.inneholder(c));
		assertTrue(m3.inneholder(d));
		assertTrue(m3.inneholder(e));
		assertTrue(m3.inneholder(f));
		assertTrue(m3.inneholder(g));
		assertTrue(m3.inneholder(h));
		
		m3.fjern(a);
		assertFalse(m3.inneholder(a));
		m3.fjern(b);
		assertFalse(m3.inneholder(b));
	}
	
	@Test
	public void testSnitt() {
		MengdeADT<Integer> m3 = m1.snitt(m2);
		assertTrue(m3.inneholder(a));
		assertTrue(m3.inneholder(b));
		assertFalse(m3.inneholder(c));
		assertFalse(m3.inneholder(h));
	}
	
	@Test
	public void testDifferens() {
		MengdeADT<Integer> differens = init();
		MengdeADT<Integer> m3 = m1.differens(m2);
		assertTrue(m3.inneholder(c));
		assertTrue(m3.inneholder(d));
		assertTrue(m3.inneholder(e));
		assertFalse(m3.inneholder(a));
		assertFalse(m3.inneholder(b));
		assertFalse(m3.inneholder(f));
		assertFalse(m3.inneholder(g));
		assertFalse(m3.inneholder(h));
	}
	
}
