
public class Ouvriere {
private boolean possessionNourriture;
private int fatigue = 0;
public static final int fatigueMax = 3;
public Ouvriere (){
}
public void chercherNourriture(Fleurs fleur) {
	fatigue++;
	possessionNourriture = true;
	//creer get et set dans fleurs
}
}
