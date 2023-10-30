import java.io.*; //package JAVA que nous utiliserons pour lire et écrire des fichiers txt

public class PI_Main {
  public static void main(String[] args) { 
	String FichierAlgo="test.txt"; //variable String du nom du fichier txt de l'algorithme
	String [] Algo = new String[100]; //on créé un tableau de 100 chaînes de caractère de façon à manipuler les lignes de l'algorithme plus facilement
	File file = new File("CodeTikz.txt"); //création d'un fichier txt en sortie (pour le code Tikz)
	file.delete();
	
	/* Partie 1 : conversion du fichier txt en tableau de chaînes de caractères*/
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
	
	/* Partie 2 : conversion des chaines de caractères en code Tikz*/
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("CodeTikz.txt")); 
		//Début du code Tikz
		writer.write("\\documentclass{article}");
		writer.write("\n\\usepackage[utf8]{inputenc}");
		writer.write("\n\\usepackage{tikz}");
		writer.write("\n\\usetikzlibrary{positioning,shapes.geometric}");
		writer.write("\n\\tikzstyle{carre}=[rectangle,rounded corners,draw=red!80,fill=red!10, inner ysep=0.2cm,text width=2cm,text centered]");
		writer.write("\n\\tikzstyle{losange}=[diamond,draw=blue!80,fill=blue!10, inner ysep=0.1cm,text width=1cm,text centered]");
		writer.write("\n\\tikzstyle{cercle}=[draw,circle]");
		writer.write("\n\\begin{document}");
		writer.write("\n\n\\begin{tikzpicture}\n");
		writer.close();
		}
	catch (IOException e) {
		System.out.println("Erreur");
	}
	System.out.println("Votre code Tikz a été généré !");
  }
}
		
