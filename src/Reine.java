
public class Reine extends Abeille{
private int etatNourris;
public static final int etatNourrisMax = 30;
public Reine(int etatNourris) {
	this.etatNourris = etatNourris;
}
public int getEtatNourris() {
	return etatNourris;
}
public Ouvriere pondre() {
	etatNourris-=5;
	return new Ouvriere();
}
public void manger(Ruche ruche) {
	this.etatNourris+=1;
	ruche.setStockNourriture(ruche.getStockNourriture()-1);
}
}
