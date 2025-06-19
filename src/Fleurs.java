
public class Fleurs {
private int quantiteNourriture = quantiteNourritureMax;
public static final int quantiteNourritureMax = 10;
public static final int quantiteNourritureRetirableMax = 1;

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
