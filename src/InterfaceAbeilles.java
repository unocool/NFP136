import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceAbeilles extends JFrame {
	
    private Monde monde;

    // Composants de l'interface
    private JLabel labelQuantite = new JLabel("Quantité de nourriture :");
    private JTextField champQuantite = new JTextField(10);
    private JButton boutonFloraison = new JButton("Floraison");

    public InterfaceAbeilles(Monde monde) {
    	this.monde = monde;
    	
    	//Création d'un zone princpale qui contiendra la zone d'explication et les boutons intéractifs
    	JPanel contenuFenetre = new JPanel();
    	
    	//Création de la zone de texte explicative
    	JTextField zoneTexte = new JTextField("Le programme se comporte de cette façon ...");
    	contenuFenetre.add(zoneTexte, BorderLayout.NORTH);
    	
    	
        JPanel fenetreBouton = new JPanel();
        GridLayout disposition = new GridLayout(3, 3);
        fenetreBouton.setLayout(disposition);

        champQuantite.setText(Integer.toString(monde.getFleurs().getQuantiteNourriture()));
   
        // Ajout des composants pour la gestion de la fleur
        fenetreBouton.add(labelQuantite);
        fenetreBouton.add(champQuantite);
        fenetreBouton.add(boutonFloraison);
        
        boutonFloraison.addActionListener(new ActionListener()	
		{					
			public void actionPerformed(ActionEvent eve)
			{
				monde.getFleurs().floraison();
                champQuantite.setText(Integer.toString(monde.getFleurs().getQuantiteNourriture()));
			}
				
		});
        
        contenuFenetre.add(fenetreBouton, BorderLayout.SOUTH);
        
        // Configuration de la fenêtre
        contenuFenetre.setBackground(new Color(255, 255, 0));
        this.setContentPane(contenuFenetre);
        this.setSize(400, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
