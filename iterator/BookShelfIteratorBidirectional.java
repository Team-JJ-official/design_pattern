public class BookShelfIteratorBidirectional extends BookShelfIterator implements IteratorBidirectional {
    public BookShelfIteratorBidirectional(BookShelfBidirectional bookShelfBidirectional) {
        super(bookShelfBidirectional);
    }

    @Override
    public boolean hasPrev() {
        return index > 0;
    }

    @Override
    public Object prev() {
        index--;
        return bookShelf.getBookAt(index);
    }
}
