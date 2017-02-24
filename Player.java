
public class Player {
	private Symbol symb;
	private String name;
	public Player(String name, Symbol symb) {
		this.name = name;
		this.symb = symb;
	}
	public String getName() {
		return this.name;
	}
	public Symbol getSymbol() {
		return this.symb;
	}
	public void placeSymbol(Board b, int row, int col){
		b.placeSymbol(this.symb, row, col);
	}
}
