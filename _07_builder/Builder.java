package _07_builder;

public abstract class Builder {
    private boolean titleCalled = false;
    public final void makeTitle(String title) {
        createTitle(title);
        titleCalled = true;
    };
    public abstract void createTitle(String title);
    public final void makeString(String str) {
        checkTitleCalled();
        createString(str);
    };
    public abstract void createString(String str);
    public final void makeItems(String[] items) {
        checkTitleCalled();
        createItems(items);
    }
    public abstract void createItems(String[] items);
    public final void close() {
        checkTitleCalled();
        internalClose();
    };
    public abstract void internalClose();
    private void checkTitleCalled() {
        if(!titleCalled) {
            System.out.println("makeTitleメソッドが呼び出されてないよ");
            System.exit(0);
        }
    }
}
