package chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame implements MouseListener{

	JPanel [][] squares;
	public static void main(String[] args) {
		Board test = new Board();
        test.addPiece("king.bmp",0,0);
        test.setSize(300,300);
        test.setResizable(false);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
	}
	
	public void addPiece(String piece_name,int i, int j)
    {
        Icon piece_icon = new ImageIcon(getClass().getResource(piece_name));
        squares[i][j].add((JComponent)piece_icon);
    }
	
	public Board(){
		Container c = getContentPane();
		c.setLayout(new GridLayout(8, 8, 1, 1));
		squares = new JPanel[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new JPanel();
				if ((i+j)%2 == 0) 
					squares[i][j].setBackground(Color.WHITE);
				else 
					squares[i][j].setBackground(Color.BLACK);
				squares[i][j].addMouseListener(this);
				c.add(squares[i][j]);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
