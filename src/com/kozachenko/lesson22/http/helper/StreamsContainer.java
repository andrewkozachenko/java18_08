package com.kozachenko.lesson22.http.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class StreamsContainer {
    private DataInputStream in;
    private DataOutputStream out;

    public StreamsContainer() {
    }

    public StreamsContainer(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }
}
