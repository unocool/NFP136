import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceAbeilles extends JFrame {
	
    private Monde monde;

    // Composants de l'interface
    private JLabel labelEtatNourris = new JLabel("Etat Nourris (Reine) :");
    private JTextField champEtatNourris = new JTextField(30);
    private JButton boutonPondre = new JButton("Pondre");
    
    private JButton boutonMangerReine = new JButton("Manger reine");
    private JLabel labelQuantiteStockRuche = new JLabel("Stock Ruche :");
    private JTextField champStockRuche = new JTextField(0);
    
    private JLabel labelQuantitePollen = new JLabel("Quantité de Pollen :");
    private JTextField champQuantitePollen = new JTextField(10);
    private JButton boutonFloraison = new JButton("Floraison");  
    
    private JLabel labelAbeillesDisponiblesCollecte = new JLabel("Abeille disponible pour collecter :");
    private JTextField champAbeilleDisponibleCollecte = new JTextField(0);
    private JButton boutonCollecter = new JButton("Collecter");
    
    private JLabel labelAbeillesAttenteStockage = new JLabel("Abeilles en attente pour stockage :");
    private JTextField champAbeillesAttenteStockage = new JTextField(0);
    private JButton boutonStocker = new JButton("Stocker");
    
    private JLabel labelCimetiereAbeilles = new JLabel("Cimetière abeilles :");
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

        champQuantitePollen.setText(Integer.toString(monde.getFleurs().getQuantiteNourriture()));
        champEtatNourris.setText(Integer.toString(monde.getRuche().getReine().getEtatNourris()));
   
        // Ajout des composants pour la gestion de la fleur
        
        fenetreBouton.add(labelEtatNourris); 
        fenetreBouton.add(boutonMangerReine);
        fenetreBouton.add(labelQuantitePollen);
        fenetreBouton.add(labelAbeillesDisponiblesCollecte);   
        fenetreBouton.add(labelAbeillesAttenteStockage);
        fenetreBouton.add(labelCimetiereAbeilles);
        fenetreBouton.add(champEtatNourris); 
        fenetreBouton.add(labelQuantiteStockRuche);
        fenetreBouton.add(champQuantitePollen);
        fenetreBouton.add(champAbeilleDisponibleCollecte);
        fenetreBouton.add(champAbeillesAttenteStockage);
        fenetreBouton.add(champCimetiereAbeilles);	
        fenetreBouton.add(boutonPondre);
        fenetreBouton.add(champStockRuche);
        fenetreBouton.add(boutonFloraison);  
        fenetreBouton.add(boutonCollecter); 
        fenetreBouton.add(boutonStocker);
                               
        boutonFloraison.addActionListener(new ActionListener()	
		{					
			public void actionPerformed(ActionEvent eve)
			{
				monde.getFleurs().floraison();
                champQuantitePollen.setText(Integer.toString(monde.getFleurs().getQuantiteNourriture()));
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
