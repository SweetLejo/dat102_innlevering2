package no.hvl.dat102;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.listeklient.Person;

public class TekstGrensesnitt implements AutoCloseable {
	private Scanner scanner;
	
	public TekstGrensesnitt() {
		scanner = new Scanner(System.in);
	}
	
	public String lesCommand() {
		return scanner.nextLine();
	}

	public Person lesPerson() {
		int forsoek = 3;
		while(forsoek > 0) {
			System.out.println("Gi 'fornavn etternavn fødselsår'");
			try {
				String[] input = scanner.nextLine().split(" ");
				String fornavn = input[0];
				String etternavn = input[1];
				for(int i = 2; i < input.length - 1; i++)
					etternavn += " " + input[i];
				int foedselsaar = Integer.parseInt(input[input.length - 1]);
				
				return new Person(fornavn, etternavn, foedselsaar);
	
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
				System.err.println("Feil format. " + forsoek + " forsøk igjen.");
				forsoek--;
			} catch (NoSuchElementException e) {
				System.err.println("Programfeil: " + e.getMessage());
				forsoek = -1;
			} 
		}
		throw new IllegalArgumentException("For mange forsøk.");
	}
	
	public void skrivPerson(Person person) {
		System.out.println(person);
	}
	
	public void skrivHelp() {
		String format = "%16s: %12s: %58s\n";
		String overskrift = String.format(format, "COMMANDS", "PARAMETER", "FORKLARING");
		String help = String.format(format, "help", "", "Vis mulige commands i consollen");
		String lesPerson = String.format(format, "lesPerson", "", "Leser inn en ny person fra consollen");
		String skrivPerson = String.format(format, "skrivPerson", "", "Skriver ut en person");
	}
	
	@Override
	public void close() throws Exception {
		scanner.close();
	}
	
	
	
}
