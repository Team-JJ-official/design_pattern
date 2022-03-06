package _07_builder;

public class TextBuilder extends Builder {
    private StringBuffer buffer = new StringBuffer();

    public void createTitle(String title) {
        buffer.append("===================\n");
        buffer.append("[" + title + "]\n\n");
    }
    public void createString(String str) {
        buffer.append("■" + str + "\n\n");
    }
    public void createItems(String[] items) {
        for(int i = 0; i < items.length; i++) {
            buffer.append("  ・" + items[i] + "\n");
        }
        buffer.append("\n");
    }
    public void internalClose() {
        buffer.append("===================\n");
    }
    public String getResult() {
        return buffer.toString();
    }
}
