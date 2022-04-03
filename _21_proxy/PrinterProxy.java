package _21_proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrinterProxy implements Printable {
    private String name;
    private Printable real;
    private Class<?> printerClass;
    public PrinterProxy(String name, Class<?> cls) {
        this.name = name;
        this.printerClass = cls;
    }
	@Override
	public synchronized void setPrinterName(String name) {
		if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
	}

	@Override
	public String getPrinterName() {
		return name;
	}

	@Override
	public void print(String string) {
		realize();
        real.print(string);
	}

    private synchronized void realize() {
        if (real == null) {
            try {
                Constructor<?> cons = printerClass.getConstructor(String.class);
                real = (Printable)cons.newInstance(name);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    
}
