package utill;

import chess.Board;
import chess.Game;

public class KingCheck {
	
	int Black_Kingx = 0;
	int Black_Kingy = 0;
	int White_Kingx = 0;
	int White_Kingy = 0;
	private void Check() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (Game.isSet(i, j) && Board.isWhiteTurn && Game.table[i][j].equals("White_King")) {
				}
			}
		}
	}
}
