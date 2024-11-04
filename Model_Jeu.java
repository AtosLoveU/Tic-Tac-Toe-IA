public class Model_Jeu {
	
	private int joueur; 
	
	public Model_Jeu() {
		this.joueur = 0;
	}
	
	public void Tour() {
		joueur++;
		joueur = joueur % 2;
		
	}
	
	public int getJoueur() {
		return joueur;
	}
}
