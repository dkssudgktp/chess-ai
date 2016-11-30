package utill;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chess.Game;
import chess.Piece;

public class PromotionFrame extends JFrame implements MouseListener{
	Boolean Color = true;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	public PromotionFrame(int x, int y, Boolean Color) {// true : white false: black
		this.Color = Color;
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(1, 4));
		
		if (Color) {
			p1.add(new Piece("img/White_Rook.png"));
			p2.add(new Piece("img/White_Knight.png"));
			p3.add(new Piece("img/White_Bishop.png"));
			p4.add(new Piece("img/White_Queen.png"));
		}else {
			p1.add(new Piece("img/Black_Rook.png"));
			p2.add(new Piece("img/Black_Knight.png"));
			p3.add(new Piece("img/Black_Bishop.png"));
			p4.add(new Piece("img/Black_Queen.png"));
		}
		
		ImageIcon img = new ImageIcon("img/icon.png");
		
		this.setIconImage(img.getImage());
		this.setSize(700,300);
		this.setTitle("Promotion");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel getJ = (JPanel) e.getComponent();
		if (Color) {
			if (getJ.equals(p1)) 
				Game.isAiPlaying = true;
			this.dispose();
			new Game();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
