package foundation;

import java.util.HashMap;

public class Grid {
	private HashMap<String, Cell> map;

	public HashMap<String, Cell> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Cell> map) {
		this.map = map;
	}
	
	public Grid() {
		this.map = new HashMap<String, Cell>();
	}
	
	public void initSquare(int width, int height) {
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				map.put(i+","+j, new Cell(i,j));
			}
		}
	}
	
	public void randomizieSquare(int width, int height) {
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				map.get(i+","+j).setAlive(Math.random() < 0.5);
			}
		}
	}
	
	public void initOscillator() {
		map.get("4,1").setAlive(true);
		map.get("4,2").setAlive(true);
		map.get("4,3").setAlive(true);
	}
	
	public Cell getCell(int x, int y) {
		if(map.get(x+","+ y) != null) {
			return map.get(x+","+ y);
		}
		return new Cell(0, 0, false);
	}
	
	public Cell getCellByKey(String key) {
		if(map.get(key) != null) {
			return map.get(key);
		}
		return new Cell(0, 0, false);
	}
}
