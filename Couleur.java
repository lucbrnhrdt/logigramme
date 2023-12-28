import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Couleur {

    public static int[] SelecteurCouleur(String forme) {
        Color initialColor = Color.WHITE;
        Color selectedColor = JColorChooser.showDialog(null, "Choisir une couleur pour le " + forme, initialColor);

        if (selectedColor != null) {
            int[] RGB = new int[]{selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue()};
            return RGB;
        } else {
            return null;
        }
    }
}
