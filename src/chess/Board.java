package chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
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
	public static boolean BWchose = true;//누구의 차레인지 Ture:화이트, false:블랙
	static Byte[][] possible;
	public static int chosenx, choseny, gox, goy;
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
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(8, 8));

		squares = new JPanel[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new JPanel();
				squares[i][j].setName(String.valueOf(i)+'.'+String.valueOf(j));

				if ((i+j)%2 == 0){
					squares[i][j].setBackground(Color.decode("#FFC489"));
				}
				else {
					squares[i][j].setBackground(Color.decode("#C77931"));
				}

				squares[i][j].addMouseListener(this);
				pane.add(squares[i][j]);
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

	private void pickup(Object obj) {
		JPanel panel = (JPanel)obj;
		if (panel.getBorder() != null && chosen == true) {
			panel.setBorder(null);
			chosen = false;
		}
		else if(panel.getBorder() == null && chosen == false) {
			StringTokenizer position = new StringTokenizer(panel.getName(), ".");

			chosenx = Integer.parseInt(position.nextToken());
			choseny = Integer.parseInt(position.nextToken());

			if (Game.isSet(chosenx, choseny)) {
				squares[chosenx][choseny].setBorder(BorderFactory.createLineBorder(Color.red,4));
				chosen = true;

				Game.stuffCheck();
			}
		}
		else if(panel.getBorder() == null && chosen == true){
			StringTokenizer position = new StringTokenizer(panel.getName(), ".");

			gox = Integer.parseInt(position.nextToken());
			goy = Integer.parseInt(position.nextToken());

			for (int i = 0; i < Board.possible[0].length; i++) {
				if (possible[0][i] == gox && possible[1][i] == goy) {

					squares[chosenx][choseny].setBorder(null);
					chosen = false;

					squares[gox][goy].add(squares[chosenx][choseny].getComponent(0));

					Game.table[gox][goy] = Game.table[chosenx][choseny];
					Game.table[chosenx][choseny] = null;

					paintAll(getGraphics());
					break;
				}
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
