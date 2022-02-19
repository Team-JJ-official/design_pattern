package _01_iterator;

public interface IteratorBidirectional extends Iterator {
    public abstract boolean hasPrev();
    public abstract Object prev();
}
