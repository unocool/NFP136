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
    
    private JLabel labelAbeillesDisponiblesCollecte = new JLabel("Abeilles disponible pour collecter :");
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
    	JLabel zoneTexte = new JLabel("Le programme se comporte de cette façon : l'états nourris de la reine permet de pondre une ouvrière en la diminuant de 5, "
    			+"elle est directement envoyée dans la file pour collecter.La reine peut manger en diminuant le stock ruche pour augmenter son états nourris (qui ne peut pas dépasser 30."
    			+"La fleur possède une certaine quantité de pollen, le bouton floraison permet de la mettre au maximum.Les abeilles disponible pour collecter peuvent aller prendre 2 pollen, "
    			+"elles sont ensuite placées dans la file pour stocker leur butin, aller chercher du pollen augmente la fatigue de l'ouvrière de 1, à 3 points de fatigue l'abeille meurt et va "
    			+"au cimetière des abeilles (Attention si elle part collecter alors qu'il n'y a pas de pollen présent, elle gagne quand même un point de fatigue).Les abeilles en attente pour "
    			+"stockage peuvent aller stocker leur pollen dans le stock ruche, elle seront ensuite placé dans les abeilles disponible pour collecter.");
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
        
        boutonCollecter.addActionListener(new ActionListener()	
		{					
			public void actionPerformed(ActionEvent eve)
			{
				Ruche ruche = monde.getRuche();
				Ouvriere ouvriere = ruche.getArbre().extraireMoinsFatiguee();
				if (ouvriere != null) {
					//si L'ouvrière est trop fatigué, on l'envoie au cimetière
					if (ouvriere.getFatigue() >= Ouvriere.fatigueMax) {
						ruche.ajouterOuvriereCimetierre(ouvriere);
						champCimetiereAbeilles.setText(Integer.toString(ruche.getTailleCimetierre()));
						champAbeilleDisponibleCollecte.setText(Integer.toString(ruche.getArbre().getTaille()));
					}
					else {
						Fleurs fleurs = monde.getFleurs();
						ouvriere.chercherNourriture(fleurs);
						//Sinon si elle à réussi à collecter de la nourriture (présence de pollen sur la fleur), elle est envoyé dans la file pour stocker
						if (ouvriere.getPossedeNourriture() == true) {
							ruche.ajouterOuvriereStock(ouvriere);
							champAbeillesAttenteStockage.setText(Integer.toString(ruche.getTailleFile()));
							champAbeilleDisponibleCollecte.setText(Integer.toString(ruche.getArbre().getTaille()));
							champQuantitePollen.setText(Integer.toString(fleurs.getQuantiteNourriture()));
						}
						//Sinon elle retourne dans l'arbre avec de la fatigue en plus, car elle a été chercher de la nourriture sans en trouver (plus de nourriture dans la fleur)
						else {
							ABRFatigueOuvriere arbre = monde.getRuche().getArbre();
						    arbre.inserer(ouvriere);
						    champEtatNourris.setText(Integer.toString(ruche.getTailleFile()));
						    champAbeilleDisponibleCollecte.setText(Integer.toString(arbre.getTaille()));
						}
					}
				}
			}
				
		});
        
        boutonStocker.addActionListener(new ActionListener()	
		{					
			public void actionPerformed(ActionEvent eve)
			{
				Ruche ruche = monde.getRuche();
				if(ruche.getStockNourriture() <= (Ruche.stockNourritureMax-Fleurs.quantiteNourritureRetirableMax)) {
					Ouvriere ouvriere = ruche.retirerOuvriereStock();
					if (ouvriere != null) {
						ouvriere.stockerNourriture(ruche);
						ruche.getArbre().inserer(ouvriere);
						champStockRuche.setText(Integer.toString(ruche.getStockNourriture()));
						champAbeilleDisponibleCollecte.setText(Integer.toString(ruche.getArbre().getTaille()));
						champAbeillesAttenteStockage.setText(Integer.toString(ruche.getTailleFile()));
					}
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
