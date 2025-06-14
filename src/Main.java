
public class Main {

	public static void main(String[] args) {
		Monde monde = new Monde();
		System.out.println(monde.getRuche().getReine().getEtatNourris());
		System.out.println(monde.getFleurs().getQuantiteNourriture());
		monde.getRuche().getReine().manger(monde.getRuche());
		System.out.println(monde.getRuche().getStockNourriture());
	}

}
