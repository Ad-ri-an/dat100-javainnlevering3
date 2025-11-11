package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

        Blogg samling = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(mappe, filnavn)))) {
            int antall = Integer.parseInt(reader.readLine());
            samling = new Blogg(antall);

            for (int i = 0; i < antall; i++) {
                String type = reader.readLine();
                int id = Integer.parseInt(reader.readLine());
                String bruker = reader.readLine();
                String dato = reader.readLine();
                int likes = Integer.parseInt(reader.readLine());
                String tekst = reader.readLine();

                Innlegg innlegg;

                if (type.equals(TEKST)) {
                    innlegg = new Tekst(id, bruker, dato, likes, tekst);
                } else {
                    String url = reader.readLine();
                    innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                }

                samling.leggTilUtvid(innlegg);
            }

        } catch (IOException e) {
            System.out.println("Feil ved lesing av fil: " + e.getMessage());
        }

        return samling;

		//throw new UnsupportedOperationException(TODO.method());
	}
}
