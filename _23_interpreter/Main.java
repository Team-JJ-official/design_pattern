package _23_interpreter;


import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("_23_interpreter/program.txt"));
            String text;
            while((text = reader.readLine()) != null) {
                System.out.println(String.format("text = '%s'", text));
                Node node = new ProgramNode();
                node.parse(new Context(text));
                node.accept(new PrintVisitor());
                System.out.println("node = " + node);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
