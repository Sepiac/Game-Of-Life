package computation;

import java.util.Iterator;
import java.util.Map;

import foundation.Cell;
import foundation.Grid;

public class ConwayStepper {
	public static Grid step(Grid g) {
		Grid result = new Grid();
		
		Iterator it = g.getMap().entrySet().iterator();
		int count = 0;
		while(it.hasNext()) {
			Map.Entry<String, Cell> pair = (Map.Entry<String, Cell>)it.next();

			if(pair.getValue().isAlive() && Utils.getNumberOfLivingNeighbors(pair.getKey(), g) < 2) {
				result.getMap().put(pair.getKey(), new Cell(pair.getValue().getX(), pair.getValue().getY(), false));
			}else
			
			if(pair.getValue().isAlive() && (Utils.getNumberOfLivingNeighbors(pair.getKey(), g) == 2 || Utils.getNumberOfLivingNeighbors(pair.getKey(), g) == 3)) {
				result.getMap().put(pair.getKey(), new Cell(pair.getValue().getX(), pair.getValue().getY(), true));
			}else
			
			if(pair.getValue().isAlive() && Utils.getNumberOfLivingNeighbors(pair.getKey(), g) > 3) {
				result.getMap().put(pair.getKey(), new Cell(pair.getValue().getX(), pair.getValue().getY(), false));
			}else
			
			if(!pair.getValue().isAlive() && Utils.getNumberOfLivingNeighbors(pair.getKey(), g) == 3) {
				result.getMap().put(pair.getKey(), new Cell(pair.getValue().getX(), pair.getValue().getY(), true));
			}else{
				result.getMap().put(pair.getKey(), pair.getValue());
			}
			
			
		}
		
		return result;
	}
	
}
