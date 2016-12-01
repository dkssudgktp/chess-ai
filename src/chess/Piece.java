package chess;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.net.URL;

public class Piece extends JLabel{
	//make JLabel with image icon

	private static final long serialVersionUID = 1L;
	public Piece() {
		super(new ImageIcon("Black_King.png"), JLabel.CENTER);
	}

	public Piece(String image_file) {
    super(new ImageIcon(image_file), JLabel.CENTER);
  }

	public JLabel make(String image_file) {
		URL url = getClass().getClassLoader().getResource(image_file);
		JLabel img = new JLabel(new ImageIcon(url), JLabel.CENTER);

		return img;
	}
}
