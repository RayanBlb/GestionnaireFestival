import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Application_Liste extends Liste_Setting {
	
//variable d'instance
private String type ,file_path;

//variable global
private static String []tableau_de_liste;
private static String uniteMes;
private static int nbArticle, prixOb, tailleStands, scannerPrix, scannerPosition, scannerMesureStands;
private static boolean error;

//Initialization scanner
static Scanner clavierInt = new Scanner(System.in);
static Scanner clavier = new Scanner(System.in);

//constructeur
public Application_Liste(String file_Path, String type){
    this.file_path = file_Path;
    this.type = type;
}

public static void Generateur_de_liste(Application_Liste liste){//methode permettant la création de liste dans un fichier txt
	int i=0;//correspond a la possition de la depense ou du stand dans la liste

    System.out.println("Entrer nombre "+liste.type);//liste.type correspond au type (stand ou depense)
    do {
    	error = true;
    	try {
    		clavierInt = new Scanner(System.in);
    		nbArticle = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas le nombre d'object (stand ou depense) de sa liste
	    	
	    }catch (java.util.InputMismatchException e) {
	    	System.out.println("Vous devez entrer des chiffres !!!");
	    	error = false;
	    }
    	
    }while(error == false);//fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
    
    System.out.println("quelle est votre monnaie ?" );
    
    String typeMonnaie = clavier.nextLine();//capture la saisie de l'utilisateur, dans notre cas le type de monnaie de l'utilisateur (Eur, dollars, franc suisse)

    if(AllMenu.test_type_application == false){ // cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
    System.out.println("quelle est votre unité de mesure ?" );
    uniteMes = clavier.nextLine(); //capture la saisie de l'utilisateur, dans notre cas le type d'unité de mesure (m2 ou autre)
    }
    
    for(i=1 ; i<=nbArticle; i++){// permet de créé une liste de i object
        
        System.out.println("Entrer titre de votre "+liste.type+" n°"+i);
        String titreOb = clavier.nextLine();//capture la saisie de l'utilisateur, dans notre cas le titre du type

        Fichier separateurHaut = new Fichier(liste.file_path, "   ");//création d'un object du type Fichier
        Fichier.ouverture_ecriture(separateurHaut);// permet de séparer les différents object dans le fichier txt

        Fichier objectNumero = new Fichier(liste.file_path, liste.type+" N°" +i);//création d'un object du type Fichier
        Fichier.ouverture_ecriture(objectNumero);//écrit dans le fichier le type ainsi que le numéro de l'object

        Fichier objectTitre = new Fichier(liste.file_path, "Titre : "+titreOb);//création d'un object du type Fichier
        Fichier.ouverture_ecriture(objectTitre);//écrit dans le fichier le titre de l'object
        
        
        if(AllMenu.test_type_application == false){// cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
        System.out.println("Estimez le prix de location du stand n°"+i);
        }else {
        	System.out.println("Entrez le prix de votre "+liste.type+" n°"+i);
        }
        do {
        	error = true;
        	try {
        		clavierInt = new Scanner(System.in);
        		prixOb = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas le prix de l'object (stand ou depense)
    	    	
    	    }catch (java.util.InputMismatchException e) {
    	    	System.out.println("Vous devez entrer des chiffres !!!");
    	    	error = false;
    	    }
        	
        }while(error == false);//fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence

        Fichier objectPrix = new Fichier(liste.file_path, "Prix : " +prixOb+typeMonnaie);//création d'un object du type Fichier
        Fichier.ouverture_ecriture(objectPrix);//écrit le prix de l'object dans le fichier

        if(AllMenu.test_type_application == false){// cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
        System.out.println("Entrez la taille pour le stands n°"+i);
        do {
        	error = true;
        	try {
        		clavierInt = new Scanner(System.in);
        		tailleStands = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas la taille du stand
    	    	
    	    }catch (java.util.InputMismatchException e) {
    	    	System.out.println("Vous devez entrer des chiffres !!!");
    	    	error = false;
    	    }
        	
        }while(error == false);//fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
        
        Fichier objectTaille = new Fichier(liste.file_path, "Taille : "+tailleStands+uniteMes);//création d'un object du type Fichier
        Fichier.ouverture_ecriture(objectTaille);//écrit la taille du stand dans le fichier 
        }
                    
        System.out.println("Entrer une description concernant votre "+liste.type+" n°"+i);
        String descrOb = clavier.nextLine();//capture la saisie de l'utilisateur, dans notre cas une rapide description de l'object (stands ou depense)

        Fichier objectDescr = new Fichier(liste.file_path, "Description : " +descrOb);//création d'un object du type Fichier
        Fichier.ouverture_ecriture(objectDescr);//écrit dans le fichier txt la description saisie par l'utilisateur

        Fichier separateurBas = new Fichier(liste.file_path,"   ");//création d'un object du type Fichier
        Fichier.ouverture_ecriture(separateurBas);//permet de séparer les différents object dans le fichier txt

        
    }
    
    System.out.println("Liste terminée, le fichier contenant la liste a été créé");// message afficher après création de la liste
    System.out.println("   ");
    
    AllMenu.Menu_Types_Application();//renvoie l'utilisateur au menu type d'application
    
    }

public static void Affichage_liste(Application_Liste affichage_liste) {//methode permettant d'afficher les liste créé
	File file = new File(affichage_liste.file_path);//création d'un object file, permet d'intéragire avec les fichier de notre systeme
	System.out.println("Voici votre liste de "+affichage_liste.type);

	if(file.exists()) {//si le fichier existe la situe d'instuction si dessous sera executer
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(affichage_liste.file_path),"UTF-8"));// création d'un memoir tampon afin de lire notre fichier (UTF-8 correspond a l'encodage de notre fichier en .txt) 
			String line = reader.readLine();//permet de lire notre fichier en .txt

			while(line != null) {//tant que line est différent de null 
				System.out.println(line);//en affiche la ligne
				line = reader.readLine();//line prend la valeur de la ligne en dessous 
			}
		
		reader.close();//une fois sortie de la boucle while, il faut fermer met la memoire tampon
		
		}catch (IOException e) {
			e.printStackTrace();//en cas d'erreur, permet de récuperé l'erreur est de l'affichier dans le terminale
			}
		}else {
			System.out.println("La liste n'existe pas");// si le fichier n'existe pas affichage de cette ligne
		}
	AllMenu.Menu_Types_Application();//une fois l'affichage de la liste terminer, retour au menu du type d'application
}
	

public static void Transfer_liste_tableau(Application_Liste liste_dans_tableau) {//permet de transférer le comptenu d'un fichier dans un tableau
	
	File file = new File(liste_dans_tableau.file_path);//création d'un object file, permet d'intéragire avec les fichier de notre systeme
	
	Liste_Setting.Taille_fichier_liste(liste_dans_tableau.file_path);//exécution de la méthode qui calcule le nombre de ligne d'un fichier

	if(file.exists()) {// si le fichier existe 
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(liste_dans_tableau.file_path),"UTF-8"));// création d'un memoir tampon afin de lire notre fichier
			String line = reader.readLine();//permet de lire notre fichier en .txt
			
			tableau_de_liste = new String[Liste_Setting.taille_tableau_fichier];//initialisation du tableau
				int i=0;//initialisation de la variable i
				
				while(line != null  && i < Liste_Setting.taille_tableau_fichier) {//tant que la line est différent de null et que i est inférieur a la taille du fichier 
					if(line.length()!=0) {//verifie si la ligne est différent de rien
					tableau_de_liste[i]=line;//si différent de rien, la ligne est stocker dans la premier case du tableau tableau_de_liste
					line = reader.readLine();//la ligne prend la valeur de la ligne suivante
					i++;//i incrémenté de 1
					}
					}
				reader.close();// une fois sortie de la boucle while, en ferme la mémoire tampon
				}
		catch (IOException e) {
			e.printStackTrace();//en cas d'erreur, permet de récuperé l'erreur est de l'affichier dans le terminale
		}
		}
	}

public static void Recherche_liste_Prix() {// permet de faire une recherche sur la liste en fonction du prix 
    System.out.println("Entrer le montant à rechercher");   
    do {
    	error = true;
    	try {
    		clavierInt = new Scanner(System.in);
    		scannerPrix = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas le prix a rechercher
	    	
	    }catch (java.util.InputMismatchException e) {
	    	System.out.println("Vous devez entrer des chiffres !!!");
	    	error = false;
	    }
    	
    }while(error == false);//fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
    
    int i=0;
    
    	 for(i=0; i<Liste_Setting.taille_tableau_fichier-1; i++) {
    		 if(Pattern.matches("^Prix :.*"+scannerPrix+"[a-z[A-Z]]*$", tableau_de_liste[i]) == true) {// vérifie chaque case du tableau, si une case est égale a ce qui est rechercher alors la comparaison renvoie true
    	            System.out.println(tableau_de_liste[i-2]);//permet d'affichier le titre, le prix, la position, la description ainsi que la taille pour un stand
    	            System.out.println(tableau_de_liste[i-1]);
    	            System.out.println(tableau_de_liste[i]);
    	            System.out.println(tableau_de_liste[i+1]);
    	            if(AllMenu.test_type_application == false) {// cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
    	            	System.out.println(tableau_de_liste[i+2]);
    	            }
    	            System.out.println("   ");
    	        }
    	    }
    AllMenu.Menu_Types_Application();//renvoie l'utilisateur au menu de type d'application
}

public static void Recherche_liste_position(String type) {// permet de faire une recherche sur la liste en fonction de la position de l'object rechercher 
	System.out.println("Entrer la position à rechercher");
    do {
    	error = true;
    	try {
    		clavierInt = new Scanner(System.in);
    		scannerPosition = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas la position a rechercher
	    	
	    }catch (java.util.InputMismatchException e) {
	    	System.out.println("Vous devez entrer des chiffres !!!");
	    	error = false;
	    }
    	
    }while(error == false);//fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
    
    int i=0;
    
    for(i=0; i<Liste_Setting.taille_tableau_fichier-1; i++) {
    	if(Pattern.matches("^"+type+" N°"+scannerPosition+"$", tableau_de_liste[i]) == true) {// vérifie chaque case du tableau, si une case est égale a ce qui est rechercher alors la comparaison renvoie true
            System.out.println(tableau_de_liste[i]);//permet d'affichier le titre, le prix, la position, la description ainsi que la taille pour un stand
            System.out.println(tableau_de_liste[i+1]);
            System.out.println(tableau_de_liste[i+2]);
            System.out.println(tableau_de_liste[i+3]);
            System.out.println(tableau_de_liste[i+4]);
            if(AllMenu.test_type_application == false) {// cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
            	System.out.println(tableau_de_liste[i+5]);
	            }
            System.out.println("   ");
        }
}
    AllMenu.Menu_Types_Application();//renvoie l'utilisateur au menu de type d'application
	
}

public static void Recherche_liste_description(){// permet de faire une recherche sur la liste en fonction d'un mot clé dans la description
	System.out.println("Entrer un ou plusieurs mots clés de la description");
    String scannerDescription =  clavier.nextLine();//capture la saisie de l'utilisateur, dans notre cas un mot clé de la description
    int i=0;
    for(i=0; i<Liste_Setting.taille_tableau_fichier-1; i++) {
        if(Pattern.matches("^Description :.*"+scannerDescription+".*$", tableau_de_liste[i]) == true) {// vérifie chaque case du tableau, si une case est égale a ce qui est rechercher alors la comparaison renvoie true
            if(AllMenu.test_type_application == false) {// cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
            System.out.println(tableau_de_liste[i-4]);//permet d'affichier le titre, le prix, la position, la description ainsi que la taille pour un stand
            }
            System.out.println(tableau_de_liste[i-3]);
            System.out.println(tableau_de_liste[i-2]);
            System.out.println(tableau_de_liste[i-1]);
            System.out.println(tableau_de_liste[i]);
            System.out.println("   ");
        }
}
    AllMenu.Menu_Types_Application();//renvoie l'utilisateur au menu de type d'application
}

public static void Recherche_liste_titre(){// permet de faire une recherche sur la liste en fonction du titre
System.out.println("Entrer le titre a rechercher");
String scannerTitre =  clavier.nextLine();//capture la saisie de l'utilisateur, dans notre cas le titre a rechercher
int i=0;

for(i=0; i<Liste_Setting.taille_tableau_fichier-1; i++) {
    if(Pattern.matches("^Titre :.*"+scannerTitre+".*$", tableau_de_liste[i]) == true) {// vérifie chaque case du tableau, si une case est égale a ce qui est rechercher alors la comparaison renvoie true
        System.out.println(tableau_de_liste[i-1]);//permet d'affichier le titre, le prix, la position, la description ainsi que la taille pour un stand
        System.out.println(tableau_de_liste[i]);
        System.out.println(tableau_de_liste[i+1]);
        System.out.println(tableau_de_liste[i+2]);
        if(AllMenu.test_type_application == false) {// cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
        System.out.println(tableau_de_liste[i+3]);
        }
        System.out.println("   ");
    }
}
AllMenu.Menu_Types_Application();//renvoie l'utilisateur au menu de type d'application
}

public static void Recherche_taille_stands(){// permet de faire une recherche sur la liste en fonction de la taille d'un stand
	System.out.println("Entrer la taille du stand recherché");
    do {
    	error = true;
    	try {
    		clavierInt = new Scanner(System.in);
    		scannerMesureStands = clavierInt.nextInt();//capture la saisie de l'utilisateur, dans notre cas la taille du stands a rechercher
	    	
	    }catch (java.util.InputMismatchException e) {
	    	System.out.println("Vous devez entrer des chiffres !!!");
	    	error = false;
	    }
    	
    }while(error == false);//fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
    
    int i=0;
    
    
    for(i=0; i<Liste_Setting.taille_tableau_fichier-1; i++) {// vérifie chaque case du tableau, si une case est égale a ce qui est rechercher alors la comparaison renvoie true
        if(Pattern.matches("^Taille :.*"+scannerMesureStands+"[a-z[A-Z][0-9]]*$", tableau_de_liste[i]) == true) {
            System.out.println(tableau_de_liste[i-3]);//permet d'affichier le titre, le prix, la position, la description ainsi que la taille pour un stand
            System.out.println(tableau_de_liste[i-2]);
            System.out.println(tableau_de_liste[i-1]);
            System.out.println(tableau_de_liste[i]);
            System.out.println(tableau_de_liste[i+1]);
            System.out.println("   ");
        }

}

    AllMenu.Menu_Types_Application();//renvoie l'utilisateur au menu de type d'application
}
//Assesseur 
public String getFile_path() {
	return file_path;
}

public String getType() {
	return type;
}
//mutateurs
public void setFile_path(String file_path) {
	this.file_path = file_path;
}

public void setType(String type) {
	this.type = type;
}
}
