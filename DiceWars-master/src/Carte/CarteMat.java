package Carte;

import main.Partie;

public class CarteMat {

	public static int cmpt = 0; //compteur du nombre de terrain jouable
	
	
	public static int mapInit[][] = {{0,1,0,0,0,0,1,1,0,0}, // init des cases jouable 1=jouable ; 0=non jouable
								  	 {0,1,0,0,0,0,1,1,0,0}, 
								 	 {1,1,1,1,1,1,1,0,0,0}, 
								 	 {1,1,0,0,0,1,0,0,0,0}, 
								 	 {1,1,0,0,1,1,1,0,0,0},
								 	 {1,1,1,0,1,1,1,1,1,0}, 
								 	 {0,1,1,0,0,1,0,1,1,1}, 
								 	 {0,0,1,1,0,0,0,0,1,0},
								 	 {0,0,1,1,0,0,0,0,1,1},
								 	 {0,0,0,0,0,0,0,0,1,1}};
	public static int mapID[][] = {{0,1,2,3,4,5,6,7,8,9}, //ID de chaque case de jeu
								   {10,11,12,13,14,15,16,17,18,19}, 
								   {20,21,22,23,24,25,26,27,28,29}, 
								   {30,31,32,33,34,35,36,37,38,39}, 
								   {40,41,42,43,44,45,46,47,48,49},
								   {50,51,52,53,54,55,56,57,58,59}, 
								   {60,61,62,63,64,65,66,67,68,69}, 
								   {70,71,72,73,74,75,76,77,78,79},
								   {80,81,82,83,84,85,86,87,88,89},
								   {90,91,92,93,94,95,96,97,98,99}};
	public static int mapJ[][] ={{0,0,0,0,0,0,0,0,0,0},  // Le num du joueurs qui possede la case
		  	 				 	 {0,0,0,0,0,0,0,0,0,0}, 
		  	 				 	 {0,0,0,0,0,0,0,0,0,0}, 
		  	 				 	 {0,0,0,0,0,0,0,0,0,0}, 
		  	 				 	 {0,0,0,0,0,0,0,0,0,0},
		  	 				 	 {0,0,0,0,0,0,0,0,0,0}, 
		  	 				 	 {0,0,0,0,0,0,0,0,0,0}, 
		  	 				 	 {0,0,0,0,0,0,0,0,0,0},
		  	 				 	 {0,0,0,0,0,0,0,0,0,0},
		  	 				 	 {0,0,0,0,0,0,0,0,0,0}};
	public static int mapD[][] ={{0,0,0,0,0,0,0,0,0,0},  // nbr de des possede par case
								 {0,0,0,0,0,0,0,0,0,0}, 
								 {0,0,0,0,0,0,0,0,0,0}, 
								 {0,0,0,0,0,0,0,0,0,0}, 
								 {0,0,0,0,0,0,0,0,0,0},
								 {0,0,0,0,0,0,0,0,0,0}, 
								 {0,0,0,0,0,0,0,0,0,0}, 
								 {0,0,0,0,0,0,0,0,0,0},
								 {0,0,0,0,0,0,0,0,0,0},
								 {0,0,0,0,0,0,0,0,0,0}};
	
	public static void initialisation(int nbrj) {
		for(int i = 0; i < mapInit.length; ++i)
			for(int j = 0; j < mapInit[i].length; ++j)
				if(mapInit[i][j] == 1)
					++cmpt;
		//int x = (cmpt/nbrj) +1;
		for(int i = 0; i < mapInit.length; ++i)
			for(int j = 0; j < mapInit[i].length; ++j)
				if(mapInit[i][j] == 1) {
					int nbrAleaJ = 1 + (int)(Math.random() * ((nbrj - 1) + 1));
					int nbrAleaD = 1 + (int)(Math.random() * ((6 - 1) + 1));
					mapJ[i][j] = Partie.joueurs.get(nbrAleaJ - 1).getID() + 1;
					mapD[i][j] = nbrAleaD;
				}	
	}
	
	public static int getJ(int i) { // doit avoir en paraemtre un ID, retourne le joueur sur la case
		return mapJ[i/10][i%10];
	}
	
	public static int getD(int i) { // Doit avoir en parametre un ID, retourne le nbr de des sur la case
		return mapD[i/10][i%10];
	}
	
	public static int[] getV(int i) { // Doit avoir en parametre un ID retourne un tableau des ID des voisins
		int[] retour = null;
		if(mapInit[(i/10)+1][(i%10)] == 1 )
			retour = new int[mapID[(i/10)+1][(i%10)]];
		if(mapInit[(i/10)-1][(i%10)] == 1 )
			retour = new int[mapID[(i/10)-1][(i%10)]];
		if(mapInit[(i/10)][(i%10)+1] == 1 )
			retour = new int[mapID[(i/10)][(i%10)+1]];
		if(mapInit[(i/10)][(i%10)-1] == 1 )
			retour = new int[mapID[(i/10)][(i%10)-1]];
		return retour;
		
	}
	
	public static void setJ(int i, int j) { // parametre i ID de la case, parametre J num du nouveau joueur
		mapJ[i/10][i%10] = j;
	}
	
	public static void setD(int i, int j) { // parametre i ID de la case, parametre J nouveau nombre de des
		mapD[i/10][i%10] = j;
	}
	
	public static void affichage() {
		for(int i = 0; i < mapJ.length; ++i) {
			for(int j = 0; j < mapJ[i].length; ++j) {
				if (mapJ[i][j] == 0)
					System.out.print("        | ");
				else
					System.out.print("J:" + mapJ[i][j] + " D:" + mapD[i][j] + " | ");
			}
				System.out.println();
				System.out.print("---------------------------------------------------------------------------------------------------");
				System.out.println();
		}
			
	}
}
