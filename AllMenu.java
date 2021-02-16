import java.util.Scanner;

public class AllMenu {
	
	//variable global
	private static String login;
	private static int choixAppli;
	protected static boolean test_type_application;
	private static boolean error;
	
	//initialisation des scanner
	static Scanner choixClavier;
	static Scanner clavierString = new Scanner(System.in);
	
	//1ere methode qui correspond au menu de connexion
	public static void Login_menu() {
		
		System.out.println("Bonjour et bienvenue dans notre nouveau programme de gestion de festival, veuillez vous connecter ou créer un compte.");
		System.out.println("1-Connexion");
	    System.out.println("2-Créer un compte"); //affichage des différentes options du menu
	    
	    do {
	    	error = true;
	    	try {
		    	choixClavier = new Scanner(System.in);
		    	choixAppli = choixClavier.nextInt(); //capture ce que l'utilisateur entre
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");// si ce n'est pas des chiffres la boucle recommance sinon en sort de la boucle est le programme lance une application en fonction du chiffre donner
		    	error = false;
		    }
	    	
	    }while(error == false); //boucle do while qui permet de ne plus avoir d'erreur lorque l'utilisateur entre autre chose que des chiffres, tant que l'utilisateur n'entre pas de chiffre la bouche recommence
	 
	    
	    switch (choixAppli) {// lance une application en fonction du chiffre donner
		  case 1: // premier application permet la connexion au logiciel
			  
			  
			  System.out.println("Saisissez votre identifiant: ");
			  login = clavierString.nextLine(); //récuper l'identifiant de l'utilisateur
			  
			  if(login.length()==0) { //verifie que l'identifiant correspond bien a une chaine de caractère, sinon l'utilisateur est renvoyer au menu de connection
				  System.out.println("aucun identifiant entré");
				  System.out.println("  ");
				  AllMenu.Login_menu();
			  }
			  
			  System.out.println("Saisisez votre mot de passe: ");
			  String password = clavierString.nextLine(); // recuperation du mot de passe
			  
			  Compte loginUser = new Compte("LoginPassword.txt",login,password); // création d'un objet Compte
			  
			  Compte.Login_test(loginUser); //lancement de la methode login_test, methode qui permet de vérifier que le compte a bien été créé
			  
			  break;
			  
		  case 2: // deuxième application permet la création d'un compte
			  
			  System.out.println("Saisissez un identifiant: ");
			  String loginRegister = clavierString.nextLine(); //recuperation de l'identifiant a enregister
			  
			  if(loginRegister.length()==0) { //verifie que l'identifiant correspond bien a une chaine de caractère, sinon l'utilisateur est renvoyer au menu de connection
				  System.out.println("aucun identifiant entré");
				  System.out.println("  ");
				  AllMenu.Login_menu();
			  }
			  
			  System.out.println("Saisissez un mot de passe: ");
			  String passwordRegister = clavierString.nextLine(); //recuperation du mot de passe a enregister
			  
			  if(passwordRegister.length()==0) {//verifie que le mot de passe correspond bien a une chaine de caractère, sinon l'utilisateur est renvoyer au menu de connection
				  System.out.println("aucun mot de passe entré");
				  System.out.println("  ");
				  AllMenu.Login_menu();
			  }
			  
			  Compte registerUser = new Compte("LoginPassword.txt",loginRegister,passwordRegister); //création d'un object compte
			  
			  Compte.register(registerUser); //lancement de la methode register qui permet de créé un compte.
			  
			  Main.main(null); //renvoie au main afin de pouvoir ce connecter
			  
			  
			  break;
			  
		  default: 
			  System.out.println("Ce choix n'existe pas !!!"); //reponse par defaut si le chiffre entrée par l'utilisateur est différent de 1 ou 2
			  AllMenu.Login_menu();
			  
	}
	}
	
	public static void Menu_Types_Application() { //2eme menu, menu qui correspond au type d'application a choisir après connection
		
		System.out.println("Bienvenue "+AllMenu.login+" choisissez un type d'application.");
		System.out.println("1-Application de Finance");
		System.out.println("2-Application de Gestion"); //affiche les différents types d'applications
		System.out.println("3-Deconnexion");
		
	    do {
	    	error = true;
	    	try {
		    	choixClavier = new Scanner(System.in);
		    	choixAppli = choixClavier.nextInt(); //capture la saisie de l'utilisateur
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);// fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
	    
		switch (choixAppli) {
		  case 1: //permet d'accéder au menu des applications de finance
			  test_type_application = true; //varible permettant a certaine application de ce comporter différemment
			  AllMenu.Finance_Menu(); //lance le menu finance situer un peu plus bas dans la class
			  
		  break;

		  case 2://permet d'accéder au menu des applications de gestion
			  test_type_application = false;//varible permettant a certaine application de ce comporter différemment
			  AllMenu.Gestion_Menu(); //lance le menu gestion situer un peu plus bas dans la class
			  
		  break;
		  
		  case 3://permet a l'utilisateur de se déconnecter
			  Main.main(null); //renvoie au main afin de pouvoir de reconnecter 
		  break;

		  default: System.out.println("Ce choix n'existe pas !!!");//reponse par defaut si le chiffre entrée par l'utilisateur est différent de 1 ou 2
		  AllMenu.Menu_Types_Application();
		  }
		}
	
	private static void Finance_Menu(){ //3eme menu, menu des applications de finance
		
		System.out.println("Bienvenue dans le menu finance, ici vous trouverez toutes les applications dont vous avez besoin pour gérer vos finance");
		System.out.println("Choisir une application");
		System.out.println("1-Gestion de liste de depense");
		System.out.println("2-nombre de places minimum a vendre");
		System.out.println("3-Retour au menu précédent"); //affiche les différentes applications de finance
	    
	    do {
	    	error = true;
	    	try {
		    	choixClavier = new Scanner(System.in);
		    	choixAppli = choixClavier.nextInt(); //capture de la saisie de l'utilisateur
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);// fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
		
		switch (choixAppli) {
		
		  case 1: //lance le menu de gestion des liste
			  AllMenu.Liste_menu("Dépenses");
			  break;
			  
		  case 2:
			  Application_Finance.Nombre_place_a_vendre(); //lance l'application Nombre_place_a_vendre
			  break;
		  case 3:
			  
			  AllMenu.Menu_Types_Application(); //bouton retour permettant de se rendre au menu du type d'application
			  
			  break;
		  default: 
			  System.out.println("Ce choix n'existe pas !!!");//reponse par defaut si le chiffre entrée par l'utilisateur est différent de 1,2 ou 3
			  AllMenu.Finance_Menu();//renvoie l'utilisateur au menu des applications de finance
		}
	}
	
	private static void Gestion_Menu(){//4eme menu, menu des applications de gestion
		
			System.out.println("Bienvenue dans le menu gestion, ici vous trouverez toutes les applications afin de mener à bien la gestion de votre festival");
			System.out.println("Choisir une application");
			System.out.println("1-Gestion de liste de stands");
			System.out.println("2-Nombre de stands possible");
			System.out.println("3-Retour au menu précédent"); //affiche les différentes applications de gestion
		    
		    do {
		    	error = true;
		    	try {
			    	choixClavier = new Scanner(System.in);
			    	choixAppli = choixClavier.nextInt(); //capture de la saisie de l'utilisateur
			    	
			    }catch (java.util.InputMismatchException e) {
			    	System.out.println("Vous devez entrer des chiffres !!!");
			    	error = false;
			    }
		    	
		    }while(error == false);// fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
			
			switch (choixAppli) {
			  case 1: //lance le menu de gestion des liste
				  AllMenu.Liste_menu("Stand");
				  break;
			  
			  case 2:
				  Application_Gestion.Nombre_de_stands_possible(); //lance l'application Nombre_de_stands_possible
				  break;
				  
			  case 3:
				  
				  AllMenu.Menu_Types_Application();//bouton retour permettant de se rendre au menu du type d'application
				  
				  break;
			  
			  default: System.out.println("Ce choix n'existe pas !!!");//reponse par defaut si le chiffre entrée par l'utilisateur est différent de 1,2 ou 3
			  AllMenu.Gestion_Menu();//renvoie l'utilisateur au menu des applications de gestion
			}  
	}
	
	private static void Liste_menu(String type) {//5eme menu, menu des applications de gestion de liste, ce menu s'adapte en fonction du type de liste a manipuler (liste de stands ou de dépense) d'ou l'utilisation d'un argument type
		
		System.out.println("Bonjour est bienvenue dans le menu de gestion de liste");
		System.out.println("Ici vous trouverez diverses applications afin de manipuler votre liste de "+type);
		System.out.println("1-Créér un liste de "+type);
		System.out.println("2-Effacer la liste créér");
		System.out.println("3-afficher la liste deja créée");
		System.out.println("4-Faire une recherche sur votre liste");
		System.out.println("5-Retour au menu de selection des applications");//affiche les différentes applications de gestion des listes
	    do {
	    	error = true;
	    	try {
		    	choixClavier = new Scanner(System.in);
		    	choixAppli = choixClavier.nextInt();//capture de la saisie de l'utilisateur
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);// fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
	    Application_Liste Creation_liste = new Application_Liste("liste_"+type+"_"+AllMenu.login+".txt", type); //création d'un object Application_Liste (String type permet de specifier le type de liste (stands, dépense) AllMenu.login permet de specifier le nom d'utilisateur a qui appartient cette liste)
		switch (choixAppli) {
		  case 1:
			  Application_Liste.Generateur_de_liste(Creation_liste);//lance l'application Generateur de liste, application qui permet de créé une liste en fonction du type de liste a créé(depense ou stands) ainsi que du nom du fichier dans le quels la liste va être créé
			  break;
			  
		  case 2:
			  Fichier effacement_contenu_fichier = new Fichier("liste_"+type+"_"+AllMenu.login+".txt","le contenu de la liste a bien été effacé");//création d'un object fichier
			  Fichier.Effacement_Fichier(effacement_contenu_fichier);//lancement de la méthode Effacement_Fichier qui permet d'effacer le contenu d'un fichier
			  AllMenu.Menu_Types_Application();//renvoie l'utilisateur vers le menu du type d'application
			  break;
		  
		  case 3:
			  Application_Liste.Affichage_liste(Creation_liste); //application permettant d'affichier la liste créé en fonction du titre du fichier txt
			  break;
			  
		  case 4:
			  AllMenu.Liste_Recherche_menu(type); //lance le menu recherche dans liste
			  break;
			  
		  case 5:
			  if(test_type_application == true) { //en fonction de la valeur de la variable test_type_application le bouton retour nous renvoie soit au menu finance soit au menu gestion
				  AllMenu.Finance_Menu();
			  }else if (test_type_application == false) {
				  AllMenu.Gestion_Menu();
			  }
			  break;
		  
		  default: System.out.println("Ce choix n'existe pas !!!");//reponse par defaut si le chiffre entrée par l'utilisateur est différent de 1,2,3 ou 4
		  AllMenu.Liste_menu(type);//renvoie l'utilisateur au menu des applications de liste
		}  
		
		
	}
	private static void Liste_Recherche_menu(String type) {//6eme menu, menu des applications de recherche sur une liste, ce menu s'adapte en fonction du type de liste a manipuler (liste de stands ou de dépense) d'ou l'utilisation d'un argument type
		
		System.out.println("1-Faire une recherche en fonction du prix");
		System.out.println("2-Faire une recherche en fonction de la position de votre "+type+" recherchée");
		System.out.println("3-Faire une recherche en fonction d'un mot clé de la description");
		System.out.println("4-Faire une recherche en fonction du titre"); //affiche le menu des applications
		if(test_type_application == false) {
			System.out.println("5-Faire une recherche en fonction de la taille du stands recherché");// cette options apparaît uniquement lorsque nous accédent a cette application via le type d'application Gestion
		}
		System.out.println("6-Retour au menu de gestion de liste");
		
		Application_Liste transfer_liste_dans_tableau = new Application_Liste("liste_"+type+"_"+AllMenu.login+".txt", type); //création de l'object Application_Liste
	    
	    do {
	    	error = true;
	    	try {
		    	choixClavier = new Scanner(System.in);
		    	choixAppli = choixClavier.nextInt();//capture de la saisie de l'utilisateur
		    	
		    }catch (java.util.InputMismatchException e) {
		    	System.out.println("Vous devez entrer des chiffres !!!");
		    	error = false;
		    }
	    	
	    }while(error == false);// fait en sorte que tant que l'utilisateur n'entrer pas de chiffre le scanner recommence
		
		switch (choixAppli) {
		  case 1:
			  Application_Liste.Transfer_liste_tableau(transfer_liste_dans_tableau); //lance l'application Transfer_liste_tableau, application qui permet de transférer la liste de stands ou de depense dans un tableau afin de faciliter les recherches
			  Application_Liste.Recherche_liste_Prix();  //lance l'application permettant de rechercher en fonction du prix
			  break;
		  
		  case 2:
			  Application_Liste.Transfer_liste_tableau(transfer_liste_dans_tableau);
			  Application_Liste.Recherche_liste_position(type);  //lance l'application permettant de rechercher en fonction de la possition de l'object rechercher
			  break;
			  
		  case 3:
			  Application_Liste.Transfer_liste_tableau(transfer_liste_dans_tableau);
			  Application_Liste.Recherche_liste_description(); //lance l'application permettant de rechercher en fonction d'un mot clé dans la description
			  break;
		  
		  case 4:
			  Application_Liste.Transfer_liste_tableau(transfer_liste_dans_tableau);
			  Application_Liste.Recherche_liste_titre(); //lance l'application permettant de rechercher en fonction du titre
			  break;
			  
		case 5:
			if(test_type_application == false) { // cette options apparaît uniquement lorsque nous accédant a cette application via le type d'application Gestion
				Application_Liste.Transfer_liste_tableau(transfer_liste_dans_tableau);
				Application_Liste.Recherche_taille_stands(); //lance l'application permettant de rechercher en fonction de la taille du stands rechercher
			}else {
				System.out.println("Ce choix n'existe dans cette catégorie !!!");
				System.out.println("    ");
				AllMenu.Liste_menu(type);
			}
			  break;
			  
		case 6:
			AllMenu.Liste_menu(type);//bouton retour qui renvoie l'utilisateur au menu précédent
			  break;
		  
		  default: System.out.println("Ce choix n'existe pas !!!");//reponse par defaut si le chiffre entrée par l'utilisateur est différent de 1,2,3,4,5 ou 6
		  AllMenu.Liste_menu(type);//renvoie l'utilisateur au menu des applications de recherche
		}  
		
	}
}
