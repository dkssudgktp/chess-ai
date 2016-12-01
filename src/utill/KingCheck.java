package utill;

import chess.Board;
import chess.Game;
import structure.Pos;
import java.util.List;
import java.util.ArrayList;

public class KingCheck {

	int Black_Kingx = 0;
	int Black_Kingy = 4;
	int White_Kingx = 7;
	int White_Kingy = 4;

	public KingCheck() { }

	public Pos[] Check() {
		List<Pos> res = new ArrayList<Pos>();

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (Game.isSet(i, j) && Game.table[i][j].equals("White_King")) {
					White_Kingx = i;
					White_Kingy = j;
				}else if (Game.isSet(i, j) && Game.table[i][j].equals("Black_King")) {
					Black_Kingx = i;
					Black_Kingy = j;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (Board.isWhiteTurn && Game.isSet(i, j) && Game.table[i][j].startsWith("Black")) {
					Pos[] possible = Game.stuffCheck(i, j);
					for (int k = 0; k < possible.length; ++k) {
						if (possible[k].x == i && possible[k].y == j) {
							res.add(possible[k]);
						}
					}
				}
				else if (!Board.isWhiteTurn && Game.isSet(i, j) && Game.table[i][j].startsWith("White")) {
					Pos[] possible = Game.stuffCheck(i, j);
					for (int k = 0; k < possible.length; ++k) {
						if (possible[k].x == i && possible[k].y == j) {
							res.add(possible[k]);
						}
					}
				}
			}
		}

		Pos[] result = res.toArray(new Pos[res.size()]);
	  return result;
	}
}
