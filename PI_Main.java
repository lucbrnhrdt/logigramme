import java.io.*; //package JAVA que nous utiliserons pour lire et écrire des fichiers txt

public class PI_Main {
  public static void main(String[] args) {
	String nom_fichier;
	System.out.println("\nVeuillez vérifier que le fichier algorithme est dans le même dossier que ce programme Java.");
	System.out.println("\nEntrez le nom de votre fichier algorithme (en .txt) à convertir :");
	nom_fichier=Lire.S();
	
	File file = new File("CodeTikz.txt"); //création d'un fichier txt en sortie (pour le code Tikz)
	file.delete();
	
	String[] Algo; 
    Algo = Conversion.convertir(nom_fichier); //fonction qui convertit un fichier txt (algorithme initial) en tableau
	
	CodeTikz.codetikz(Algo); //fonction qui convertit l'algorithme initial en code Tikz
	 
	System.out.println("Votre code Tikz a été généré !");
	}
}
		

