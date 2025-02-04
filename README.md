# Chat Messenger with Log Facility

## Overview
The Chat Messenger with Log Facility is a simple client-server chat application built using Java Socket Programming. It enables peer-to-peer communication between a client and a server, while maintaining a timestamped log of all chat messages exchanged.

## Features
- Real-time Text-Based Chat: Communicate between client and server over a TCP connection.
- Timestamped Chat Logs: Each chat session generates a unique log file (`YYYY-MM-DD_HH-mm-ss.txt`).
- Cross-Platform Compatibility: Works on any OS supporting Java.
- Simple and Lightweight: Uses Java's built-in networking libraries.

## Technology Used
- Programming Language: Java (JDK 8 or later)
- Java Sockets (TCP/IP)
- Buffered Streams for Efficient Data Transfer
- File Handling for Logging

## User Interface Used
- Command Line Interface (CLI)

## Platform Required
- Operating System: Linux, Windows, or macOS
- Additional software: Java environment set up

## Prerequisites
- Install Java Development Kit (JDK 8 or later).
- Ensure Java is properly configured in the system's PATH.

## Installation & Usage

### 1. Clone the Repository
```sh
git clone https://github.com/gauravgavhane/chat-messenger.git
cd chat-messenger
```

### 2. Compile the Source Code
```sh
javac Server.java
javac Client.java
```

### 3. Run the Server
```sh
java Server
```
The server will start and wait for client connections.

### 4. Run the Client
```sh
java Client
```
The client will connect to the server and initiate a chat session.

### 5. Start Chatting!
- Type your messages in the client terminal and press **Enter**.
- The server will receive and respond to messages.
- A log file will be created automatically for each session:
  - `client_chat_log_YYYY-MM-DD_HH-mm-ss.txt` (Client side)
  - `server_chat_log_YYYY-MM-DD_HH-mm-ss.txt` (Server side)

### 6. End the Chat
- Type **`end`** in the client terminal to close the chat session.

## File Structure
```
├── Client.java    # Client-side implementation
├── Server.java    # Server-side implementation
├── README.md      # Documentation
```

## Example Usage
### Server Side:
```
Server application is running...
--------------------------------
Waiting for client at port number 2100...
Connection established with the client..
Client: Hello
SERVER: Hi there!
Client: How are you?
SERVER: I'm a chat server, always ready!
```

### Client Side:
```
Client application is running...
--------------------------------
Connecting to server...
Connection established with the server..
CLIENT: Hello
Server: Hi there!
CLIENT: How are you?
Server: I'm a chat server, always ready!
```

## File Structure
```
├── Client.java    # Client-side implementation
├── Server.java    # Server-side implementation
├── README.md      # Documentation
```

## Author
Developed by Gaurav Gavhane

## License
This project is open-source and available under the MIT License.

## Contributing
Contributions are welcome! Feel free to fork the repository and submit a pull request.
