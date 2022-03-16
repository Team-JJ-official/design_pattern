package _13_visitor;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir, tmpdir, usrdir);
            bindir.add(new File("vi", 10000), new File("latex", 20000));
            rootdir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrdir.add(yuki, hanako, tomura);
            yuki.add(new File("diary.html", 100), new File("Composite.java", 200));
            hanako.add(new File("memo.txt", 300), new File("jj.html", 3333));
            File f1 = new File("game.doc", 400);;
            tomura.add(f1, new File("junk.mail", 500));
            rootdir.accept(new ListVisitor());

            FileFindVisitor ffv = new FileFindVisitor(".html");
            rootdir.accept(ffv);
            System.out.println("HTML Files are: ");
            Iterator<File> it = ffv.getFoundFiles();
            while (it.hasNext()) {
                File file = (File)it.next();
                System.out.println(file.toString());
            }

            ElementArrayList list = new ElementArrayList();
            list.add(rootdir);
            list.add(yuki);
            list.add(new File("team-jj.py", 1000000));
            list.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
