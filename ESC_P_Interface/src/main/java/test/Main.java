package test;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SerialManager serialManager = new SerialManager("COM3", 9600);
            SerialFileSender fileSender = new SerialFileSender(serialManager);
            new SerialSender(serialManager, fileSender);
            new SerialReceiver(serialManager);
            
        });
    }
}
