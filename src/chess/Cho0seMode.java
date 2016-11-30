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
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
  public Cho0seMode(){
    Container pane = getContentPane();
	pane.setLayout(new GridLayout(1, 2));
	

	
    p1.add(new Piece("img/human.jpg"));
    p2.add(new Piece("img/computer.jpg"));
    
    p1.add(new JLabel("Human Vs Human"));
    p2.add(new JLabel("Human Vs Computer"));
    
    p1.addMouseListener(this);
    p2.addMouseListener(this);
    
    pane.add(p1);
    pane.add(p2);
    
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
	// TODO Auto-generated method stub
	JPanel getJ = (JPanel) e.getComponent();
	if (getJ.equals(p1)) 
		Game.isAiPlaying = true;
	this.dispose();
	new Game();
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
