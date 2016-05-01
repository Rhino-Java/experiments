package test.example.singleton;

public class SingletonClass {

	private int counter;

	private SingletonClass() {
		counter = 0;
	}

	/**
	 * ClassLazyHolder class will be initialized only when getInstance() method
	 * of outer class will be called. Thereby, delaying the instance creation of
	 * outer singleton class i.e. lazy initializing singleton class.
	 * 
	 */
	private static class ClassLazyHolder {
		private static final SingletonClass INSTANCE = new SingletonClass();
	}

	public static SingletonClass getInstance() {
		return ClassLazyHolder.INSTANCE;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}