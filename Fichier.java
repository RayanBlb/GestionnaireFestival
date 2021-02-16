import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichier{
	
	//Variable d'instance
	private  String file_path;
	private  String message_write;
	private  String message_after_write="  ";

	//Constructeur avec message de confirmation 
	public Fichier(String file_path, String message_write, String message_after_write) {
		this.file_path = file_path;
		this.message_write = message_write;
		this.message_after_write = message_after_write;
	}
	//Constructeur sans message de confirmation 
	public Fichier(String file_path, String message_write) {
		this.file_path = file_path;
		this.message_write = message_write;
	}
	
	public static void ouverture_ecriture(Fichier fichier){// methode qui permet de créer un fichier ,s'il n'est pas créé permet de l'ouvrir est d'écrire dedans

	File file = new File(fichier.file_path);//création d'un object file, permet d'intéragir avec les fichiers de notre systeme
		
		if(!file.exists()) {//si le fichier n'existe pas
			try {
				file.createNewFile();//le fichier est créé
				FileWriter Writer = new FileWriter(file, true);//création d'un nouvel object du type FileWriter ,permet de créer un flux pour écrire  dans le fichier
				BufferedWriter bw = new BufferedWriter(Writer);//création d'un buffer afin d'écrire dans le fichier text, permet l'interaction avec un fichier
				bw.write(fichier.message_write);//permet d'ecrire dans le fichier le message passé en paramètre
				bw.newLine();//permet d'aller a la ligne
				bw.close();//fermeture du buffer
				Writer.close();//fermeture du flux
				
				System.out.println(fichier.message_after_write);// message ecrit après exécution des ligne précédentes
			} catch (IOException e) {
				e.printStackTrace();//en cas d'erreur, permet de récuperé l'erreur est de l'afficher dans le terminal
			}
		}
		
		else {
			try {
				
				FileWriter Writer = new FileWriter(file, true);//création d'un nouvel object du type FileWriter ,permet de créer un flux pour écrire  dans le fichier
				BufferedWriter bw = new BufferedWriter(Writer);//création d'un buffer afin d'écrire dans le fichier text, permet l'interaction avec un fichier
				bw.write(fichier.message_write);//permet d'écrire dans le fichier le message passé en paramètre
				bw.newLine();//permet d'aller a la ligne
				bw.close();//fermeture du buffer
				Writer.close();//fermeture du flux
				
				
				System.out.println(fichier.message_after_write);// message ecrit après exécution des lignes précédentes
			}catch (IOException e) {
				e.printStackTrace();//en cas d'erreur, permet de récuperer l'erreur est de l'afficher dans le terminal
			}
		}
		
		
	}

	public static void Effacement_Fichier(Fichier effacement_fichier) {
File file = new File(effacement_fichier.file_path);//création d'un object file, permet d'intéragir avec les fichier de notre systeme
		
		if(file.exists()) {//si le fichier existe
			try {
				FileWriter Writer = new FileWriter(file, false);//création d'un nouvel object du type FileWriter ,permet d'effacer le contenu du fichier donné en paramère
				Writer.close();
				System.out.println(effacement_fichier.message_write);// message ecrit après effacement du fichier
			} catch (IOException e) {
				e.printStackTrace();//en cas d'erreur, permet de récupéré l'erreur est de l'afficher dans le terminal
			}
		}
		
		else {
			System.out.println("le fichier n'existe pas");// message ecrit si le fichier n'existe pas
		}
	}
	
	//accesseur
	public String getFile_Path() {
		return file_path;
	}
	
	public String getMessage_write() {
		return message_write;
	}
	
	public String getMessage_After_write() {
		return message_after_write;
	}
	//mutateur
	public void setFile_Path(String file_path){
		this.file_path = file_path;
	}
	
	public void setMessage_write(String message_write){
		this.message_write = message_write;
	}
	
	public void setMessage_After_write(String message_after_write){
		this.message_after_write = message_after_write;
	}
}
