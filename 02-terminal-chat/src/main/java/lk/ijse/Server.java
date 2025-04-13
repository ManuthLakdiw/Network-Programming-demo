package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author manuthlakdiv
 * @email manuthlakdiv2006.com
 * @project Network-Programming-demo
 * @github https://github.com/ManuthLakdiw
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("waiting for client");
            Socket socket = serverSocket.accept();
            System.out.println("client connected");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println("\n"+dataInputStream.readUTF());

                Scanner scanner = new Scanner(System.in);
                System.out.print("Type here : ");
                String message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();

                if (message.equals("exit")) {
                    break;

                }
            }

            socket.close();






        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
