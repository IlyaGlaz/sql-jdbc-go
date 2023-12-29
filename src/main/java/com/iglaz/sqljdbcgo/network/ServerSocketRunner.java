package com.iglaz.sqljdbcgo.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerSocketRunner {
    private static final String[] ANSWER = {"Maybe", "No way", "You are lucky"};
    private static final Random random = new Random();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5000);
             Socket socket = serverSocket.accept();
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {

            String request = dataInputStream.readUTF();

            while (!"stop".equals(request)) {
                System.out.println("Client request " + request);
                dataOutputStream.writeUTF(ANSWER[random.nextInt(3)]);
                request = dataInputStream.readUTF();
            }
        }
    }
}
