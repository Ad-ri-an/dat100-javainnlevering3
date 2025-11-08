package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggtabell;
    private int nesteledig;

	public Blogg() {

        this.innleggtabell = new Innlegg[20];
        this.nesteledig = 0;

		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public Blogg(int lengde) {

        this.innleggtabell = new Innlegg[lengde];
        this.nesteledig = 0;

		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public int getAntall() {

        return nesteledig;

		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public Innlegg[] getSamling() {

        return innleggtabell;

		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public int finnInnlegg(Innlegg innlegg) {

        for(int i = 0; i < nesteledig; i++){
            if(innleggtabell[i].erLik(innlegg)){
                return i;
            }
        }
        return -1;
		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean finnes(Innlegg innlegg) {

        return finnInnlegg(innlegg) != -1;

		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean ledigPlass() {

        return nesteledig < innleggtabell.length;

		//hrow new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTil(Innlegg innlegg) {

        if(!finnes(innlegg) && ledigPlass()){

            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        else {

            return false;
        }
		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public String toString() {

        String result = nesteledig + "\n";
        for(int i = 0; i < nesteledig; i++){

            result += innleggtabell[i].toString();
        }
        return result;
		//throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {

        Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
        for(int i = 0; i < nesteledig; i++){

            nyTabell[i] = innleggtabell[i];
        }

        innleggtabell = nyTabell;

		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

        if(finnes(innlegg)){

            return false;
        }

        if(!ledigPlass()){

            utvid();
        }

        innleggtabell[nesteledig] = innlegg;
        nesteledig++;
        return true;

		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean slett(Innlegg innlegg) {

        int indeks = finnInnlegg(innlegg);

        if(indeks == -1){
            return false;
        }

        innleggtabell[indeks] = innleggtabell[nesteledig - 1];
        innleggtabell[nesteledig - 1] = null;
        nesteledig--;
        return true;

		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {

        int[] temp = new int[nesteledig];
        int count = 0;

        for(int i = 0; i < nesteledig; i++){

            Innlegg innlegg = innleggtabell[i];

            if(innlegg instanceof Tekst){
                Tekst t = (Tekst) innlegg;

                if(t.getTekst().contains(keyword)){
                    temp[count] = t.getId();
                    count++;
                }
            }
        }

        int[] result = new int[count];
        for(int i = 0; i < count; i++){
            result[i] = temp[i];
        }
        return result;
		//throw new UnsupportedOperationException(TODO.method());
	}
}