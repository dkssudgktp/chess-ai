package chess;

import ai.AiMain;
import ai.Functions;
import stuff.Pair;
import structure.Pos;
import structure.Tuple;

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
import javax.swing.JOptionPane;


public class Board extends JFrame implements MouseListener {
	private boolean chosen;//선택 되었는지 확인 true 선택됨 false 선택 안됨
	private int chosenx, choseny;
	private AiMain ai = new AiMain();
	private boolean isGameEnd = false;
	public static boolean isWhiteTurn = true;//누구의 차레인지 Ture:화이트, false:블랙

	/*
	 * 체크판의 기본적인 배경 및 말 그리는 곳
	 */
	private static final long serialVersionUID = 1L;
	private JPanel [][] squares;

	public Board(){
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(8, 8));

		squares = new JPanel[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new JPanel();
				squares[i][j].setName(String.valueOf(i)+'.'+String.valueOf(j));

				if ((i + j) % 2 == 0){
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

	public void addPiece(Piece p,int i, int j){
    squares[i][j].add(p);
    paintAll(getGraphics());
  }

	public void removePiece(int x, int y){
    squares[x][y].remove(0);
    paintAll(getGraphics());
  }

	private void moveStuff(Pos chosen, Pos go) {
		if (Game.isEnemy(go.x, go.y)) {
			squares[go.x][go.y].removeAll();
		}

		squares[go.x][go.y].add(squares[chosen.x][chosen.y].getComponent(0));

		Game.table[go.x][go.y] = Game.table[chosen.x][chosen.y];
		Game.table[chosen.x][chosen.y] = null;

		paintAll(getGraphics());
	}

	private void end() {
		String winner = "White";
		if (isWhiteTurn) {
			winner = "Black";
		}

		JOptionPane.showMessageDialog(this, winner + " win !!");
		System.exit(0);
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
				if (Game.isEnemy(chosenx, choseny)) {
					JOptionPane.showMessageDialog(this, "not your turn");
					return;
				}

				squares[chosenx][choseny].setBorder(BorderFactory.createLineBorder(Color.red,4));
				chosen = true;
			}
		}
		else if(panel.getBorder() == null && chosen == true){
			StringTokenizer position = new StringTokenizer(panel.getName(), ".");

			int gox = Integer.parseInt(position.nextToken());
			int goy = Integer.parseInt(position.nextToken());

			Byte[][] possible = Game.stuffCheck(chosenx, choseny);

			for (int i = 0; i < possible[0].length; i++) {
				if (possible[0][i] == gox && possible[1][i] == goy) {

					squares[chosenx][choseny].setBorder(null);
					chosen = false;

					if (Game.isEnemy(gox, goy) && Game.table[gox][goy].endsWith("King")) {
						isGameEnd = true;
					}

					moveStuff(new Pos(chosenx, choseny), new Pos(gox, goy));
					isWhiteTurn = !isWhiteTurn;

					if (isGameEnd) {
						end();
					}
					if (Game.isAiPlaying) {
						aiPlay();
					}

					break;
				}
			}
		}
	}

	private void aiPlay() {
		Tuple<Pos, Pos> move = ai.getBestMove(4);
		Pos chosen = move.fst();
		Pos go = move.snd();

		if (Game.isEnemy(go.x, go.y) && Game.table[go.x][go.y].endsWith("King")) {
			isGameEnd = true;
		}

		System.out.println(Game.table[chosen.x][chosen.y] + " > " + move);

		moveStuff(chosen, go);
		isWhiteTurn = !isWhiteTurn;

		if (isGameEnd) {
			end();
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
