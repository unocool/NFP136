
public class ABRFatigueOuvriere {
	private NoeudOuvriere racine;
	private int taille = 0;
	// On stock l'ouvrière dans l'abre binaire de recherche selon sa fatigue
	public void inserer(Ouvriere ouvriere) {
		if (racine == null){
			racine = new NoeudOuvriere(ouvriere);
			taille++;
			return;
		}

		NoeudOuvriere courant = racine;
		// Descente dans l'arbre pour insérer au bon endroit
		while(true) {
			if(ouvriere.getFatigue() < courant.ouvriere.getFatigue()) {
				if (courant.fg == null) {
					courant.fg = new NoeudOuvriere(ouvriere);
					taille++;
					break;
					}
				courant = courant.fg;
			} 
			else {
				if (courant.fd == null) {
					courant.fd = new NoeudOuvriere(ouvriere);
					taille++;
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
		taille--;
		return courant.ouvriere;
		
	}
	
	public int getTaille() {
	    return taille;
	}
    
}
