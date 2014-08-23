/**
 * Created by Denis V. Kirpichenkov on 23.08.14.
 */
public class Blinker {
	public Blinker(CellGrid grid){
		grid.putCell(1,1);
		grid.putCell(2,1);
		grid.putCell(3,1);
		//grid.putCell(2,3);
		grid.nextGeneration();
	}
}
