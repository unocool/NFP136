
public class ABRFatigueOuvriere {
	private NoeudOuvriere racine;
	// On stock l'ouvrière dans l'abre binaire de recherche selon sa fatigue
	public void inserer(Ouvriere ouvriere) {
		if (racine == null){
			racine = new NoeudOuvriere(ouvriere);
			return;
		}

		NoeudOuvriere courant = racine;
		//Parcours infixe de l'arbre
		while(true) {
			if(ouvriere.getFatigue() < courant.ouvriere.getFatigue()) {
				if (courant.fg == null) {
					courant.fg = new NoeudOuvriere(ouvriere);
					break;
					}
				courant = courant.fg;
			} 
			else {
				if (courant.fd == null) {
					courant.fd = new NoeudOuvriere(ouvriere);
					break;
					}
				courant = courant.fd;
			}
			}
	}

    // On récupère l’ouvrière avec la fatigue la moins élevée (située le plus à gauche de l'abre)
	public Ouvriere extraireMoinsFatiguee() {
		if (racine == null) {
			return null;
			}
		NoeudOuvriere parent = null;
		NoeudOuvriere courant = racine;

		while (courant.fg != null) {
			parent = courant;
			courant = courant.fg;
			}
		// Supprime le nœud le moins fatigué
		if (parent == null) {
			racine = courant.fd;// si le premier noeud gauche est nul, on le remplace par le noeud droit (si la racine est une feuille, elle prend la valeur null)
			} 
		else {
			parent.fg = courant.fd;//L'ouvrière avec la fatigue la moins élevée est dans parent.fg, donc on la supprime en la remplaçant par courant.fd
			}
		return courant.ouvriere;
	}
	
	// Parcours infixe pour debug/affichage
    public void afficherInfixe() {
        afficherRec(racine);
    }

    private void afficherRec(NoeudOuvriere n) {
        if (n != null) {
            afficherRec(n.fg);
            System.out.println("Ouvrière: fatigue=" + n.ouvriere.getFatigue());
            afficherRec(n.fd);
        }
    }

    
}
