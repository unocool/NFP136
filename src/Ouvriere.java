
public class Ouvriere extends Abeille {
//La fatigue tue l'ouvrière quand elle atteind la valeur 3 (l'objet ouvrière est déplacé dans l'arraylist cimetière )
private int fatigue = 0;
public static final int fatigueMax = 3;
private boolean possedeNourriture = false;

public Ouvriere (){
}

public void chercherNourriture(Fleurs fleur) {
	fatigue++;
	if (fleur.getQuantiteNourriture() >= Fleurs.quantiteNourritureRetirableMax) {
		fleur.retirerNourriture();
		possedeNourriture =true;
	}
}

public void stockerNourriture(Ruche ruche) {
	ruche.setStockNourriture(ruche.getStockNourriture()+Fleurs.quantiteNourritureRetirableMax);
	possedeNourriture =false;
}

public int getFatigue() {
	return fatigue;
}

public boolean getPossedeNourriture() {
	return possedeNourriture;
}
}
