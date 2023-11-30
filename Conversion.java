import java.io.*; //package JAVA permettant de lire et écrire des fichiers txt

/* Partie 2 : conversion du fichier txt en tableau de chaînes de caractères*/

public class Conversion {
	
	public static String [] convertir(String nom_fichier) {
		
	String FichierAlgo = nom_fichier; //variable String du nom du fichier txt de l'algorithme
	String [] Algo = new String[100]; //on créé un tableau de 100 chaînes de caractère de façon à manipuler les lignes de l'algorithme plus facilement
	
	try { //try / catch : gestion des exceptions qui peuvent survenir (ici, le fait que le fichier n'existe pas dans le dossier parent de main.java)
    BufferedReader reader = new BufferedReader(new FileReader(FichierAlgo)); //assignation du fichier texte d'entré à utilisé pour l'algo, en utilisant la classe BufferedReader (issu de java.io)
    String line;
    int i=0;
    while ((line = reader.readLine()) != null) {
		Algo[i]=line; //on assigne la chaîne de caractère de la ligne i dans le tableau Algo au rang i.
		i=i+1;
		}
    reader.close();
    } catch (IOException e) { //si l'exception est vérifiée, alors on renvoie l'erreur à l'utilisateur
		System.out.println("Erreur");
	}
	return Algo;
}
}
