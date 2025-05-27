
public class Reine {
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
Manger
}
