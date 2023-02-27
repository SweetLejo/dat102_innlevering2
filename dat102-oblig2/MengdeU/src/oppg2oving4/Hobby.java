package oppg2oving4;

public class Hobby { 
	private String hobbyNavn;  
	public Hobby(String hobby){ 
		hobbyNavn = hobby; 
	} 
	public String toString(){ 
		return "<" + hobbyNavn + ">";
	} 
	public boolean equals(Object hobby2){  
		//eventuelt fylle ut først med "standard" kode        
		//som vi ofte har med overkjøring av 
		//equals-metoden generert av Eclipse 
		Hobby hobbyDenAndre = (Hobby)hobby2; 
		return(hobbyNavn.equalsIgnoreCase(hobbyDenAndre.getHobbyNavn())); 
	} 
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
}