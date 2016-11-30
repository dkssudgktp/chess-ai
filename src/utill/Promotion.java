package utill;

import chess.Board;
import chess.Game;

public class Promotion {
	int prox = 0;
	int proy = 0;
	
	public Promotion(int prox, int proy) {
		if (prox == 0 && Board.isWhiteTurn && Game.table[prox][proy].equals("White_Pawn")) {
			new PromotionFrame(prox, proy, true);
		}else if (prox == 7 && !Board.isWhiteTurn && Game.table[prox][proy].equals("Black_Pawn")) {
			new PromotionFrame(prox, proy, false);
		}
	}
	
	
}
