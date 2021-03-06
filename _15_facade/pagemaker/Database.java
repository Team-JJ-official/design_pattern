package _15_facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Database {
    private Database() {}
    public static Properties getProperties(String dbname) {
        String filename = "_15_facade/" + dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
