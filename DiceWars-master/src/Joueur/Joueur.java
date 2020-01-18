package Joueur;

import java.util.Scanner;

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
}
