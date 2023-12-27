/* Partie 3 : conversion des chaines de caractères en code Tikz*/

import java.io.*; // package JAVA permettant de lire et écrire des fichiers txt

public class CodeTikz {

    public static void codetikz(String[] Algo) {
        try {
			// Sélection des couleurs pour les blocs
            int[] couleurCarre = Couleur.SelecteurCouleur("carré");
            int[] couleurLosange = Couleur.SelecteurCouleur("losange");
            
            // Création d'un BufferedWriter pour écrire dans le fichier CodeTikz.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("CodeTikz.txt"));

            // Début du code Tikz
            writer.write("\\documentclass{article}\n" +
                    "\\usepackage[utf8]{inputenc}\n" +
                    "\\usepackage{tikz}\n" +
                    "\\usepackage{calc}\n" +
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
            int tempsi = 0;
            int tempsinon = 0;
            int tempfinsi = 0;
            int temptantque = 0;
            int tempfintantque = 0;
            int temp2 = 0;
            int temp3 = 0;
            int tempfin = 0;
            String[][] relations = new String[Algo.length][2]; // Création d'une liste pour stocker les relations entre les blocs

            // Partie 1 : Traduction des blocs
            if (!Algo[i].equals("Début")) { // Chercher ligne par ligne pour trouver le début de l'algortithme à traduire
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
                    temptantque = j;
                    writer.append("\n\\node[losange] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i].replace(" faire", "") + "};");
                    writer.flush();
                    relations[j - 1][0] = "t" + (j - 1);
                    relations[j - 1][1] = "t" + j;
                    i++;
                    j++;

                } else if (Algo[i].startsWith("Si")) {
                    Algo[i] = Algo[i].replace("<=", "$<$=");
                    Algo[i] = Algo[i].replace(">=", "$>$=");
                    Algo[i] = Algo[i].replace("!=", "$!$=");
                    writer.append("\n\\node[losange] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i].replace(" si", "") + "};");
                    tempsi = j;
                    writer.flush();
                    relations[j - 1][0] = "t" + (j - 1);
                    relations[j - 1][1] = "t" + j;
                    i++;
                    j++;
                } else if (Algo[i].startsWith("sinon")) {
                    writer.append("\n\\node[losange] (t" + j + ") [right =of t" + (tempsi + 1) + "] {" + Algo[i].replace(" sinon", "") + "};");
                    tempsinon = j;
                    writer.flush();
                    i++;
                    j++;
                    relations[tempsi][1] = "t" + (tempsi + 1);
                } else if (Algo[i].startsWith("Fin si")) {
                    tempfinsi = j;
                    if (tempsinon != 0) {
                        writer.append("\n\\node (t" + j + ") at (t" + (tempfinsi - 1) + ".south -| t" + (tempsinon - 1) + ".south) {};");
                        j++;
                        writer.append("\n\\node (t" + j + ") [below =of t" + (j - 1) + "]{};");
                        i++;
                        j++;
                    } else if (tempsinon == 0) {
						if (tempfinsi==(tempfin-1)){
							relations[j - 1][0] = "t" + (j - 1);
							relations[j - 1][1] = "t" + j;
							i++;
						}else if (tempfinsi!=(tempfin-1)){
							writer.append("\n\\node (t" + j + ") [below =of t" + (j - 1) + "]{};");
							
							i++;
							j++;
					}
                       
                    }
                } else if (Algo[i].startsWith("Fin tantque")) {
                    tempfintantque = j;
                    i++;
                   
                } else if (Algo[i].startsWith("Fin")) {
					tempfin = j;
					if (tempfin == (tempfinsi+1)){
						writer.append("\n\\node[cercle] (t" + (tempfinsi+1) + ") [below =of t" + tempfinsi + "] {\\textbullet};");
						writer.flush();
                    } else if (tempfin == (tempfinsi+1)){
						writer.append("\n\\node[cercle] (t" + (tempfintantque+1) + ") [below =of t" + tempfintantque + "] {\\textbullet};");
						writer.flush();
                    }else {
					writer.append("\n\\node[cercle] (t" + j + ") [below =of t" + (j - 1) + "] {\\textbullet};");
                    writer.flush();
                    
                    if ((tempsi != 0) && (tempsinon != 0) && (tempfin == (tempfinsi +1))) {
                        writer.append("\n\\draw[->] (t" + (tempsinon - 1) + ".south) to (t" + (tempfinsi+1) + ".north);");

                    } else if ((tempsi != 0) && (tempsinon != 0) && (tempfin != (tempfinsi + 1))) {
                        writer.append("\n\\draw[->] (t" + (tempsinon - 1) + ".south) to (t" + (tempfin) + ");");
                        
                    }
                    if ((tempsi != 0) && (tempsinon == 0) && (tempfin == (tempfinsi + 1))) {
                        writer.append("\n\\draw[->] (t" + (tempfinsi - 1) + ".south) to (t" + (tempfin) + ");");
                        
                    }
}
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
            i = 0;
            j = 1;
            int exclu = 0;
            int exclutantque = 0;

            if (!Algo[i].equals("Début")) { // Chercher ligne par ligne pour trouver le début de l'algortithme à traduire
                i++;
            }
            i++;

            while (Algo[i] != null) {
                if (Algo[i].startsWith("tantque")) {
                    writer.append("\n\\node(aux" + aux + ") [right = 4em of t" + temptantque + "]{};");
                    temp2 = aux;
                    aux++;
                    writer.append("\n\\node(aux" + aux + ") [left = 3em of t" + temptantque + "]{};");
                    aux++;
                    writer.flush();
                    i++;
                    j++;

                } else if (Algo[i].startsWith("Si")) {
                    i++;
                    j++;
                } else if (Algo[i].startsWith("sinon")) {
                    writer.append("\n\\node(aux" + aux + ") [above = 4em of t" + j + "]{};");
                    writer.append("\n\\draw[->] (t" + tempsi + ".east)|- (aux" + aux + ".center)node[pos=1.2,align=center]{non}|- (t" + tempsinon + ".north);");
                    writer.flush();
                    aux++;
                    i++;
                    j++;
                } else if (Algo[i].startsWith("Fin si")) {
                    if (tempsinon != 0) {
                        writer.append("\n\\node(aux" + aux + ") [below = 3em of t" + j + "]{};");
                        writer.append("\n\\draw[-] (t" + (tempfinsi - 1) + ".south) |- (aux" + aux + ".center)|- (t" + (tempfinsi + 1) + ".center);");
                        aux++;
                        exclu = (j + 1);
                        writer.flush();
                    }
                    if (tempsinon == 0) {
                        writer.append("\n\\node(aux" + aux + ") [right = 3em of t" + tempsi + "]{};");
                        aux++;
                        writer.append("\n\\node(aux" + aux + ") [right = 3em of t" + tempfinsi + "]{};");
                        aux++;
                        writer.append("\n\\draw[->] (t" + tempsi + ".east) |- (aux" + (aux - 2) + ".center)node[pos=1.3,align=center]{non}|- (aux" + (aux - 1) + ".center)|- (t" + tempfinsi + ".center);");
                        aux++;
                        writer.append("\n\\node(aux" + aux + ") [below = 3em of t" + j + "]{};");
                        writer.append("\n\\draw[->] (t" + (tempfinsi - 1) + ".south) to (t" + (tempfinsi + 1) + ".north);");
                        aux++;
                        exclu = (j + 1);
                        writer.flush();
                    }
                    i++;
                    j++;
                } else if (Algo[i].startsWith("Fin tantque")) {
                    writer.append("\n\\node(aux" + aux + ") [right = 3em of t" + tempfintantque + "]{};");
                    aux++;
                    writer.append("\n\\node(aux" + aux + ") [left = 4em of t" + (tempfintantque - 1) + "]{};");
                    temp3 = aux;
                    aux++;
                    writer.append("\n\\draw[->] (t" + temptantque + ".east)|- (aux" + temp2 + ".center)node[pos=1.3,align=center]{non}|- (aux" + (temp2 + 2) + ".center)|- (t" + tempfintantque + ".east);");
                    writer.append("\n\\draw[->] (t" + (tempfintantque - 1) + ".west)|- (aux" + temp3 + ".center)|- (aux" + (temp2 + 1) + ".center)|- (t" + temptantque + ".west);");
                    exclutantque = j;
                    writer.flush();
                    i++;
                    j++;
                } else {
                    i++;
                    j++;
                }
            }

            // Partie 3 : Dessin des flèches
            if (exclutantque != 0) {
                for (int k = 0; k < (exclutantque-1); k++) {
                    if (relations[k][0] != null && relations[k][1] != null) {
                        writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                    }
                }
                if ((temptantque!=0)&&(tempfintantque!=(tempfin))){
					for (int k = (exclutantque); k < j; k++) {
						if (relations[k][0] != null && relations[k][1] != null) {
							writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                    }
                }
				writer.append("\n\\draw[->] (t" + (tempfin-1) + ") to (t" + (tempfin) + ");");
			}
            }else if (exclu != 0) {
                for (int k = 0; k < (exclu - 1); k++) {
                    if (relations[k][0] != null && relations[k][1] != null) {
                        writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                    }
                }
                for (int k = exclu; k < relations.length; k++) {
                    if (relations[k][0] != null && relations[k][1] != null) {
                        writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                    }
                }    
            } else {
                for (int k = 0; k < j; k++) {
                    if (relations[k][0] != null && relations[k][1] != null) {
                        writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                    }
                }
            }
            if ((tempsi!=0)&&(tempsinon==0)&&(tempfinsi!=(tempfin-1))){
				writer.append("\n\\draw[->] (t" + (tempfin-1) + ") to (t" + (tempfin) + ");");
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
