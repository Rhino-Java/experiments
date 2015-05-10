package test.example;

public class App {
	public static void main(String[] args) {
		String str = "maven";
		// using string in switch statement is feature of Java 1.7
		switch (str) {
		case "hello":
			System.out.println("Hello World!");
		case "maven":
			System.out.println("Hello Maven!");
		}
	}
}
