package rendering;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Map;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import computation.ConwayStepper;
import computation.Utils;

import foundation.Cell;
import foundation.Grid;

public class SquareGUIRenderer extends JFrame{
	
	public Grid grid;
	public int squareSize;
	
	private Timer timer;
	
	public SquareGUIRenderer(final Grid grid, final int squareSize) {
		this.grid = grid;
		this.squareSize = squareSize;
		
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_S : timer.start(); break;
				case KeyEvent.VK_R : grid.randomizieSquare(squareSize, squareSize); repaint(); break;
				case KeyEvent.VK_T : timer.stop(); break;
				case KeyEvent.VK_P : repaint(); break;
				}
			}
		});
		
		setTitle("Game of Life");
		add(new GUIPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		pack();
		setFocusable(true);
		requestFocusInWindow();
		setVisible(true);
	}
	
	
	
	class GUIPanel extends JPanel {
		
		public GUIPanel(){
			timer = new Timer(100, new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					repaint();
				}
			});
		}
		
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawGrid(g);
			grid = ConwayStepper.step(grid);
		}
		
		private void drawGrid(Graphics g) {
			for(int i=0; i<squareSize; i++) {
				for(int j=0; j<squareSize; j++) {
					drawCell(g, grid.getCell(i, j));
				}
			}
		}
		
		private void drawCell(Graphics g, Cell c) {
			int pixelSize = 10;
			if(c.isAlive()){
				g.setColor(Color.magenta);
			} else {
				g.setColor(Color.lightGray);
			}
			g.fillRect(c.getX()*pixelSize, c.getY()*pixelSize, pixelSize, pixelSize);
		}
	}
}
