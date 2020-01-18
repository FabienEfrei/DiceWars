package Joueur;

import java.util.Scanner;

import Carte.CarteMat;
import Jeu.Jeu;

public class Joueur {
	
	private static Scanner sc = new Scanner(System.in);
	
	private int ID;
	
	public Joueur(int ID) {
		
		this.setID(ID);
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	
	public void jouer() {
		String a = sc.next();
		if(a == "q") {
			System.out.println("Fin du programme");
		}
	}
	
	public void attaquer (int at, int ae) { // at = attaquant ; ae = attaquee
		int a = Jeu.lancerD(CarteMat.mapD[at/10][at%10]);
		int b = Jeu.lancerD(CarteMat.mapD[ae/10][ae%10]);
		Jeu.maj(a, b);
	}
}
