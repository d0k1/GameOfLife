/**
 * Created by Denis V. Kirpichenkov on 23.08.14.
 */
public class Beacon {
	public Beacon(CellGrid grid){
		grid.putCell(0,0);
		grid.putCell(1,0);
		grid.putCell(0,1);

		grid.putCell(2,3);
		grid.putCell(3,3);
		grid.putCell(3,2);

		grid.nextGeneration();
	}
}
