package com.iglaz.sqljdbcgo.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String massage = scanner.nextLine();
                dataOutputStream.writeUTF(massage);
                System.out.println(dataInputStream.readUTF());
            }
        }
    }
}
