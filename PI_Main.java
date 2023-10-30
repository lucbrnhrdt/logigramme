import java.io.*; //package JAVA que nous utiliserons pour lire et écrire des fichiers txt

public class PI_Main {
  public static void main(String[] args) { 
	String FichierAlgo="test.txt"; //variable String du nom du fichier txt de l'algorithme
	String [] Algo = new String[100]; //on créé un tableau de 100 chaînes de caractère de façon à manipuler les lignes de l'algorithme plus facilement
	
	/* Partie 1 : conversion du fichier txt en tableau de chaîne de caractères*/
	try { //try / catch : gestion des exceptions qui peuvent survenir (ici, le fait que le fichier n'existe pas dans le dossier parent de main.java)
    BufferedReader reader = new BufferedReader(new FileReader(FichierAlgo)); //assignation du fichier texte d'entré à utilisé pour l'algo, en utilisant la classe BufferedReader (issu de java.io)
    String line;
    int i=0;
    while ((line = reader.readLine()) != null) {
		Algo[i]=line; //on assigne la chaîne de caractère de la ligne i dans le tableau Algo au rang i.
		i=i+1;
		}
    reader.close();
    } catch (IOException e) { //si l'exception est vérifiée, alors on renvoie l'information à l'utilisateur
		System.out.println("Le fichier n'existe pas");
	}
	
	/* Partie 2 : conversion des chaines de caractères en code Tikz*/
	System.out.println(Algo[0]);
  }
}
