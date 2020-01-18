package Carte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Carte {
	
	private static ArrayList<Sommet> sommets;
	private static ArrayList<Arc> arcs;
	
	
	public void creationGraphe() throws NumberFormatException, IOException {
		File graphe = new File("carte.txt"); // lecture fichier
		BufferedReader buffer = new BufferedReader(new FileReader(graphe));
		String line;
		int nodeNumber = Integer.parseInt(buffer.readLine()); // parser

		sommets = new ArrayList<Sommet>(); // liste sommets
		for (int i = 0; i < nodeNumber; i++)
			sommets.add(new Sommet(i));
		arcs = new ArrayList<Arc>();

		while ((line = buffer.readLine()) != null) { // liste arcs
			if (!line.isEmpty()) {
				String[] l = line.split(" ");
				int source = Integer.parseInt(l[0]);
				int value = Integer.parseInt(l[1]);
				int destination = Integer.parseInt(l[2]);
				Arc a = new Arc(sommets.get(source), sommets.get(destination), value);
				arcs.add(a);
				this.addArc(a);
			}

		}
		buffer.close(); // fin parser
	}
	
	public void dice() {
		
	}
	
	public void addArc(Arc a) { //ajoutez un arc
		if (taille() <= a.source.tag || taille() <= a.destination.tag)
			throw new IllegalArgumentException();
		else if (getNumSommet(a.source).successeurs.contains(a.destination))
			throw new IllegalArgumentException(
					"Il existe deja  une arrete entre ses deux sommets, vous essayez de faire quoi la  ?");
		else {
			getNumSommet(a.source).successeurs.add(a.destination); //successeur
			getNumSommet(a.source).successeursCopy.add(a.destination); //copie successeur pour reference
			getNumSommet(a.destination).predecesseur.add(a.source); //predecesseur
			getNumSommet(a.destination).predecesseurCopy.add(a.source); //copie predecesseur pour reference
			getNumSommet(a.source).arcsIncident.add(a);
		}
	}
	
	public int taille() { //taille d'un sommet
		return sommets.size();
	}
	
	public Sommet getNumSommet(Sommet n) {
		return sommets.get(sommets.indexOf(n));
	}
}
