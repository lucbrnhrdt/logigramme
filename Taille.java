import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taille {

	public static double SelecteurTaille(String forme) {
        // Créer le slider
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        double multiplicateur = 0.1;

        // Créer le panneau pour contenir le slider
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(new JLabel("Taille du "+forme+": "));
        sliderPanel.add(slider);

        // Afficher le dialogue avec le slider
        int result = JOptionPane.showOptionDialog(null, sliderPanel, "Choisir la taille",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (result == JOptionPane.OK_OPTION) {
            double taille = slider.getValue() * multiplicateur;
            return taille;
        } else {
            return -1.0; // Valeur par défaut si l'utilisateur annule
        }
    }
}
