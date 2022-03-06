package _07_builder;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            // usage();
            System.exit(0);
        }
        if (args[0].equals("plain")) {
            TextBuilder textbuilder = new TextBuilder();
            Director director = new Director(textbuilder);
            director.construct();
            String result = textbuilder.getResult();
            System.out.println(result);
        }
        else if (args[0].equals("html")) {
            HTMLBuilder htmlbuilder = new HTMLBuilder();
            Director director = new Director(htmlbuilder);
            director.construct();
            String filename = htmlbuilder.getResult();
            System.out.println(filename + "が作成されました．");
        }
        else if (args[0].equals("md")) {
            MDBuilder mdbuilder = new MDBuilder();
            Director director = new Director(mdbuilder);
            director.construct();
            String filename = mdbuilder.getResult();
            System.out.println(filename + "が作成されました．");
        }
        else if (args[0].equals("frame")) {
            FrameBuilder framebuilder = new FrameBuilder();
            Director director = new Director(framebuilder);
            director.construct();
            JFrame frame = framebuilder.getResult();
            frame.setVisible(true);
        }
    }
}
