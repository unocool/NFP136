import javax.swing.*;
import java.awt.*;

public class InterfaceAbeilles extends JFrame {

    public InterfaceAbeilles() {
    	setTitle("Le monde des abeilles");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contenuFenetre = new JPanel();
        //Création d'un layout qui empile les composants de haut en bas
        contenuFenetre.setLayout(new BoxLayout(contenuFenetre, BoxLayout.Y_AXIS));

      //50 est la hauteur des bandes
        int nbBandes = getHeight() / 50;

        // Création des bandes noirs et jaunes de façon alternée
        for (int i = 0; i <= nbBandes; i++) {
        	JPanel bande = new JPanel();         
            if (i % 2 == 0) {
                bande.setBackground(Color.BLACK);
            } else {
                bande.setBackground(Color.YELLOW);
            }
            
            contenuFenetre.add(bande);
        }

        setContentPane(contenuFenetre);
        setVisible(true);
    }
}
