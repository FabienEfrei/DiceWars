package Joueur;

import main.Main;

public class Joueur {
	
	private static int ID;
	
	public Joueur(int ID) {
		
		this.setID(ID);
		
	}

	public static int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	
	public void jouer() {
		String a = Main.sc.next();
		if(a == "q") {
			System.out.println("Fin du programme");
		}
	}
}
