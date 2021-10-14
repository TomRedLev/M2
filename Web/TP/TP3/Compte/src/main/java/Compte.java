
public class Compte {
	private int solde = 0;
	
	public void depotDe(int montant) {
		solde += montant;
	}
	
	public void retraitDe(int montant) {
		solde -= montant;
	}
	
	public int valeurDuSolde() {
		return solde;
	}
}
