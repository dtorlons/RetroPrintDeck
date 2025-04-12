package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class SerialReceiver extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea receivedArea;

	public SerialReceiver(SerialManager manager) {
		manager.setReceiver(this);
		setTitle("Serial Monitor");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		receivedArea = new JTextArea();
		receivedArea.setEditable(false);
		receivedArea.setBackground(Color.BLACK);
		receivedArea.setForeground(Color.GREEN);
		receivedArea.setFont(new Font("Monospaced", Font.BOLD, 16));

		JScrollPane scrollPane = new JScrollPane(receivedArea);
		add(scrollPane);
		setVisible(true);
	}

	public void appendReceivedData(char data) {
		SwingUtilities.invokeLater(() -> {
			receivedArea.append(data + "");
			receivedArea.setCaretPosition(receivedArea.getDocument().getLength()); // Auto-scroll
		});
	}
}