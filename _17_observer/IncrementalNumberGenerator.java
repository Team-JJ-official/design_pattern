package _17_observer;

public class IncrementalNumberGenerator extends NumberGenarator {
    private int number;
    private int begin, end, step;

    public IncrementalNumberGenerator(int begin, int end, int step) {
        this.begin = begin;
        this.end = end;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (number = begin; number < end; number += step) {
            notifyObservers();
        }
    }
    
}
