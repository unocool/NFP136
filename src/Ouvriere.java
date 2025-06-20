
public class Ouvriere extends Abeille {
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
