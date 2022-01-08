package com.pb.prykhodko.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static ExecutorService threadPool;


    static class Handler implements Runnable {
        private final Socket socket;
        BufferedReader in = null;
        PrintWriter out = null;

        public Handler(Socket socket) {
            this.socket = socket;

        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String clientMessage = null;
            System.out.println("Ожидаем сообщений");
            while (true) {
                try {
                    if ((clientMessage = in.readLine()) == null) break;

                } catch (IOException e) {
                    e.printStackTrace();
                }
                if ("exit".equalsIgnoreCase(clientMessage)) {
                    break;
                }
                out.println("Сервер: " + Calendar.getInstance().getTime() + " Сообщение клиента: " + clientMessage);

                System.out.println(clientMessage);
            }
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }



    public static void main(String[] args) throws Exception {
        int port = 1235;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
