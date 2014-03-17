package foundation;

public class Cell {
	private int x;
	private int y;
	private boolean isAlive;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.isAlive = false;
	}
	
	public Cell(int x, int y, boolean isAlive) {
		this(x,y);
		this.isAlive = isAlive;
	}
	
	public String toString() {
		if(isAlive) {
			return "1";
		} else {
			return "0";
		}
	}
}
