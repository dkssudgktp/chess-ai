package chess;

public class Game {
	public Game() {
		// TODO Auto-generated constructor stub
	}
	public String[][] table = new String[8][8];
	private String[] pieces = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook" };

	private void newGame() {
		for (int i = 0; i < pieces.length; i++) {

		}

		for (int i = 0; i < 8; i++) {
			table[1][i] = "Black_Pawn";
		}
		for (int i = 0; i < 8; i++) {
			table[6][i] = "White_Pawn";
		}
	}
}
