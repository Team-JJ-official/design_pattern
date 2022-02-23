package _04_factory_method.idcard;
import _04_factory_method.framework.*;

public class IDCard extends Product {
    private String owner;
    private int id;
    public IDCard(){}
    IDCard(String owner, int id) {
        super(owner, id);
        System.out.printf("CREATE  ID: %d, Name: %s\n", id, owner);
        this.owner = owner;
        this.id = id;
    }
    public void use() {
        System.out.println(owner + "のカードを使います。");
    }
    public String getOwner() {
        return owner;
    }
    public int getId() {
        return id;
    }
}
