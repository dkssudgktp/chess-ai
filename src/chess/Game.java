package chess;

import stuff.Bishop;
import stuff.King;
import stuff.Pair;
import stuff.Pawn;
import stuff.Queen;
import stuff.Rook;

public class Game {
	public static String[][] table = new String[8][8];

	private String[] pieces = {"Rook", "Knight", "Bishop", "Queen", "King", "Bishop", "Knight", "Rook" };
	private static String[] stuffpiece = {"Pawn","Rook", "Knight", "Bishop", "Queen", "King"};
	private static Pair[] stuffs = {new Pawn(), new Rook(), new Bishop(), new Queen(), new King()};
	
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

	private void newGame() { // 체크판을 새로 초기화 하는 함수
		for (int i = 0; i < pieces.length; i++) {
			table[0][i] = "Black_"+pieces[i];
			table[7][i] = "White_"+pieces[i];
			table[1][i] = "Black_Pawn";
			table[6][i] = "White_Pawn";
		}
	}

	public static Byte[][] stuffCheck(){// 체스가 갈수 있는 범위 체
		for (int i = 0; i < stuffpiece.length; i++) {
			if (table[Board.chosenx][Board.choseny].endsWith(stuffpiece[i])) {
				Byte[][] possible = stuffs[i].movable();
				for (int j = 0; j < possible.length; j++) {
					for (int j2 = 0; j2 < 2; j2++) {
						System.out.println(possible[j2][j]);
						
					}
				}
				System.out.println("___________________");
			}
		}
		return null;
	}

	public static boolean isSet(int i, int j){ // 이함수는 판에 말이 있는지 없는지 확인할때 쓰는 함수
		if (table[i][j] != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isEnemy(int i, int j) {//true:white false:black
		if (isSet(i,j) && table[i][j].startsWith("White")) {
			return true;
		}
		else {
			return false;
		}
	}
}
