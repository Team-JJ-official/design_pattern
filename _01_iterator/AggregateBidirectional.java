package _01_iterator;

public interface AggregateBidirectional extends Aggregate {
    @Override
    public abstract IteratorBidirectional iterator();
}
