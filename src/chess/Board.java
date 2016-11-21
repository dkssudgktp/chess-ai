package chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame implements MouseListener{
	static boolean chosen;//선택 되었는지 확인 true 선택됨 false 선택 안됨
	static boolean BWchose;//누구의 차레인지 Ture:화이트, false:블랙
	static int chosenx, choseny, gox, goy;
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
		c.setLayout(new GridLayout(8, 8));
		squares = new JPanel[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new JPanel();
				squares[i][j].setName(String.valueOf(i)+'.'+String.valueOf(j));
				if ((i+j)%2 == 0)
					squares[i][j].setBackground(Color.decode("#FFC489"));
				else
					squares[i][j].setBackground(Color.decode("#C77931"));
				squares[i][j].addMouseListener(this);
				c.add(squares[i][j]);
			}
		}

		ImageIcon img = new ImageIcon("img/icon.png");
		this.setIconImage(img.getImage());
		this.setSize(550,550);
		this.setTitle("Chess");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	private void pickup(Object e) {
		JPanel j = (JPanel)e;

		if (j.getBorder() != null && chosen == true) {
			j.setBorder(null);
			chosen = false;
		}
		else if(j.getBorder() == null && chosen == false) {
			StringTokenizer position = new StringTokenizer(j.getName(), ".");

			chosenx = Integer.parseInt(position.nextToken());
			choseny = Integer.parseInt(position.nextToken());

			System.out.println(1);
			if (Game.isSet(chosenx, choseny)) {
				squares[chosenx][choseny].setBorder(BorderFactory.createLineBorder(Color.red,4));
				chosen = true;
			}

		}
		else if(j.getBorder() == null && chosen == true){
			StringTokenizer position = new StringTokenizer(j.getName(), ".");

			gox = Integer.parseInt(position.nextToken());
			goy = Integer.parseInt(position.nextToken());

			System.out.println(chosenx);
			System.out.println(gox);

			Movement m = new Movement();

			if (m.piecemove()) {
				System.out.println("asd");
				System.out.println(squares[gox][goy].getName());
				squares[gox][goy].add(squares[chosenx][choseny].getComponent(0));
				//squares[chosenx][choseny].remove(0);
				paintAll(getGraphics());

				squares[chosenx][choseny].setBorder(null);
				chosen = false;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pickup(e.getSource());
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
