package computation;

import java.util.Iterator;
import java.util.Map;

import foundation.Cell;
import foundation.Grid;

public class InversionStepper {
	public static Grid step(Grid g) {
		Grid result = new Grid();
		
		Iterator it = g.getMap().entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Cell> pair = (Map.Entry<String, Cell>)it.next();
			result.getMap().put(pair.getKey(), new Cell(pair.getValue().getX(), pair.getValue().getY(), !pair.getValue().isAlive()));
		}
		return result;
	}
}
