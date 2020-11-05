package com.kozachenko.lesson22.http.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DataStreamHelper {

    public static DataInputStream getDataInputStream(Socket socket) throws IOException {
        InputStream sin = socket.getInputStream();
        DataInputStream in = new DataInputStream(sin);
        return in;
    }

    public static DataOutputStream getDataOutputStream(Socket socket) throws IOException {
        OutputStream sout = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(sout);
        return out;
    }

}
