package chess;

import stuff.Pair;
import structure.Pos;

public class Game {
	public static String[][] table = new String[8][8];
	public static Boolean isAiPlaying = false;
	private String[] pieces = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook" };

	public Game() {
		newGame();
		Board t = new Board();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (table[i][j] != null) {
					t.addPiece(new Piece("img/"+table[i][j]+".png"), i, j);
				}
			}
		}
	}

	private void newGame() {
		for (int i = 0; i < pieces.length; i++) {
			table[0][i] = "Black_"+pieces[i];
			table[7][i] = "White_"+pieces[i];
			table[1][i] = "Black_Pawn";
			table[6][i] = "White_Pawn";
		}
	}

	public static Pos[] stuffCheck(int chosenx, int choseny) {
		Pos[] possible = null;
		Pair piece = Pair.getStuffClass(table[chosenx][choseny]);

		if (piece != null) {
			possible = piece.movable(chosenx, choseny);
		}

		return possible;
	}

	public static boolean isValuable(int i , int j){
		if (i < 8 && i >= 0 && j < 8 && j >= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isSet(int i, int j){
		boolean result = false;

		try {
			if (table[i][j] != null) {
				result = true;
			}
		} catch (Exception e) {}

		return result;
	}

	public static boolean isEnemy(int i, int j) {
		if (isSet(i, j)) {
			if ((Board.isWhiteTurn && table[i][j].startsWith("Black"))
				|| (!Board.isWhiteTurn && table[i][j].startsWith("White")))
			{
				return true;
			}
		}

		return false;
	}
}
