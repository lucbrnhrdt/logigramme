import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Ouverture {

    public static void ouvrirFichier(String chemin) {
        try {
            File fichier = new File(chemin);
            if (!fichier.exists()) {
                System.out.println("Le fichier spécifié n'existe pas : " + chemin);
                return;
            }

            Desktop desktop = Desktop.getDesktop();

            if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(fichier);
            } else {
                System.out.println("L'ouverture de l'explorateur de fichiers n'est pas supportée sur ce système.");
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de l'ouverture du fichier : " + e.getMessage());
        }
    }
}
