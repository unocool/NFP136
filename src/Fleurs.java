
public class Fleurs {
//La quantité nourriture est considéré comme le pollen disponible sur la fleur
private int quantiteNourriture = quantiteNourritureMax;
public static final int quantiteNourritureMax = 20;
public static final int quantiteNourritureRetirableMax = 2;

public Fleurs() {
}

public void floraison() {
	this.quantiteNourriture = quantiteNourritureMax;
}

public void retirerNourriture() {
	this.quantiteNourriture -=  quantiteNourritureRetirableMax;
}

public int getQuantiteNourriture() {
	return this.quantiteNourriture;
}
}
