package test;

import com.fazecast.jSerialComm.*;
import java.io.InputStream;
import java.io.OutputStream;

class SerialManager {
	private SerialPort comPort;
	private InputStream input;
	private OutputStream output;
	private SerialReceiver receiver;

	public SerialManager(String portName, int baudRate) {
		comPort = SerialPort.getCommPort(portName);
		comPort.setBaudRate(baudRate);
		if (comPort.openPort()) {
			input = comPort.getInputStream();
			output = comPort.getOutputStream();
			System.out.println("Porta seriale aperta: " + portName);
			startListening();
		} else {
			System.out.println("❌ Impossibile aprire la porta seriale.");
		}
	}

	public void send(char data) {
		try {
			output.write(data);
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setReceiver(SerialReceiver receiver) {
		this.receiver = receiver;
	}

	private void startListening() {
		new Thread(() -> {
			try {
				while (true) {
					if (input.available() > 0) {
						char received = (char) input.read();
						if (receiver != null)
							receiver.appendReceivedData(received);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	public int getBaudRate() {
		return comPort.getBaudRate();
	}
}
