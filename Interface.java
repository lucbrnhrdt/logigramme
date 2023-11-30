import javax.swing.*; //utilisation de la classe Swing pour les interfaces graphiques
import java.awt.event.*; //classes nécessaires pour gérer les événements d'action
import java.io.*; //package JAVA permettant de lire et écrire des fichiers txt

/* Partie 1 : sélection du fichier txt par le biais d'un explorateur de fichier*/

public class Interface {

    public static String i() {
        JFrame frame = new JFrame("Sélection fichier algorithme (.txt)"); //création d'une fenêtre pop-up
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        JFileChooser fileChooser = new JFileChooser(); //création d'un sélecteur de fichiers
        
        String chemin = null;
          
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile(); //récupération du fichier sélectionné
            chemin = selectedFile.getAbsolutePath(); //obtention du chemin absolu du fichier
            System.out.println("Fichier sélectionné : " + chemin);
        } 
        else {
            System.out.println("Aucun fichier sélectionné.");
        }

        frame.dispose(); // fermer la fenêtre après avoir obtenu le chemin du fichier

        return chemin;
    }
}
