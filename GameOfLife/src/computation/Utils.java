package computation;

import foundation.Grid;

public class Utils {
	public static String getNorthNeighborKey(int x, int y) {
		return x+","+(y-1);
	}
	
	public static String getNorthEastNeighborKey(int x, int y) {
		return (x+1)+","+(y-1);
	}
	
	public static String getEastNeighborKey(int x, int y) {
		return (x+1)+","+(y);
	}
	
	public static String getSouthEastNeighborKey(int x, int y) {
		return (x+1)+","+(y+1);
	}
	
	public static String getSouthNeighborKey(int x, int y) {
		return x+","+(y+1);
	}
	
	public static String getSouthWestNeighborKey(int x, int y) {
		return (x-1)+","+(y+1);
	}
	
	public static String getWestNeighborKey(int x, int y) {
		return (x-1)+","+y;
	}
	
	public static String getNorthWestNeighborKey(int x, int y) {
		return (x-1)+","+(y-1);
	}
	
	public static int getNumberOfLivingNeighbors(String key, Grid g) {
		return getNumberOfLivingNeighbors(Integer.parseInt(key.split(",")[0]), Integer.parseInt(key.split(",")[1]), g);
	}
	
	public static int getNumberOfLivingNeighbors(int x, int y, Grid g) {
		int count=0;
		if(g.getCellByKey(getNorthNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		if(g.getCellByKey(getNorthEastNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		if(g.getCellByKey(getEastNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		if(g.getCellByKey(getSouthEastNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		if(g.getCellByKey(getSouthNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		if(g.getCellByKey(getSouthWestNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		if(g.getCellByKey(getWestNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		if(g.getCellByKey(getNorthWestNeighborKey(x, y)).isAlive()) {
			count ++;
		}
		
		return count;
	}
}
