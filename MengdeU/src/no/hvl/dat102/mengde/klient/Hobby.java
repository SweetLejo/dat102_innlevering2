package no.hvl.dat102.mengde.klient;

public class Hobby {
    private String hobbyNavn;


    public Hobby(String hobbyNavn){
        this.hobbyNavn = hobbyNavn;
    }


    //git ikke menging hva de spurte om i oppgaven
    @Override
    public String toString(){
        return "<" + hobbyNavn + ">";
    }


    public boolean equals(Object other){

    }

}
