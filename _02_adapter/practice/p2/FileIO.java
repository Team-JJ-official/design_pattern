package _02_adapter.practice.p2;

import java.io.*;

public interface FileIO {
    public abstract void readFromFile(String filename) throws IOException;
    public abstract void writeToFile(String filename) throws IOException;
    public abstract void setValue(String key, String Value);
    public abstract String getValue(String key);
}