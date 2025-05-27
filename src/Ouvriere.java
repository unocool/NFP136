
public class Ouvriere {
private boolean possessionNourriture;
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
	
}
}
