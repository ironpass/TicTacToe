import java.util.Scanner;

public class Game {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Enter the size of the board: ");
		int boardSize = Integer.parseInt(scanner.nextLine());
		System.out.print("Player one enters the name: ");
		String playerOneName = scanner.nextLine();
		System.out.print("Player two enters the name: ");
		String playerTwoName = scanner.nextLine();
		Board board = new Board(boardSize);
		Player playerOne = new Player(playerOneName, new Symbol("X"));
		Player playerTwo = new Player(playerTwoName, new Symbol("O"));

		while (true) {
			if (playing(playerOne, board))
				break;
			if (playing(playerTwo, board))
				break;
		}
		scanner.close();
	}

	public static boolean playing(Player player, Board board) {
		board.printBoard();
		System.out.println(player.getName() + "'s turn.");
		System.out.print("Please select row: ");
		int row = Integer.parseInt(scanner.nextLine())-1;
		System.out.print("Please select column: ");
		int column = Integer.parseInt(scanner.nextLine())-1;
		while (!board.isValidPlacing(row, column)) {
			System.out.println("You can't place on that square");
			System.out.print("Please select row: ");
			row = Integer.parseInt(scanner.nextLine())-1;
			System.out.print("Please select column: ");
			column = Integer.parseInt(scanner.nextLine())-1;
		}
		player.placeSymbol(board, row, column);
		System.out.println("You placed " + player.getSymbol().getSymbol() + " on " + "(" + row + "," + column + ")\n");
		if (board.isConsecFive(player.getSymbol())) {
			board.printBoard();
			System.out.println(player.getName() + " wins.");
			return true;
		}
		return false;
	}
}
