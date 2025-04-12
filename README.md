# 🖥️ Centronics GUI – Java Interface for Serial-to-Centronics

This is a simple Java-based GUI to interact with vintage **Centronics-compatible printers** 🖨️ through a serial connection. It is designed to work with the [serial-to-centronics](https://github.com/tuo-utente/serial-to-centronics) Arduino bridge project.

With this app, you can send characters to your dot-matrix printer and receive data back — right from your modern computer. 🧠💾

---

## 🎯 Features

- 📤 Send text via serial to your printer
- 📥 Receive and display printer responses (if any)
- 🪟 Clean, minimal graphical interface (Java Swing)
- 🔌 Uses [jSerialComm](https://fazecast.github.io/jSerialComm/) for cross-platform serial communication
- 🧪 Designed to work with `serial-to-centronics` firmware


---

## 🚀 Getting Started

1. 📦 Clone the repository
2. 🧱 Add `jSerialComm.jar` to your classpath
3. 🖥️ Compile and run `Main.java`
4. 🔌 Select the correct serial port (USB/COM) in the interface
5. 🧾 Type and send text to print it on your Centronics printer!

---

## 🛠️ Dependencies

- Java 8+
- [jSerialComm](https://fazecast.github.io/jSerialComm/)

You can get the `.jar` file from [here](https://github.com/Fazecast/jSerialComm).

---


## 🔗 Related Projects

👉 [serial-to-centronics](https://github.com/dtorlons/Sertronix) – The Arduino firmware that connects serial input to a parallel printer

---

## 🛠️ To Do

- [ ] Add port status indicator
- [ ] Save sent/received logs
- [ ] Support printer control codes

---

## 📜 License

MIT License – use it, modify it, share it. Contributions welcome! 💬

---

Made with ☕ and nostalgia for that glorious *printer noise*. 🖨️🎶


