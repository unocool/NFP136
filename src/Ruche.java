import java.util.LinkedList;
import java.util.Queue;

public class Ruche {
private Reine reine = new Reine(5);
private int stockNourriture = 0;
public static final int stockNourritureMax = 20;
private LinkedList<Ouvriere> listOuvriere = new LinkedList<>(); 
private Queue<Ouvriere> fileStockNourriture = new LinkedList<>();
private Queue<Ouvriere> fileCollecteNourriture = new LinkedList<>();

Ruche(){
	
}

public void setStockNourriture(int stockNourriture) {
	this.stockNourriture = stockNourriture;
}

public int getStockNourriture() {
	return this.stockNourriture;
}

public Reine getReine() {
    return reine;
}
}
