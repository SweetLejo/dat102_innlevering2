package oppg3oving5;

public interface Parentessjekker {
	/**
	* Metoden sjekker om et tegn er '(', '[' eller '{'.
	*
	* @param p tegn som skal sjekkes
	* @return true dersom tegnet er en venstrepareentes, false elles
	*/
	boolean erVenstreparentes(char p);
	/**
	* Metoden sjekker om et tegn er ')', ']' eller '}'.
	*
	* @param p tegn som skal sjekkes
	* @return true dersom tegnet er en hogreparentes, false elles
	*/
	boolean erHogreparentes(char p);
	/**
	* Metoden sjekkker om et tegn er en parentes.
	*
	* @param p tegn som skal sjekkes
	* @return true dersom tegnet er (', '[', '{', ')', ']' eller '}', false
	 ellers.
	*/
	boolean erParentes(char p);
	/**
	* Metoden sjekker om to tegn er et parentespar.
	*
	* @param venstre er første tegn i potensielt par
	* @param hogre er andre tegn i potensielt par
	*
	* @return true dersom de matcher, dvs. venstre er en venstreparentes og
	 * hogre er tilhørende høgreparentes
	*/
	boolean erPar(char venstre, char hogre);
	/**
	* Metoden sjekker om en streng som inneholder parenteser er balansert.
	 * Den ser bort fra tegn som ikke er parenteser.
	*
	* @param s streng som skal sjekkes
	* @return true dersom parentesene i strengen er balansert, false ellers.
	*/
	boolean erBalansert(String s);
}
