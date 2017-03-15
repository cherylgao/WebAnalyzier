import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TechnicalQ {
	static String URL;
	static int numWord = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL=args[0];
		GUI gui = new GUI(numWord, URL);
		gui.setSize(600, 500);
		gui.setVisible(true);
		gui.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				int promptResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if (promptResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}

}
