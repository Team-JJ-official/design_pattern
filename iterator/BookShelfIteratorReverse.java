public class BookShelfIteratorReverse implements Iterator {
    private BookShelf bookShelf;
    private int index;
    public BookShelfIteratorReverse(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = bookShelf.getLength();
    }
    @Override
    public boolean hasNext() {
        return index > 0;
    }
    @Override
    public Object next() {
        index--;
        return bookShelf.getBookAt(index);
        
    }
}
