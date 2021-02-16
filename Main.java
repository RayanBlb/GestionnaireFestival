public class Main {

	public static void main(String[] args) {
		
		AllMenu.Login_menu();//lance le menu login permettant de se connecter ou de créer un compte
	    
			if(Compte.login_value == null && Compte.password_value == null) {	//si Compte.password_value et Compte.login_value sont null rien ne se passe, mais si elles sont true cela veux dire que l'utilisateur s'est connecté avec des identifiants et mots de passe valides ainsi il a acces à tout le programme
			}else if(Compte.login_value == true && Compte.password_value == true) {// les variable Compte.password_value et Compte.login_value permettent la verification des idenfiants et mots de passe
				
				AllMenu.Menu_Types_Application();//lance le menu type application
				
				
			}else {
				System.out.println("Erreur, Identifiant ou Mot de passe errone");// si Compte.password_value et Compte.login_value sont false, cela veut dire que le mot de passe ou l'identifiant sont erroné
				System.out.println("   ");
				System.out.println("   ");
				Main.main(null);//relance le main
			}
	}
}
