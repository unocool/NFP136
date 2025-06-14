
public class Fleurs {
private int quantiteNourriture = quantiteNourritureMax;
public static final int quantiteNourritureMax = 10;

public Fleurs() {
}

public void floraison() {
	this.quantiteNourriture = quantiteNourritureMax;
}

public void setQuantiteNourriture(int quantiteNourriture) {
	this.quantiteNourriture = quantiteNourriture;
}

public int getQuantiteNourriture() {
	return this.quantiteNourriture;
}
}
