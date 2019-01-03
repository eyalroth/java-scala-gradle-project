package org.myproject.server;

import org.myproject.common.Printer;
import org.myproject.common.VersionData;
import org.myproject.common.VersionReader$;
import scala.Option;

public class ServerHelloWorld {

    public static void main(String[] args) {

        Printer printer = new Printer();

        printer.print(new Greeter().greet(new World()));

        Option<VersionData> versionData = VersionReader$.MODULE$.readVersionData();
        if (versionData.isDefined()) {
            printer.print(versionData.get().toString());
        } else {
            printer.print("No version info");
        }

    }
}
