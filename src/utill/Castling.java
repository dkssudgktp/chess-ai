package utill;

import chess.Game;

public class Castling {
	String[] list = {"White_Rook", "White_Rook", "Black_RookL", "Black_RookR", "White_King", "Black_King"};
	public static Boolean White_RookL = true;
	public static Boolean White_RookR = true;
	public static Boolean Black_RookL = true;
	public static Boolean Black_RookR = true;
	
	public static Boolean White_King = true;
	public static Boolean Black_King = true;
	Boolean[] chklist = {White_RookL, White_RookR, Black_RookL, Black_RookR, White_King, Black_King};
	public Castling(int gox, int goy) {
		for (int i = 0; i < list.length; i++) {
			if (Game.table[gox][goy].equals(list[i])) {
			}
		}
	}
}
