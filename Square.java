
public class Square {
	private Symbol status;
	public Square(Symbol symb) {
		this.status = symb;
	}
	public void setStatus(Symbol newStatus) {
		this.status = newStatus;
	}
	public Symbol getStatus () {
		return this.status;
	}
	@Override
	public String toString() {
		return this.status.getSymbol();
	}
}
