package Jeu;

import Carte.CarteMat;
import Serialisation.Serialisation;
import main.Partie;

public class Jeu {

	public static int lancerD(int i) {
		int compt = 0;
		for(int j =0; j < i; j++) {
			compt += aleatoire();
		}
		return compt;
	}

	public static int aleatoire() {
		return 1 + (int)(Math.random() * ((6 - 1) + 1));
	}

	public static void maj(int a, int b) { // a = attaquant ; b = attaquee
		int compt = 0;
		int joueur = CarteMat.mapJ[(a/10)][(a%10)];

		if(a > b) {
			CarteMat.mapJ[(b/10)][(b%10)] = CarteMat.mapJ[(a/10)][(a%10)];
			CarteMat.mapD[(b/10)][(b%10)] = CarteMat.mapD[(a/10)][(a%10)] - 1;
			CarteMat.mapD[(a/10)][(a%10)] = 1;
		}
		
		if( b > a) {
			CarteMat.mapD[(a/10)][(a%10)] = 1;
		}



		for(int i = 0; i < CarteMat.mapJ.length; ++i) {
			for(int j = 0; j < CarteMat.mapJ[i].length; ++j) {
				if(CarteMat.mapJ[i][j] == joueur)
					compt++;
			}
		}
		if(compt == CarteMat.cmpt)
			System.out.println("Victoire");
	}

	public static void newD() {

	}
	
	
	public static void sauvegarde() {
		
		Serialisation.writeObj(CarteMat.mapJ);
		Serialisation.writeObj(CarteMat.mapD);
		for(int i = 0; i < Partie.nbrj; i++) {
			Serialisation.writeObj(Partie.joueurs.get(i));
		}
		
	}
}
