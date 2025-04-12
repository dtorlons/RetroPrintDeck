package test;

import javax.swing.*;
import java.awt.*;

class SerialSender extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField inputField;
	private SerialManager serialManager;
	private SerialFileSender fileSender;

	public SerialSender(SerialManager manager, SerialFileSender fileSender) {
		this.serialManager = manager;
		this.fileSender = fileSender;
		setTitle("Data sender");
		setSize(800, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 7)); // Layout a griglia per i pulsanti

		// Mappa dei nomi per i caratteri speciali con valore decimale
		String[] controlChars = { "NUL (0)", "SOH (1)", "STX (2)", "ETX (3)", "EOT (4)", "ENQ (5)", "ACK (6)",
				"BEL (7)", "BS (8)", "TAB (9)", "LF (10)", "VT (11)", "FF (12)", "CR (13)", "SO (14)", "SI (15)",
				"DLE (16)", "DC1 (17)", "DC2 (18)", "DC3 (19)", "DC4 (20)", "NAK (21)", "SYN (22)", "ETB (23)",
				"CAN (24)", "EM (25)", "SUB (26)", "ESC (27)", "FS (28)", "GS (29)", "RS (30)", "US (31)" };

		for (int i = 0; i <= 31; i++) {
			JButton button = new JButton(controlChars[i]);
			button.setBackground(Color.green);
			if (i == 10)
				button.setBackground(Color.orange);
			if (i == 27)
				button.setBackground(Color.red);
			if (i == 17)
				button.setBackground(Color.GRAY);
			if (i == 18)
				button.setBackground(Color.GRAY);
			if (i == 19)
				button.setBackground(Color.GRAY);
			if (i == 20)
				button.setBackground(Color.GRAY);
			final char charToSend = (char) i;
			button.addActionListener(e -> serialManager.send(charToSend));
			panel.add(button);
		}

		inputField = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(e -> {
			String text = inputField.getText();
			if (!text.isEmpty()) {

				for (int i = 0; i < text.length(); i++) {
					serialManager.send(text.charAt(i));
				}
				inputField.setText("");
			}
		});

		JPanel inputPanel = new JPanel();

		inputPanel.add(inputField);
		inputPanel.add(sendButton);
		
		JButton sendFileBtn = new JButton("Send file...");
		sendFileBtn.addActionListener(e ->{this.fileSender.sendFile();});
		inputPanel.add(sendFileBtn);

		add(panel, BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
}
