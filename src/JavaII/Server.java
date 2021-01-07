package JavaII;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private ServerSocket serverSocket;
    public Server(int port) throws IOException{
        serverSocket = new ServerSocket(port);
    }

    public void run(){
        while (true){
            try {
                System.out.println("Clien connected: " + serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String helloFromClient = input.readUTF();
                System.out.println("Clien: " + helloFromClient);
                out.writeUTF("hello sever");
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(8050);
            server.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
