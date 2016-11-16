package chess;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Piece extends JLabel{
	/**
	 * 말의 이미지를 띄우기 위해 jlabel 생성 하는 곳
	 */
	private static final long serialVersionUID = 1L;
	public Piece() {
		super(new ImageIcon("Black_King.png"), JLabel.CENTER);
	}

	public Piece(String image_file)
    {
        super(new ImageIcon(image_file), JLabel.CENTER);
    }
	public static void main(String[] args) {
		Board t = new Board();
		t.addPiece(new Piece("img/Black_Rook.png"), 0, 0);
		t.addPiece(new Piece("img/Black_Knight.png"), 0, 1);
		t.addPiece(new Piece("img/Black_Bishop.png"), 0, 2);
		t.addPiece(new Piece("img/Black_Queen.png"), 0, 3);
		t.addPiece(new Piece("img/Black_King.png"), 0, 4);
		t.addPiece(new Piece("img/Black_Bishop.png"), 0, 5);
		t.addPiece(new Piece("img/Black_Knight.png"), 0, 6);
		t.addPiece(new Piece("img/Black_Rook.png"), 0, 7);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 0);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 1);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 2);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 3);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 4);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 5);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 6);
		t.addPiece(new Piece("img/Black_Pawn.png"), 1, 7);
		t.addPiece(new Piece("img/White_Rook.png"), 7, 0);
		t.addPiece(new Piece("img/White_Knight.png"), 7, 1);
		t.addPiece(new Piece("img/White_Bishop.png"), 7, 2);
		t.addPiece(new Piece("img/White_Queen.png"), 7, 3);
		t.addPiece(new Piece("img/White_King.png"), 7, 4);
		t.addPiece(new Piece("img/White_Bishop.png"), 7, 5);
		t.addPiece(new Piece("img/White_Knight.png"), 7, 6);
		t.addPiece(new Piece("img/White_Rook.png"), 7, 7);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 0);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 1);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 2);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 3);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 4);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 5);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 6);
		t.addPiece(new Piece("img/White_Pawn.png"), 6, 7);
	}
}
