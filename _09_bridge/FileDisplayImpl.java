package _09_bridge;

import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.*;

public class FileDisplayImpl extends DisplayImpl {
    private String string;
    public FileDisplayImpl(String filename) {
        try {
            this.string = new String(Files.readAllBytes(Paths.get(filename)), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void rawOpen() {
        printline();
    }
    @Override
    public void rawPrint() {
        System.out.println(string.replace("\r\n", " "));
    }

    @Override
    public void rawClose() {
        printline();
    }

    private void printline() {
        System.out.println(string.replaceAll(".|\r\n", "+"));
    }
}
