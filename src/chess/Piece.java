package chess;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Piece extends JLabel{
	//make JLabel with image icon

	private static final long serialVersionUID = 1L;
	public Piece() {
		super(new ImageIcon("Black_King.png"), JLabel.CENTER);
	}

	public Piece(String image_file) {
    super(new ImageIcon(image_file), JLabel.CENTER);
  }
}
