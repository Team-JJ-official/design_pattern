package _18_memento.game;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<String>();
    private Random random = new Random();
    private String mementoFile;
    private static String[] fruitsname = {
        "りんご", "ぶどう", "バナナ", "みかん"
    };

    public Gamer(int money, String mementoFile) {
        this.mementoFile = mementoFile;
        this.money = money;
        if (new File(mementoFile).exists()) {
            restoreMemento();
        }
    }
    public int getMoney() {
        return money;
    }
    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました．");
        }
        else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました．");
        }
        else if (dice == 6) {
            String f = getFruit();
            System.out.println("フルーツ(" + f + ")をもらいました．");
            fruits.add(f);
        }
        else {
            System.out.println("何も起こりませんでした．");
        }
    }
    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator<String> it = fruits.iterator();
        while(it.hasNext()) {
            String f = (String)it.next();
            if (f.startsWith("おいしい")) {
                m.addFruit(f);
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new DeflaterOutputStream(new FileOutputStream(mementoFile)));
            oos.writeObject(m);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    public void restoreMemento() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new InflaterInputStream(new FileInputStream(mementoFile)));
            Memento memento = (Memento)ois.readObject();
            this.money = memento.money;
            this.fruits = memento.getFruits();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String toString() {
        return String.format("[money=%s, fruits=%s]", money, fruits);
    }
    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}

