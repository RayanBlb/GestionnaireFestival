import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Compte{
	
	//variable d'instance
	private String file_path;
	private String login;
	private String password;
	
	
	//variable global
	protected static Boolean login_value,password_value;
	
	//initialisation clavier
	static Scanner clavier = new Scanner(System.in);
	
	//constructeur
	public Compte(String file_path, String login, String password) {
		this.file_path = file_path;
		this.login = login;
		this.password = password;
	}
	
	public static void Login_test(Compte login) {//methode Login_test qui permet de vérifier si les identifiants et mots de passes saisis par l'utilisateur sont correctes
		File file = new File(login.file_path);//création d'un object file, permet d'intéragir avec les fichiers de notre systeme

		if(file.exists()) {//si le fichier existe
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(login.file_path),"UTF-8"));//création d'une mémoire tampon afin de lire le fichier
				String line = reader.readLine();//permet de lire notre fichier en .txt
				login_value = false;//initialisation des booleans
				password_value = false;

				while(line != null) {//tant que la ligne est différente de null
					if(line.startsWith("Identifiant : "+login.login)){// si la ligne correspond a "Identifiant : "+login.login alors login_value prend la valeur true
						login_value = true;
					}else if(line.startsWith("Mot de passe : "+login.password)){//si la ligne correspond à "Mot de passe : "+login.password alors password_value prend la valeur true ainsi si l'identifiant et le mot de passe sont vérifié, le reste du programme est accessible
						password_value = true;
						break;
						}
					
					line= reader.readLine(); //line prend la valeur de la ligne suivante
					
					}
				
				reader.close();//fermeture de la mémoire tampon
				
				}catch (IOException e) {
					e.printStackTrace();//en cas d'erreur, permet de récuperer l'erreur est de l'afficher dans le terminal
					}
			}else {
				System.out.println("Erreur aucun compte enregisté");// si le fichier n'existe pas alors ce message est afficher
				System.out.println("   ");
				System.out.println("   ");
				Main.main(null);// renvoit l'utilisateur au menu main
				}
		}
	
	
	public static void register(Compte register) {//methode qui permet la création d'un compte et de vérifier si l'identifiant entré par l'utilisateur à la création du compte est déja utilisé
		Boolean login_used = false;//initialisation boolean
		
		File file = new File(register.file_path);//création d'un object file, permet d'intéragir avec les fichier de notre systeme

		if(file.exists()) {//si le fichier existe
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(register.file_path),"UTF-8"));//création d'une mémoire tampon
				String line = reader.readLine();//permet de lire notre fichier en .txt

				while(line != null) {//tant que line est différent de null
					if(line.startsWith("Identifiant : "+register.login)){// si "Identifiant : "+register.login existe deja dans le fichier texte alors la suite d'instruction ci-dessous est exécuté
						System.out.println("   ");
						System.out.println("Identifiant deja utilisé");//message d'erreur 
						System.out.println("   ");
						login_used = true;//permet de ne pas exécuter la suite du code, c'est à dire la partie qui permet d'enregister le mot de passe ainsi que l'identifiant dans un fichier texte
						break;
					}
					line= reader.readLine();// line prend la valeur de la ligne suivante
				}
				reader.close();// fermeture de la mémoire tampon
			}catch (IOException e) {
				e.printStackTrace();//en cas d'erreur, permet de récuperer l'erreur est de l'afficher dans le terminal
				}
		}
		
		if(login_used == false) {// si login_used est false alors cela veux dire que l'identifiant entré par l'utilisateur n'est pas deja enregisté
			 
		  Fichier separateurHaut = new Fichier(register.file_path, "**************");// création d'object fichier
		  Fichier registerLogin = new Fichier(register.file_path, "Identifiant : "+register.login);// création d'object fichier
		  Fichier registerPassword = new Fichier(register.file_path,"Mot de passe : "+register.password, "Identifiant et mot de passe enregistés, veuillez vous connecter");// création d'object fichier
		  Fichier separateurbas = new Fichier(register.file_path, "**************");// création d'object fichier
		  
		  Fichier.ouverture_ecriture(separateurHaut);//permet de séparer les login et password des autres logins et passwords dans le fichier texte
		  Fichier.ouverture_ecriture(registerLogin);// enregistrement du login dans un fichier texte
		  Fichier.ouverture_ecriture(registerPassword);// enregistrement du password dans un fichier texte
		  Fichier.ouverture_ecriture(separateurbas);//permet de séparer les logins et passwords des autres logins et password dans le fichier texte
		  System.out.println(" ");
		  System.out.println(" ");
		}
	}
	
	//Assesseur 
	public String getFile_path() {
		return file_path;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	//mutateurs
	public void setFile_path(String File_Path) {
		this.file_path = File_Path;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
