
public class Board {
	private int size;
	private Square[][] board;

	public Board(int size) {
		this.size = size;
		board = new Square[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				board[i][j] = new Square(new Symbol("-"));
			}
		}
	}

	public Square[][] getBoard() {
		return this.board;
	}

	public Square getSquare(int row, int column) {
		return this.board[row][column];
	}

	public boolean isValidPlacing(int row, int column) {
		if (row < this.size && row >= 0 && column < this.size && column >= 0 && board[row][column].toString().equals("-"))
			return true;
		else
			return false;
	}

	public void placeSymbol(Symbol s, int row, int col) {
		board[row][col].setStatus(s);
	}

	public void printBoard() {
		for (int i = 0;i<=this.size;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for (int i = 0; i < this.size; i++) {
			System.out.print((i+1)+" ");
			for (int j = 0; j < this.size; j++) {
				System.out.print(getSquare(i, j).toString() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean isConsecFive(Symbol symb) {
		String horizon = "";
		String vertical = "";
		String diagonal = "";
		String consec = "";
		for (int i = 0; i < 5; i++) {
			consec += symb.getSymbol();
		}
		for (int k = 0;k<size;k++) {
			for (int i = k,j = 0;i<size && j < size;i++,j++) {
				diagonal += board[i][j].toString();
			}
			if (diagonal.contains(consec)) return true; else diagonal = "";
		}
		for (int k = 0;k<size;k++) {
			for (int i = k,j = size-1;i<size && j >= 0;i++,j--) {
				diagonal += board[i][j].toString();
			}
			if (diagonal.contains(consec)) return true; else diagonal = "";
		}
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				horizon += board[i][j].toString();
				vertical +=board[j][i].toString();
			}
			if (horizon.contains(consec) || vertical.contains(consec)) return true;
			else {horizon =""; vertical = "";}
		}
		return false;
	}
}
