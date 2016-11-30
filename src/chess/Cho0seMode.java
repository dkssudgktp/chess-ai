package chess;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cho0seMode extends JFrame implements MouseListener{
	JPanel humanPanel = new JPanel();
	JPanel aiPanel = new JPanel();

	private static final long serialVersionUID = 1L;

  public Cho0seMode(){
    Container pane = getContentPane();
		pane.setLayout(new GridLayout(1, 2));

    humanPanel.add(new Piece("img/human.jpg"));
    aiPanel.add(new Piece("img/computer.jpg"));

    humanPanel.add(new JLabel("Human Vs Human"));
    aiPanel.add(new JLabel("Human Vs Computer"));

    humanPanel.addMouseListener(this);
    aiPanel.addMouseListener(this);

    pane.add(humanPanel);
    pane.add(aiPanel);

    ImageIcon img = new ImageIcon("img/icon.png");

		this.setIconImage(img.getImage());
		this.setSize(700,300);
		this.setTitle("Chess");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
  }

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel pane = (JPanel) e.getComponent();
		if (pane.equals(aiPanel)) {
			Game.isAiPlaying = true;
		}

		this.dispose();
		new Game();
	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
}
