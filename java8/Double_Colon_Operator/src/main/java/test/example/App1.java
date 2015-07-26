package test.example;

public class App1 {

	public static void show() {
		System.out.println("Hello world using Double Colon Operator");

	}

	public static void main(String[] args) {

		Runnable r1 = () -> System.out.println("Hello World using Lambda Expressions");
		r1.run();

		Runnable r2 = App1::show;
		r2.run();

	}
}
