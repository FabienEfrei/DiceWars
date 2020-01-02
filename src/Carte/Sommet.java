package Carte;

import java.util.ArrayList;

public class Sommet {

	public int tag;
	public int rang;
	public int dateTot, dateTard, incidentValue;
	public ArrayList<Sommet> successeurs;
	public ArrayList<Sommet> successeursCopy;
	public ArrayList<Sommet> predecesseur;
	public ArrayList<Sommet> predecesseurCopy;
	public ArrayList<Arc> arcsIncident;

	public Sommet(int name) {
		this.tag = name;
		this.rang = 0;
		this.dateTot = 0;
		this.dateTard = 0;
		this.incidentValue = 0;
		successeurs = new ArrayList<Sommet>();
		successeursCopy = new ArrayList<Sommet>();
		predecesseur = new ArrayList<Sommet>();
		predecesseurCopy = new ArrayList<Sommet>();
		arcsIncident = new ArrayList<Arc>();
	}

	public Sommet(Sommet n) {
		this.tag = n.tag;
		this.rang = n.rang;
		successeurs = new ArrayList<Sommet>(n.successeurs);
		successeursCopy = new ArrayList<Sommet>(n.successeursCopy);
		predecesseur = new ArrayList<Sommet>(n.predecesseur);
		predecesseurCopy = new ArrayList<Sommet>(n.predecesseurCopy);
		arcsIncident = new ArrayList<Arc>(n.arcsIncident);
	}

	@Override
	public String toString() {
		return String.valueOf(this.tag);
	}

	public int max(ArrayList<Sommet> sommets) {
		int max = Integer.MIN_VALUE;
		for (Sommet som : sommets)
			if (som.incidentValue > max)
				max = som.incidentValue;
		return max;
	}

	public int calculMargeTotal() {
		return dateTard - dateTot;
	}

	public boolean arcsSortie(Sommet incident) {
		if (successeurs.contains(incident))
			return true;
		return false;
	}

	public void remiseAZero() {
		this.predecesseur = new ArrayList<Sommet>(this.predecesseurCopy);
		this.successeurs = new ArrayList<Sommet>(this.successeursCopy);

	}
	
}

