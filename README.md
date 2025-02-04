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

## How to Run

### 1. Compile the Source Code
```sh
javac Server.java
javac Client.java
```

### 2. Run the Server
```sh
java Server
```
The server will start and wait for client connections.

### 3. Run the Client
```sh
java Client
```
The client will connect to the server and initiate a chat session.

### 4. Start Chatting!
- Type messages in the client terminal and press Enter.
- The server will receive and respond to messages.
- The chat will be logged in a file named `client_chat_log_YYYY-MM-DD_HH-mm-ss.txt` (for the client) and `server_chat_log_YYYY-MM-DD_HH-mm-ss.txt` (for the server).

### 5. End the Chat
- Type `end` in the client terminal to close the chat session.

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


