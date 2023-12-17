import java.io.*; // package JAVA permettant de lire et écrire des fichiers txt

/* Partie 3 : conversion des chaines de caractères en code Tikz*/

public class CodeTikz {

    public static void codetikz(String[] Algo) {
        try {
            int[] couleurCarre = Couleur.SelecteurCouleur("carré");
            int[] couleurLosange = Couleur.SelecteurCouleur("losange");
            BufferedWriter writer = new BufferedWriter(new FileWriter("CodeTikz.txt"));

            // Début du code Tikz
            writer.write("\\documentclass{article}");
            writer.write("\n\\usepackage[utf8]{inputenc}");
            writer.write("\n\\usepackage{tikz}");
            writer.write("\n\\usetikzlibrary{positioning,shapes.geometric}");
            writer.write("\n\\tikzstyle{debfin}=[ellipse,draw,text width=2cm,text centered]");
            writer.write("\n\\tikzstyle{carre}=[rectangle,rounded corners,draw={rgb,255:red," + couleurCarre[0] + "; green," + couleurCarre[1] + "; blue," + couleurCarre[2] + "}, draw opacity = 0.8, fill={rgb,255:red," + couleurCarre[0] + "; green," + couleurCarre[1] + "; blue," + couleurCarre[2] + "}, fill opacity=0.1, text opacity = 1, inner ysep=0.2cm,text width=2cm,text centered]");
            writer.write("\n\\tikzstyle{losange}=[diamond,draw={rgb,255:red," + couleurLosange[0] + "; green," + couleurLosange[1] + "; blue," + couleurLosange[2] + "}, draw opacity = 0.8, fill={rgb,255:red," + couleurLosange[0] + "; green," + couleurLosange[1] + "; blue," + couleurLosange[2] + "}, fill opacity=0.1, text opacity = 1, inner ysep=0.1cm,text width=1cm,text centered]");
            writer.write("\n\\tikzstyle{cercle}=[draw,circle]");
            writer.write("\n\\begin{document}");
            writer.write("\n\n\\begin{tikzpicture}\n");
            writer.flush();

            int i = 0;
            int j = 1;
            int temp = 0;
            int temp1=0;
            String[][] relations = new String[Algo.length][2];// Création d'une liste pour stocker les relations entre les blocs

            if (!Algo[i].equals("Début")) {  // Chercher ligne par ligne pour trouver le début de l'algortithme à traduire
                i = i + 1;
            }
            i = i + 1;

           while (Algo[i] != null) {
    if ((Algo[i].startsWith("Début"))) {
        writer.append("\n\\node[debfin] (t" + j + ") {" + Algo[i] + "};");
        writer.flush();
        i = i + 1;
        j = j + 1;
    } else if ((Algo[i].startsWith("Lire")) || (Algo[i].startsWith("Ecrire"))) {
        writer.append("\n\\node[carre] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i] + "};");
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i = i + 1;
        j = j + 1;
    } else if (Algo[i].startsWith("tantque")) {
        Algo[i] = Algo[i].replace("<=", "$<$=");
        Algo[i] = Algo[i].replace(">=", "$>$=");
        Algo[i] = Algo[i].replace("!=", "$!$=");
        temp1=j;
        // Dessiner une flèche vers le haut
        writer.append("\n\\node[losange] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i].replace(" faire", "") + "};");
        
        
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i = i + 1;
        j = j + 1;
    } else if (Algo[i].startsWith("si")) {
        Algo[i] = Algo[i].replace("<=", "$<$=");
        Algo[i] = Algo[i].replace(">=", "$>$=");
        Algo[i] = Algo[i].replace("!=", "$!$=");
        writer.append("\n\\node[losange] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i].replace(" si", "") + "};");
        temp = j;
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i = i + 1;
        j = j + 1;
    } else if (Algo[i].startsWith("sinon")) {
        writer.append("\n\\node[losange] (t" + temp + ") [right =of t" + (temp) + "] {" + Algo[i].replace(" sinon", "") + "};");
        writer.flush();
        relations[temp][1] = "t" + j;
        i = i + 1;
        j = j + 1;
    } else if ((Algo[i].startsWith("Fin si")) || (Algo[i].startsWith("Fin tantque"))) {
        // Dessiner une flèche vers le bas
        writer.append("\n\\node[cercle] (t" + j + ") [below =of t" + (j - 1) + "] {\\textbullet};");
        writer.append("\n\\draw[->] (t" + temp1 +".east) to (t" + j + ".east);");
        writer.append("\n\\draw[->] (t" + (j - 1) +".west) to (t" + temp1 + ".west);");
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i = i + 1;
        j = j + 1;
    } else {
        writer.append("\n\\node[carre] (t" + j + ") [below =of t" + (j - 1) + "] {" + Algo[i] + "};");
        writer.flush();
        relations[j - 1][0] = "t" + (j - 1);
        relations[j - 1][1] = "t" + j;
        i = i + 1;
        j = j + 1;
    }
}

            // Ajouter des flèches
            for (int k = 0; k < relations.length; k++) {
                if (relations[k][0] != null && relations[k][1] != null) {
                    writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                    writer.append("\n\\draw[->] (" + relations[k][0] + ") to (" + relations[k][1] + ");");
                }
            }

            writer.append("\n\n\\end{tikzpicture}");
            writer.append("\n\n\\end{document}");
            writer.flush();

            Ouverture.ouvrirFichier("CodeTikz.txt");
        } catch (IOException e) {
            System.out.println("Erreur");
        }
    }
}
