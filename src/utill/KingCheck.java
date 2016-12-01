package utill;

import chess.Board;
import chess.Game;

import java.util.List;
import java.util.ArrayList;

public class KingCheck {

	int Black_Kingx = 0;
	int Black_Kingy = 4;
	int White_Kingx = 7;
	int White_Kingy = 4;
	
	KingCheck(){
	}


	public Byte[][] Check() {
		List<Byte> resx = new ArrayList<Byte>();
		List<Byte> resy = new ArrayList<Byte>();

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
						Byte[][] possible = Game.stuffCheck(i,j);
						for (int k = 0; k < possible[0].length; k++) {
							if (possible[0][k] == i && possible[1][k] == j) {
								resx.add((byte) i);
								resy.add((byte) j);
							}
						}
					}else if (!Board.isWhiteTurn && Game.isSet(i, j) && Game.table[i][j].startsWith("White")) {
						Byte[][] possible = Game.stuffCheck(i,j);
						for (int k = 0; k < possible[0].length; k++) {
							if (possible[0][k] == i && possible[1][k] == j) {
								resx.add((byte) i);
								resy.add((byte) j);
							}
						}
					}
				}
			}
			
			Byte[] bResX = resx.toArray(new Byte[resx.size()]);
		    Byte[] bResY = resy.toArray(new Byte[resy.size()]);
		    Byte[][] result = new Byte[][] { bResX, bResY };
		    
		    return result;
		}
    
    

}
