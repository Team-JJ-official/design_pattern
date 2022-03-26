package _17_observer;

public class DigitObserver implements Observer {

	@Override
	public void update(NumberGenarator generator) {
		System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
	}
    
}
