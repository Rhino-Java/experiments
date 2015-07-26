package test.example;

public class App1 {
	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello World Till Java 1.7");
			}
		}).start();

		new Thread(
				() -> System.out.println("Hello World In Java 1.8")
				).start();
	}
}
