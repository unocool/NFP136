
public class Reine extends Abeille{
private int etatNourris;
public static final int etatNourrisMax = 30;
public static final int quantiteReineMange = 1;
public static final int coutNourriturePourPondre = 5;

public Reine(int etatNourris) {
	this.etatNourris = etatNourris;
}

public int getEtatNourris() {
	return etatNourris;
}

public Ouvriere pondre() { 
	etatNourris-=coutNourriturePourPondre;
	return new Ouvriere();
	
}

public void manger(Ruche ruche) {
	this.etatNourris+=quantiteReineMange;
	ruche.setStockNourriture(ruche.getStockNourriture()-quantiteReineMange);
}
}
