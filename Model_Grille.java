public class Model_Grille {
	
	private Model_Cells[][] tableau = new Model_Cells[3][3];
	
	public Model_Grille() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				tableau[i][j] = new Model_Cells(i, j, Model_Cells.CellState.EMPTY);
			}
		}
	}
	public Model_Cells[][] getTableau() {
		return tableau;
	}
	
	public boolean winCondition() {
		for (int i = 0; i < 3; i++) {
			if(this.tableau[i][0].getEtat() == this.tableau[i][1].getEtat() 
			&& this.tableau[i][0].getEtat() == this.tableau[i][2].getEtat()
			&& this.tableau[i][0].getEtat() != Model_Cells.CellState.EMPTY) {
				return true;	
			}
		}
		for (int i = 0; i < 3; i++) {
			if(this.tableau[0][i].getEtat() == this.tableau[1][i].getEtat() 
			&& this.tableau[0][i].getEtat() == this.tableau[2][i].getEtat()
			&& this.tableau[0][i].getEtat() != Model_Cells.CellState.EMPTY) {
			return true;	
			}
		}
		if (this.tableau[0][0].getEtat() == this.tableau[1][1].getEtat() 
		&& this.tableau[0][0].getEtat() == this.tableau[2][2].getEtat()
		&& this.tableau[0][0].getEtat() != Model_Cells.CellState.EMPTY) {
			return true;	
		}
		if (this.tableau[0][2].getEtat() == this.tableau[1][1].getEtat() 
		&& this.tableau[0][2].getEtat() == this.tableau[2][0].getEtat()
		&& this.tableau[0][2].getEtat() != Model_Cells.CellState.EMPTY) {
			return true;	
		}
		return false;
	}
	
	public boolean DrawCondition() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(this.tableau[i][j].getEtat() == Model_Cells.CellState.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}	

	public void affichageGrille() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Model_Cells.CellState etat = this.tableau[i][j].getEtat();
				if (etat == Model_Cells.CellState.EMPTY) {
					System.out.print("_ ");
				} else if (etat == Model_Cells.CellState.X) {
					System.out.print("X ");
				} else if (etat == Model_Cells.CellState.O) {
					System.out.print("O ");
				}
			}
			System.out.println();
		}
	}


	
}

