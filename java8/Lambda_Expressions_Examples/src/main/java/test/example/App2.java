package test.example;

@FunctionalInterface
interface App2Interface {

	public void doSomething();

}

public class App2 {

	public static void test(App2Interface app2Interface) {
		app2Interface.doSomething();
	}

	public static void main(String[] args) {

		test(new App2Interface() {

			@Override
			public void doSomething() {
				System.out.println("Interface method is called in traditional way");
			}
		});

		test(

		() -> System.out.println("Interface method is called using Lambda Expressions")
		);

		test(

		() -> {
			System.out.println("Statement 1 of Interface method called using Lambda Expressions ");
			System.out.println("Statement 2 of Interface method called using Lambda Expressions ");
		});
	}

}
