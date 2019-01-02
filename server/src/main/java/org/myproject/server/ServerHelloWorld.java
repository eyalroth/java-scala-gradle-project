package org.myproject.server;

import org.myproject.common.Printer;

public class ServerHelloWorld {

    public static void main(String[] args) {

        new Printer().print(new Greeter().greet(new World()));
    }
}
