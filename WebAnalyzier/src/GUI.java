import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {
//	JLabel label;
//	JTextField tf;
	JButton button;
	JScrollPane scrollPane;
	static JTextArea textArea;
	String input;
	int numWord;

	public GUI(int numWord, String input) {
		this.numWord = numWord;
		this.input=input;
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		//was designed to have user input in GUI, now removed
//		label = new JLabel("Please enter an URL");
//		panel.add(label);
//		tf = new JTextField(30);
//		panel.add(tf);
		button = new JButton("Process");

		panel.add(button);
		textArea = new JTextArea(20, 40);
		scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		panel.add(textArea);
		add(scrollPane, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		Listener listen = new Listener();
		button.addActionListener(listen);

	}

	public void display(ArrayList<ArrayList<String>> result) {
		textArea.setText("");
		for (int i = 0; i < result.size(); i++) {
			ArrayList<String> cur = result.get(i);
			for (int j = 0; j < cur.size(); j++) {
				textArea.append(cur.get(j) + "\n");
				;
			}
		}
	}

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			String input = tf.getText();
			Manager manager = new Manager(input, numWord);
			ArrayList<ArrayList<String>> result;
			try {
				result = manager.manage();
				display(result);
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}

		}
	}

}
