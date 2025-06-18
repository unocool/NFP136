import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Ruche {
private Reine reine = new Reine(30);
private int stockNourriture = 1;
public static final int stockNourritureMax = 20;
private Queue<Ouvriere> fileStockNourriture = new LinkedList<>();
private ABRFatigueOuvriere arbre = new ABRFatigueOuvriere();
private ArrayList<Ouvriere> cimetierreAbeilles = new ArrayList<Ouvriere>();

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

public ABRFatigueOuvriere getArbre() {
    return arbre;
}

public void ajouterOuvriereStock(Ouvriere ouvriere) {
    fileStockNourriture.add(ouvriere);
}

public Ouvriere retirerOuvriereStock() {
    return fileStockNourriture.poll();
}

public int getTailleFile() {
	return fileStockNourriture.size();
}

public void ajouterOuvriereCimetierre(Ouvriere ouvriere) {
	cimetierreAbeilles.add(ouvriere);
}

public int getTailleCimetierre() {
	return cimetierreAbeilles.size();
}

}
