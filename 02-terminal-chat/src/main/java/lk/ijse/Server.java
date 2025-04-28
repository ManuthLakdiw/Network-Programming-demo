package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            // Thread to continuously read messages from client
            Thread readThread = new Thread(() -> {
                try {
                    while (true) {
                        String clientMessage = inputStream.readUTF();
                        System.out.println("From client: " + clientMessage);

                        if (clientMessage.equals("bye")) {
                            socket.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Client disconnected.");
                }
            });
            readThread.start();

            // Main thread for writing messages to client
            while (true) {
                System.out.print("Write message to client: ");
                String serverMessage = scanner.nextLine();
                outputStream.writeUTF(serverMessage);
                outputStream.flush();

                if (serverMessage.equals("bye")) {
                    socket.close();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Connection closed or error occurred: " + e.getMessage());
        }
    }
}
