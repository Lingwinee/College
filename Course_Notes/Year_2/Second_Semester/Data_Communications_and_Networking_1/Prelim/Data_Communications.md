# Data Communications - Lecture 01

## 📋 Summary
* **Core Concept:** Data communications is the exchange of data between two devices via a transmission medium, governed by protocols and characterized by delivery, accuracy, timeliness, and minimal jitter.

> **Takeaways:** Effective data communication systems require five fundamental components (message, sender, receiver, transmission medium, and protocol) and can operate in three data flow modes (simplex, half-duplex, or full-duplex) depending on the communication requirements.

---

## 📖 Definition

* **Data Communications:** The exchange of data between two devices via some form of transmission medium such as a wire cable.

* **Message:** The information (data) to be communicated, which can be in the form of text, numbers, images, audio, or video.

* **Protocol:** A set of rules that govern data communications, ensuring that devices can communicate effectively.

* **Jitter:** The variation in packet arrival time during data transmission.

### Fundamental Characteristics

The effectiveness of a data communications system depends on four fundamental characteristics:

* **Delivery:** The system must deliver data to the correct destination.
* **Accuracy:** The system must deliver the data accurately without corruption.
* **Timeliness:** The system must deliver data in a timely manner to be useful.
* **Jitter:** The system must minimize variation in packet arrival time.

---

## 📊 Components of Data Communications System

| Component | Description | Example |
| :--- | :--- | :--- |
| Message | Information to be communicated | Text, numbers, images, audio, video |
| Sender | Device that sends the data message | Computer, smartphone, server |
| Receiver | Device that receives the message | Monitor, laptop, printer |
| Transmission Medium | Physical path for message travel | Wire cable, fiber optic, wireless |
| Protocol | Rules governing communication | TCP/IP, HTTP, FTP |

### Message Types and Representation

* **Text:** Represented as bit patterns using coding systems (Unicode is prevalent).
* **Numbers:** Directly converted to binary format for simplified mathematical operations.
* **Images:** Composed of a matrix of pixels, where each pixel is a small dot represented by bit patterns.
* **Audio:** Recording or broadcasting of sound or music; continuous in nature, not discrete.
* **Video:** Recording or broadcasting of pictures or movies; can be continuous or a combination of discrete images arranged to convey motion.

---

## 📡 Data Flow Modes

### Three Types of Communication Modes

1. **Simplex**
   * Communication is unidirectional (one-way street)
   * Only one device can transmit; the other can only receive
   * Example: CPU Tower → Monitor
   * Use case: Broadcasting, monitor displays

2. **Half-Duplex**
   * Both devices can transmit and receive, but not simultaneously
   * When one device sends, the other can only receive, and vice versa
   * Example: Walkie-Talkie communication
   * Use case: Two-way radios, some network protocols

3. **Full-Duplex**
   * Both devices can transmit and receive simultaneously
   * Like a two-way street with traffic flowing in both directions at the same time
   * Example: Laptop ↔ Laptop communication
   * Use case: Telephone conversations, modern network communications

---

## 💻 Practical Examples

### Example 1: Simplex Communication (Monitor Display)
```python
# Conceptual representation of simplex communication
class SimplexCommunication:
    def __init__(self):
        self.sender = "CPU Tower"
        self.receiver = "Monitor"
    
    def transmit(self, data):
        """
        One-way transmission from sender to receiver
        Receiver cannot send data back
        """
        print(f"{self.sender} → {self.receiver}: {data}")
        # No return path for data

# Usage
display = SimplexCommunication()
display.transmit("Video Frame Data")
# Output: CPU Tower → Monitor: Video Frame Data
```

### Example 2: Half-Duplex Communication (Walkie-Talkie)
```python
# Conceptual representation of half-duplex communication
class HalfDuplexCommunication:
    def __init__(self):
        self.device_a = "Walkie-Talkie A"
        self.device_b = "Walkie-Talkie B"
        self.channel_busy = False
    
    def transmit(self, sender, receiver, message):
        """
        Communication where only one device can transmit at a time
        """
        if not self.channel_busy:
            self.channel_busy = True
            print(f"{sender} → {receiver}: {message}")
            self.channel_busy = False
        else:
            print(f"Channel busy! {sender} must wait.")
    
# Usage
radio = HalfDuplexCommunication()
radio.transmit("Device A", "Device B", "Message at time 1")
radio.transmit("Device B", "Device A", "Message at time 2")
# Devices alternate transmission
```

### Example 3: Full-Duplex Communication (Network Connection)
```python
# Conceptual representation of full-duplex communication
import threading
import time

class FullDuplexCommunication:
    def __init__(self):
        self.device_a = "Laptop A"
        self.device_b = "Laptop B"
    
    def transmit(self, sender, receiver, message):
        """
        Both devices can send and receive simultaneously
        """
        print(f"{sender} → {receiver}: {message}")
    
    def bidirectional_communication(self):
        """
        Simulate simultaneous two-way communication
        """
        # Thread 1: A sends to B
        def a_to_b():
            for i in range(3):
                self.transmit(self.device_a, self.device_b, f"Data packet {i}")
                time.sleep(0.1)
        
        # Thread 2: B sends to A
        def b_to_a():
            for i in range(3):
                self.transmit(self.device_b, self.device_a, f"ACK packet {i}")
                time.sleep(0.1)
        
        # Both transmissions happen simultaneously
        thread1 = threading.Thread(target=a_to_b)
        thread2 = threading.Thread(target=b_to_a)
        
        thread1.start()
        thread2.start()
        
        thread1.join()
        thread2.join()

# Usage
network = FullDuplexCommunication()
network.bidirectional_communication()
# Both directions transmit simultaneously
```

### Example 4: Message Type Representation
```python
# Example of different message types in data communications

class MessageEncoder:
    def encode_text(self, text):
        """
        Text represented as bit patterns using Unicode
        """
        return text.encode('utf-8')
    
    def encode_number(self, number):
        """
        Numbers converted directly to binary
        """
        return bin(number)
    
    def encode_image_pixel(self, red, green, blue):
        """
        Simple RGB pixel representation
        Each color component: 0-255
        """
        return f"R:{red} G:{green} B:{blue}"

# Usage
encoder = MessageEncoder()

# Text encoding
text_data = encoder.encode_text("Hello")
print(f"Text: {text_data}")

# Number encoding
number_data = encoder.encode_number(42)
print(f"Number: {number_data}")

# Image pixel encoding
pixel_data = encoder.encode_image_pixel(255, 128, 0)
print(f"Pixel: {pixel_data}")
```

---

## 🔑 Key Concepts Summary

### Communication System Requirements
1. **Correct Delivery:** Data must reach the intended destination
2. **Data Accuracy:** Information must remain uncorrupted during transmission
3. **Timely Delivery:** Data must arrive when needed to be useful
4. **Minimal Jitter:** Consistent packet arrival timing for quality communication

### Choosing the Right Data Flow Mode

* **Use Simplex when:** Information flows in only one direction (broadcasting, displays)
* **Use Half-Duplex when:** Two-way communication is needed but devices take turns (radio communication, some sensors)
* **Use Full-Duplex when:** Simultaneous two-way communication is required (phone calls, modern networks)

---

## 📚 References
* [Lecture 01](https://drive.google.com/file/d/1MMdv10G_mpHzC5uzVuGGzDGl5DzoW4iE/view?usp=drive_link) - Presentation Link
* **Course Material:** Data Communications and Networking with TCP/IP Protocol Suite (2022)
* **Instructor:** Engr. Violdan E. Bayocot
* **Institution:** University of San Jose - Recoletos, School of Computer Studies

---

## 💡 Additional Notes

### For CCNA Preparation
This lecture covers fundamental concepts that appear in CCNA certification exams. Understanding simplex, half-duplex, and full-duplex modes is essential for network configuration and troubleshooting.

### Practical Applications
* **Cybersecurity Context:** Understanding data flow modes is important for analyzing network traffic patterns and identifying potential security vulnerabilities.
* **AR/VR Applications:** Full-duplex communication is critical for real-time interactive AR/VR systems where both user input and system feedback must occur simultaneously with minimal latency and jitter.

### Study Tips
1. Memorize the four fundamental characteristics: Delivery, Accuracy, Timeliness, Jitter
2. Understand the five components of data communication systems
3. Be able to identify and explain the three data flow modes with examples
4. Practice distinguishing between different message types and their representations