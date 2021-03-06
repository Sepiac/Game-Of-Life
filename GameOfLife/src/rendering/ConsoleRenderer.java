package rendering;

import foundation.Grid;

public class ConsoleRenderer {
	public static void render(Grid g, int width, int height) {
		
		for(int i=0; i<width+2; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=0; i<width; i++) {
			System.out.print("*");
			for(int j=0; j<height; j++) {
				System.out.print(g.getCell(i, j));
			}
			System.out.println("*");
		}
		
		for(int i=0; i<width+2; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
	}
}
