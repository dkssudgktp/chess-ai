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
}
