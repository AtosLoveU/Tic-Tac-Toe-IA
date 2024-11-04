public class Model_Cells {
	
	private int x;
	private int y;
	private CellState etat;
	
	enum CellState {
		EMPTY,
		X,
		O
	}

	public Model_Cells(int x, int y, CellState etat) {
		this.x = x;
		this.y = y;
		this.etat = etat;
	}
	
	public void setx(int x) {
		this.x = x;
	}
	
	public int getx() {
		return x;
	}
	
	public void sety(int y) {
		this.y = y;
	}
	
	public int gety() {
		return y;
	}
	
	public void setEtat(CellState etat) {
		this.etat = etat;
	}
	
	public CellState getEtat() {
		return etat;
	}

}
