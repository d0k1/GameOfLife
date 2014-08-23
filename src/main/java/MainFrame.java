import javax.swing.*;
import java.awt.*;

/**
 * Created by Denis V. Kirpichenkov on 23.08.14.
 */
public class MainFrame {
	CellGrid canvas;

	public MainFrame(int w, int h) {
		JFrame frame = new JFrame("FrameDemo");

		canvas = new CellGrid(w, h);

		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(1280, 1024);

		frame.getContentPane().add(canvas);

		//5. Show it.
		frame.setVisible(true);
	}

	public CellGrid getGrid(){
		return canvas;
	}
}
