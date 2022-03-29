package _18_memento.game;

import java.util.*;
import java.io.Serializable;

public class Memento implements Serializable {
    int money;
    ArrayList<String> fruits;

    public int getMoney() {
        return money;
    }

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<String>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    @SuppressWarnings("unchecked")
    List<String> getFruits() {
        // System.out.println(this.fruits);
        // System.out.println(fruits);
        return (List<String>)fruits.clone();
    }
}
