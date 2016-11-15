package chess;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Piece extends JLabel{
	/**
	 * 말의 이미지를 띄우기 위해 jlabel 생성 하는 곳 
	 */
	private static final long serialVersionUID = 1L;
	public Piece() {
		super(new ImageIcon("Black_King.png"));
	}
	
	public Piece(String image_file)
    {
        super(new ImageIcon(image_file));
    }
	public static void main(String[] args) {
		Board t = new Board();
		t.addPiece(new Piece("img/Black_Bishop.png"), 0, 0);
		t.addPiece(new Piece("img/Black_Bishop.png"), 2, 0);
	}
}
