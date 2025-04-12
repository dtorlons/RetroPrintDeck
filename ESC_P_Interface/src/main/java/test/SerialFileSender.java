package test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class SerialFileSender extends JFrame {
    private static final long serialVersionUID = 1L;
    private SerialManager serialManager;

    public SerialFileSender(SerialManager manager) {
        this.serialManager = manager;
    }

    public void sendFile() {
        new Thread(() -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    int character;
                    long delay = calculateDelay(serialManager.getBaudRate());

                    ConsoleLog.sendingData();

                    while ((character = reader.read()) != -1) {
                        serialManager.send((char) character);
                        System.out.print((char) character);
                        Thread.sleep(delay);
                    }

                    serialManager.send((char) 10); // Invia un carattere di fine linea

                    ConsoleLog.dataSent();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error sending file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }).start(); // Esegui `sendFile` su un thread separato
    }

    private long calculateDelay(int baudRate) {    
        return 15L;
    }
    
}

class ConsoleLog{
	
	private static final String SENDING_DATA 	= 	"\n\n***********************📤 SENDING DATA STARTED ************************\n\n";
	private static final String DATA_SENT		=	"\n\n***********************✅ DATA SENT SUCCESSFULLY ***********************\n\n";
	
	public static void sendingData() {
		System.out.println(SENDING_DATA);
	}
	
	public static void dataSent() {
		System.out.println(DATA_SENT);
	}
}

