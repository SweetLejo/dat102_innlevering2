package oppg4;

import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		testRekursiveMetoder.runTester();
	}
	
	/**
	 * Oppgave 4a
	 */
	public static int sumAvNaturligeTall(int n) {
		int base = 1;
		if (n < base) 
			return 0;
		if(n == base)
			return base;
		
		int sn = n + sumAvNaturligeTall(n - 1);
		return sn;
	}
	
	/**
	 * Oppgave 4b
	 */
	public static int beregnAn(int n) {
		int a0 = 2;
		int a1 = 5;
		if(n == 0)
			return a0;
		if(n == 1)
			return a1;
		
		int an = (5*beregnAn(n-1)) - (6*beregnAn(n-2)) + 2;
		return an;
	}
	
	/**
	 * Oppgave 4c
	 */
	public static long rekursivFibonacci(int n) {
		int f0 = 0;
		int f1 = 1;
		if(n == 0)
			return f0;
		if(n == 1)
			return f1;
		
		long fn = rekursivFibonacci(n-1) + rekursivFibonacci(n-2);	
		return fn;
	}
	
	/**
	 * Oppgave 4d
	 */
	public static long ikkeRekursivFibonacci(int n) {
		long forrige = 0;
		long neste = 1;
		long fn = 0;
		for(int i = 0; i < n; i++) {
			neste += forrige;
			forrige = fn;
			fn = neste;
		}
		return fn;
	}
	
	/**
	 *  Klasse for å kjøre metodene
	 */
	private static class testRekursiveMetoder {
		public static void runTester() {
			testSumAvNaturligeTall();
			testBeregnAn();
			testRekursivFibonacci();
			testIkkeRekursivFibonacci();
		}
		
		public static void testSumAvNaturligeTall() {
			String tekst = "Summen av de første 100 naturlige tallene er ";
			System.out.println(tekst + sumAvNaturligeTall(100));
		}
		
		public static void testBeregnAn() {
			int[] an = new int[10];
			for(int i = 0; i < 10; i++) {
				an[i] = beregnAn(i);
			}
			
			String tekst = "De første 10 leddene i tallfølgen an er ";
			System.out.println(tekst + Arrays.toString(an));
		}
		
		
		public static void testRekursivFibonacci() {
			int[] n = new int[] {5, 32, 12, 45, 10};
			long[] fn = new long[5];
			long[] utforingsTid = new long[5];
			for(int i = 0; i < 5; i++) {
				long startTidspunkt = System.currentTimeMillis();		
				fn[i] = rekursivFibonacci(n[i]);
				long sluttTidspunkt = System.currentTimeMillis();
				utforingsTid[i] = sluttTidspunkt - startTidspunkt;
			}
			
			System.out.println("-- REKURSIV FIBONACCI -------------------");
			String tekst = "Fibonaccitall %d er %d. "
					+ "Metoden brukte %d millisekund å gjennomføre.%n";
			for(int i = 0; i < 5; i++) {
				System.out.format(tekst, n[i], fn[i], utforingsTid[i]);
			}
		}
		
		public static void testIkkeRekursivFibonacci() {
			int[] n = new int[] {5, 32, 12, 45, 10};
			long[] fn = new long[5];
			long[] utforingsTid = new long[5];
			for(int i = 0; i < 5; i++) {
				long startTidspunkt = System.currentTimeMillis();		
				fn[i] = ikkeRekursivFibonacci(n[i]);
				long sluttTidspunkt = System.currentTimeMillis();
				utforingsTid[i] = sluttTidspunkt - startTidspunkt;
			}
			
			System.out.println("-- IKKE REKURSIV FIBONACCI --------------");
			String tekst = "Fibonaccitall %d er %d. "
					+ "Metoden brukte %d millisekund å gjennomføre.%n";
			for(int i = 0; i < 5; i++) {
				System.out.format(tekst, n[i], fn[i], utforingsTid[i]);
			}
		}
	}
}
