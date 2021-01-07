package JavaII;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Clien {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                Socket client = new Socket(InetAddress.getByName("localhost"), 8050);
                DataInputStream input = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                System.out.println("Nhập du liệu muốn ghi lên sever");
                String str = sc.nextLine();
                out.writeUTF(str);

                String s = input.readUTF();
                System.out.println("Sever: " + s);

                client.close();
                System.out.println("Tiếp tục ko:");
                String rs = sc.nextLine();
                if ("N".equalsIgnoreCase(rs)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
