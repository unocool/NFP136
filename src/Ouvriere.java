
public class Ouvriere extends Abeille {
private boolean possessionNourriture = false;
private int fatigue = 0;
public static final int fatigueMax = 3;
public Ouvriere (){
}
public void chercherNourriture(Fleurs fleur) {
	fatigue++;
	possessionNourriture = true;
	fleur.setQuantiteNourriture(fleur.getQuantiteNourriture()-1);
}
public void stockerNourriture(Ruche ruche) {
	ruche.setStockNourriture(ruche.getStockNourriture()+1);
}
}
