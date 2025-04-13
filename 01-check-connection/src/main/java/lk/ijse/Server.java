package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author manuthlakdiv
 * @email manuthlakdiv2006.com
 * @project Default (Template) Project
 * @github https://github.com/ManuthLakdiw
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("server is on . waiting for client.....");
            ServerSocket serverSocket = new ServerSocket(4000);
            Socket socket = serverSocket.accept();
            System.out.println("client connected");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("hi from server");
            dataOutputStream.flush();
            System.out.println(dataInputStream.readUTF());
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}