package _04_factory_method.idcard;
import _04_factory_method.framework.*;
import java.util.*;

public class IDCardFactory extends Factory {
    // private List<String> owners = new ArrayList<String>();
    private HashMap<Integer, String> owners = new HashMap<Integer, String>();
    private int currentId = 0;
    protected Product createProduct(String owner) {
        return new IDCard(owner, currentId++);
    }
    protected void registerProduct(Product product) {
        owners.put(((IDCard)product).getId(), ((IDCard)product).getOwner());
    }
    public HashMap<Integer, String> getOwners() {
        return owners;
    }
}
