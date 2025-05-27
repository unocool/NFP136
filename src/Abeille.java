
public abstract class Abeille {
	private int numero;
	private static int identifiant = 0;
	public Abeille() {
		identifiant++;
		this.numero = getIdentifiant();
	}
	public static int getIdentifiant() {
		return identifiant;
	}
	public int getNumero() {
		return this.numero; 
	}
}
