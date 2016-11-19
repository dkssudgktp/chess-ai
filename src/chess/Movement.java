package chess;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Movement {
	boolean piecemove(){
		System.out.println(Game.table[Board.chosenx][Board.choseny]);
		String piece = Game.table[Board.chosenx][Board.choseny];
		StringTokenizer token = new StringTokenizer(piece, "_");
		String color = token.nextToken();
		String pieceKind = token.nextToken();
		
		if (pieceKind.equals("Pawn")) {
			System.out.println(Pawn(color));
			if (Pawn(color)) {
				Game.table[Board.gox][Board.goy] = Game.table[Board.chosenx][Board.choseny];
				Game.table[Board.chosenx][Board.choseny] = null;
				return true;
			}
				
		}
		return false;
	}
	
	private boolean Pawn(String color){
		int Moveable[][] = {{1,1}, {1,-1}, {1,0}, {2,0}};
		
		for (int i = 0; i < Moveable.length; i++) {
			if (Board.gox == Board.chosenx+Moveable[i][0] && Board.goy == Board.choseny+Moveable[i][1]) {
				if (Board.gox == Board.chosenx+2) {
					if (Board.chosenx == 1 || Board.choseny == 6) {
						return true;
					}
					else{
						return false;
					}
				}
				if (Board.gox == Board.chosenx+Moveable[0][0] && Board.goy == Board.choseny+Moveable[0][1]) {
					if (Game.isSet(Board.chosenx+Moveable[0][0], Board.choseny+Moveable[0][1])) {
						return true;
					}else{
						return false;
					}
				}
				if (Board.gox == Board.chosenx+Moveable[1][0] && Board.goy != Board.choseny+Moveable[1][1]) {
					try {
						if (Game.isSet(Board.chosenx+Moveable[1][0], Board.choseny+Moveable[1][1])) {
							return true;
						}else{
							return false;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				return true;
			}
		}
		return false;
	}
	
	static int[] addElement(int[] a, int e) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = e;
	    return a;
	}
}
