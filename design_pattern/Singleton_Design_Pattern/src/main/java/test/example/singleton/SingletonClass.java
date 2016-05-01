package test.example.singleton;

public class SingletonClass {

	private static SingletonClass instance;

	private static volatile boolean instanceCreated;

	private int counter;

	private SingletonClass() {
		counter = 0;

	}

	public static SingletonClass getInstance() {
		if (!instanceCreated) {
			synchronized (SingletonClass.class) {
				if (!instanceCreated) {
					instance = new SingletonClass();
					instanceCreated = true;
				}
			}
		}
		return instance;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}