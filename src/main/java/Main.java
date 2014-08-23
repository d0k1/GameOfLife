/**
 * Created by Denis V. Kirpichenkov on 23.08.14.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Test");
		final MainFrame frame = new MainFrame(50, 50);
		final Engine eng = new Engine(frame.getGrid());

		new Blinker(frame.getGrid());
		//new Block(frame.getGrid());
		new Beacon(frame.getGrid());
		new Glinder(frame.getGrid());
		frame.getGrid().redrawLife();
		//eng.step();

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					eng.step();
					frame.getGrid().redrawLife();

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		thread.start();
	}

}
