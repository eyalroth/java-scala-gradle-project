package org.myproject.mix;

import org.myproject.common.Printer;
import org.myproject.common.VersionData;
import org.myproject.common.VersionReader$;
import scala.Option;

public class MixJavaScalaHelloWorld {

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

    public static Runnable dummyLambda = () -> {

            int i = 1 + 11;
            int j = i + 2;
    };

    public static class DummyInnerClass {

        public int foo() {

            int i = 1 + 3;
            int j = i + 5;
            return i + j;
        }
    }
}
