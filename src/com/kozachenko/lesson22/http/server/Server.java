package com.kozachenko.lesson22.http.server;


import com.kozachenko.lesson22.http.helper.DataStreamHelper;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)    {
        int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();
//
//            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
//            InputStream sin = socket.getInputStream();
//            OutputStream sout = socket.getOutputStream();
//
//            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
//            DataInputStream in = new DataInputStream(sin);
//            DataOutputStream out = new DataOutputStream(sout);

            DataInputStream in = DataStreamHelper.getDataInputStream(socket);
            DataOutputStream out = DataStreamHelper.getDataOutputStream(socket);



            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));



            String line = null;

            while(true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                if("exit123".equalsIgnoreCase(line)){
                    line = "Good bye";
                    out.writeUTF(line);
                    out.flush();
                    break;
                }
                System.out.println("The dumb client just sent me this line : " + line);
                System.out.println("I'm sending it back...1111");


                line = keyboard.readLine();



                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }

            in.close();
            out.close();

            ss.close();
        } catch(Exception x) { x.printStackTrace(); }
    }
}
