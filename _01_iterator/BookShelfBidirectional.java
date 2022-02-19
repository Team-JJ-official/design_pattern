package _01_iterator;

public class BookShelfBidirectional extends BookShelf implements AggregateBidirectional{
    public BookShelfBidirectional(int maxSize) {
        super(maxSize);
    }
    @Override
    public IteratorBidirectional iterator() {
        return new BookShelfIteratorBidirectional(this);
    }
}
