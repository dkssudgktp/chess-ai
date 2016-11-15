package chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame implements MouseListener{

	/**
	 * 체크판의 기본적인 배경 및 말 그리는 곳
	 */
	private static final long serialVersionUID = 1L;
	JPanel [][] squares;
	
	public void addPiece(Piece p,int i, int j){
        squares[i][j].add(p);
        paintAll(getGraphics());
    }
	
	public void removePiece(int x, int y){
        squares[x][y].remove(0);
        paintAll(getGraphics());
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
		
		ImageIcon img = new ImageIcon("img/icon.png");
		this.setIconImage(img.getImage());
		this.setSize(500,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getSource());
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
