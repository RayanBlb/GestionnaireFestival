import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Liste_Setting {
	
	protected static int taille_tableau_fichier;
	
	protected static void Taille_fichier_liste(String File_Path) {//methode qui permet d'obtenir la taille d'un fichier de liste
	File file = new File(File_Path);//création d'un object file, permet d'intéragir avec les fichiers de notre systeme
	taille_tableau_fichier = 0;// initialisation de la taille du tableau à 0
	
	if(file.exists()) {// si le fichier existe
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(File_Path),"UTF-8"));//création d'une mémoire tampon afin de lire le fichier
			String line = reader.readLine();//permet de lire notre fichier en .txt
			
			while(line != null) {//tant que line est null 
				taille_tableau_fichier++;// taille_tableau_fichier est incrémenté de 1
				line = reader.readLine();// line prend la valeur de la ligne suivante
				}
			reader.close();// la mémoire tampon est fermée
			
		}catch (IOException e) {
			e.printStackTrace();//en cas d'erreur, permet de récuperer l'erreur est de l'afficher dans le terminal
			}
}
}
}
