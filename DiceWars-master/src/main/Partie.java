package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Carte.CarteMat;
import Joueur.Joueur;

public class Partie {


	public static Scanner sc = new Scanner(System.in);

	public static int map[][]; // map of the game
	public static boolean init;
	public static ArrayList<Joueur> joueurs;
	public static int nbrj = 0;



	public static void main(String[] args) throws NumberFormatException, IOException {

		while(!init) {
			joueurs = new ArrayList<Joueur>();
			
			while(nbrj < Integer.parseInt(args[0]))
			{
				Joueur a = new Joueur(nbrj);
				a.setID(nbrj);
				joueurs.add(a);
				nbrj++;
			}
			init = true;
		}

		CarteMat.initialisation(nbrj);
		CarteMat.affichage();


	}
}
