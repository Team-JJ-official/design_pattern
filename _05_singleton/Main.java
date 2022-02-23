package _05_singleton;
import java.util.*;

// 継承できるシングルトンクラス
class Display {
    private static HashMap _classnameToInstance = new HashMap();
    private static Object _lock = new Object();
    protected Display() {
        synchronized (_lock) {
            String classname = this.getClass().getName();
            if (_classnameToInstance.get(classname) != null) {
                throw new RuntimeException("Already created: " + classname);
            }
            _classnameToInstance.put(classname, this);
        }
    }
    public static Display getInstance(String classname) {
        synchronized (_lock) {
            Display obj = (Display)_classnameToInstance.get(classname);
            if (obj == null) {
                try {
                    Class cls = Class.forName(classname);
                    obj = (Display)cls.newInstance();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(classname + " is not found");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(classname + " cannot be accessed.");
                } catch (InstantiationException e) {
                    throw new RuntimeException(classname + " cannot be instantiated.");
                }
            }
            return obj;
        }
    }
    public void display(String msg) {
        System.out.println("Display: " + msg);
    }
}

class ScreenDisplay extends Display {
    public void display(String msg) {
        System.out.println("ScreenDisplay: " + msg);
    }
}

class HyperDisplay extends Display {
    public void display(String msg) {
        System.out.println("HyperDisplay: " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        ScreenDisplay sd = new ScreenDisplay();
        // ScreenDisplay sd2 = new ScreenDisplay();
        String classname = "_05_singleton.ScreenDisplay";
        try {
            Class cls = Class.forName(classname);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(classname + " is not found");
        }
        System.out.println(sd == Display.getInstance(classname));

        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        // Singleton s = new Singleton();
        if (obj1 == obj2) {
            System.out.println("同じインスタンスです");
        } else {
            System.out.println("同じインスタンスではありません．");
        }
        System.out.println("End.");
    }
}
