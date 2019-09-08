import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {

		// in previous version like JAVA 4 || 5
		// as some says we need to run swing application in
		// special thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Hello World");
				frame.setSize(600, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
