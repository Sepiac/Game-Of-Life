package execution;

import java.util.Scanner;

import computation.ConwayStepper;
import computation.InversionStepper;
import computation.Utils;

import rendering.ConsoleRenderer;
import foundation.Cell;
import foundation.Grid;

public class ConsoleExecuter {
	public static void main(String[] args) {
		int squaresize = 20;
		Grid g = new Grid();
		g.initSquare(squaresize, squaresize);
		g.randomizieSquare(squaresize, squaresize);
		
		ConsoleRenderer.render(g, squaresize, squaresize);
		Scanner in = new Scanner(System.in);
		while(!in.next().equals("q")) {
			System.out.println(Utils.getNumberOfLivingNeighbors(0,0, g));
			g = ConwayStepper.step(g);
			ConsoleRenderer.render(g, squaresize, squaresize);
		}
	}
}
