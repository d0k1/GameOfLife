import javax.swing.*;
import java.awt.*;

/**
 * Created by Denis V. Kirpichenkov on 23.08.14.
 */
public class CellGrid extends JPanel {

	private final int cellWidth;
	private final int cellHeight;
	private int widthStep;
	private int heightStep;

	private int [][]matrix;
	private int [][]nextMatrix;

	public CellGrid(int w, int h) {
		cellWidth = w;
		cellHeight = h;
		matrix = new int[w][h];
		nextMatrix = new int[w][h];
	}

	@Override
	public void paint(Graphics g) {

		widthStep = getWidth() / cellWidth;
		heightStep = getHeight() / cellHeight;

		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());

		for(int i=0;i<cellWidth;i++){
			for(int j=0;j<cellHeight;j++){
				int x0 = 0;
				int y0 = 0;

				x0 = i*widthStep;
				y0 = j*heightStep;

				System.out.println("X: "+i+" Y: "+j+" V: "+matrix[i][j]);

				if(matrix[i][j]==0)
				{
					g.setColor(Color.gray);
				} else {
					g.setColor(Color.green);
				}

				g.fillRect(x0, y0, widthStep, heightStep);
			}
		}

		g.setColor(Color.white);

		for(int i=0;i<cellWidth;i++){
			g.drawLine(i*widthStep, 0, i*widthStep, getHeight());
		}

		for(int i=0;i<cellHeight;i++){
			g.drawLine(0, i*heightStep, getWidth(), i*heightStep);
		}

	}

	public void putCell(int x, int y){
		try {
			nextMatrix[x][y] = 1;
		}catch(Throwable e){

		}
	}

	public void deadCell(int x, int y){
		try {
			nextMatrix[x][y] = 0;
		}catch(Throwable e){

		}
	}

	public void nextGeneration(){
		matrix = nextMatrix;
		nextMatrix = new int[cellWidth][cellHeight];
	}

	public void redrawLife(){
		this.repaint();
	}

	public int isCell(int x, int y){
		try {
			if(x<0)
				x = cellWidth + x;
			if(x>=cellWidth)
				x = x - cellWidth;

			if(y<0)
				y = cellHeight + y;

			if(y>=cellHeight)
				y = y - cellHeight;

			return matrix[x][y];
		}catch(Throwable e){
			return 0;
		}
	}

	public int getCellWidth(){
		return cellWidth;
	}

	public int getCellHeight(){
		return cellHeight;
	}
}
