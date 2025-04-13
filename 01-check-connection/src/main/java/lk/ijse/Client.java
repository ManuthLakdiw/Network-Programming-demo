package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author manuthlakdiv
 * @email manuthlakdiv2006.com
 * @project Network-Programming-demo
 * @github https://github.com/ManuthLakdiw
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost" , 4000);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        System.out.println(inputStream.readUTF());
        outputStream.writeUTF("Hello World");
        outputStream.flush();
        socket.close();
    }
}
