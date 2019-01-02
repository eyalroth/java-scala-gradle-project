package org.myproject.client;

import org.myproject.common.CaseChanger;
import org.myproject.common.Printer;

public class ClientHelloWorld {

    public static void main(String[] args) {

        new Printer().print(new CaseChanger().toLowerCase("Hello world!"));
    }
}
