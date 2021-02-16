import java.util.Scanner;

public class Application_Gestion {
	
	//variable globale
	static Scanner clavierInt;
	private static boolean error;
	private static int tailleTotal,superMoyens;
	
public static void Nombre_de_stands_possible() {//permet de calculer le nombre de stands possibles en fonction de la superficie du terrain
		
		int i = 0;
		
		System.out.println("Quelle est la superficie du terrain ? (en m2)");
		do {
	    	error = true;
	    	try {
	    		clavierInt = new Scanner(System.in);
	    		tailleTotal = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas la superficie du terrain
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);//fait en sorte que tant que l'utilisateur n'entre pas de chiffre le scanner recommence
    	
    	System.out.println("Quelle est la superficie moyens d'un stand ? (en m2)");
    	do {
	    	error = true;
	    	try {
	    		clavierInt = new Scanner(System.in);
	    		superMoyens = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas la superficie moyen d'un stand
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);//fait en sorte que tant que l'utilisateur n'entre pas de chiffre le scanner recommence
    	
    	int resteSuperfi = tailleTotal % superMoyens; //resteSuperfi correspond au reste de la division entre tailleTotal et superMoyens, autrement dit resteSuperfi correspond au reste de la superficie du terrain
    	
    	while(tailleTotal > resteSuperfi){ //tant que la tailleTotal est strictement superieur au resteSuperfi, on soustrait a tailleTotal la superficie moyens d'un stand
    		tailleTotal = tailleTotal - superMoyens;
    		i++; //i correspond au nombre de stands possible
    	}
    	
    	System.out.println("le nombre total de stand est de : "+i+ " avec un reste de superficie de : "+ resteSuperfi+"m2"); //affiche le nombre de stands possible, ainsi que le reste de superficie du terrain
    	System.out.println("  ");
    	System.out.println("  ");
    	AllMenu.Menu_Types_Application(); //renvoit l'utilisteur au menu type d'application
	}

}
