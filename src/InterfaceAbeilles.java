import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceAbeilles extends JFrame {
	
    private Monde monde;

    // Composants de l'interface
    private JLabel labelEtatNourris = new JLabel("Etat Nourris (Reine) :");
    private JTextField champEtatNourris = new JTextField();
    private JButton boutonPondre = new JButton("Pondre");
    
    private JButton boutonMangerReine = new JButton("Manger reine");
    private JLabel labelQuantiteStockRuche = new JLabel("Stock Ruche :");
    private JTextField champStockRuche = new JTextField();
    
    private JLabel labelQuantitePollen = new JLabel("Quantité de Pollen :");
    private JTextField champQuantitePollen = new JTextField();
    private JButton boutonFloraison = new JButton("Floraison");  
    
    private JLabel labelAbeillesDisponiblesCollecte = new JLabel("Abeille disponible pour collecter :");
    private JTextField champAbeilleDisponibleCollecte = new JTextField();
    private JButton boutonCollecter = new JButton("Collecter");
    
    private JLabel labelAbeillesAttenteStockage = new JLabel("Abeilles en attente pour stockage :");
    private JTextField champAbeillesAttenteStockage = new JTextField();
    private JButton boutonStocker = new JButton("Stocker");
    
    private JLabel labelCimetiereAbeilles = new JLabel("Cimetière abeilles :");
    private JTextField champCimetiereAbeilles = new JTextField();
    

    public InterfaceAbeilles(Monde monde) {
    	this.monde = monde;
    	
    	//Création d'un zone princpale qui contiendra la zone d'explication et les boutons intéractifs
    	JPanel contenuFenetre = new JPanel();
    	contenuFenetre.setLayout(new BorderLayout());
    	
    	//Création de la zone de texte explicative
    	JLabel zoneTexte = new JLabel("Le programme se comporte de cette façon ...");
    	contenuFenetre.add(zoneTexte, BorderLayout.NORTH);
    	
    	
        JPanel fenetreBouton = new JPanel();
        GridLayout disposition = new GridLayout(3, 6);
        fenetreBouton.setLayout(disposition);

        //Initialisation des champs
        Ruche ruche = monde.getRuche();
        
        champQuantitePollen.setText(Integer.toString(monde.getFleurs().getQuantiteNourriture()));
        champEtatNourris.setText(Integer.toString(ruche.getReine().getEtatNourris()));
        champStockRuche.setText(Integer.toString(ruche.getStockNourriture()));
        champAbeilleDisponibleCollecte.setText(Integer.toString(ruche.getArbre().getTaille()));
        champAbeillesAttenteStockage.setText(Integer.toString(ruche.getTailleFile()));
        champCimetiereAbeilles.setText(Integer.toString(ruche.getTailleCimetierre()));
        
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
        
        boutonPondre.addActionListener(new ActionListener()	
		{					
			public void actionPerformed(ActionEvent eve)
			{
				Reine reine = monde.getRuche().getReine();
				if (reine.getEtatNourris() >= Reine.coutNourriturePourPondre) {
				    ABRFatigueOuvriere arbre = monde.getRuche().getArbre();
				    arbre.inserer(reine.pondre());
				    champEtatNourris.setText(Integer.toString(reine.getEtatNourris()));
				    champAbeilleDisponibleCollecte.setText(Integer.toString(arbre.getTaille()));
				}
			}
				
		});
        
        boutonMangerReine.addActionListener(new ActionListener()	
		{					
			public void actionPerformed(ActionEvent eve)
			{
				Reine reine = monde.getRuche().getReine();
				Ruche ruche = monde.getRuche();
				if ((reine.getEtatNourris() < Reine.etatNourrisMax) && (ruche.getStockNourriture() >= Reine.quantiteReineMange)) {
					reine.manger(ruche);
					champEtatNourris.setText(Integer.toString(reine.getEtatNourris()));
					champStockRuche.setText(Integer.toString(ruche.getStockNourriture()));
				}
			}
				
		});
        
        
        
        contenuFenetre.add(fenetreBouton, BorderLayout.SOUTH);
        
        // Configuration de la fenêtre
        contenuFenetre.setBackground(new Color(255, 255, 0));
        this.setContentPane(contenuFenetre);
        fenetreBouton.setPreferredSize(new Dimension(1500, 150)); 
        this.pack(); 
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
    }
}
