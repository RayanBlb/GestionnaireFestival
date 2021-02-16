import java.util.Scanner;

public class Application_Finance {
	
	//variable globale
	private static Float benefice,prixBillet,argentInvers;
	static Scanner clavierFloat;
	private static boolean error;
	
public static void Nombre_place_a_vendre() {//application Nombre_place_a_vendre, permet de calculer le nombre de billets à vendre en fonction du bénéfice, de l'investissement, et du prix des billets 
		
		int i = 0; //initialisation de i, i correspond au nombre de billets à vendre
		
		System.out.println("Quels bénéfices voulez vous faire ? (en euro)");
		
	    do {
	    	error = true;
	    	try {
	    		clavierFloat = new Scanner(System.in);
	    		benefice = clavierFloat.nextFloat();//capture la saisie de l'utilisateur, dans notre cas le bénéfice à réaliser
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);//fait en sorte que tant que l'utilisateur n'entre pas de chiffre le scanner recommence
    	
    	System.out.println("Prix des billets ? (en euro)");
    	
    	do {
	    	error = true;
	    	try {
	    		clavierFloat = new Scanner(System.in);
	    		prixBillet = clavierFloat.nextFloat();//capture la saisie de l'utilisateur, dans notre cas le prix des billets
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);//fait en sorte que tant que l'utilisateur n'entre pas de chiffre le scanner recommence
    	
    	System.out.println("quantité d'argent investi ? (en euro)");
    	do {
	    	error = true;
	    	try {
	    		clavierFloat = new Scanner(System.in);
	    		argentInvers = clavierFloat.nextFloat();//capture la saisie de l'utilisateur, dans notre cas l'argent investi
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    }while(error == false);//fait en sorte que tant que l'utilisateur n'entre pas de chiffre le scanner recommence
    	
    	argentInvers = -argentInvers; //argent investi devient négatif
    	
    	while(argentInvers < benefice) { //tant que l'argent investi est inférieur au bénéfice, argent inverstion devient égale a l'argent investi plus prix  d'un billets et i est incrémenté de 1 (i correspond au nombre de billets)
    		argentInvers = argentInvers + prixBillet;
    		i++;
    	}
    	System.out.println("le nombre total de place à vendre est de : "+i+" Billets"); //affichage du résultat
    	System.out.println("    ");
    	AllMenu.Menu_Types_Application();//renvoit l'utilisateur au menu de type d'application
    	}
}
