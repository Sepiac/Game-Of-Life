package execution;

import foundation.Grid;
import rendering.SquareGUIRenderer;

public class SquareGUIExecuter {
	public static void main(String[] args) {
		
		int squaresize = 50;
		Grid g = new Grid();
		g.initSquare(squaresize, squaresize);
		g.randomizieSquare(squaresize, squaresize);
		
		SquareGUIRenderer gr = new SquareGUIRenderer(g, squaresize);
	}
}
