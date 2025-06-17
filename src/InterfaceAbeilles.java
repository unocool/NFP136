import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceAbeilles extends JFrame {
	
    private Monde monde;

    // Composants de l'interface
    private JLabel etatNourris = new JLabel("Etat Nourris (Reine) :");
    private JTextField champEtatNourris = new JTextField(30);
    private JButton boutonPondre = new JButton("Pondre");
    
    private JButton boutonMangerReine = new JButton("Manger reine");
    private JLabel quantiteStockRuche = new JLabel("Stock Ruche :");
    private JTextField champStockRuche = new JTextField(0);
    
    private JLabel labelQuantite = new JLabel("Quantité de Pollen :");
    private JTextField champQuantite = new JTextField(10);
    private JButton boutonFloraison = new JButton("Floraison");  
    
    private JLabel AbeillesDisponiblesCollecte = new JLabel("Abeille disponible pour collecter :");
    private JTextField champAbeilleDisponible = new JTextField(0);
    private JButton boutonCollecter = new JButton("Collecter");
    
    private JLabel AbeillesAttenteStockage = new JLabel("Abeilles en attente pour stockage :");
    private JTextField champAbeillesAttenteStockage = new JTextField(0);
    private JButton boutonStocker = new JButton("Stocker");
    
    private JLabel cimetiereAbeilles = new JLabel("Cimetière abeilles :");
    private JTextField champCimetiereAbeilles = new JTextField(0);
    

    public InterfaceAbeilles(Monde monde) {
    	this.monde = monde;
    	
    	//Création d'un zone princpale qui contiendra la zone d'explication et les boutons intéractifs
    	JPanel contenuFenetre = new JPanel();
    	
    	//Création de la zone de texte explicative
    	JLabel zoneTexte = new JLabel("Le programme se comporte de cette façon ...");
    	contenuFenetre.add(zoneTexte, BorderLayout.NORTH);
    	
    	
        JPanel fenetreBouton = new JPanel();
        GridLayout disposition = new GridLayout(3, 6);
        fenetreBouton.setLayout(disposition);

        champQuantite.setText(Integer.toString(monde.getFleurs().getQuantiteNourriture()));
        champEtatNourris.setText(Integer.toString(monde.getRuche().getReine().getEtatNourris()));
   
        // Ajout des composants pour la gestion de la fleur
        fenetreBouton.add(etatNourris);
        fenetreBouton.add(champEtatNourris);
        fenetreBouton.add(boutonPondre);
        
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
