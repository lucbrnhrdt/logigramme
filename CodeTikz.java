/* Partie 3 : conversion des chaines de caractères en code Tikz*/

import java.io.*; // package JAVA permettant de lire et écrire des fichiers txt

public class CodeTikz {

    public static void codetikz(String[] Algo) {
        try {
            int[] couleurCarre = Couleur.SelecteurCouleur("carré");
            int[] couleurLosange = Couleur.SelecteurCouleur("losange");
            BufferedWriter writer = new BufferedWriter(new FileWriter("CodeTikz.txt"));

// Début du code Tikz
			writer.write("\\documentclass{article}\n" +
                         "\\usepackage[utf8]{inputenc}\n" +
                         "\\usepackage{tikz}\n" +
                         "\\usetikzlibrary{positioning,shapes.geometric}\n" +
                         "\\tikzstyle{debfin}=[ellipse,draw,text width=2cm,text centered]\n" +
                         "\\tikzstyle{carre}=[rectangle,rounded corners,draw={rgb,255:red," + couleurCarre[0] + "; green," + couleurCarre[1] + "; blue," + couleurCarre[2] + "}, draw opacity = 0.8, fill={rgb,255:red," + couleurCarre[0] + "; green," + couleurCarre[1] + "; blue," + couleurCarre[2] + "}, fill opacity=0.1, text opacity = 1, inner ysep=0.2cm,text width=2cm,text centered]\n" +
                         "\\tikzstyle{losange}=[diamond,draw={rgb,255:red," + couleurLosange[0] + "; green," + couleurLosange[1] + "; blue," + couleurLosange[2] + "}, draw opacity = 0.8, fill={rgb,255:red," + couleurLosange[0] + "; green," + couleurLosange[1] + "; blue," + couleurLosange[2] + "}, fill opacity=0.1, text opacity = 1, inner ysep=0.1cm,text width=1cm,text centered]\n" +
                         "\\tikzstyle{cercle}=[draw,circle]\n" +
                         "\\begin{document}\n\n" +
                         "\\begin{tikzpicture}\n");
            writer.flush();


            int i = 0;
            int j = 1;
            int aux = 0;
            int temp = 0;
            int temp1= 0;
            int temp2= 0;
            int temp3= 0;
            String[][] relations = new String[Algo.length][2];// Création d'une liste pour stocker les relations entre les blocs

// Partie 1 : Traduction des blocs
            if (!Algo[i].equals("Début")) {  // Chercher ligne par ligne pour trouver le début de l'algortithme à traduire
                i++;
            }
            i++;

           while (Algo[i] != null) {
    if ((Algo[i].startsWith("Début"))) {
        writer.append("\n\\node[debfin] (t" + j + ") {" + Algo[i] + "};");
        writer.flush();
        i++;
        j++;
    } else if ((Algo[i].startsWith("Lire")) || (Algo[i].startsWith("Ecrire"))) {
        writer.append("\n\\node[carre] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i] + "};");
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i++;
        j++;
    } else if (Algo[i].startsWith("tantque")) {
        Algo[i] = Algo[i].replace("<=", "$<$=");
        Algo[i] = Algo[i].replace(">=", "$>$=");
        Algo[i] = Algo[i].replace("!=", "$!$=");
        temp1=j;
        writer.append("\n\\node[losange] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i].replace(" faire", "") + "};");
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i++;
        j++;
        
    } else if (Algo[i].startsWith("si")) {
        Algo[i] = Algo[i].replace("<=", "$<$=");
        Algo[i] = Algo[i].replace(">=", "$>$=");
        Algo[i] = Algo[i].replace("!=", "$!$=");
        writer.append("\n\\node[losange] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i].replace(" si", "") + "};");
        temp = j;
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i++;
        j++;
    } else if (Algo[i].startsWith("sinon")) {
        writer.append("\n\\node[losange] (t" + j + ") [below right =of t" + temp + "] {" + Algo[i].replace(" sinon", "") + "};");
        writer.flush();
        relations[temp][1] = "t" + j;
        i++;
        j++;
    } else if ((Algo[i].startsWith("Fin si")) || (Algo[i].startsWith("Fin tantque"))) {
        i++;
    } else if (Algo[i].startsWith("Fin")) {
        writer.append("\n\\node[cercle] (t" + j + ") [below =of t" + (j - 1) + "] {\\textbullet};");
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i++;
        j++;
    } else {
        writer.append("\n\\node[carre] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i] + "};");
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i++;
        j++;
    }
}

// Partie 2 : Gestion des exclusions
	i=0;
	j=1;
	int exclu=0;
	
	if (!Algo[i].equals("Début")) {  // Chercher ligne par ligne pour trouver le début de l'algortithme à traduire
		i++;
	}
    i++;
    
	while (Algo[i] != null) {
    if (Algo[i].startsWith("tantque")) {
        writer.append("\n\\node(aux"+aux+") [right = 4em of t"+j+"]{};");
        temp2 = aux;
        aux++;
        writer.append("\n\\node(aux"+aux+") [left = 3em of t"+j+"]{};");
        aux++;
        writer.flush();
        i++;
        j++;
        
    } else if (Algo[i].startsWith("si")) {
        i++;
        j++;
    } else if (Algo[i].startsWith("sinon")) {
        i++;
        j++;
    } else if ((Algo[i].startsWith("Fin si")) || (Algo[i].startsWith("Fin tantque"))) {
        writer.append("\n\\node(aux"+aux+") [right = 4em of t"+j+"]{};");
        aux++;
        writer.append("\n\\node(aux"+aux+") [left = 4em of t"+(j-1)+"]{};");
        temp3 = aux;
        aux++;
        writer.append("\n\\draw[->] (t" + temp1 +".east)|- (aux"+ temp2 +".center)|- (aux"+ (temp2+2) +".center)|- (t" + j + ".east);");
        writer.append("\n\\draw[->] (t" + (j-1) +".west)|- (aux"+ temp3 +".center)|- (aux"+ (temp2+1) +".center)|- (t" + temp1 + ".west);");
        exclu = j;
        writer.flush();
        i++;
    } else {
		i++;
		j++;
    }
}

// Partie 3 : Dessin des flèches
	for (int k = 0; k < (exclu-1); k++) {
		if (relations[k][0] != null && relations[k][1] != null) {
			writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                }
            }
	for (int k = exclu; k < relations.length; k++) {
		if (relations[k][0] != null && relations[k][1] != null) {
			writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                }
            }
    
// Fin du code Tikz
	writer.append("\n\n\\end{tikzpicture}");
	writer.append("\n\n\\end{document}");
	writer.flush();

// Ouverture du fichier
	Ouverture.ouvrirFichier("CodeTikz.txt");
	
        } catch (IOException e) {
            System.out.println("Erreur");
        }
    }
}
