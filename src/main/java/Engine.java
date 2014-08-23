/**
 * Created by Denis V. Kirpichenkov on 23.08.14.
 */
public class Engine {
	private CellGrid grid;

	public Engine(CellGrid grid) {
		this.grid = grid;
	}

	public void step()
	{
		int w = grid.getCellWidth();
		int h = grid.getCellHeight();

		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){

				int count = getNear(i, j);
				int alive = grid.isCell(i, j);

				if(alive == 0 && count==3){
					System.out.println("Alive: x="+i+";y="+j);
					grid.putCell(i,j);
				} else if(alive==1 && (count==2 || count ==3)){
					grid.putCell(i, j);
					System.out.println("Still alive: x="+i+";y="+j);
				} else if(alive==1 && (count<2 || count>3)){
					grid.deadCell(i, j);
					System.out.println("Dead: x="+i+";y="+j);
				}
			}
		}

		grid.nextGeneration();
	}

	public int getNear(int w, int h) {

		int left = grid.isCell(w-1, h);
		int right = grid.isCell(w+1, h);
		int top = grid.isCell(w, h+1);
		int bottom = grid.isCell(w, h-1);
		int top_left = grid.isCell(w-1, h+1);
		int top_right = grid.isCell(w+1, h+1);
		int bottom_left = grid.isCell(w-1, h-1);
		int bottom_right = grid.isCell(w+1, h-1);

		return left+right+top+bottom+top_left+top_right+bottom_left+bottom_right;
	}
}
